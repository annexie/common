package com.xuliugen.common.domain;

import com.alibaba.fastjson.JSON;
import com.xuliugen.common.repository.IEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by liugen.xu on 15/10/16.
 */
@Named
public class BaseEntity implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(EntityInMybatis.class);

    @Inject
    private IEntityRepository entityRepository;

    /**
     * 实体Id
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public <T extends Entity> T get(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        T entity = entityRepository.selectByPrimaryKey(id);
        logger.debug(entity.toString());
        return entity;
    }

    /**
     * 添加实体
     * @param entity
     * @return
     */
    public <T extends Entity> int add(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("entity cannot be null");
        }
        logger.debug(entity.toString());
        int addCount = entityRepository.insert(entity);
        return addCount;
    }

    /**
     * 更新实体
     * @param entity
     * @return
     */
    <T extends Entity> int update(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("entity cannot be null");
        }
        logger.debug(entity.toString());
        return entityRepository.updateByPrimaryKeySelective(entity);
    }

    /**
     * 删除实体
     * @param id
     * @return
     */
    int delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        logger.debug(id.toString());
        return entityRepository.deleteByPrimaryKey(id);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
