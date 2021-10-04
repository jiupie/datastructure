package com.wl.tree;

import com.wl.tree.utils.printer.BinaryTreeInfo;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;

/**
 * SearchBinaryTree class
 * 二叉树
 * 小码哥 黑马
 *
 * @author 南顾北衫
 * @date 2020/9/5 10:42
 * @email 17674641491@163.com
 */

public class SearchBinaryTree<Key, Value> implements BinaryTreeInfo {
    //根节点
    private Node<Key, Value> root;
    private static int N;
    private Comparator<Key> comparator;

    public Node<Key, Value> getRoot() {
        return root;
    }

    private int compare(Key k1, Key k2) {
        if (comparator != null) {
            return comparator.compare(k1, k2);
        } else {
            return ((Comparable<Key>) k1).compareTo(k2);
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    /**
     * 层序遍历
     */
    public void traversal() {
        traversal(root);
    }

    private void traversal(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.remove();
            System.out.print(" " + node.getKey());
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 判断是否为完全二叉树
     *
     * @return
     */
    public boolean isComplete() {
        return isComplete(root);
    }

    /**
     * node.left==null&&node.right!=null 不是完全二叉树
     * 满足node.left==null&&node.right==null 或者 node.left！=null&&node.right==null，那么
     * 后面的节点都是叶子节点
     *
     * @param root
     * @return
     */
    private boolean isComplete(Node<Key, Value> root) {
        ArrayDeque<Node<Key, Value>> deque = new ArrayDeque<>();
        deque.add(root);
        boolean leaf = false;
        while (!deque.isEmpty()) {
            Node<Key, Value> remove = deque.remove();
            if (leaf && !isLeaf(remove)) {
                return false;
            }
            if (remove.left != null && remove.right != null) {
                deque.add(remove.left);
                deque.add(remove.right);
            } else if (remove.left == null && remove.right != null) {
                return false;
            } else if ((remove.left == null && remove.right == null) || (remove.left != null && remove.right == null)) {
                //后面节点需要全部都是叶子节点
                leaf = true;
                //为了防止left节点没有被遍历
                if (remove.left != null) {
                    deque.add(remove.left);
                }

            }
        }
        return true;
    }

    /**
     * 判断是否是叶子节点
     *
     * @param node
     * @return
     */
    public boolean isLeaf(Node<Key, Value> node) {
        if (node.left == null && node.right == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 插入 ，大的在右边 小的在左边 ，递归
     *
     * @param x
     * @param key
     * @param value
     * @return
     */
    private Node put(Node x, Key key, Value value) {
        //添加第一个节点
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }

        int i = compare(key, (Key) x.key);//添加 根
        if (i > 0) {
            //新结点的key大于当前结点的key，继续找当前结点的右子结点
            x.right = put(x.right, key, value);//------
        } else if (i < 0) {
            //新结点的key大于当前结点的key，继续找当前结点的左子结点
            x.left = put(x.left, key, value);//----
        } else {
            x.value = value;
        }
        return x;
    }

    /**
     * 翻转二叉树
     */
    public void reserveTree() {
        reserveTree(root);
    }

    private void reserveTree(Node<Key, Value> node) {
        if (node == null) {
            return;
        }

        Node<Key, Value> tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;

        reserveTree(node.left);
        reserveTree(node.right);
    }

    /**
     * 复制二叉树
     *
     * @return
     */
    public SearchBinaryTree<Key, Value> copyTree() {
        SearchBinaryTree<Key, Value> tree = new SearchBinaryTree<>();
        tree.root = copyTree(root);
        return tree;
    }

    private Node<Key, Value> copyTree(Node<Key, Value> node) {
        if (node == null) {
            return null;
        }
        Node<Key, Value> node1 = new Node<>(node.key, node.value, node.left, node.right);
        copyTree(node.left);
        copyTree(node.right);
        return node1;
    }

    /**
     * 寻找前驱节点
     * 1.左子树不为空   predecessor = node.left.right....终结条件：right = null
     * 2.左子树为空，父节点不为空 predecessor = node.parent.parent.parent.....终结条件：node在parent的右子树中。
     * 3.左子树为空且父节点为空   那就没有前驱节点
     *
     * @param node
     * @return
     */
    public Node<Key, Value> predecessor(Node<Key, Value> node) {
        if (node == null) {
            return null;
        }
        //1.左子树不为空
        if (node.left != null) {
            Node left = node.left;
            while (left.right != null) {
                left = left.right;
            }
            return left;
        }
        //2.左子树为空，父节点不为空
        if (node.left == null && foundParent(node) != null) {
            Node<Key, Value> tempNode = null;
            while ((tempNode = foundParent(node)) != null) {
                if (tempNode.right == node) {
                    return tempNode;
                }
                node = tempNode;
            }
        }

        //3.左子树为空且父节点为空
        if (node.left == null && foundParent(node) == null) {
            return null;
        }
        return null;
    }

    /**
     * 寻找后继节点
     * 1.右子树不为空且父节点不为空   predecessor = node.right.left
     * 2.右子树为空 父节点不为空
     * 3.右子树为空且父节点为空   那就没有前驱节点
     *
     * @param node
     * @return
     */
    public Node<Key, Value> successor(Node<Key, Value> node) {
        if (node == null) {
            return null;
        }
        //1.左子树不为空
        if (node.right != null) {
            Node left = node.right;
            while (left.left != null) {
                left = left.left;
            }
            return left;
        }
        //2.左子树为空，父节点不为空
        if (node.right == null && foundParent(node) != null) {
            Node<Key, Value> tempNode = null;
            while ((tempNode = foundParent(node)) != null) {
                if (tempNode.left == node) {
                    return tempNode;
                }
                node = tempNode;
            }
        }

        //3.左子树为空且父节点为空
        if (node.right == null && foundParent(node) == null) {
            return null;
        }
        return null;
    }


    public void add(Key key, Value value) {
        root = add(root, key, value);
    }

    /**
     * 非递归方式
     *
     * @param x
     * @param key
     * @param value
     * @return
     */
    private Node add(Node x, Key key, Value value) {
        //添加第一个节点
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }

        //添加不是第一个节点
        //记录插入元素的父节点
        Node parent = root;
        Node node = root;
        //记录最后一次是插入左子树还是右子树
        int cmp = 0;
        while (node != null) {
            cmp = compare(key, (Key) node.key);//添加 根

            //保存父节点
            parent = node;
            if (cmp > 0) {
                //新结点的key大于当前结点的key，继续找当前结点的右子结点
                node = node.right;
            } else if (cmp < 0) {
                //新结点的key大于当前结点的key，继续找当前结点的左子结点
                node = node.left;
            } else {//相等
                node.value = value;
                return x;
            }
        }
        Node newNode = new Node(key, value, null, null);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        return x;
    }


    /**
     * 查找
     *
     * @return
     */
    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node temp, Key key) {
        int i = compare(key, (Key) temp.key);//添加 根
        Value value = null;
        if (i > 0) {
            value = (Value) get(temp.right, key);
        } else if (i < 0) {
            value = (Value) get(temp.left, key);
        } else {
            return (Value) temp.value;
        }
        return value;
    }


    public void remove(Key key) {
        Node<Key, Value> node = getNode(key);
        remove(node);
    }

    /**
     * 移除节点
     * 1.移除度为2的节点，如果移除的节点的度为2，可以使用前驱节点或者后继节点替换他的位置，
     * 2.如果度为1的节点，使用左子节点或者右子节点代替，如果node根节点，
     * 3.
     *
     * @param node
     */
    private void remove(Node<Key, Value> node) {
        N--;
        //删除度为2的节点
        if (hasTwoChildren(node)) {
            //使用前驱节点代替要删除的节点
            Node<Key, Value> predecessor = predecessor(node);
            node.key = predecessor.key;
            node.value = predecessor.value;
            node = predecessor;
        }

        //度为1或者为0的节点
        Node<Key, Value> repleacement = node.left != null ? node.left : node.right;

        //说明是度为1的节点
        if (repleacement != null) {
            Node<Key, Value> parent = foundParent(node);
            //有父节点
            if (parent != null) {
                if (parent.left == node) {
                    parent.left = repleacement;
                } else if (parent.right==node) {
                    parent.right = repleacement;
                }
            } else {//没有父节点，也就是根节点时候
                root = node;
            }
        } else {//说明度为0，删除度为0的节点
            Node<Key, Value> parent = foundParent(node);
            //说明不是根节点
            if (parent != null) {
                if (parent.left == node) {
                    parent.left = null;
                } else if (parent.right == node) {
                    parent.right = null;
                }
            } else {//是根节点
                root = null;
            }
        }


    }

    /**
     * 判断该节点是否是度为2
     *
     * @param node
     * @return
     */
    private boolean hasTwoChildren(Node<Key, Value> node) {
        if (node.left != null && node.right != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过key获取Node
     *
     * @param key
     * @return
     */
    public Node<Key, Value> getNode(Key key) {
        Node<Key, Value> tempNode = root;
        while (tempNode != null) {
            int compare = compare(key, tempNode.key);
            if (compare == 0) {
                return tempNode;
            } else if (compare > 0) {
                tempNode = tempNode.right;
            } else {
                tempNode = tempNode.left;
            }
        }
        return null;
    }


    /**
     * 删除  左子树 右子节点的左边
     *
     * @return
     */
    public void delete(Key key) {
        delete(root, key);
    }

    private Node delete(Node<Key, Value> temp, Key key) {
        if (temp == null) {
            return null;
        }
        int i = compare(key, (Key) temp.key);
        if (i > 0) {
            temp.right = delete(temp.right, key);
        } else if (i < 0) {
            temp.left = delete(temp.left, key);
        } else {

            if (temp.right == null) {
                return temp.left;
            }
            if (temp.left == null) {
                return temp.right;
            }

            //node是要删除的元素
            //minNode是要替换node的位置的元素
            //找到要删除元素右子树上的左子树最底部
            Node minNode = temp.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }

            //删除右子树最小的节点
            Node n = temp.right;
            while (n.left == null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }

            minNode.left = temp.left;
            minNode.right = temp.right;
            N = N - 1;
            temp = minNode;

        }
        return temp;
    }


    public Node getMin() {
        return getMin(root);
    }

    /**
     * 获取最小值
     *
     * @param node
     * @return
     */
    private Node getMin(Node<Key, Value> node) {
        while (node.left != null) {
            if (node.left.left == null) {
                return node.left;
            } else {
                node = node.left;
            }
        }
        return node;
    }

    public Node getMax() {
        return getMax(root);
    }

    /**
     * 获取树的最大值
     *
     * @param node
     * @return
     */
    private Node getMax(Node<Key, Value> node) {
        while (node.right != null) {
            if (node.right.right == null) {
                return node.right;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    public int size() {
        return N;
    }


    public int getMaxDepth() {
        return getMaxDepth(root);
    }

    /**
     * 获取二叉查找树的最大深度
     *
     * @param node
     * @return
     */
    private int getMaxDepth(Node<Key, Value> node) {
        if (node == null) {
            return 0;
        }
        int maxLeft = 0;
        int maxRight = 0;
        if (node.left != null) {
            maxLeft = getMaxDepth(node.left);
        }
        if (node.right != null) {
            maxRight = getMaxDepth(node.right);
        }
        return maxLeft > maxRight ? maxLeft + 1 : maxRight + 1;
    }

    /**
     * 先序
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(" " + node.getKey());
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }


    /**
     * 中序
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inOrder(node.left);
        }

        System.out.print(" " + node.getKey());

        if (node.right != null) {
            inOrder(node.right);
        }
    }

    public Node<Key, Value> foundParent(Node<Key, Value> node) {
        return foundParent(root, node);
    }

    /**
     * 寻找节点的parent,递归
     *
     * @param parent
     * @param node
     * @return
     */
    private Node<Key, Value> foundParent(Node<Key, Value> parent, Node<Key, Value> node) {
        if (parent == null || parent.left == node || parent.right == node) {
            return parent;
        }

        Node left = foundParent(parent.left, node);
        if (left != null) {
            return left;
        }
        Node right = foundParent(parent.right, node);
        if (right != null) {
            return right;
        }
        return left;
    }

    /**
     * 寻找父节点 ，迭代方式
     *
     * @param node
     * @return
     */
    public Node<Key, Value> foundParentIteration(Node<Key, Value> node) {
        Node temp = root;
        ArrayDeque<Node<Key, Value>> deque = new ArrayDeque<>();
        deque.add(temp);
        while (!deque.isEmpty()) {
            Node<Key, Value> remove = deque.remove();
            if (remove.left != null) {
                if (remove.left == node) {
                    return remove;
                }
                deque.add(remove.left);
            }

            if (remove.right != null) {
                if (remove.right == node) {
                    return remove;
                }
                deque.add(remove.right);
            }
        }
        return null;
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node) node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node) node).value;
    }


    class Node<Key, Value> {

        private Key key;
        private Value value;
        public Node left;
        public Node right;

        public Key getKey() {
            return key;
        }

        public void setKey(Key key) {
            this.key = key;
        }

        public Value getValue() {
            return value;
        }

        public void setValue(Value value) {
            this.value = value;
        }

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

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }
}

