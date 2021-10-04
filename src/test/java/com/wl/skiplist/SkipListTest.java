package com.wl.skiplist;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class SkipListTest {

    @Test
    public void add(){
        SkipList<Integer, String> skipList = new SkipList<>();
        skipList.add(2,"2");
        skipList.add(3,"3");
        skipList.add(4,"4");
        skipList.add(5,"5");
        skipList.add(6,"6");
        System.out.println(skipList);
        System.out.println(skipList.find(3));
        System.out.println(skipList.getSize());
        System.out.println(skipList.remove(3));
        System.out.println(skipList.find(3));
        System.out.println(skipList.getSize());
        System.out.println(skipList);
    }
    @Test
    public void random(){
        SkipList<Integer, String> skipList = new SkipList<>();
        for (int i = 0; i < 20; i++) {
            System.out.println(skipList.randomLevel());
        }
    }

}