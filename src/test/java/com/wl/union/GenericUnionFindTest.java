package com.wl.union;

import org.junit.Test;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class GenericUnionFindTest {
    @Test
    public void test() {
        GenericUnionFind<Student> unionFind = new GenericUnionFind<>();
        Student student = new Student("xi", 12, "1");
        Student student1 = new Student("hi", 22, "2");
        Student student2 = new Student("as", 20, "2");
        Student student3 = new Student("sd", 22, "1");
        Student student4 = new Student("es", 12, "1");
        unionFind.makeSet(student);
        unionFind.makeSet(student1);
        unionFind.makeSet(student2);
        unionFind.makeSet(student3);
        unionFind.makeSet(student4);

        unionFind.union(student, student1);
        unionFind.union(student2, student1);
        unionFind.union(student2, student3);

        System.out.println(unionFind.find(student));
        System.out.println(unionFind.find(student1));
        System.out.println(unionFind.find(student2));
        System.out.println(unionFind.find(student3));
        System.out.println(unionFind.find(student4));
    }

}