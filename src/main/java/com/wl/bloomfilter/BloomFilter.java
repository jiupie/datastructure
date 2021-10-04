package com.wl.bloomfilter;

/**
 * 布隆过滤器
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class BloomFilter<T> {
    /**
     * 二进制向量
     */
    private long[] bitMaps;

    /**
     * 二进制向量位数
     */
    private int bitSize;

    /**
     * hash函数的个数
     */
    private int hashSize;

    /**
     * 初始化二进制向量位数和hash函数个数
     * 二进制位的个数：m=-(nlnp)/(ln2)^2
     * 哈希函数个数：k=(m*ln2)/n
     *
     * @param n 数据规模
     * @param p 误判率（0，1）
     */
    public BloomFilter(int n, double p) {
        double ln2 = Math.log(2);
        //二进制向量位数
        bitSize = (int) -((n * Math.log(p)) / (ln2 * ln2));
        //hash函数个数
        hashSize = (int) ((bitSize / n) * ln2);

        bitMaps = new long[(bitSize + Long.SIZE - 1) / Long.SIZE];
        System.out.println("bitSize=" + bitSize);
        System.out.println("hashSize=" + hashSize);
        // 分页问题:
        // 每一页显示100条数据, pageSize = 100
        // 一共有999999条数据, n = 999999
        // 请问有多少页 pageCount = (n + pageSize - 1) / pageSize
    }


    /**
     * 把元素放入布隆过滤器
     *
     * @param value
     */
    public void put(T value) {
        int hash1 = value.hashCode();
        int hash2 = hash1 << 16;
        for (int i = 0; i < hashSize; i++) {
            int combinedHash = hash1 + (hash2 * i);
            //不能为负数
            if (combinedHash < 0) {
                combinedHash = ~combinedHash;
            }
            int index = combinedHash % bitSize;
            setBit(index);
        }

    }

    /**
     * 传入索引把该位置的bit设置为1
     * 10000001
     * | 01000000
     *
     * @param index
     */
    private void setBit(int index) {
       /* //100-64=36  1
        //在bitMap数组中的位置
        int i = index / Long.SIZE;
        //在该位置中的位数
        int j = index - (i  * Long.SIZE);
        bitMaps[i] |= 1 << j;*/


        // 对应的long值
        long value = bitMaps[index / Long.SIZE];
        int bitValue = 1 << (index % Long.SIZE);
        bitMaps[index / Long.SIZE] = value | bitValue;
    }


    /**
     * 判断是否存在
     *
     * @return
     */
    public Boolean contains(T value) {
        int hash1 = value.hashCode();
        int hash2 = hash1 << 16;
        for (int i = 0; i < hashSize; i++) {
            int combinedHash = hash1 + (hash2 * i);
            //不能为负数
            if (combinedHash < 0) {
                combinedHash = ~combinedHash;
            }
            int index = combinedHash % bitSize;
            if (!getBit(index)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 查看在二进制变量在index处的bit是1还是0
     * 10000001
     * & 01000000
     * ------------
     *
     * @param index
     * @return
     */
    private boolean getBit(int index) {
        int i = index / Long.SIZE;
        int j = index - (i * Long.SIZE);
        long temp = bitMaps[i];
        temp &= 1 << j;
        return temp != 0;
    }
}
