package org.lc.classInit;

/**
 * Created by Administrator on 2018/5/20.
 */
public class Person {
    public static int age=32;

    static {
        System.out.println("静态代码");
    }

    public Person(){
        System.out.println("构造函数");
    }

    public static void test1(){
        System.out.println("静态方法test1"+age);
    }

}
