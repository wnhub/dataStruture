package com.atguigu.stack;

/**
 * ************************
 *
 * @Description: 数组模拟栈
 * @Author: wanghaining
 * @Date: 2020/4/11 11:27
 * <p>
 * ************************
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.push(6);
        arrayStack.getLength();
        arrayStack.pop();
        arrayStack.getLength();
    }
}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int[] getStack() {
        return stack;
    }

    public void setStack(int[] stack) {
        this.stack = stack;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public void getLength() {
        System.out.println("栈中元素个数=" + (top + 1));
    }

    public void push(int data) {
        if (top >= maxSize - 1) {
            System.out.println("栈已满，不能再添加元素");
            return;
        }
        top++;
        stack[top] = data;
        System.out.println("入栈元素=" + data);
    }

    public void pop() {
        if (top == -1) {
            System.out.println("栈中无元素");
            return;
        }
        int result = stack[top];
        top--;
        System.out.println("出栈元素=" + result);
    }
}
