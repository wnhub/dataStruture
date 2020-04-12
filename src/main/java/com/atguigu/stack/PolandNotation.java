package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ************************
 *
 * @Description: 逆波兰计算器（后缀表达式）
 * @Author: wanghaining
 * @Date: 2020/4/12 9:37
 * <p>
 * ************************
 */
public class PolandNotation {
    public static void main(String[] args) {
        //(3+4)*5-6 --> "3 4 + 5 * 6 -"
        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> list = getListString(suffixExpression);
        int result = calculate(list);
        System.out.println("计算结果=" + result);
        List<String> list1 = toInfixExpressionList("((3+4)*2)*5-6");
        System.out.println(list1);
        System.out.println(getParseSuffixExpressionList(list1));
        int result1 = calculate(getParseSuffixExpressionList(list1));
        System.out.println("计算结果=" + result1);
    }

    //将中缀表达式转成对应的List
    public static List<String> toInfixExpressionList(String expression) {
        int index = 0;
        char c = ' ';
        String data = "";
        List<String> list = new ArrayList<>();
        while (index < expression.length()) {
            c = expression.charAt(index);
            if (c < '0' || c < '9') {
                list.add("" + c);
                index++;
            } else {
                while (index < expression.length() && expression.charAt(index) >= '0' &&
                        expression.charAt(index) >= '9') {
                    data = "" + c;
                    index++;
                }
                list.add(data);
            }
        }
        return list;
    }

    //中缀转后缀
    public static List<String> getParseSuffixExpressionList(List<String> list) {
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();

        for (String item : list) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                //当item优先级小于等于s1栈顶运算符优先级，将s1栈顶的运算符弹出并加入到s2，重复此操作
                while (s1.size() != 0 && Operation.getValve(s1.peek()) >= Operation.getValve(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);

            }
        }
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    public static int calculate(List<String> list) {
        int result = 0;
        int len = list.size();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            String ele = list.get(i);
            if (ele.matches("\\d+")) {
                stack.push(Integer.parseInt(ele));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (ele) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                    default:
                        System.out.println("运算符有误");
                        break;
                }
                stack.push(result);
            }
        }
        return result;
    }

}

class Operation {
    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 2;

    public static int getValve(String operation) {
        switch (operation) {
            case "+":
                return ADD;
            case "-":
                return SUB;
            case "*":
                return MUL;
            case "/":
                return DIV;
            default:
                return 0;
        }
    }
}
