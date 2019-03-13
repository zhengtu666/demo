package com.example.common.annotation;

import java.lang.annotation.*;

/**
 * @Description: 打印方法耗时注解，标注于方法，用于Aop切面
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TimeAnn {
}
