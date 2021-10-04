package com.wl.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * PaperFloder class
 *
 * @author 南顾北衫
 * @date 2020/9/6 17:35
 * @email 17674641491@163.com
 */
public class PaperFloder {

    public static void main(String[] args) {
        Node tree = createTree1(4);
        System.out.println(tree);
        print(tree);
    }

    private static void print(Node node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            print(node.left);
        }
        System.out.println(node.getName());
        if (node.right != null) {
            print(node.right);
        }
    }

    //2.构建深度为N的折痕树；
    private static Node createTree(int N) {
        Node root = null;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                //1.第一次对折，只有一条折痕，创建根结点；
                root = new Node("down", null, null);
            } else {
                //2.如果不是第一次对折，则使用队列保存根结点；
                Queue<Node> queue = new ArrayDeque<>();
                queue.add(root);
                //3.循环遍历队列：
                while (!queue.isEmpty()) {
                    //3.1从队列中拿出一个结点；
                    Node tmp = queue.remove();
                    //3.2如果这个结点的左子结点不为空，则把这个左子结点添加到队列中；
                    if (tmp.left != null) {
                        queue.add(tmp.left);
                    }
                    //3.3如果这个结点的右子结点不为空，则把这个右子结点添加到队列中；
                    if (tmp.right != null) {
                        queue.add(tmp.right);
                    }
                    //3.4判断当前结点的左子结点和右子结点都不为空，如果是，则需要为当前结点创建一个值为down的左子结点，一个值为up的右子结点。
                    if (tmp.left == null && tmp.right == null) {
                        tmp.left = new Node("down", null, null);
                        tmp.right = new Node("up", null, null);
                    }
                }
            }
        }
        return root;
    }

    //2.构建深度为N的折痕树；
    private static Node createTree1(int N) {
        //如果只有一个那么就是down
        Node node = null;
        ArrayDeque<Node> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                node = new Node(null, null, "down");
            } else {
                deque.add(node);
                while (!deque.isEmpty()) {
                    Node remove = deque.remove();
                    if (remove.left != null) {
                        deque.add(remove.left);
                    }
                    if (remove.right != null) {
                        deque.add(remove.right);
                    }
                    if (remove.left == null && remove.right == null) {
                        remove.left = new Node(null, null, "down");
                        remove.right = new Node(null, null, "up");
                    }
                }
            }
        }
        return node;
    }

    static class Node {
        public Node(Node left, Node right, String name) {
            this.left = left;
            this.right = right;
            this.name = name;
        }

        public Node(String name, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", name='" + name + '\'' +
                    '}';
        }

        private Node left;
        private Node right;
        private String name;

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
