package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * ************************
 *
 * @Description: 堆排序(大顶堆升序 ； 小顶堆降序)
 * @Author: wanghaining
 * @Date: 2020/4/24 11:29
 * <p>
 * ************************
 */
public class HeapSort {
    public static void main(String[] args) {
//        int[] arr = {4, 6, 8, 5, 9 };
//        System.out.println(Arrays.toString(arr));
//        heapSort(arr);
//        System.out.println(Arrays.toString(arr));

        int arr[] = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        System.out.println("排序前的时间：" + simpleDateFormat.format(new Date()));
        heapSort(arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println("排序后的时间：" + simpleDateFormat.format(new Date()));

    }


    public static void heapSort(int[] arr) {
        for (int k = arr.length / 2 - 1; k >= 0; k--) {
            adjusHeap(arr, k, arr.length);
        }
//        System.out.println(Arrays.toString(arr));
        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjusHeap(arr, 0, j);
//            System.out.println(Arrays.toString(arr));
        }
    }

    public static void adjusHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
