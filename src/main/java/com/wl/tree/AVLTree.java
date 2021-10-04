package com.wl.tree;

import com.wl.tree.utils.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * AvlTree class
 *
 * @author 南顾北衫
 * @date 2020/9/22 16:37
 * @email 17674641491@163.com
 */
public class AVLTree<E> implements BinaryTreeInfo {
    private int N;
    private AVLNode<E> root;
    private Comparator<E> comparator;

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((AVLNode<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((AVLNode<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        return ((AVLNode<E>) node).e + "_h(" + ((AVLNode<E>) node).height + ")";
    }

    private static class AVLNode<E> {
        private E e;
        public AVLNode<E> parent;
        public AVLNode<E> left;
        public AVLNode<E> right;
        private int height = 1;

        public int balanceFactor() { // 获取该节点平衡因子(左子树高度 - 右子树高度)
            int leftHeight = left == null ? 0 : left.height;
            int rightHeight = right == null ? 0 : right.height;
            return leftHeight - rightHeight;
        }

        public void updateHeight() { // 更新高度
            int leftHeight = left == null ? 0 : left.height;
            int rightHeight = right == null ? 0 : right.height;
            height = 1 + Math.max(leftHeight, rightHeight);
        }

        public AVLNode(E e, AVLNode<E> parent, AVLNode<E> left, AVLNode<E> right) {
            this.e = e;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public AVLNode<E> tallerChild() {
            int leftHeight = left == null ? 0 : left.height;
            int rightHeight = right == null ? 0 : right.height;
            return leftHeight > rightHeight ? left : right;
        }

        public boolean isLeftChild() {
            if (parent != null && parent.left == this) {
                return true;
            }
            return false;
        }

        public boolean isRightChild() {
            if (parent != null && parent.right == this) {
                return true;
            }
            return false;
        }
    }


    /**
     * 增加节点后的调整
     */
    public void afterAdd(AVLNode<E> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) { // 如果平衡
                // 更新高度
                updateHeight(node);
            } else { // 如果不平衡
                // 恢复平衡
                rebalance(node);
                // AVL树中, 只要恢复了最下面的子树的平衡, 则整棵树恢复平衡
                break;
            }
        }
    }

    /**
     * 1.左子树的右子树
     * 2.父子节点 父子节点的右节点
     * 3.父节点为null并且没有左子树，那么就是没有前驱节点
     * 前驱节点
     */
    public AVLNode<E> predecessor(AVLNode<E> node) {
        if (node == null) {
            return null;
        }
        //1.左子树不为空
        if (node.left != null) {
            AVLNode<E> left = node.left;
            while (left.right != null) {
                left = left.right;
            }
            return left;
        }
        //2.左子树为空，父节点不为空
        if (node.left == null && node.parent != null) {
            AVLNode<E> tempNode = null;
            while ((tempNode = node.parent) != null) {
                if (tempNode.right == node) {
                    return tempNode;
                }
                node = tempNode;
            }
        }
        //3.左子树为空且父节点为空
        if (node.left == null && node.parent == null) {
            return null;
        }
        return null;
    }

    /**
     * 删除的节点
     */
    public void remove(E e) {
        AVLNode<E> node = getNode(e);
        remove(node);
    }

    /**
     * 通过key获取Node
     *
     * @param e
     * @return
     */
    public AVLNode<E> getNode(E e) {
        AVLNode<E> tempNode = root;
        while (tempNode != null) {
            int compare = compare(e, tempNode.e);
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
     * 1.度为2的节点，删除，使用前驱节点代替
     * 2.度为1的节点，删除，子节点代替
     * 3.度为0的节点，删除，该节点置为null
     */
    public void remove(AVLNode<E> node) {
        N--;
        //删除度为2的节点
        if (hasTwoChildren(node)) {
            //使用前驱节点代替要删除的节点
            AVLNode<E> predecessor = predecessor(node);
            node.e = predecessor.e;
            //删除后继节点
            node = predecessor;
        }
        //度为1或者为0的节点
        AVLNode<E> repleacement = node.left != null ? node.left : node.right;
        //说明是度为1的节点
        if (repleacement != null) {
            AVLNode<E> parent = node.parent;
            //有父节点
            if (parent != null) {
                if (parent.left == node) {
                    parent.left = repleacement;
                } else if (parent.right == node) {
                    parent.right = repleacement;
                }
            } else {//没有父节点，也就是根节点时候
                root = node;
            }
            afterRemove(node);
        } else {//说明度为0，删除度为0的节点
            AVLNode<E> parent = node.parent;
            //说明不是根节点
            if (parent != null) {
                if (parent.left == node) {
                    parent.left = null;
                } else if (parent.right == node) {
                    parent.right = null;
                }
                afterRemove(node);
            } else {//是根节点
                root = null;
                afterRemove(node);
            }
        }
    }

    /**
     * 删除节点后的调整
     */
    public void afterRemove(AVLNode<E> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) { // 如果平衡
                // 更新高度
                updateHeight(node);
            } else { // 如果不平衡
                // 恢复平衡
                rebalance(node);
            }
        }
    }

    /**
     * 判断该节点是否是度为2
     *
     * @param node
     * @return
     */
    private boolean hasTwoChildren(AVLNode<E> node) {
        if (node.left != null && node.right != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 恢复平衡
     *
     * @param grand
     */
    private void rebalance(AVLNode<E> grand) {
        //获取父节点
        AVLNode<E> parent = grand.tallerChild();

        //获取子字节
        AVLNode<E> node = parent.tallerChild();

        if (parent.isLeftChild()) {//L
            if (node.isLeftChild()) {//LL
                rotateRight(grand);
            } else {//LR
                rotateLeft(parent);
                rotateRight(grand);
            }
        } else {//R
            if (node.isRightChild()) {//RR
                rotateLeft(grand);
            } else {//RL
                rotateRight(parent);
                rotateLeft(grand);
            }
        }

    }

    private void rotateLeft(AVLNode<E> grand) {
        AVLNode<E> grandParentNode = grand.parent;
        AVLNode<E> parent = grand.right;
        AVLNode<E> child = parent.left;
        grand.right = child;
        parent.left = grand;
        if (grandParentNode == null) {
            root = parent;
        } else if (grandParentNode != null && grandParentNode.left == grand) {
            grandParentNode.left = parent;
        } else if (grandParentNode != null && grandParentNode.right == grand) {
            grandParentNode.right = parent;
        }
        //修改grand和parent的父节点
        grand.parent = parent;
        // 让parent成为子树的根节点
        parent.parent = grandParentNode;
        // 更新child的parent
        if (child != null) {
            child.parent = grand;
        }
        updateHeight(grand);
        updateHeight(parent);
    }

    private void rotateRight(AVLNode<E> grand) {
        AVLNode<E> grandParentNode = grand.parent;//祖父节点的父节点
        AVLNode<E> parent = grand.left;//父节点
        AVLNode<E> child = parent.right;
        grand.left = child;
        //如果child是null
        parent.right = grand;
        if (grandParentNode == null) {
            root = parent;
        } else if (grandParentNode != null && grandParentNode.left == grand) {
            grandParentNode.left = parent;
        } else if (grandParentNode != null && grandParentNode.right == grand) {
            grandParentNode.right = parent;
        }
        //修改grand和parent的父节点
        grand.parent = parent;
        // 让parent成为子树的根节点
        parent.parent = grandParentNode;
        // 更新child的parent
        if (child != null) {
            child.parent = grand;
        }
        updateHeight(grand);
        updateHeight(parent);
    }

    /**
     * 是否平衡
     *
     * @param node
     * @return
     */
    private boolean isBalanced(AVLNode<E> node) {
        return Math.abs(node.balanceFactor()) <= 1 ? true : false;
    }

    /**
     * 更新高度
     */
    private void updateHeight(AVLNode<E> node) {
        node.updateHeight();
    }

    public void add(E e) {
        AVLNode<E> node = add(root, e);
        afterAdd(node);
    }

    /**
     * 非递归方式
     *
     * @param x
     * @param e
     * @return
     */
    private AVLNode<E> add(AVLNode<E> x, E e) {
        //添加第一个节点
        if (x == null) {
            N++;
            AVLNode<E> node = new AVLNode<>(e, null, null, null);
            root = node;
            return node;
        }

        //添加不是第一个节点
        //记录插入元素的父节点
        AVLNode<E> parent = root;
        AVLNode<E> node = root;
        //记录最后一次是插入左子树还是右子树
        int cmp = 0;
        while (node != null) {
            cmp = compare(e, node.e);//添加 根
            //保存父节点
            parent = node;
            if (cmp > 0) {
                //新结点的key大于当前结点的key，继续找当前结点的右子结点
                node = node.right;
            } else if (cmp < 0) {
                //新结点的key大于当前结点的key，继续找当前结点的左子结点
                node = node.left;
            } else {//相等
                node.e = e;
                return x;
            }
        }
        AVLNode<E> newNode = new AVLNode<E>(e, null, null, null);
        if (cmp > 0) {
            parent.right = newNode;
            newNode.parent = parent;
        } else {
            parent.left = newNode;
            newNode.parent = parent;
        }
        return newNode;
    }


    private int compare(E k1, E k2) {
        if (comparator != null) {
            return comparator.compare(k1, k2);
        } else {
            return ((Comparable<E>) k1).compareTo(k2);
        }
    }
}
