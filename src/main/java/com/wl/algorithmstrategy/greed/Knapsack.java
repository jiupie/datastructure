package com.wl.algorithmstrategy.greed;

import java.util.Arrays;

/**
 * 0-1背包问题
 * <p>
 * 有n件物品和一个最大承重为W的背包，每件物品点重量是W<sub>i</sub>、价值是V<sub>i</sub>
 * <p>
 * 再保证总重量不超过W点前提下，将那几件物品放入背包，可以使得背包的总价值最大
 * <p>
 * 注意：每个物品只有1件，也就是每个物品只能选择0件或者1件，因此称为0-1背包问题
 * <p>
 * 如果采取贪心算法策略一共有三种方法：
 * <p>
 * 1.价值主导：优先选择价值最高的物品放入书包中
 * <p>
 * 2.重量主导：优先选择重量最轻的放入背包中
 * <p>
 * 3.价值密度主导：优先选择价值密度最高的放入背包中（价值密度=价值/价值重量）
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class Knapsack {
    public static void main(String[] args) {
        Article[] articles = {new Article(35, 10),
                new Article(30, 40), new Article(60, 30), new Article(50, 50),
                new Article(40, 35), new Article(10, 40), new Article(25, 30)
        };
        //背包最大的承重量
        int weight = 150;
//        weightMain(articles, weight);
        densityMain(articles, weight);

    }

    /**
     * 价值主导
     * 130
     *
     * @param articles
     */
    public static void valuesMain(Article[] articles, int weight) {
        //1.价值主导：优先选择价值最高的物品放入书包中
        Arrays.sort(articles, (a1, a2) -> a2.values - a1.values);

        int sum = 0;
        for (int i = 0; i < articles.length; i++) {
            if (weight - sum >= articles[i].weight) {
                sum += articles[i].weight;
                System.out.println(articles[i]);
            }
        }
        System.out.println(sum);
    }

    /**
     * 重量主导
     * 140
     *
     * @param articles
     * @param weight
     */
    public static void weightMain(Article[] articles, int weight) {
        //1.价值主导：优先选择价值最高的物品放入书包中
        Arrays.sort(articles, (a1, a2) -> a1.weight - a2.weight);

        int sum = 0;
        for (int i = 0; i < articles.length; i++) {
            if (weight - sum >= articles[i].weight) {
                sum += articles[i].weight;
                System.out.println(articles[i]);
            }
        }
        System.out.println(sum);
    }

    /**
     * 价值密度主导
     *
     * @param articles
     * @param weight
     */
    public static void densityMain(Article[] articles, int weight) {
        //1.价值主导：优先选择价值最高的物品放入书包中
        Arrays.sort(articles, (a1, a2) -> Double.compare(a2.density, a1.density));

        int sum = 0;
        for (int i = 0; i < articles.length; i++) {
            if (weight - sum >= articles[i].weight) {
                sum += articles[i].weight;
                System.out.println(articles[i]);
            }
        }
        System.out.println("总重量:" + sum);
    }
}

/**
 * 物品类
 */
class Article {
    /**
     * 重量
     */
    Integer weight;

    /**
     * 价值
     */
    Integer values;

    /**
     * 价值密度
     */
    Double density;

    public Article(Integer weight, Integer values) {
        this.weight = weight;
        this.values = values;
        this.density = values * 1.0 / weight;
    }

    @Override
    public String toString() {
        return "Article{" +
                "weight=" + weight +
                ", values=" + values +
                ", density=" + density +
                '}';
    }
}
