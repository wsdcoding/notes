package com.wsdcding.set;

/**
 * @Description: 集合接口
 * @Authror Shiko
 * @Date 2020/5/25 20:31
 */
public interface Set<E> {
    int size();
    boolean isEmpty();
    void clear();
    boolean contains(E element);
    void add(E element);
    void remove(E element);
    void traversal(Visitor<E> visitor); //遍历集合

    public static abstract class Visitor<E> {
        boolean stop;
        public abstract boolean visit(E element);
    }
}
