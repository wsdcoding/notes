package com.wsdcoding.队列.list;

/**
 * @Description:
 * @Authror Mohanjun
 * @Date 2020/5/15 15:14
 */
public interface List<E> {
    static final int ELEMENT_NOT_FOUND = -1;

    /**
     * 清除所有元素
     */
    void clear();

    /**
     * 元素的数量
     *
     * @return
     */
    int size();

    /**
     * 是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含某个元素
     *
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * 添加元素到尾部
     *
     * @param element
     */
    void add(E element);

    /**
     * 获取 index 位置的元素
     *
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 设置 index 位置的元素
     *
     * @param index
     * @param element
     * @return
     */
    E set(int index, E element);

    /**
     * 在 index 位置插入一个元素
     *
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * 删除 index 位置的元素
     *
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 查看元素的索引
     *
     * @param element
     * @return
     */
    int indexOf(E element);
}
