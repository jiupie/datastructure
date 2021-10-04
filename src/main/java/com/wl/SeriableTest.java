package com.wl;

import com.wl.serializable.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class SeriableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.txt"));
        Person o = (Person) objectInputStream.readObject();
        System.out.println(o);

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        HashSet<String> h = new HashSet<>();
        h.add("sd");
        h.add("sxx");
        h.add("sxxpp");
        k(hashSet,h);
    }

    public static void k(Set<String>... keys) {
        System.out.println(Arrays.toString(keys));

    }


}
