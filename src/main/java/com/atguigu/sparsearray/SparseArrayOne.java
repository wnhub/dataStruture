package com.atguigu.sparsearray;

/**
 * ************************
 *
 * @Description: 稀疏数组
 * @Author: wanghaining
 * @Date: 2020/4/10 9:37
 * <p>
 * ************************
 */
public class SparseArrayOne {
    public static void main(String[] args) {
        int originalArray[][] = new int[11][12];
        originalArray[1][2] = 1;
        originalArray[2][3] = 2;
        originalArray[4][5] = 1;
        originalArray[4][7] = 2;
        int sparseArray[][] = originalToSparseArray(originalArray);
        sparseToOriginalArray(sparseArray);

    }

    private static void sparseToOriginalArray(int sparseArray[][]) {
        int row = sparseArray.length;
        int originalArray[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < row; i++) {
            originalArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("稀疏数组 --> 原始数组：");
        for (int row1[] : originalArray) {
            for (int data : row1) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    private static int[][] originalToSparseArray(int originalArray[][]) {
        int sum = 0;
        System.out.println("原始数组：");
        for (int[] row : originalArray) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        int sparseArray[][] = new int[sum + 1][3];
        sparseArray[0][0] = originalArray.length;
        sparseArray[0][1] = originalArray[0].length;
        sparseArray[0][2] = sum;
        int k = 1;
        for (int i = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray[0].length; j++) {
                if (originalArray[i][j] != 0) {
                    sparseArray[k][0] = i;
                    sparseArray[k][1] = j;
                    sparseArray[k][2] = originalArray[i][j];
                    k++;
                }
            }
        }
        System.out.println("稀疏数组：");
        for (int[] row : sparseArray) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
        return sparseArray;
    }
}
