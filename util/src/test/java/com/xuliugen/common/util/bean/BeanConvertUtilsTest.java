package com.xuliugen.common.util.bean;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuliugen on 16/1/2.
 */
public class BeanConvertUtilsTest {

    @Test
    public void testMaptoBean() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "xuliugen");
        map.put("password", "123456");

        //如果JavaBean中有sex属性，但是map中没有的话，则不会被映射：Persion{name='xuliugen', password='123456', sex='null'}
        //map.put("sex", "男");

        //如果map中的key和Bean中的属性不对应也不会报错，只是会丢掉
        map.put("other", "other");
        Persion p = BeanConvertUtils.MaptoBean(map, Persion.class);

        System.out.println(p.toString());
    }
}
