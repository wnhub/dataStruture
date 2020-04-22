package com.atguigu.queue;


import java.util.Scanner;

/**
 * ************************
 *
 * @Description: 使用数组模拟环形队列
 * @Author: wanghaining
 * @Date: Create in 2019/8/30 9:40
 * <p>
 * ************************
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //设置4，队列有效数据最多为3
        CircleArrayQueue arrayQueue = new CircleArrayQueue(4);
        System.out.println("测试数组模拟环形队列的案例~~");
        /**用户输入*/
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(Show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int data = arrayQueue.getQueue();
                        System.out.printf("从队列中取出的数据是%d\n",data);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int headData = arrayQueue.headQueue();
                        System.out.printf("队列的头数据是%d\n", headData);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("已经退出程序！");
    }
}

class CircleArrayQueue {
    /**
     * 队列的最大容量
     */
    private int maxSize;
    /**
     * 指向队列头
     */
    private int front;
    /**
     * 指向队列尾
     */
    private int rear;
    /**
     * 用于存放数据，模拟队列
     */
    private int[] arr;

    public CircleArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        front = 0;
        rear = 0;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据队列
     */
    public void addQueue(int n) {
        if (isFull()) {
            //通过抛出异常的方式
            System.out.println("队列已满，不能添加数据");
            return;
        } else {
            //直接将数据加入
            arr[rear] = n;
            //rear后移，考虑取模
            rear = (rear + 1) % maxSize;
        }
    }

    /**
     * 从队列中取数据
     */
    public int getQueue() {
        if (isEmpty()) {
            //通过抛出异常的方式
            throw new RuntimeException("队列为空，不能取出数据");
        } else {
            /**
             * 1.先把front对应的值保存到value
             * 2.front后移，考虑取模
             * 3.将临时保存的变量返回
             */
            int valve = arr[front];
            front = (front + 1) % maxSize;
            return valve;
        }
    }

    /**
     * 显示队列所有的数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        } else {
            for (int i = front; i < front + size(); i++) {
                System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
            }
        }
    }

    /**
     * 当前队列的有效数据的个数
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列的头数据（不是取数据）
     */
    public int headQueue() {
        if (isEmpty()) {
            //通过抛出异常的方式
            throw new RuntimeException("队列为空，没有头数据");
        }
        return arr[front];
    }
}
