package com.imc.decorator.grep;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author luoly
 * @date 2018/12/20 09:52
 * @description
 */
public class Grep {

    static GrepReader g;
    private static GrepView gv = new GrepView();

    public static void main(String[] args) {
        String line;

        if(args.length <= 1) {
            gv.println("Usage:java Grep");
            gv.println("no regexp");
            System.exit(1);
        }

        try {
            gv.println("\nGrep：搜索" + args[0] + "文件" + args[1]);
            gv.println("文件号和行号\t\t 下面的行里含有所搜索的字符串\n");
            g = new GrepReader(new FileReader(args[1]), args[0]);

            for (;;) {
                line = g.readLine();
                if(line == null) break;
                gv.println(args[1] + ":" + g.lineNo() + ":\t" + line);
            }
            g.close();
        }catch (IOException e) {
            gv.println(e.getMessage());
        }
    }
}
