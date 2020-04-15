package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * ************************
 *
 * @Description: 快速排序
 * java快速排序引起的StackOverflowError异常,是因为虚拟机栈溢出，函数调用的太深了。通过设置虚拟机参数-Xss10m，为虚拟机栈分配了10M的内存，
 * 使这个算法可以正常执行。最后，快速排序花费了4830ms。
 * @Author: wanghaining
 * @Date: 2020/4/14 16:43
 * <p>
 * ************************
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {-9, 0, 23, -567, 0, 70, 0, 900, 4561};
//        arr = quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
        int arr[] = new int[80000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        System.out.println("排序前的时间：" + simpleDateFormat.format(new Date()));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后的时间：" + simpleDateFormat.format(new Date()));
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        //中间的值
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            //在pivot左边一直找，直到找到大于pivot的值
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //一轮结束后，l和r各自向中间移动一位，若移动前所在位置与选定的中间值相等，则不需要移动
            if (arr[l] == pivot) {
                r -= 1;
            }
            if (arr[r] == pivot) {
                l += 1;
            }
            if (l == r) {
                l += 1;
                r -= 1;
            }
            if (left < r) {
                quickSort(arr, left, r);
            }
            if (right > l) {
                quickSort(arr, l, right);
            }
        }
        return arr;
    }
}
