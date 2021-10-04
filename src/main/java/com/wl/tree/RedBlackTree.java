package com.wl.tree;

import com.wl.tree.utils.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * RedBlackTree class
 * 红黑树
 *
 * @author 南顾北衫
 * @date 2020/10/6 14:48
 * @email 17674641491@163.com
 */
public class RedBlackTree<E> implements BinaryTreeInfo {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private RBNode<E> root;
    private int N = 0;

    public RedBlackTree() {
    }

    /**
     * 1.左子树的右子树
     * 2.父子节点 父子节点的右节点
     * 3.父节点为null并且没有左子树，那么就是没有前驱节点
     * 前驱节点
     */
    public RBNode<E> predecessor(RBNode<E> node) {
        if (node == null) {
            return null;
        }
        //1.左子树不为空
        if (node.left != null) {
            RBNode<E> left = node.left;
            while (left.right != null) {
                left = left.right;
            }
            return left;
        }
        //2.左子树为空，父节点不为空
        if (node.left == null && node.parent != null) {
            RBNode<E> tempNode = null;
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
     * 1.度为2的节点，删除，使用前驱节点代替
     * 2.度为1的节点，删除，子节点代替
     * 3.度为0的节点，删除，该节点置为null
     */
    public void remove(RBNode<E> node) {
        N--;
        //删除度为2的节点
        if (hasTwoChildren(node)) {
            //使用前驱节点代替要删除的节点
            RBNode<E> predecessor = predecessor(node);
            node.element = predecessor.element;
            //删除后继节点
            node = predecessor;
        }
        //度为1或者为0的节点
        RBNode<E> replacement = node.left != null ? node.left : node.right;
        //说明是度为1的节点
        if (replacement != null) {
            RBNode<E> parent = node.parent;
            //有父节点
            if (parent != null) {
                if (parent.left == node) {
                    parent.left = replacement;
                } else if (parent.right == node) {
                    parent.right = replacement;
                }
            } else {//没有父节点，也就是根节点时候
                root = node;
            }
            afterRemove(node, replacement);
        } else {//说明度为0，删除度为0的节点
            RBNode<E> parent = node.parent;
            //说明不是根节点
            if (parent != null) {
                if (parent.left == node) {
                    parent.left = null;
                } else if (parent.right == node) {
                    parent.right = null;
                }
                afterRemove(node, replacement);
            } else {//是根节点
                root = null;
                afterRemove(node, replacement);
            }
        }
    }


    /**
     * 删除元素之后做的操作，为了保持红黑树平衡
     *
     * @param rbNode
     */
    public void afterRemove(RBNode<E> rbNode, RBNode<E> replacement) {
        //如果删除节点是红色
        if (isRed(rbNode)) {
            return;
        }
        //删除节点度为1或者2
        if (isRed(replacement)) {
            black(replacement);
            return;
        }
        RBNode<E> parent = rbNode.parent;
        //如果删除的是根节点
        if (parent == null) {
            return;
        }


    }

    /**
     * 判断该节点是否是度为2
     *
     * @param node
     * @return
     */
    private boolean hasTwoChildren(RBNode<E> node) {
        if (node.left != null && node.right != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 添加之后做的操作，为了保持红黑树的平衡
     * 添加的子节点都是红颜色
     * 1.父节点是黑色的
     * a.如果父节点为null，说明添加的是根节点，需要把节点染成黑色
     * b.如果父节点不为null，直接返回
     * 2.父节点是红色的
     * a.如果uncle不是红色
     * (1).LL/RR：parent变成黑色，grand变成红色，grand单旋
     * (2).LR/RL:添加的子节点变成黑色，grand变成红色，parent单旋，grand单旋
     * b.如果uncle是红色，把parent、uncle染成black,grand染成red，把grand当做新添加节点处理（递归）,grand向上合并，可能发生上溢
     *
     * @param rbNode
     */
    public void afterAdd(RBNode<E> rbNode) {
        //获取父节点
        RBNode<E> parent = rbNode.parent;
        //1.
        //a.如果添加的节点是黑色并且是根节点
        if (parent == null) {
            black(rbNode);
            root = rbNode;
            return;
        }
        //b.如果父节点是黑色的
        if (isBlack(parent)) {
            return;
        }
        //2.
        //a.
        //叔父节点
        RBNode<E> uncle = sibling(parent);
        //祖父节点
        RBNode<E> grand = parent.parent;

        //b.uncle是红色
        if (isRed(uncle)) {
            black(parent);
            black(uncle);
            afterAdd(red(grand));
            return;
        }

        //如果叔父节点不是红色的
        if (parent.isLeftChild()) {//L
            if (rbNode.isLeftChild()) {//LL
                // 染色 grand染成红色 parent染成黑色
                red(grand);
                black(parent);
                //grand右单旋
                rightRotate(grand);
            } else {//LR
                //添加节点染成黑色
                black(rbNode);
                //grand染成red色
                red(grand);
                //parent L旋
                leftRotate(parent);
                //grand R旋
                rightRotate(grand);
            }
        } else {//R
            if (rbNode.isRightChild()) {//RR
                // 染色 grand染成红色 parent染成黑色
                red(grand);
                black(parent);
                //左单旋
                leftRotate(grand);
            } else {//RL
                //添加节点染成黑色
                black(rbNode);
                //grand染成red色
                red(grand);
                //parent R旋
                rightRotate(parent);
                //grand l旋
                leftRotate(grand);
            }
        }

    }

    private void leftRotate(RBNode<E> grand) {
        RBNode<E> grandParentNode = grand.parent;
        RBNode<E> parent = grand.right;
        RBNode<E> child = parent.left;
        grand.right = child;
        parent.left = grand;

        //说明grand是根节点
        if (grandParentNode == null) {
            //把root根节点更新
            root = parent;
        } else if (grandParentNode != null && grandParentNode.left == grand) {
            //更新grand父节点左右子树的指针，不是根节点并且grand节点在它的父节点的左边
            grandParentNode.left = parent;
        } else if (grandParentNode != null && grandParentNode.right == grand) {
            grandParentNode.right = parent;
        }
        parent.parent = grandParentNode;

        grand.parent = parent;
        if (child != null) {
            child.parent = grand;
        }
    }

    private void rightRotate(RBNode<E> grand) {
        RBNode<E> grandParentNode = grand.parent;
        RBNode<E> parent = grand.left;
        RBNode<E> child = parent.right;
        grand.left = child;
        parent.right = grand;
        //说明grand是根节点
        if (grandParentNode == null) {
            //把root根节点更新
            root = parent;
        } else if (grandParentNode != null && grandParentNode.left == grand) {
            //更新grand父节点左右子树的指针，不是根节点并且grand节点在它的父节点的左边
            grandParentNode.left = parent;
        } else if (grandParentNode != null && grandParentNode.right == grand) {
            grandParentNode.right = parent;
        }
        parent.parent = grandParentNode;
        grand.parent = parent;
        if (child != null) {
            child.parent = grand;
        }
    }


    /**
     * 染色，传入一个节点，对其节点进行染色，并且返回染色后的节点
     *
     * @param rbNode
     * @param color
     * @return
     */
    private RBNode<E> color(RBNode<E> rbNode, boolean color) {
        if (rbNode == null) {
            return null;
        }
        rbNode.color = color;
        return rbNode;
    }

    /**
     * 染成红色
     *
     * @param rbNode
     * @return
     */
    private RBNode<E> red(RBNode<E> rbNode) {
        return color(rbNode, RED);
    }

    /**
     * 染成黑色
     *
     * @param rbNode
     * @return
     */
    private RBNode<E> black(RBNode<E> rbNode) {
        return color(rbNode, BLACK);
    }

    /**
     * 返回节点的颜色，null节点颜色为黑色
     *
     * @param rbNode
     * @return
     */
    private boolean colorOf(RBNode<E> rbNode) {
        if (rbNode == null) {
            return BLACK;
        }
        return rbNode.color == RED ? RED : BLACK;
    }

    /**
     * 节点是否是红色
     *
     * @param rbNode
     * @return
     */
    public boolean isRed(RBNode<E> rbNode) {
        return colorOf(rbNode) == RED;
    }

    /**
     * 节点是否是黑色
     *
     * @param rbNode
     * @return
     */
    public boolean isBlack(RBNode<E> rbNode) {
        return colorOf(rbNode) == BLACK;
    }

    /**
     * 获取该节点的兄弟节点
     *
     * @param rbNode
     * @return
     */
    public RBNode<E> sibling(RBNode<E> rbNode) {
        if (rbNode.isLeftChild() && rbNode.parent.right != null) {
            return rbNode.parent.right;
        } else if (rbNode.isRightChild() && rbNode.parent.left != null) {
            return rbNode.parent.left;
        }
        return null;
    }

    public void add(E e) {
        RBNode<E> node = add(root, e);
        afterAdd(node);
    }

    private RBNode<E> add(RBNode<E> x, E e) {
        N++;
        //添加第一个节点
        if (x == null) {
            RBNode<E> node = new RBNode<>(RED, null, null, null, e);
            root = node;
            return node;
        }

        //添加不是第一个节点
        //记录插入元素的父节点
        RBNode<E> parent = root;
        RBNode<E> node = root;
        //记录最后一次是插入左子树还是右子树
        int cmp = 0;
        while (node != null) {
            cmp = compare(e, node.element);//添加 根
            //保存父节点
            parent = node;
            if (cmp > 0) {
                //新结点的key大于当前结点的key，继续找当前结点的右子结点
                node = node.right;
            } else if (cmp < 0) {
                //新结点的key大于当前结点的key，继续找当前结点的左子结点
                node = node.left;
            } else {//相等
                node.element = e;
                return x;
            }
        }
        RBNode<E> newNode = new RBNode<>(RED, null, null, null, e);

        if (cmp > 0) {
            parent.right = newNode;
            newNode.parent = parent;
        } else {
            parent.left = newNode;
            newNode.parent = parent;
        }
        return newNode;
    }

    private Comparator<E> comparator;

    private int compare(E k1, E k2) {
        if (comparator != null) {
            return comparator.compare(k1, k2);
        } else {
            return ((Comparable<E>) k1).compareTo(k2);
        }
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((RBNode<E>) node).getLeft();
    }

    @Override
    public Object right(Object node) {
        return ((RBNode<E>) node).getRight();
    }

    @Override
    public Object string(Object node) {
        RBNode<E> rbNode = (RBNode<E>) node;
        String s = rbNode.color == RED ? "R" : "B";
        return rbNode.element + "_" + s;
    }


    private static class RBNode<E> {
        boolean color;
        RBNode<E> left;
        RBNode<E> right;
        RBNode<E> parent;
        E element;

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

        public RBNode() {
        }

        public RBNode(boolean color, RBNode<E> left, RBNode<E> right, RBNode<E> parent, E element) {
            this.color = color;
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.element = element;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public RBNode getLeft() {
            return left;
        }

        public void setLeft(RBNode left) {
            this.left = left;
        }

        public RBNode getRight() {
            return right;
        }

        public void setRight(RBNode right) {
            this.right = right;
        }

        public RBNode(boolean color, RBNode left, RBNode right) {
            this.color = color;
            this.left = left;
            this.right = right;
        }
    }
}
