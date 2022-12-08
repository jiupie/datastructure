package jz.datastructure;

import java.util.Random;

/**
 * @author 南顾北衫
 * @date 2022/12/7
 */
public class SkipList {
    private static int MAX_LEVEL = 32;
    private int vaildLevel = 1;
    private double p = 0.25;

    private Node header;

    public SkipList() {
        header = new Node();
        header.level = MAX_LEVEL;
        header.levelListNode = new Node[MAX_LEVEL];
    }

    static class Node {
        Node[] levelListNode;

        int score;

        //层级
        int level;

    }


    void add(int score) {

        //只需要插入
        Node node = new Node();
        node.level = randomLevel();
        node.score = score;
        node.levelListNode = new Node[node.level];

        //找到每个前驱节点
        Node[] preNode = new Node[node.level];
        for (int i = 0; i < node.level; i++) {
            Node node1 = header;
            Node tempNode = node1.levelListNode[i];
            while (tempNode != null) {
                if (score > tempNode.score) {
                    node1 = tempNode;
                    tempNode = tempNode.levelListNode[i];
                } else {
                    break;
                }
            }
            preNode[i] = node1;
        }

        for (int i = 0; i < node.level; i++) {
            if (i >= vaildLevel) {
                header.levelListNode[i] = node;
            } else {
                Node node1 = preNode[i].levelListNode[i];
                preNode[i].levelListNode[i] = node;
                node.levelListNode[i] = node1;
            }
        }
        if (node.level > vaildLevel) {
            vaildLevel = node.level;
        }


    }


    int randomLevel() {
        Random random = new Random();
        double v = random.nextDouble();

        int level = 1;

        while (v < p && level < MAX_LEVEL) {
            level++;
            v = random.nextDouble();
        }
        return level;
    }

    String toStr() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("一共有" + vaildLevel + "层\n");

        for (int i = 0; i < vaildLevel; i++) {
            Node tempNode = header;
            while (tempNode != null) {
                stringBuilder.append("\t");
                stringBuilder.append(tempNode.level+"_").append(i).append(":").append(tempNode.score).append("\t");
                tempNode = tempNode.levelListNode[i];
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.add(5);
        skipList.add(4);
        skipList.add(10);
        skipList.add(2);
        skipList.add(51);
        System.out.println(skipList.toStr());
    }


}
