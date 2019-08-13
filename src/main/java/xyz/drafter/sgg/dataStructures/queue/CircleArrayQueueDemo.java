package xyz.drafter.sgg.dataStructures.queue;

/**
 * @author wangmeng
 * @date 2019/8/13
 * @desciption 环形数组模拟队列
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {

        // 设置为4 ，其队列的有效数据最大是3
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        circleArrayQueue.addQueue(1);
        circleArrayQueue.addQueue(2);
        circleArrayQueue.addQueue(3);
        circleArrayQueue.addQueue(4);
        System.out.println(circleArrayQueue.headQueue());
        circleArrayQueue.showQueue();
        System.out.println(circleArrayQueue.getQueue());
        System.out.println(circleArrayQueue.getQueue());

    }


    static class CircleArrayQueue {
        private int maxSize;//数组最大容量
        private int front;//队列头 指向的第一个数据
        private int rear;//队列尾  指向的队尾的数据的下一个位置
        private int[] arr; //存放数据


        public CircleArrayQueue(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];

        }

        public boolean isFull() {
            return (rear+1)%maxSize == front;
        }

        public boolean isEmpty() {
            return rear == front;
        }

        public void addQueue(int n) {
            if (isFull()) {
                System.out.println("队列满，不能加入数据");
                return;
            }
            arr[rear] = n;
            rear = (rear+1)%maxSize;
        }

        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列空，不能取数据");
            }
            int value = arr[front];
            front = (front +1)%maxSize;
            return value;


        }


        public void showQueue() {
            if (isEmpty()) {
                System.out.println("队列空");
                return;
            }

            for (int i = front; i < front+size(); i++) {
                System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i%maxSize]);
            }

        }

        // 求出当前数据的有效数据的个数
        public int size(){
            return (rear+maxSize-front)%maxSize;
        }


        public int headQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列空，不能取数据");
            }
            return arr[front];

        }

    }
}
