package com.atguigu.tree;

import java.util.*;

/**
 * ************************
 *
 * @Description: 赫夫曼编码
 * @Author: wanghaining
 * @Date: 2020/4/24 16:11
 * <p>
 * ************************
 */
public class HuffmanCode {
    static Map<Character, String> huffmanCodesMap = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes();
        System.out.println(bytes.length);

        List<HuffmanNode> nodes = getNodes(bytes);

        System.out.println("");
        HuffmanNode huffmanNodeRoot = createHuffmanTree(nodes);
        huffmanNodeRoot.preOrder();

        Map<Character, String> huffmanCodes = getCodes(huffmanNodeRoot);
        System.out.println("生成的赫夫曼编码表：" + huffmanCodes);

    }

    public static Map<Character, String> getCodes(HuffmanNode huffmanNode) {
        if (huffmanNode == null) {
            return null;
        }
        getCodes(huffmanNode, "", stringBuilder);
        return huffmanCodesMap;
    }

    /**
     * 生成赫夫曼编码表
     *
     * @param huffmanNode
     * @param code
     * @param builder
     * @return
     */
    public static Map<Character, String> getCodes(HuffmanNode huffmanNode, String code, StringBuilder builder) {
        StringBuilder stringBuilder = new StringBuilder(builder);
        stringBuilder.append(code);

        if (huffmanNode != null) {
            if (huffmanNode.value == null) {
                getCodes(huffmanNode.left, "0", stringBuilder);
                getCodes(huffmanNode.right, "1", stringBuilder);
            } else {
                huffmanCodesMap.put((char)((int)huffmanNode.value), stringBuilder.toString());
            }
        }
        return huffmanCodesMap;
    }

    public static List<HuffmanNode> getNodes(byte[] bytes) {
        List<HuffmanNode> list = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<>();

        for (int i = 0; i < bytes.length - 1; i++) {
            Integer count = map.get(bytes[i]);
            if (count == null) {
                map.put(bytes[i], 1);
            } else {
                map.put(bytes[i], count + 1);
            }
        }

        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            list.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }
        return list;
    }

    public static HuffmanNode createHuffmanTree(List<HuffmanNode> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);

            HuffmanNode leftNode = nodes.get(0);
            HuffmanNode rightNode = nodes.get(1);

            HuffmanNode parent = new HuffmanNode(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }

        return nodes.get(0);
    }
}


class HuffmanNode implements Comparable<HuffmanNode> {
    Byte value;
    /**
     * 权值（字符出现的次数）
     */
    int weight;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(Byte value) {
        this.value = value;
    }

    public HuffmanNode(Byte value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "value=" + value +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.weight - o.weight;
    }

    public void preOrder() {
        System.out.println(this + "\t");

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }
}