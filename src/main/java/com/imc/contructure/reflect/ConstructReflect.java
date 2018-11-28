package com.imc.contructure.reflect;

import java.lang.reflect.Constructor;

/**
 * @author luoly
 * @date 2018/11/28 17:49
 * @description
 *       ********* getConstructor()和getDeclaredConstructor()区别：*********
 *       getDeclaredConstructor(Class<?>... parameterTypes)
 *       这个方法会返回制定参数类型的所有构造器，包括public的和非public的，当然也包括private的。
 *       getDeclaredConstructors()的返回结果就没有参数类型的过滤了。
 *
 *       再来看getConstructor(Class<?>... parameterTypes)
 *       这个方法返回的是上面那个方法返回结果的子集，只返回制定参数类型访问权限是public的构造器。
 *       getConstructors()的返回结果同样也没有参数类型的过滤。
 */
public class ConstructReflect {

    public ConstructReflect() {
        System.out.println("无参构造器");
    }
    public ConstructReflect(String a) {
        System.out.println("有1参数的构造器-->a=" + a);
    }
    public ConstructReflect(String a, int b) {
        System.out.println("有2参数的构造器-->a=" + a + ",b=" + b);
    }

    public static void main(String[] args) throws Exception{
        //getConstructor方法 2个参
        Class[] cls = new Class[]{String.class, int.class};
        ConstructReflect constructReflect = ConstructReflect.class.getConstructor(cls).newInstance("big", 2);
        System.out.println(constructReflect);

        //getDeclaredConstructor方法  无参
        ConstructReflect constructReflect1 = ConstructReflect.class.getDeclaredConstructor().newInstance();

        //getDeclaredConstructor方法  1个参
        ConstructReflect constructReflect2 = ConstructReflect.class.getDeclaredConstructor(String.class).newInstance("adfasdf");
    }
}
