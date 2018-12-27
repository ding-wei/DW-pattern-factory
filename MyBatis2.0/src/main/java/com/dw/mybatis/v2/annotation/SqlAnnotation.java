package com.dw.mybatis.v2.annotation;

        import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface SqlAnnotation {
    String Sql() default "";
}
