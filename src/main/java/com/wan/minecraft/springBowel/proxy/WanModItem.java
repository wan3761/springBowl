package com.wan.minecraft.springBowel.proxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface WanModItem {
    boolean value() default true;
    String[] stringKey() default {};
}
