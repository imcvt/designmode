package com.imc.lambda;

/**
 * @author luoly
 * @date 2018/12/17 11:05
 * @description
 */
public interface Listener {
    String doSomething(String a, String b);

    default String doSomething2() {
        return null;
    }
}
