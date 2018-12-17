package com.imc.lambda;

/**
 * @author luoly
 * @date 2018/12/17 11:06
 * @description
 */
public class Test {
    public static void main(String[] args) {
        //lambda表达式 创建一个接口的具体实现
        Listener myListener = (a,b)-> {
            return a + b;
        };

        System.out.println(myListener.doSomething("a", "b"));
    }
}
