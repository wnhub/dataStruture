package com.atguigu.search;

import java.util.ArrayList;
import java.util.List;

/**
 * ************************
 *
 * @Description: 插值查找(要求数组有序)
 * @Author: wanghaining
 * @Date: 2020/4/22 15:22
 * <p>
 * ************************
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 2;
        }
        long start = System.currentTimeMillis();
        int list = insertValueSearch(arr, 0, arr.length - 1, 56);
        long end = System.currentTimeMillis();
        System.out.println("目标元素下标是:" + list + ",所用时间：" + (end - start));
    }

    public static int insertValueSearch(int[] arr, int left, int right, int targetValue) {
        System.out.println("hello~~~");
        if (left > right || targetValue < arr[0] || targetValue > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (targetValue - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (targetValue > midValue) {
            return insertValueSearch(arr, mid + 1, right, targetValue);
        } else if (targetValue < midValue) {
            return insertValueSearch(arr, left, mid - 1, targetValue);
        } else {
            return mid;
        }
    }

}
