package com.company.hs.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)  // 어노테이션이 생성될 수 있는 위치 지정. 파라미터타입 => 파라미터로만 사용가능.
@Retention(RetentionPolicy.RUNTIME) // RetentionPolicy.RUNTIME : 런타임까지 남아있는다.(=사실상 안 사라진다.)
public @interface LoginUser {
}
