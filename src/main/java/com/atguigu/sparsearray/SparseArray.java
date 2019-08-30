package com.atguigu.sparsearray;

/**
 * ************************
 *
 * @Description: 稀疏数组
 * @Author: wanghaining
 * @Date: Create in 2019/8/28 17:04
 * <p>
 * ************************
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] array = new int[11][11];
        array[1][2] = 1;
        array[2][3] = 2;
        array[4][5] = 2;
        System.out.println("原始数组：");
        for (int[] row : array) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println("原始数组-->稀疏数组：");
        //数组中不同于0的值的数量
        int sum = 0;
        for (int[] row : array) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //记录不同的值
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);

        }
        System.out.println();
        System.out.println("稀疏数组-->原始数组：");
        int array1[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            array1[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                System.out.printf("%d\t", array1[i][j]);
            }
            System.out.println();
        }
    }
}
