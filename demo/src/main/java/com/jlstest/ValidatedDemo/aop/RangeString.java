package com.jlstest.ValidatedDemo.aop;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



/**
 * String参数在指定的范围内.<br>
 * @author lisc
 * @date 2023/7/28 10:48
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {SpecifiedValidator.class})
public @interface RangeString {

    /** 允许的取值范围 */
    String[] allows();

    /** 校验失败错误消息 */
    String message() default "字符串不在指定范围";

    /** 下边两个属性不可删除, 代码中虽然没有显示用到, 但是Spring Validate会用到 */
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
