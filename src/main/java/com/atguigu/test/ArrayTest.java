package com.atguigu.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * ************************
 *
 * @Description: 测试数组扩容
 * @Author: wanghaining
 * @Date: 2020/4/23 11:05
 * <p>
 * ************************
 */
public class ArrayTest {

    /**
     * 第一种也是最基础的一种
     */
    @Test
    public void test1() {
        //定义一个数组变量名和一个扩容变量的元素数量
        int[] a = {1, 12, 2, 2, 2, 2};

        int[] b = new int[10];
        //将a数组的元素一一赋值给b数组

        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        //将b的属性和数值 赋值给a
        a = b;

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    /**
     * 第二种是第一种的简化版  基本原理是一样的
     */
    @Test
    public void test2() {
        //定义一个数组变量名和一个扩容变量的元素数量
        int[] a = {1, 2, 2, 2, 23, 3};

        int[] b = new int[20];
        //固定的写法  a  为 扩容前的变量名   0是从数组a的第几个数开始传递
        // b为a目标扩容的数量   0是b数组从第几个元素开始接受来自数组a的元素
        //a.length是元素a的元素量
        System.arraycopy(a, 0, b, 0, a.length);
        a = b;

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    /**
     * 第三种是利用类库自带的方法进行扩容   Arrays
     */
    @Test
    public void test3() {
        int[] a = {1, 2, 2, 3, 3, 4, 9, 4,};
        int[] b = Arrays.copyOf(a, a.length * 2);

        a = b;
        //循环打印出a

        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j] + "  ");
        }
    }

    int[] arr = {1, 2, 3, 5, 6};

    @Test
    public void test4() {
        System.out.println(Arrays.toString(arr));
        setArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void setArray(int[] arr) {
        arr[3] = 4;
    }
}
