package com.imc.singleton.propertymanager;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author luoly
 * @date 2018/11/28 20:55
 * @description
 */
public class ConfigManager {

    /**
     * 属性文件命名
     */
    private static final String PFILE = System.getProperty("user.dir") + File.separator + "singleton.properties";
    /**
     * 对应于属性文件的文件对象变量
     */
    private File m_file = null;
    /**
     * 属性文件的最后修改日期
     */
    private long m_lastModifiedTime = 0;
    /**
     * 属性对象变量
     */
    private Properties m_props = null;
    /**
     * 唯一实例
     */
    private static ConfigManager m_instance = new ConfigManager();

    /**
     * 私有构造方法
     */
    private ConfigManager() {
        m_file = new File(PFILE);
        m_lastModifiedTime = m_file.lastModified();
        if(m_lastModifiedTime == 0) {
            System.err.println(PFILE + "file not exist !");
        }
        m_props =  new Properties();
        try{
            m_props.load(new FileInputStream(PFILE));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 静态工厂方法
     * 返回ConfigManager类的单一实例
     */
    public synchronized static ConfigManager getInstance() {
        return m_instance;
    }
    /**
     * 读取一个特定的属性项
     */
}
