package com.imc.serial;

import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * @author luoly
 * @date 2018/12/11 17:18
 * @description
 */
public class PickleMarker extends Frame{

    /**
     * 构造方法，创建一个frame视窗，显示一个TextField
     * @param text
     * @param size
     */
    PickleMarker(String text, int size) {

        /**
         * (1) 调用超类的构造函数
         * (2) 增加一个事件监听对象
         * (3) 将布局管理器改为Flow类型
         */
        super("Pickle Marker");
        addWindowListener(new win());
        setLayout(new FlowLayout());

        /**
         * 创建TextField对象并将它串行化
         */
        TextField textField = makeTextField(text, size);
        serializeTextField(textField, "mytextfield.ser");
        add(textField);

    }

    /**
     * 这个方法创建一个TextField对象，以传进的text为文字内容，size为宽度
     * @param text
     * @param size
     * @return
     */
    private TextField makeTextField(String text, int size) {
        TextField textField = new TextField(text, size);
        return textField;
    }

    private void serializeTextField(TextField textField, String fileName) {
        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            out.writeObject(textField);
            out.flush();
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * 创建一个iframe对象 并显示一个textfield
     * @param args
     */
    public static void main(String[] args) {
        Frame frame = new PickleMarker("asdfasdfadfds", 25);
        frame.setBounds(0, 0, 300, 200);
        frame.setVisible(true);
    }

    /**
     * 这个内部类提供了监听功能，以便在接到操作系统传过来的关闭窗口事件时，将应用程序结束掉
     */
    class win extends WindowAdapter{
        public void windowClosing(WindowEvent evt) {
            Frame frame = (Frame) evt.getSource();
            frame.setVisible(false);
            frame.dispose();
            System.exit(0);
        }
    }

}
