package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * ************************
 *
 * @Description: 基数排序（桶排序）
 * @Author: wanghaining
 * @Date: 2020/4/15 13:52
 * <p>
 * ************************
 */
public class RadixSort {
    public static void main(String[] args) {
//        int[] arr = {53, 3, 542, 748, 14, 214};
//        radixSort(arr);
//        System.out.println(Arrays.toString(arr));

        int arr[] = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        System.out.println("排序前的时间：" + simpleDateFormat.format(new Date()));
        radixSort(arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println("排序后的时间：" + simpleDateFormat.format(new Date()));
    }

    public static void radixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        //获取最大数的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        //排序
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int k = 0; k < arr.length; k++) {
                int digitOfElement = arr[k] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[k];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            for (int j = 0; j < bucketElementCounts.length; j++) {
                if (bucketElementCounts[j] > 0) {
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        arr[index] = bucket[j][k];
                        index++;
                    }
                }
                bucketElementCounts[j] = 0;
            }
        }

    }

    public static void radixSort1(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        for (int j = 0; j < arr.length; j++) {
            int digitOfElement = arr[j] % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        int index = 0;
        for (int k = 0; k < bucketElementCounts.length; k++) {
            if (bucketElementCounts[k] != 0) {
                for (int h = 0; h < bucketElementCounts[k]; h++) {
                    arr[index++] = bucket[k][h];
                }
            }
            bucketElementCounts[k] = 0;
        }
        System.out.println("第一轮：" + Arrays.toString(arr));

        for (int j = 0; j < arr.length; j++) {
            int digitOfElement = arr[j] / 10 % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        int index1 = 0;
        for (int k = 0; k < bucketElementCounts.length; k++) {
            if (bucketElementCounts[k] != 0) {
                for (int h = 0; h < bucketElementCounts[k]; h++) {
                    arr[index1++] = bucket[k][h];
                }
            }
            bucketElementCounts[k] = 0;
        }
        System.out.println("第二轮：" + Arrays.toString(arr));

        for (int j = 0; j < arr.length; j++) {
            int digitOfElement = arr[j] / 100 % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        int index2 = 0;
        for (int k = 0; k < bucketElementCounts.length; k++) {
            if (bucketElementCounts[k] != 0) {
                for (int h = 0; h < bucketElementCounts[k]; h++) {
                    arr[index2++] = bucket[k][h];
                }
            }
            bucketElementCounts[k] = 0;
        }
        System.out.println("第三轮：" + Arrays.toString(arr));
    }
}
