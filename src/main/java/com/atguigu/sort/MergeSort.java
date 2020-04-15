package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * ************************
 *
 * @Description: 归并排序
 * @Author: wanghaining
 * @Date: 2020/4/15 10:38
 * <p>
 * ************************
 */
public class MergeSort {

    /**
     * 排序前的时间：2020-04-15 01:31:39:565
     * 排序后的时间：2020-04-15 01:31:58:065
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] arr = {8, 4, 5, 7, 1, 3, 6};
//        int temp[] = new int[arr.length];
//        mergeSort(arr, 0, arr.length - 1, temp);
//        System.out.println(Arrays.toString(arr));


        int arr[] = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        System.out.println("排序前的时间：" + simpleDateFormat.format(new Date()));
        int temp[] = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("排序后的时间：" + simpleDateFormat.format(new Date()));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * @param arr
     * @param left:左边有序序列的初始索引
     * @param mid：中间索引
     * @param right:右边索引
     * @param temp
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
