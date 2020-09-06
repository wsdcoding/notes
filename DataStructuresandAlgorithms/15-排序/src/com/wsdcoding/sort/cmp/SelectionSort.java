package com.wsdcoding.sort.cmp;

import com.wsdcoding.sort.Sort;

/**
 * @Description: 选择排序
 * @Authror Shiko
 * @Date 2020/6/1 17:07
 */
public class SelectionSort <T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int max = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(max, begin) < 0) {
                    max = begin;
                }
            }
            swap(max, end);
        }
    }
}
