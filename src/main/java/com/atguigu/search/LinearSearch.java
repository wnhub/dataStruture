package com.atguigu.search;

/**
 * ************************
 *
 * @Description: 线性查找
 * @Author: wanghaining
 * @Date: 2020/4/15 15:59
 * <p>
 * ************************
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};
        int index = linearSearch(arr, -1);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.printf("目标元素下标是%d", index);
        }
    }

    public static int linearSearch(int[] arr, int targetValue) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (targetValue == arr[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
}
