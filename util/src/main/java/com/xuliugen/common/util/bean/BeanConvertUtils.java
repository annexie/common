package com.xuliugen.common.util.bean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.util.Map;

/**
 * Bean的转化工具类
 * Created by xuliugen on 15/10/18.
 */
public class BeanConvertUtils {

    /**
     * 把map转换成JavaBean对象,要求map中的可以、名称与JavaBean中的属性相对应
     * 如果一个map中有多个javaBean中对应的属性，则同样可以实现对不同JavaBean的映射
     * @param map
     * @param clazz
     * @param <T>
     * @return 把map转换成对象
     */
    public static <T> T MaptoBean(Map map, Class<T> clazz) {
        try {
            /*
             * 1. 通过参数clazz创建实例
			 * 2. 使用BeanUtils.populate把map的数据封闭到bean中
			 */
            T bean = clazz.newInstance();
            ConvertUtils.register(new DateConverter(), java.util.Date.class);
            BeanUtils.populate(bean, map);
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
