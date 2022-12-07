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


    static class Node {
        Node[] levelListNode = new Node[1];

        int score;

        //层级
        int level = levelListNode.length;

        @Override
        public String toString() {
            return "Node{" +
                    "levelListNode=" + level() +
                    ", score=" + score +
                    ", level=" + level +
                    '}';
        }

        String level() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (int i = 0; i < levelListNode.length; i++) {
                stringBuilder.append(i).append(":").append(levelListNode[i].score).append(",");
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }


    void add(int score) {
        Random random = new Random();
        double v = random.nextDouble();

        int level = 1;

        while (v < p && level < MAX_LEVEL) {
            level++;
            v = random.nextDouble();
        }


        //只需要插入
        Node node = new Node();
        node.level = level;
        node.score = score;
        node.levelListNode = new Node[level];


        if (header == null) {
            vaildLevel = level;
            header = new Node();
            header.levelListNode = new Node[vaildLevel];

            //header
            for (int j = 0; j < vaildLevel; j++) {
                header.levelListNode[j] = node;
            }

        } else {
            //查询
            Node listNode = header.levelListNode[vaildLevel - 1];
            int i = 0;
            while (i < vaildLevel && listNode != null) {
                if (score < listNode.score) {
                    listNode = listNode.levelListNode[vaildLevel - 1 - i];
                    i++;
                } else if (score > listNode.score) {
                    Node tempListNode = listNode.levelListNode[vaildLevel - 1 - i - 1];
                    if (tempListNode == null) {
                        listNode = header.levelListNode[vaildLevel - 1 - i];
                        i++;
                    } else {
                        if (tempListNode.score > score) {
                            break;
                        }
                    }
                } else {
                    //找到
                    break;
                }
            }

            //复制节点指针
            int level1 = listNode.level;
            for (int j = 0; j < level1; j++) {
                Node listNode1 = listNode.levelListNode[j];
                node.levelListNode[j] = listNode1;
                listNode.levelListNode[j] = node;
            }

            if (level > level1) {
                for (int j = level1; j < level && j < vaildLevel; j++) {
                    Node listNode1 = header.levelListNode[j];
                    while (listNode1 != null) {
                        if (listNode1.score >= score) {

                            break;
                        } else {
                            listNode1 = listNode1.next;
                        }
                    }
                }
            }

            //需要修改头尾节点
            if (header.level < level) {
                int oldVaildLevel = vaildLevel;
                vaildLevel = level;
                ListNode[] listNodes = new ListNode[vaildLevel];
                System.arraycopy(header.levelListNode, 0, listNodes, 0, header.levelListNode.length);
                header.levelListNode = listNodes;

                for (int j = oldVaildLevel; j < vaildLevel; j++) {
                    ListNode listNode1 = new ListNode();
                    listNode1.next = node.levelListNode[j];
                    listNodes[j] = listNode1;
                    listNodes[j].node = header;
                }
            }
        }


    }


    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.add(5);
        skipList.add(4);
        skipList.add(10);
        skipList.add(2);
        skipList.add(51);
        System.out.println(skipList.header);
    }


}
