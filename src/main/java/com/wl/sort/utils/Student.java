package com.wl.sort.utils;

/**
 * Student class
 *
 * @author 南顾北衫
 * @date 2020/10/17 12:49
 * @email 17674641491@163.com
 */
public class Student implements Comparable<Student> {
    public int score;
    public int age;

    public Student(int score, int age) {
        this.score = score;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return age - o.age;
    }
}
