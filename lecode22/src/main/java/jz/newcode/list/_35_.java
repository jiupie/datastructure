package jz.newcode.list;

/**
 * @author 南顾北衫
 * @date 2022/11/21
 */
public class _35_ {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        node1.random = node1;
        node.random = node1;
        node.next = node1;
        _35_ v = new _35_();
        v.copyRandomList1(node);
    }

    /**
     * 拼接和拆分
     */
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }

        //插入节点
        Node tempNode = head;
        while (tempNode != null) {
            Node node = new Node(tempNode.val);

            Node next = tempNode.next;
            tempNode.next = node;
            node.next = next;

            tempNode = tempNode.next.next;
        }

        //拼接random
        tempNode = head;
        while (tempNode != null) {
            Node random = tempNode.random;
            if (random != null) {
                tempNode.next.random = random.next;
            }

            tempNode = tempNode.next.next;
        }


        // 3. 拆分两链表
        Node cur = head.next;
        Node pre = head, res = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点


        return res;
    }

    /**
     * 死方法
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Node newHead = new Node(-1);

        Node tempHeadNode = head;
        Node newHeadTemp = newHead;

        while (tempHeadNode != null) {
            newHeadTemp.next = new Node(tempHeadNode.val);
            tempHeadNode = tempHeadNode.next;
            newHeadTemp = newHeadTemp.next;
        }


        //random
        tempHeadNode = head;
        newHeadTemp = newHead.next;
        while (tempHeadNode != null && newHeadTemp != null) {
            Node random = tempHeadNode.random;
            if (random == null) {
                newHeadTemp.random = null;
            } else {
                Node tmpNode = newHead.next;
                Node tempHeadNode1 = head;
                newHeadTemp.random = null;
                while (tmpNode != null && tempHeadNode1 != null) {
                    if (random.val == tmpNode.val && tempHeadNode1 == random) {
                        newHeadTemp.random = tmpNode;
                        break;
                    } else {
                        tmpNode = tmpNode.next;
                        tempHeadNode1 = tempHeadNode1.next;
                    }
                }
            }
            tempHeadNode = tempHeadNode.next;
            newHeadTemp = newHeadTemp.next;
        }

        return newHead.next;

    }
}


//[[3,null],[5,17],[4,null],[-9,6],[-10,3],[5,15],[0,11],[6,null],[-6,16],[3,16],[-6,11],[9,12],
// [-2,1],[-3,11],[-1,10],[2,11],[-3,null],[-9,7],[-2,4],[-8,null],[5,null]]