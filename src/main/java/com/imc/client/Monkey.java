package com.imc.client;

/**
 * @author luoly
 * @date 2018/12/7 11:04
 * @description
 */
public class Monkey {
    private static Monkey monkey = new Monkey();
    private static int a;
    private static int b = 0;

    private Monkey() {
        a++;
        b++;
    }

    private Monkey getInstance() {
        return monkey;
    }

    public static void main(String[] args) {
        System.out.println("a=" + monkey.a + ",b=" + monkey.b);
    }
}
