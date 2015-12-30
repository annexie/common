package com.xuliugen.common.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

/**
 * JSR303验证工具类，用于校验参数
 */
public class ValidationUtil<T> {

    private static class ValidationUtilHolder {
        private static ValidationUtil instance = new ValidationUtil();
    }

    public static ValidationUtil getInstance() {
        return ValidationUtilHolder.instance;
    }

    /**
     * 检查参数
     * @return 如果验证没有通过返回报错信息
     */
    public void validateParams(T object) {
        if (object != null) {
            //调用JSR303验证工具，校验参数
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<T>> violations = validator.validate(object);
            Iterator<ConstraintViolation<T>> iterator = violations.iterator();
            if (iterator.hasNext()) {
                String errMessage = iterator.next().getMessage();
                throw new ValidationException(errMessage);
            }
        } else {
            throw new ValidationException("输入参数不能为空");
        }
    }
}
