package util.bean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.util.Map;

/**
 * Created by xuliugen on 15/10/18.
 */
public class BeanConvertUtils {

    /**
     * 把map转换成对象
     * @param map
     * @param clazz
     * @param <T>
     * @return 把map转换成对象
     */
    @SuppressWarnings("rawtypes")
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
