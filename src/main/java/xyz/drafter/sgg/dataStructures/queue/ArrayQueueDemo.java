package xyz.drafter.sgg.dataStructures.queue;

/**
 * @author wangmeng
 * @date 2019/8/13
 * @desciption 数组模拟队列
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
       ArrayQueue arrayQueue = new ArrayQueue(3);
       arrayQueue.addQueue(1);
       arrayQueue.addQueue(2);
       arrayQueue.addQueue(3);
        System.out.println(arrayQueue.headQueue());
       arrayQueue.showQueue();
        System.out.println(arrayQueue.getQueue());
        System.out.println(arrayQueue.getQueue());
    }


    static class ArrayQueue {
        private int maxSize;//数组最大容量
        private int front;//队列头
        private int rear;//队列尾
        private int[] arr; //存放数据


        public ArrayQueue(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];
            front = -1;//指向队列头部，但不包含(头部前一个位置)
            rear = -1;// 指向队列尾，指向队尾的数据(即就是队列最后一个数据)

        }

        public boolean isFull() {
            return rear == maxSize - 1;
        }

        public boolean isEmpty() {
            return rear == front;
        }

        public void addQueue(int n) {
            if (isFull()) {
                System.out.println("队列满，不能加入数据");
                return;
            }
            rear++; //rear后移
            arr[rear] = n;
        }

        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列空，不能取数据");
            }
            front++;
            return arr[front];


        }


        public void showQueue() {
            if (isEmpty()) {
                System.out.println("队列空");
                return;
            }

            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d\n", i, arr[i]);
            }

        }


        public int headQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列空，不能取数据");
            }
            return arr[front + 1];

        }

    }
}
