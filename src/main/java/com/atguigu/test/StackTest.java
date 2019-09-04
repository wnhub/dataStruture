package com.atguigu.test;

import java.util.Stack;

/**
 * ************************
 *
 * @Description: 演示栈的使用
 * @Author: wanghaining
 * @Date: Create in 2019/9/4 14:48
 * <p>
 * ************************
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        //入栈
        stack.add("tom");
        stack.add("smith");
        stack.add("jack");
        //出栈
        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
