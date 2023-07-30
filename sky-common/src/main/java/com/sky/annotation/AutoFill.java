package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，用于标识某个方法需要经行功能字段自动填充
 */
@Target(ElementType.METHOD)//表明注解加在方法上
@Retention(RetentionPolicy.RUNTIME)//固定写法
public @interface AutoFill {
    //数据库操作类型 insert update(只有这两种需要修改人和时间的注明)
    OperationType value();
}
