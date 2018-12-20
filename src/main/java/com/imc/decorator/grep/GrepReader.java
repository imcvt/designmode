package com.imc.decorator.grep;

import java.io.BufferedReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author luoly
 * @date 2018/12/20 09:52
 * @description 大致的逻辑是，继承装饰类FilterFreader，然后在readline中调用Reader的readLine()方法，再加上自定义的逻辑（返回的line是筛选符合条件的结果）
 */
public class GrepReader extends FilterReader{

    protected String substring;
    protected BufferedReader in;
    private int lineNumber;

    /**
     * Creates a new filtered reader.
     *
     * @param in a Reader object providing the underlying stream.
     * @throws NullPointerException if <code>in</code> is <code>null</code>
     */
    public GrepReader(Reader in, String substring) {
        super(in);
        this.in = new BufferedReader(in);
        this.substring = substring;
        this.lineNumber = 0;
    }

    public String readLine()throws IOException {
        String line;
        do {
            line = in.readLine();
            lineNumber ++;
        } while((line != null) && line.indexOf(substring) == -1);
        return line;
    }

    public int lineNo() {
        return this.lineNumber;
    }
}
