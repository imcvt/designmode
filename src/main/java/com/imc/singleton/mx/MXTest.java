package com.imc.singleton.mx;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

/**
 * @author luoly
 * @date 2018/11/29 20:12
 * @description
 */
public class MXTest {

    public static void main(String[] args) throws NamingException {
        Hashtable env = new Hashtable();
        env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
        env.put("java.naming.provider.url", "dns://202.101.172.35");
        DirContext dirContext = new InitialDirContext(env);
        Attributes attrs = dirContext.getAttributes("10.21.64.225", new String[]{"MX"});
        for(NamingEnumeration ae = attrs.getAll(); ae != null && ae.hasMoreElements();) {
            Attribute attribute = (Attribute) ae.next();
            NamingEnumeration e = attribute.getAll();
            while(e.hasMoreElements()) {
                String element = e.nextElement().toString();
                System.out.println(element);
            }
        }
    }
}
