package org.lc.reflection;

/**
 * Created by Administrator on 2018/5/20.
 */
public class Person {
        public String name;
        private int age;

        public Person(){
            System.out.println("无参构造器");
        }
        public Person(String name,int age){
            this.name = name;
            this.age = age;
            System.out.println("有参构造器");
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        private void privateMethod(){
            System.out.println("这是一个私有的方法！");
        }

        public void setName(String name,int age){
            System.out.println("getName is:"+name);
            System.out.println("getAge is:"+age);
        }
}
