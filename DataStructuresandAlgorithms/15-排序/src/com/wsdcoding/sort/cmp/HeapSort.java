package com.wsdcoding.sort.cmp;

import com.wsdcoding.sort.Sort;

/**
 * @Description: 堆排序
 * @Authror Shiko
 * @Date 2020/6/1 17:16
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    private  int heapSize;
    @Override
    protected void sort() {
        //原地建堆
        heapSize = array.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            sifDown(i);
        }
        while (heapSize > 1) {
            swap(0 , --heapSize); //交换堆顶元素和尾部元素
            sifDown(0); //对0 位置进行sifdown 恢复堆的性质
        }
    }

    private void  sifDown(int index){
        T element = array[index];
        int half = heapSize >> 1;
        while (index < half) { //index 必须是叶子节点
            //默认是左边跟父节点比较
            int childIndex = (index << 1) + 1;
            T child = array[childIndex];
            int rightIndex = childIndex + 1;
            //右子节点比左子节点大
            if (rightIndex < heapSize && cmp(array[rightIndex], child) > 0){
                child = array[childIndex = rightIndex];
            }
            // >= 子节点
            if (cmp(element, child) >= 0) break;
            array[index] = child;
            index = childIndex;
        }
        array[index] = element;
    }
}
