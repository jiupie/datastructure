package com.wl.algorithmstrategy.greed;

import java.util.Arrays;

/**
 * 贪心策略
 * <p>
 * 加勒比海盗问题
 * <p>
 * 在北美洲东南部，有一片神秘的海域，是海盗最活跃的加勒比海
 * 有一天，海盗们截获了一艘装满各种各样古董的货胎，每一件都价值连城，一旦打碎就失去了他的价值
 * 海盗船的载重量为W，每件古董的重量为W<sub>i</sub>，海盗们该如何把尽可能多数量的古董装上海盗船?
 * 比如W为30，W<sub>i</sub>分别为3、5、4、10、7、14、2、11
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class Pirate {
    public static void main(String[] args) {
        int[] w = {3, 5, 4, 10, 7, 14, 2, 11};
        Arrays.sort(w);
        int weight = 30;
        int sumWeight = 0;
        for (int i = 0; i < w.length; i++) {
            if (weight - sumWeight >w[i]) {
                sumWeight += w[i];
                System.out.println(w[i]);
            }
        }
        System.out.println(sumWeight);
    }

}
