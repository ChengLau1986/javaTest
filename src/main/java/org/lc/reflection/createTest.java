package org.lc.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Administrator on 2018/5/20.
 */
public class createTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //方式1：通过newInstance
//        Class psc = Person.class;
//        Object ps = psc.newInstance();

        //方式2：通过构造函数
        Class classType = Person.class;
        Constructor<Person> con = classType.getConstructor(String.class,int.class);
        Object obj = con.newInstance("lxf", 23);
    }
}
