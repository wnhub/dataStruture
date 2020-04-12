package com.atguigu.stack;

import java.util.Stack;

/**
 * ************************
 *
 * @Description: 栈实现计算器
 * @Author: wanghaining
 * @Date: 2020/4/11 11:59
 * <p>
 * ************************
 */
public class Calculator {
    public static void main(String[] args) {
        CalculatorStack numStack = new CalculatorStack(8);
        CalculatorStack operStack = new CalculatorStack(8);
        String expression = "500+40*6-2";
        int result = 0;
        char ch = ' ';
        int index = 0;
        while (true) {
            if (index >= expression.length()) {
                break;
            }
            System.out.println("index" + index);
            ch = expression.substring(index, index + 1).charAt(0);
            String str;
            if (ch >= '0' && ch <= '9') {
                //处理多位数
                str = "" + (ch - 48);
                while (true) {
                    if (index == expression.length()-1) {
                        break;
                    }
                    char c = expression.substring(index + 1, index + 2).charAt(0);
                    if (c >= '0' && c <= '9') {
                        str += (c - 48);
                        index++;
                    } else {
                        break;
                    }
                }
                numStack.push(Integer.parseInt(str));
            }
            if (operStack.isOper(ch)) {
                if (operStack.isEmpty()) {
                    //符号栈为空直接入栈
                    operStack.push(ch);
                } else {
                    int curOriority = operStack.getPriority(ch);
                    int original = operStack.peek();
                    int originalOriority = operStack.getPriority(original);
                    //当前符号优先级大于栈顶符号优先级，则直接入栈
                    if (curOriority > originalOriority) {
                        operStack.push(ch);
                    } else {
                        //当前符号优先级小于等于栈顶符号优先级，取出operStack栈顶符号和numStack栈顶的
                        // 两个元素进行计算，将结果插入numStack，将当前符号插入operStack
                        int oper = operStack.pop();
                        int num2 = numStack.pop();
                        int num1 = numStack.pop();
                        operStack.push(ch);
                        result = numStack.calc(num1, num2, oper);
                        numStack.push(result);
                    }
                }
            }
            index++;
        }
        //符号栈为空时计算完成
        while (!operStack.isEmpty()) {
            int oper = operStack.pop();
            int num2 = numStack.pop();
            int num1 = numStack.pop();
            result = numStack.calc(num1, num2, oper);
            numStack.push(result);
        }
        System.out.println(expression + " = " + result);
    }
}

class CalculatorStack {
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

    public boolean isEmpty() {
        return top == -1;
    }

    public CalculatorStack(int maxSize) {
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

    public int pop() {
        if (isEmpty()) {
            System.out.println("栈中无元素");
            return -1;
        }
        int result = stack[top];
        top--;
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("栈中无元素");
            return -1;
        }
        int result = stack[top];
        return result;
    }

    public int getPriority(int oper) {
        switch (oper) {
            case '*':
            case '/':
                return 1;
            case '+':
            case '-':
                return 0;
            default:
                return 0;
        }
    }

    public boolean isOper(int oper) {
        return oper == '*' || oper == '/' || oper == '-' || oper == '+';
    }

    public int calc(int num1, int num2, int oper) {
        switch (oper) {
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            default:
                return 0;
        }
    }
}