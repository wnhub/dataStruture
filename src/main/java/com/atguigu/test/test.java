package com.atguigu.test;

import org.junit.jupiter.api.Test;

/**
 * ************************
 *
 * @Description:
 * @Author: wanghaining
 * @Date: Create in 2019/8/31 9:27
 * <p>
 * ************************
 */
public class test {
    @Test
    public void test1() {
        String str = "HelloWorld";
        StringBuffer buffer = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--) {
            char b = str.charAt(i);
            if (b >= 'A' && b <= 'Z') {
                //先通过静态函数value()把b转换为字符串然后再调用toLowerCase()
                buffer.append(String.valueOf(b).toLowerCase());
            } else {
                buffer.append(String.valueOf(b).toUpperCase());
            }
            System.out.print(buffer.charAt(buffer.length() - 1));
        }
        System.out.println();
        System.out.println(buffer.reverse());
    }

    @Test
    public void test2() {
        String ex = "3+21*3";
        if (51 == ex.length() - 1) {
            System.out.println("-------");
        } else {
            char ch = ex.substring(4, 6).charAt(0);
            System.out.println("-" + ch + "_");
        }
    }

    @Test
    public void test3() {
        int i = 3;
        int j = i;
        j++;
        System.out.println("j=" + j + ",i=" + i);
    }

}
