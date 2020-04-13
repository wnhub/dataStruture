package com.atguigu.recursion;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (null == root) {
            return 0;
        }
        return pathSumHelp(root, new int[1000], sum, 0);
    }

    /**
     * @param root
     * @param array    保存路径的数组
     * @param sum
     * @param curIndex 当前的数组index
     * @return
     */
    public int pathSumHelp(TreeNode root, int[] array, int sum, int curIndex) {
        if (null == root) {
            return 0;
        }
        int curNum = root.val == sum ? 1 : 0;
        int curSum = root.val;
        for (int i = curIndex - 1; i >= 0; i--) {
            curSum += array[i];
            System.out.println(array[i]);
            if (curSum == sum) {
                curNum++;
            }
        }
        array[curIndex] = root.val;
        int leftNum = pathSumHelp(root.left, array, sum, curIndex + 1);
        int rightNum = pathSumHelp(root.right, array, sum, curIndex + 1);
        return curNum + leftNum + rightNum;
    }
}

public class MainClass {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int sum = Integer.parseInt(line);

            int ret = new Solution().pathSum(root, sum);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}