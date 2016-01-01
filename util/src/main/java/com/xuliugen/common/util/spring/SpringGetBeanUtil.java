package com.xuliugen.common.util.spring;

/**
 * 用于手动获取bean
 * <p/>
 * 需要在spring的配置文件中进行注解，对该工具类进行注解
 * <bean id="springGetBeanUtil" class="util.spring.SpringGetBeanUtil"/>
 * Created by xuliugen on 15/12/6.
 */
//@Named
//public class SpringGetBeanUtil implements BeanFactoryAware {
//
//    private static BeanFactory beanFactory = null;
//
//    private static SpringGetBeanUtil springGetBeanUtil = null;
//
//    public static SpringGetBeanUtil getInstance() {
//        if (springGetBeanUtil == null)
//            springGetBeanUtil = (SpringGetBeanUtil) beanFactory.getBean("springGetBeanUtil");
//        return springGetBeanUtil;
//    }
//
//    public void setBeanFactory(BeanFactory factory) throws BeansException {
//        this.beanFactory = factory;
//    }
//
//    public Object getBean(String beanName) {
//        return beanFactory.getBean(beanName);
//    }
//}