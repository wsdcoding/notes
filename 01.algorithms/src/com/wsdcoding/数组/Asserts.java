package com.wsdcoding.数组;

/**
 * @Description:
 * @Authror Mohanjun
 * @Date 2020/5/16 18:40
 */
public class Asserts {
    public static void test(boolean value) {
        try {
            if (!value) throw new Exception("测试未通过");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
