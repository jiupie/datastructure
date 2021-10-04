package com.wl.serializable;

import java.io.Serializable;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1000L;
    private String name;
    private int age;

    /**
     * 在序列化时，会先调用此方法，再调用writeObject方法。此方法可将任意对象代替目标序列化对象
     * 反序列时返回的对象类型也要一致
     *
     * @return
     */
   /* private Object writeReplace() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        return list;
    }*/
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
}
