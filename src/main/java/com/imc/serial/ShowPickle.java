package com.imc.serial;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Beans;

/**
 * @author luoly
 * @date 2018/12/12 16:44
 * @description
 */
public class ShowPickle extends Frame{

    /**
     * 此构造方法创建一个frame视窗，将其布局改为FlowLayout，并将传入的TextField并行化，然后加到视窗上，此过程可以看作腌咸菜后的回鲜过程
     * @param serComponent
     */
    ShowPickle(String serComponent) {
        //调用超类的构造方法，加上一个监听器对象，以便监听视窗的关闭事件
        super("Show Pickle");
        addWindowListener(new win());
        setLayout(new FlowLayout());

        //将串行化的TextField对象实例化，如果找不到串行化的对象，则显示一个普通的TextField
        TextField text;
        try{
            text = (TextField) Beans.instantiate(null, serComponent);

        }catch(Exception e) {
            System.out.println(e);
            text = new TextField();
        }
        add(text);
    }

    /**
     * 这个方法创建一个Frame对象，显示并行化后的TextField对象
     * @param args
     */
    public static void main(String[] args) {
        Frame frame = new ShowPickle("mytextfield");
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * 这个内部类提供了监听功能，以便在接到操作系统传过来的关闭窗口事件时，将应用程序结束掉
     */
    class win extends WindowAdapter {
        public void windowClosing(WindowEvent evt) {
            Frame frame = (Frame) evt.getSource();
            frame.setVisible(false);
            frame.dispose();
            System.exit(0);
        }
    }
}
