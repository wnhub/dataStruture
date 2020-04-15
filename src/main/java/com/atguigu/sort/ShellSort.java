package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * ************************
 *
 * @Description: 希尔排序
 * @Author: wanghaining
 * @Date: 2020/4/14 14:46
 * <p>
 * ************************
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        shellSort(arr);
        int arr[] = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        System.out.println("排序前的时间：" + simpleDateFormat.format(new Date()));
        arr = shellSort2(arr);
        System.out.println("排序后的时间：" + simpleDateFormat.format(new Date()));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    /**
     * 交换法:
     * 第0轮排序后的数组:[3, 5, 1, 6, 0, 8, 9, 4, 7, 2]
     * 第1轮排序后的数组:[0, 2, 1, 4, 3, 5, 7, 6, 9, 8]
     * 第2轮排序后的数组:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
     *
     * @param arr
     * @return
     */
    public static int[] shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println("第" + (count++) + "轮排序后的数组:" + Arrays.toString(arr));
        }
        return arr;
    }

    //移动法
    public static int[] shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素开始，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
//            System.out.println("第" + (count++) + "轮排序后的数组:" + Arrays.toString(arr));
        }
        return arr;
    }

    public static void shellSort1(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[i]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println("第一轮排序后的数组:" + Arrays.toString(arr));

        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("第二轮排序后的数组:" + Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("第三轮排序后的数组:" + Arrays.toString(arr));
    }
}
