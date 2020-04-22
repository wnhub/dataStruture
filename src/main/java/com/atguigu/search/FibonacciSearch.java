package com.atguigu.search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ************************
 *
 * @Description: 斐波那契（黄金分割法）查找
 * @Author: wanghaining
 * @Date: 2020/4/22 15:52
 * <p>
 * ************************
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 2;
        }
        long start = System.currentTimeMillis();
        int list = fibSearch(arr, 2);
        long end = System.currentTimeMillis();
        System.out.println("目标元素下标是:" + list + ",所用时间：" + (end - start));
    }

    /**
     * 获取斐波那契数列
     *
     * @return
     */
    //生成斐波那契数列
    public static int getFibonacci(int k) {
        if (k == 0) {
            return 0;
        } else if (k == 1) {
            return 1;
        } else if (k > 1) {
            return getFibonacci(k - 1) + getFibonacci(k - 2);
        } else {
            return -1;
        }
    }
//    public static int[] fib() {
//        int[] fib = new int[200];
//        for (int i = 0; i < fib.length; i++) {
//            if (i < 2) {
//                fib[i] = 1;
//            } else {
//                fib[i] = fib[i - 1] + fib[i - 2];
//            }
//        }
//        return fib;
//    }

    /**
     * 斐波那契算法
     *
     * @param arr
     * @param keyValue:目标值
     * @return
     */
    public static int fibSearch(int[] arr, int keyValue) {
        System.out.println("hello!!!");
        int low = 0;
        int high = arr.length - 1;
        //斐波那契分割数值的下标
        int k = 0;
        int mid = 0;
        int fibo = 0;
        //用于展示斐波那契数列
        ArrayList<Integer> fibArray = new ArrayList<Integer>();
        //获取到斐波那契分割数值的下标
        while (high > fibo) {
            fibo = getFibonacci(k) - 1;
            fibArray.add(fibo);
            k++;
        }
        //因为f[k]值可能大于a的长度，所以我们要利用Arrays工具类，构建一个新的数组，并指向a
        //不足的部分会用0补充
        int[] temp = Arrays.copyOf(arr, fibArray.get(k - 1));
        //实际上需求使用a数组最后的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        //使用while循环来处理，找到我们的数key
        //只要这个条件满足，就可以查找
        while (low <= high) {
            mid = low + fibArray.get(k - 1 - 1) - 1;
            //向左查找
            if (keyValue < temp[mid]) {
                high = mid - 1;
                //为什么是k--
                //因为全部元素 = 前面元素 + 后面元素
                //f[k] = f[k-1] + f[k-2];
                //因为前面有f[k-1]个元素，所以可以拆分为f[k-1] = f[k-2] + f[k-3];
                //即在f[k-1]前面查找k--
                //mid = f[k-1-1]-1
                k--;
            } else if (keyValue > temp[mid]) {
                //向右查找
                low = mid + 1;
                //为什么是k-2
                //因为全部元素 = 前面元素 + 后面元素
                //f[k] = f[k-1] + f[k-2];
                //后面f[k-2]可以拆分成 f[k-2] = f[k-3] + f[k-4];
                //即在f[k-2]前面查找k-=2
                //mid = f[k - 1 - 2] - 1
                k -= 2;
            } else {//找到
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }

        return -1;
    }
}
