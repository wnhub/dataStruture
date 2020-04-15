package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * ************************
 *
 * @Description: 选择排序
 * @Author: wanghaining
 * @Date: 2020/4/14 11:51
 * <p>
 * ************************
 */
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1};
//        arr = selectSort(arr);
//        System.out.println("----------");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + "\t");
//        }
        int arr[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        System.out.println("排序前的时间：" + simpleDateFormat.format(new Date()));
        selectSort(arr);
        System.out.println("排序后的时间：" + simpleDateFormat.format(new Date()));
    }

    public static int[] selectSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            //选出最小的，然后交换
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
//            System.out.println("第" + (i + 1) + "次排序：" + Arrays.toString(arr));
        }
        return arr;
    }
}
