package org.lc.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/5/20.
 * 1 优点：
 （1）提高程序的灵活性和拓展性，能够在运行时动态地获取类的实例。
 （2）和java的动态编译相结合，可以提高更强大的功能。
 （3）提前无需硬编码，便可以通过类名获取对应类的实例，进而操作该实例。

  缺点：
  （1）性能较低，反射是一种接入式的操作需要找到对应的字段和方法，比起直接的代码赋值，要慢的多。
  （2）使用反射应该在一个相对安全的环境下进行。
  （3）使用时会破坏类的封装性，破坏OOP的整体设计思想。
 */
public class test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        GetMethod();
//        GetField();
    }

    public static void GetMethod() throws ClassNotFoundException {
        //Class是一个描述类的类、对每个类而言只有一个不变的Class与其对应、JRE中只有唯一一个
        Class clazz = null;

        //1 直接通过类名.class方式得到
        clazz = Person.class;
        //输出：reflection.Person
        System.out.println("直接通过类名.class得到:"+clazz);

        //2 通过对象的getClass()方法获取
        Object obj = new Person();
        clazz = obj.getClass();
        //输出：reflection.Person
        System.out.println("通过getClass(): " + clazz);

        //3 通过全类名获取，用的比较多，但可能抛出ClassNotFoundException异常
        clazz = Class.forName("org.lc.reflection.Person");
        //输出：reflection.Person
        System.out.println("通过全类名获取: " + clazz);
    }

    //获得类方法
    public static void GetMember() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //获取clazz
        Class clazz = Class.forName("reflection.Person");

        //1、得到clazz 对应的类中有哪些方法,不能获取private方法
        Method[] methods = clazz.getMethods();
        System.out.println("getMethods:");
        //遍历方法集合 获取对应的方法名称
        for (Method method : methods) {
            System.out.print(method.getName() + ", ");
        }
        System.out.println();
        //2、获取所有的方法(包括private方法）
        Method[] methods2 = clazz.getDeclaredMethods();
        System.out.println("getDeclaredMethods:");
        for (Method method : methods2) {
            System.out.print(method.getName() + ", ");
        }

        System.out.println();
        //3、获取指定的方法
        Method method = clazz.getDeclaredMethod("setName", String.class);
        System.out.println("method : " + method);

        Method method2 = clazz.getDeclaredMethod("setName", String.class, int.class);//第一个参数是方法名，后面的是方法里的参数
        System.out.println("method2: " + method2);

        //4、执行方法
        Object obj = clazz.newInstance();
        //此处注意下该invoke方法，参数为：执行该方法的对象，为该方法传入的参数列表
        method2.invoke(obj, "jaycee", 23);
    }

    public static void GetField() throws ClassNotFoundException,NoSuchFieldException,IllegalAccessException{
        Class clazz = Class.forName("org.lc.reflection.Person");

        //1、获取字段
        //1.1 获取Field的数组,私有字段也能获取
        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields) {
            System.out.print(field.getName() + ", ");
        }

        //1.2 获取指定名字的Field
        Field field = clazz.getDeclaredField("name");
        System.out.println("\n获取指定Field名=: " + field.getName());

        Person person = new Person("jaycee", 23);
        //2、获取指定对象的Field的值
        Object val = field.get(person);
        System.out.println("获取指定对象字段'name'的Field的值=：" + val);

        //3、设置指定对象的Field的值
        field.set(person, "admin");
        System.out.println("设置指定对象字段'name'的Field的值=: " + person.name);

        //4、若该字段是私有的，需要调用setAccessible(true)方法
        Field field2 = clazz.getDeclaredField("age");
        field2.setAccessible(true);
        System.out.println("获取指定私有字段名=: " + field2.getName());
    }

    //获得父类
    public static void GetParentClass() throws ClassNotFoundException {
            String className = "reflection.invoke.Son";
            Class clazz = Class.forName(className);
            //得到父类的Class
            Class superClazz = clazz.getSuperclass();
            //输出：class reflection.invoke.Father
            System.out.println(superClazz);
        }
}
