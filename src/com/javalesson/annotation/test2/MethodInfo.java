package com.javalesson.annotation.test2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//ограничиваем использование только в методе
@Retention(RetentionPolicy.RUNTIME)//политика удержания
public @interface MethodInfo {
    String author() default "Dima";

    int dateOfCreation() default 2019;

    String purpose();
}
