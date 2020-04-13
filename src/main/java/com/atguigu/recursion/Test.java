package com.atguigu.recursion;

/**
 *************************
 *
 * @Description: 递归的使用
 * @Author: wanghaining
 * @Date:  2020/4/12 14:39 
 *
 *************************
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(test(4));
    }

    public static int test(int n) {
        if (n == 1) {
            return 1;
        }
        return test(n - 1) * n;
    }
}
