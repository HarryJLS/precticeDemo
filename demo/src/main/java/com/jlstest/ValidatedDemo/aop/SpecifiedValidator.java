package com.jlstest.ValidatedDemo.aop;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

/**
 * 字符串校验器: 校验某个字符串是否在指定的范围内
 * @author lisc
 * @date 2023/7/28 11:02
 */
public class SpecifiedValidator implements ConstraintValidator<RangeString, String> {
    private String[] allows;

    @Override
    public void initialize(RangeString constraintAnnotation) {
        this.allows = constraintAnnotation.allows();
    }

    @Override
    public boolean isValid(String param, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(param)) {
            return true;
        }

        for (String allow: allows) {
            if (param.equals(allow)){
                return true;
            }
        }

        return false;
    }
}
