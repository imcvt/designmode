package com.imc.xml;

import org.xml.sax.SAXException;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author luoly
 * @date 2018/12/14 16:24
 * @description 此类是一个Properties数据和xml数据之间的转换器
 * 这里的xml格式如下
 *      <properties>
 *          <key name="myKey1">My_Value1</key>
 *          <key name="myKey2">My_Value2</key>
 *     </properties>
 */
public class XMLProperties extends Properties{

    XMLParser p = null;

    /**
     * 从一个输入流读入XML
     * @param in
     */
    public synchronized void load(InputStream in)throws IOException {
        try{
            p = new XMLParser(in, this);
        }catch(SAXException e) {
            throw new IOException(e.getMessage());
        }
    }

    /**
     * 将XML文件读入
     * @param file
     * @throws SAXException
     * @throws IOException
     */
    public synchronized void load(File file)
            throws SAXException, IOException {
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        XMLParser p = null;
        try{
            p = new XMLParser(in, this);
        }catch(SAXException e) {
            System.out.println(e);
            throw e;
        }

    }

    /**
     * 调用 store(OutputStream out, String header)
     * @param out
     * @param header
     */
    public synchronized void save(OutputStream out, String header) {
        try{
           store(out, header);
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 将此propertity列表写入到输出流里
     * @param out
     * @param header
     * @throws IOException
     */
    public synchronized void store(OutputStream out, String header)throws IOException {
        PrintWriter wout = new PrintWriter(out);
        wout.println("<?xml version='1.0'>");
        if(header != null) {
            wout.println("<!--" + header + "-->");
        }
        wout.print("<properties>");
        for(Enumeration e=keys(); e.hasMoreElements();) {
            String key = (String) e.nextElement();
            String val = (String) get(key);
            wout.print("\n <key name=\""+ key + "\">");
//            wout.print(encode(val));
            wout.print("</key>");
        }
        wout.print("\n</properties>");
        wout.flush();
    }
}
