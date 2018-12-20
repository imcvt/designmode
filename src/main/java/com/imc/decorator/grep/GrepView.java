package com.imc.decorator.grep;

import java.io.PrintStream;

/**
 * @author luoly
 * @date 2018/12/20 09:52
 * @description
 */
public class GrepView {

    PrintStream out;


    public GrepView() {
        out = System.out;
    }

    public void println(String str) {
        out.println(str);
    }
}
