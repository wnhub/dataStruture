package com.atguigu.tree;

/**
 * ************************
 *
 * @Description: 顺序存储，只能用于完全二叉树（除最后一层外的二叉树是满二叉树，最后一层的节点靠左对齐，
 * 并且倒数第二层的节点只能有2或0个；满二叉树是特殊的完全二叉树）
 * @Author: wanghaining
 * @Date: 2020/4/24 9:40
 * <p>
 * ************************
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preArrayOrder();
    }
}

class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preArrayOrder() {
        preArrayOrder(0);
    }

    /**
     * 前序遍历数组
     * n:数组的下标
     *
     * @param n
     */
    public void preArrayOrder(int n) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能遍历");
            return;
        }

        System.out.printf("%d\t", arr[n]);

        if (2 * n + 1 < arr.length) {
            preArrayOrder(2 * n + 1);
        }

        if (2 * n + 2 < arr.length) {
            preArrayOrder(2 * n + 2);
        }
    }
}
