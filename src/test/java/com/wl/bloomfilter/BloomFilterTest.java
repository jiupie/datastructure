package com.wl.bloomfilter;

import org.junit.Test;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class BloomFilterTest {

    @Test
    public void put() {
        BloomFilter<String> bloomFilter = new BloomFilter<>(1_0000_0000, 0.01);
        bloomFilter.put("a");
        bloomFilter.put("b");
        bloomFilter.put("c");
        bloomFilter.put("d");
        bloomFilter.put("e");

        System.out.println(bloomFilter.contains("a"));
        System.out.println(bloomFilter.contains("b"));
        System.out.println(bloomFilter.contains("c"));
        System.out.println(bloomFilter.contains("dsc"));
    }

    @Test
    public void contains() {
        BloomFilterDemo<String> bloomFilter = new BloomFilterDemo<>(1_0000_0000, 0.01);
        bloomFilter.put("a");
        bloomFilter.put("b");
        bloomFilter.put("c");
        bloomFilter.put("d");
        bloomFilter.put("e");

        System.out.println(bloomFilter.contains("a"));
        System.out.println(bloomFilter.contains("b"));
        System.out.println(bloomFilter.contains("c"));

    }
}