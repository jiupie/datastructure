package com.wl.queue;

import org.junit.Test;

/**
 * CircleQueueTest class
 *
 * @author 南顾北衫
 * @date 2020/9/18 13:02
 * @email 17674641491@163.com
 */
public class CircleQueueTest {
    @Test
    public void test() {
        CircleQueue<Integer> circleQueue = new CircleQueue<>();
        circleQueue.enQueue(1);
        circleQueue.enQueue(2);
        circleQueue.enQueue(3);
        circleQueue.enQueue(4);
        circleQueue.enQueue(5);
        circleQueue.enQueue(6);

        System.out.println(circleQueue);//{1,2,3,4,5,6,null,null,null,null}
        circleQueue.deQueue();
        System.out.println(circleQueue);//{null,2,3,4,5,6,null,null,null,null}

        circleQueue.enQueue(7);//{null,2,3,4,5,6,7,null,null,null}
        System.out.println(circleQueue);

        circleQueue.deQueue();//{null,null,3,4,5,6,7,null,null,null}
        circleQueue.deQueue();//{null,null,null,4,5,6,7,null,null,null}
        System.out.println(circleQueue);

        circleQueue.enQueue(9);//{null,null,null,4,5,6,7,9,null,null}
        System.out.println(circleQueue);

        System.out.println("============");
        circleQueue.enQueue(10);//{null,null,null,4,5,6,7,9,10,null}
        System.out.println(circleQueue);

        circleQueue.enQueue(11);//{null,null,null,4,5,6,7,9,10,11}
        System.out.println(circleQueue);

        circleQueue.enQueue(12);//{12,null,null,4,5,6,7,9,10,11}
        System.out.println(circleQueue);

        circleQueue.enQueue(13);//{12,13,null,4,5,6,7,9,10,11}
        System.out.println(circleQueue);
        circleQueue.enQueue(14);//{12,13,14,4,5,6,7,9,10,11}
        System.out.println(circleQueue);

        System.out.println("========扩容=========");
        circleQueue.enQueue(15);//{12,13,14,4,5,6,7,9,10,11}
        System.out.println(circleQueue);

        System.out.println("============");
        circleQueue.deQueue();//{12,13,null,null,5,6,7,9,10,11}
        System.out.println(circleQueue);
        circleQueue.deQueue();//{12,13,null,null,null,6,7,9,10,11}
        System.out.println(circleQueue);

        circleQueue.deQueue();//{12,13,null,null,null,null,7,9,10,11}
        System.out.println(circleQueue);

        circleQueue.deQueue();//{12,13,null,null,null,null,null,9,10,11}
        System.out.println(circleQueue);

        circleQueue.deQueue();//{12,13,null,null,null,null,null,null,10,11}
        System.out.println(circleQueue);

        circleQueue.deQueue();//{12,13,null,null,null,null,null,null,null,11}
        System.out.println(circleQueue);

        circleQueue.deQueue();//{12,13,null,null,null,null,null,null,null,null}
        System.out.println(circleQueue);

        circleQueue.deQueue();//{null,13,null,null,null,null,null,null,null,null}
        System.out.println(circleQueue);

        circleQueue.deQueue();//{null,null,null,null,null,null,null,null,null,null}
        System.out.println(circleQueue);
    }

}