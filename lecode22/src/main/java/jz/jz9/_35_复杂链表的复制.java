package jz.jz9;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 * <p>
 * 提示：
 * <p>
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 * <p>
 *
 * @author 南顾北衫
 */
public class _35_复杂链表的复制 {
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
        Node node = new Node(7);
//        Node node2 = new Node(13);
//        Node node3 = new Node(11);
//        Node node4 = new Node(10);
//        Node node5 = new Node(1);
        node.next = null;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = null;


        node.random = node;
//        node2.random = node;
//        node3.random = node4;
//        node4.random = node2;
//        node5.random = node;
        Node node1 = copyRandomList(node);
        System.out.println(node1);
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }


        Node[][] ints = new Node[2][10000];
        int count = 0;

        Node temp = head.next;
        ints[0][count] = head;


        Node newHead = new Node(head.val);
        Node tempNewHead = newHead;

        ints[1][count] = newHead;
        ints[0][++count] = temp;

        while (temp != null) {
            Node node = new Node(temp.val);
            tempNewHead.next = node;
            ints[1][count] = tempNewHead.next;
            temp = temp.next;
            tempNewHead = tempNewHead.next;
            ints[0][++count] = temp;
        }

        temp = head;
        tempNewHead = newHead;

        while (temp != null) {
            Node random = temp.random;
            if (random == null) {
                tempNewHead.random = null;
            } else {
                for (int i = 0; i <= count; i++) {
                    if (random == ints[0][i]) {
                        tempNewHead.random = ints[1][i];
                        break;
                    }
                }
            }
            tempNewHead = tempNewHead.next;
            temp = temp.next;
        }

        return newHead;
    }

}
