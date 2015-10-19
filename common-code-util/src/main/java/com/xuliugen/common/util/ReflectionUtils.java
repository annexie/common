package com.xuliugen.common.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName:ReflectionUtils
 * @Description: 包含一些常用反射功能的工具类
 * @Author liugen.xu
 * @Date:2013-1-19 下午8:03:27
 * @Remarks:
 * @Version:V1.1
 */
public class ReflectionUtils {

    /**
     * 获得对象自身及其直接父类已声明的字段
     * @param object 传入的对象
     * @return List<Field> 字段列表
     */
    public static List<Field> getSelfAndDirectParentDeclaredFields(Object object) {

        List<Field> declaredFields = new ArrayList<Field>();

        Field[] selfFields = object.getClass().getDeclaredFields();

        if (selfFields != null) {
            declaredFields.addAll(Arrays.asList(selfFields));

            Field[] directParentFields = object.getClass().getSuperclass()
                    .getDeclaredFields();

            if (directParentFields != null) {
                declaredFields.addAll(Arrays.asList(directParentFields));
            }

        }

        return declaredFields;

    }


    public static void reflect(Object obj) {
        if (obj == null) return;
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int j = 0; j < fields.length; j++) {
            fields[j].setAccessible(true);
            // 字段名
            System.out.print(fields[j].getName() + ",");
            // 字段值
            if (fields[j].getType().getName().equals(
                    String.class.getName())) {
                // String type
                try {
                    System.out.print(fields[j].get(obj));
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (fields[j].getType().getName().equals(
                    Integer.class.getName())
                    || fields[j].getType().getName().equals("int")) {
                // Integer type
                try {
                    System.out.println(fields[j].getInt(obj));
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            // 其他类型。。。
        }
        System.out.println();
    }


}
