package com.xuliugen.common.repository.nosql;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.xuliugen.common.constant.ConstPunctuation;
import com.xuliugen.common.domain.BaseEntity;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashSet;
import java.util.Set;

@Named
public abstract class BaseRepositoryRedis<T extends BaseEntity> {

    private static final Logger logger = LoggerFactory.getLogger(BaseRepositoryRedis.class);

    @Inject
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 根据id删除Redis中的数据
     * @param id
     * @return
     */
    public void deleteByPrimaryKey(String keyPrefix, Long id) {
        String keyPattern = assembleKeyPatternIdAsPostFix(keyPrefix, id);
        logger.info(keyPattern);

        //取出所有与该模式匹配的key
        Set<String> keySet = stringRedisTemplate.keys(keyPattern);
        logger.debug("keySet-{}", keySet);
        stringRedisTemplate.delete(keySet);
    }

    /**
     * 批量删除
     * @param keyPrefix
     * @param idSet
     */
    public void deleteInBatch(String keyPrefix, Set<Long> idSet) {
        for (Long id : idSet) {
            deleteByPrimaryKey(keyPrefix, id);
        }
    }

    /**
     * 判断是否为空之后，插入数据
     * @param entity
     * @return
     */
    public int insertSelective(T entity) {
        Set<T> priceAdjustSet = new HashSet<T>();
        priceAdjustSet.add(entity);
        insertInBatch(priceAdjustSet);
        return 0;
    }

    /**
     * 批量插入
     * @param entitySet
     */
    public void insertInBatch(Set<T> entitySet) {
        if (CollectionUtils.isNotEmpty(entitySet)) {
            for (T entity : entitySet) {
                //获得Reids中存储的key
                String key = assembleRedisKey(entity);
                stringRedisTemplate.opsForValue().set(key, JSONObject.toJSONString(entity));
            }
        }
    }

    /**
     * 更新Redis中的缓存
     * @param keyPrefix
     * @param entity
     */
    public void updateByPrimaryKey(String keyPrefix, T entity) {
        //因为传入的参数与Key相关的某些属性已经发生变化，所以此时的组装出来的key已经与原Key不一样。
        // 但ID是不变的且唯一的，所以通过ID找到原Key，删除原Key，插入新Key
        String keyPattern = assembleKeyPatternIdAsPostFix(keyPrefix, entity.getId());
        Set<String> keySet = stringRedisTemplate.keys(keyPattern);
        stringRedisTemplate.delete(keySet);

        String key = assembleRedisKey(entity);
        stringRedisTemplate.opsForValue().set(key, JSONObject.toJSONString(entity));
    }

    /**
     * 根据条件进行查询
     * @param entity
     * @return
     */
    public Set<T> listByCondition(T entity) {
        Set<T> entitySet = new HashSet<T>();
        if (entity != null) {
            String keyPattern = assembleRedisKeyPattern(entity);
            logger.info(keyPattern);

            //取出所有与该模式匹配的key
            Set<String> keySet = stringRedisTemplate.keys(keyPattern);
            if (CollectionUtils.isNotEmpty(keySet)) {
                for (String key : keySet) {
                    String value = stringRedisTemplate.boundValueOps(key).get();
                    logger.debug("key-{},value-{}", key, value);
                    if (value != null) {
                        T entityFromCache = JSON.parseObject(value, new TypeReference<T>() {
                        });
                        entitySet.add(entityFromCache);
                    }
                }
            }
        }
        return entitySet;
    }

    /**
     * 批量更新
     * @param keyPrefix
     * @param entitySet
     */
    public void updateByPrimaryKeyInBatch(String keyPrefix, Set<T> entitySet) {
        for (T entity : entitySet) {
            updateByPrimaryKey(keyPrefix, entity);
        }
    }

    /**
     * 组装存入Redis的Key的抽象方法，有子类实现具体的逻辑
     * @param entity
     * @return
     */
    protected abstract String assembleRedisKey(T entity);

    /**
     * 组装Key的Pattern用于查询匹配的Redis的Key集合
     * @param entity
     * @return
     */
    protected abstract String assembleRedisKeyPattern(T entity);

    /**
     * 组装Id为后缀的KeyPattern,例如： PREFIX*Id
     * @param keyPrefix
     * @param id
     * @return
     */
    protected String assembleKeyPatternIdAsPostFix(String keyPrefix, Long id) {
        String keyPattern = keyPrefix + ConstPunctuation.ASTERISK + id;
        logger.debug(keyPattern);
        return keyPattern;
    }
}
