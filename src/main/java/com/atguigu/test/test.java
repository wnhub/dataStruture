package com.atguigu.test;

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
    public static void main(String[] args) {
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

}
