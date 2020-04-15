package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ************************
 *
 * @Description: 冒泡排序
 * @Author: wanghaining
 * @Date: 2020/4/14 9:24
 * <p>
 * ************************
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] array = {-5, -2, 3, 4, 6};
//        array = sort(array);
//        System.out.println();
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + "\t");
//        }

        int arr[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        System.out.println("排序前的时间：" + simpleDateFormat.format(new Date()));
        sort(arr);
        System.out.println("排序后的时间：" + simpleDateFormat.format(new Date()));
    }

    public static int[] sort(int[] arr) {
        int[] array = arr;
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
//            System.out.println("\ni=" + i);
            boolean flag = false;
            for (int i1 = 0; i1 < size - i - 1; i1++) {
                if (array[i1] > array[i1 + 1]) {
                    flag = true;
                    int temp = array[i1 + 1];
                    array[i1 + 1] = array[i1];
                    array[i1] = temp;
                }
//                System.out.print("i1=" + i1 + "\t");
            }
            if (!flag) {
                //提前结束
                return array;
            } else {
                flag = false;
            }
        }
        return array;
    }
}
