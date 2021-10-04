package com.wl.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class ExPerson implements Externalizable {
    private String name;
    private int age;

    public ExPerson() {
    }

    public ExPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ExPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
    public void writeExternal(ObjectOutput out) throws IOException {
        StringBuffer stringBuffer = new StringBuffer("name=" + name);
        out.writeObject(stringBuffer);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        StringBuffer o = (StringBuffer) in.readObject();
        this.name = o.toString();
    }
}
