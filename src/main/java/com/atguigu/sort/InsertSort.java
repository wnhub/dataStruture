package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * ************************
 *
 * @Description: 插入排序
 * @Author: wanghaining
 * @Date: 2020/4/14 13:28
 * <p>
 * ************************
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1};
//        arr = insertSort(arr);
//        System.out.println("----------");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + "\t");
//        }
        int arr[] = new int[800000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        System.out.println("排序前的时间：" + simpleDateFormat.format(new Date()));
        insertSort(arr);
        System.out.println("排序后的时间：" + simpleDateFormat.format(new Date()));
    }


    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 == i) {
                arr[insertIndex + 1] = insertValue;
            }
            //System.out.println("第" + i + "次排序：" + Arrays.toString(arr));
        }
        return arr;
    }
}
