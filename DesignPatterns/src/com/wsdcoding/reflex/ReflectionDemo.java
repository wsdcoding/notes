package com.wsdcoding.reflex;

/**
 * @Description:
 * @Authror wsdcoding
 */
public class ReflectionDemo {

    private String name;

    public void sayHi(String helloSentence) {
        System.out.println(helloSentence + " " + name);
    }

    private String throwHello(String tag) {
        return "Hello" + tag;
    }
}
