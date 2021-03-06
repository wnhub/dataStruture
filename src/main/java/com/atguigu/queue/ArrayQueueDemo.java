package com.atguigu.queue;


import java.util.Scanner;

/**
 * ************************
 *
 * @Description: 使用数组模拟队列
 * @Author: wanghaining
 * @Date: Create in 2019/8/30 9:40
 * <p>
 * ************************
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
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
                        System.out.println("从队列中取出的数据是%d\n" + data);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int headData = arrayQueue.headQueue();
                        System.out.printf("队列的头数据是%d\n" ,headData);
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

class ArrayQueue {
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

    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        return rear == maxSize - 1;
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
            throw new RuntimeException("队列已满，不能添加数据");
        } else {
            rear++;
            arr[rear] = n;
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
            front++;
            return arr[front];
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
            for (int i = front + 1; i <= arr.length - 1; i++) {
                System.out.printf("arr[%d]=%d\n", i, arr[i]);
            }
        }
    }

    /**
     * 显示队列的头数据（不是取数据）
     */
    public int headQueue() {
        if (isEmpty()) {
            //通过抛出异常的方式
            throw new RuntimeException("队列为空，没有头数据");
        }
        return arr[front + 1];
    }
}
