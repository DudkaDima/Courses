package com.dudka.courses.task2.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CustomProperty {
    String name() default "";

    String dateFormat() default "d.M.uuuu, HH:mm";


}
