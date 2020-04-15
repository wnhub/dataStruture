package com.atguigu.test;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class TestSort {
    @Test
    public void test1() {
//        int[] array = {3, 6, -5, 4, -2};
//        array = insertSort(array);
//        System.out.println(Arrays.toString(array));

        int arr[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        System.out.println("排序前的时间：" + simpleDateFormat.format(new Date()));
        insertSort(arr);
        System.out.println("排序后的时间：" + simpleDateFormat.format(new Date()));
    }

    /**
     * 排序前的时间：2020-04-15 08:27:38
     * 排序后的时间：2020-04-15 08:27:53
     *
     * @param arr
     * @return
     */
    public int[] bubbleSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
        return arr;
    }

    /**
     * 排序前的时间：2020-04-15 08:39:48
     * 排序后的时间：2020-04-15 08:39:54
     *
     * @param arr
     * @return
     */
    public int[] selectSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            int min = arr[i];

            for (int j = i + 1; j < size; j++) {
                if (min > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        return arr;
    }

    /**
     * 排序前的时间：2020-04-15 08:55:06
     * 排序后的时间：2020-04-15 08:55:07
     *
     * @param arr
     * @return
     */
    public int[] insertSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            int insertValue = arr[i + 1];
            int insertIndex = i;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex != i) {
                arr[insertIndex + 1] = insertValue;
            }
        }
        return arr;
    }

    public int[] shellSort(int[] arr) {
        int size = arr.length;
        for (int gap = size / 2; gap > 0; gap /= 2) {
//            for (int j =gap;)
        }
        return arr;
    }
}
