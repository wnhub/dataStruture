package com.atguigu.queue;

import java.util.Scanner;

public class MyCircleArrayQueueDemo {
    public static void main(String[] args) {
        MyCircleArrayQueue myCircleArrayQueue = new MyCircleArrayQueue(3);
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        System.out.println("s(Show):显示队列");
        System.out.println("e(exit):退出程序");
        System.out.println("a(add):添加数据到队列");
        System.out.println("g(get):从队列取出数据");
        System.out.println("h(head):查看队列头的数据");
        while (loop) {
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    myCircleArrayQueue.showQueue();
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个整数");
                    int data = scanner.nextInt();
                    myCircleArrayQueue.addQueue(data);
                    break;
                case 'h':
                    int headQueue = myCircleArrayQueue.showHeadQueue();
                    System.out.println("头数据=" + headQueue);
                    break;
                case 'g':
                    int queueData = myCircleArrayQueue.getQueue();
                    System.out.println(queueData);
                default:
                    break;
            }
        }
        System.out.println("退出队列");
    }
}

class MyCircleArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int array[];

    public MyCircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = 0;
        rear = 0;
        array = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public void addQueue(int data) {
        if (isFull()) {
            System.out.println("队列已满，无法添加数据");
        } else {
            array[rear] = data;
            rear = (rear + 1) % maxSize;
        }
    }

    public int getQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，无法取出数据");
            return -1;
        } else {
            int value = array[front];
            front = (front + 1) % maxSize;
            return value;
        }
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        } else {
            for (int i = front; i < front + size(); i++) {
                System.out.printf("%d\t", array[i % maxSize]);
            }
        }
    }

    public int showHeadQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，无法取出头数据");
        }
        return array[front];
    }
}
