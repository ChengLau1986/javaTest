package org.lc.classInit;

/**
 * Created by Administrator on 2018/5/20.
 * 方法加载时的初始化
 */
public class test {
    
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        //创建对象触发初始化
//        Class psc = Person.class;
//        Object person = psc.newInstance();

        //调用静态方法
//        Person.test1();

        //静态字段
       int sdf =  Person.age;



    }
}
