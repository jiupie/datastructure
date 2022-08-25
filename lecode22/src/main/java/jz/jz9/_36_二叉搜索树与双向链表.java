package jz.jz9;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 * <p>
 * https://assets.leetcode.com/uploads/2018/10/12/bstdlloriginalbst.png
 * <p>
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * <p>
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 * <p>
 * https://assets.leetcode.com/uploads/2018/10/12/bstdllreturndll.png
 * <p>
 * <p>
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 * <p>
 *
 * @author 南顾北衫
 */
public class _36_二叉搜索树与双向链表 {
    class Node {
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

    private List<Node> list = new ArrayList<>();

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        order(root);
        for (int i = 0; i < list.size(); i++) {
            int next = i + 1;
            if (next >= list.size()) {
                list.get(i).right = list.get(0);
            } else {
                list.get(i).right = list.get(next);
            }

            int pre = i - 1;
            if (pre < 0) {
                list.get(i).left = list.get(list.size() - 1);
            } else {
                list.get(i).left = list.get(pre);
            }
        }
        return list.get(0);
    }


    public void order(Node root) {
        if (root == null) {
            return;
        }
        order(root.left);
        list.add(root);
        order(root.right);
    }


}
