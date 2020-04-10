package com.atguigu.queue;

import java.util.Scanner;

public class MyArrayQueueDemo {
    public static void main(String[] args) {
        MyArrayQueue myArrayQueue = new MyArrayQueue(3);
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
                    myArrayQueue.showQueue();
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个整数");
                    int data = scanner.nextInt();
                    myArrayQueue.addQueue(data);
                    break;
                case 'h':
                    int headQueue = myArrayQueue.showHeadQueue();
                    System.out.println("头数据=" + headQueue);
                    break;
                case 'g':
                    int queueData = myArrayQueue.getQueue();
                    System.out.println(queueData);
                default:
                    break;
            }
        }
        System.out.println("退出队列");
    }
}

class MyArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int array[];

    public MyArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        array = new int[maxSize];
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int data) {
        if (isFull()) {
            System.out.println("队列已满，无法添加数据");
        } else {
            rear++;
            array[rear] = data;
        }
    }

    public int getQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，无法取出数据");
            return -1;
        } else {
            front++;
            return array[front];
        }
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        } else {
            for (int i = front + 1; i <= rear; i++) {
                System.out.printf("%d\t", array[i]);
            }
        }
    }

    public int showHeadQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，无法取出头数据");
        }
        return array[front + 1];
    }
}
