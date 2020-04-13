package com.atguigu.recursion;


/**
 * ************************
 *
 * @Description: 8皇后问题： 八皇后问题是以国际象棋为背景的问题：有八个皇后（可以当成八个棋子），
 * 如何在 8*8 的棋盘中放置八个皇后，使得任意两个皇后都不在同一条横线、纵线或者斜线上。
 * @Author: wanghaining
 * @Date: 2020/4/13 13:41
 * <p>
 * ************************
 */
public class EightQueen {
    int max = 8;
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.check(0);
        System.out.printf("一共有%d种解法\n", count);
        System.out.printf("一共判断%d次是否冲突", judgeCount);
    }

    /**
     * 放置第n个皇后
     * 特别注意： check是每一次递归时，进入到check中都有循环，因此会有回溯
     *
     * @param n
     */
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        //依次放入皇后，判断是否冲突
        for (int i = 0; i < max; i++) {
            //先放到第一列
            array[n] = i;
            //不冲突，接着放第n+1个皇后；如果冲突则继续执行array[n] = i;即将第n个皇后，放置在本行的后移一个位置
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //array[i] == array[n]:表示第n个和第n-1在同一列
            //Math.abs(array[n] - array[i]) == Math.abs(n - i)：表示第n个和第n-1在同一斜线上
            if (array[i] == array[n] || Math.abs(array[n] - array[i]) == Math.abs(n - i)) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
