package com.atguigu.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ************************
 *
 * @Description: 二分查找
 * @Author: wanghaining
 * @Date: 2020/4/15 16:18
 * <p>
 * ************************
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-1, -1, -1, -1, -1, 1, 9, 34, 89};
        List<Integer> list = binarySearch1(arr, 0, arr.length, -1);
        if (list.isEmpty()) {
            System.out.println("没有找到");
        } else {
            System.out.println("目标元素下标是:" + list);
        }

//        int index = binarySearch(arr, 0, arr.length, -13);
//        if (index == -1) {
//            System.out.println("没有找到");
//        } else {
//            System.out.printf("目标元素下标是%d", index);
//        }
    }

    public static int binarySearch(int[] arr, int left, int right, int targetValue) {
        if (left > right) {
            return -1;
        }
        int index = -1;
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (targetValue > midValue) {
            binarySearch(arr, mid + 1, right, targetValue);
        } else if (targetValue < midValue) {
            binarySearch(arr, left, mid - 1, targetValue);
        } else {
            index = mid;
        }
        return index;
    }

    /**
     * 思考：输出所有符合的值
     *
     * @param arr
     * @param left
     * @param right
     * @param targetValue
     * @return
     */
    public static List<Integer> binarySearch1(int[] arr, int left, int right, int targetValue) {
        if (left > right) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (targetValue > midValue) {
            binarySearch(arr, mid + 1, right, targetValue);
        } else if (targetValue < midValue) {
            binarySearch(arr, left, mid - 1, targetValue);
        } else {
            int temp = mid - 1;
            while (temp > 0 && arr[temp] == targetValue) {
                list.add(temp);
                temp--;
            }
            temp = mid + 1;
            while (temp < arr.length && arr[temp] == targetValue) {
                list.add(temp);
                temp++;
            }
            list.add(mid);

        }
        return list;
    }
}
