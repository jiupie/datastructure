package jz.newcode;

/**
 * @author 南顾北衫
 * @date 2022/11/22
 */
public class _36_ {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(-1);
        Node node2 = new Node(1);
        Node node3 = new Node(9);
//        Node node4 = new Node(4);
//        Node node5 = new Node(5);
        node1.right = node2;
        node2.right = node3;
//        node2.left = node1;
//        node2.right = node3;
        _36_ v = new _36_();
        Node node = v.treeToDoublyList(node1);
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        node(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private Node pre, head;

    private void node(Node node) {
        if (node == null) {
            return;
        }

        //左
        node(node.left);


        //中
        if (pre != null) {
            node.left = pre;
            pre.right = node;
        } else {
            head = node;
        }
        pre = node;


        //右
        node(node.right);
    }
}
