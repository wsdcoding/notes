package com.wsdcoding;

import com.wsdcoding.sort.Sort;
import com.wsdcoding.sort.cmp.*;
import com.wsdcoding.tools.Asserts;
import com.wsdcoding.tools.Integers;

import java.util.Arrays;

/**
 * @Description: 冒泡排序
 * @Authror Shiko
 * @Date 2020/6/1 15:41
 */
public class Main {
    public static void main(String[] args) {
        Integer[] array = {7, 3, 5, 8, 6, 7, 4, 5};
        testSort(array,
                new SelectionSort(),
                new HeapSort(),
                new InsertionSort1(),
                new InsertionSort2(),
                new InsertionSort3(),
                new MergeSort()
        );

    }

    static void testSort(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }
        Arrays.sort(sorts);

        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }


//    public static void main(String[] args) {
//        Integer[] array1 = Integers.tailAscOrder(1, 10000,2000);
//        Integers.println(array1);
//        Integer[] array2 = Integers.copy(array1);
//        Integer[] array3 = Integers.copy(array1);
//        Times.test("bubbleSort1", () -> {
//            bubbleSort1(array1);
//        });
//        Times.test("bubbleSort2", () -> {
//            bubbleSort2(array2);
//        });
//        Times.test("bubbleSort3", () -> {
//            bubbleSort3(array3);
//        });
//    }
//
//    static void bubbleSort1(Integer[] array) {
//        for (int end = array.length - 1; end > 0; end--) {
//            for (int begin = 1; begin <= end; begin++) {
//                if (array[begin] < array[begin - 1]) {
//                    int tmp = array[begin];
//                    array[begin] = array[begin - 1];
//                    array[begin - 1] = tmp;
//                }
//            }
//        }
//    }
//
//    /**
//     * 优化bubbleSort1 前提是数据存在提前有序
//     * @param array
//     */
//    static void bubbleSort2(Integer[] array) {
//        for (int end = array.length - 1; end > 0; end--) {
//            boolean sorted = false; //是否进行过排序
//            for (int begin = 1; begin <= end; begin++) {
//                if (array[begin] < array[begin - 1]) {
//                    int tmp = array[begin];
//                    array[begin] = array[begin - 1];
//                    array[begin - 1] = tmp;
//                    sorted = true; // 此轮循环进行过排序
//                }
//            }
//            if (!sorted) break;
//        }
//    }
//
//    /**
//     * 如果序列尾部已经局部有序，可以记录最后一次交换的位置，减少比较次数。
//     * 记录上一次循环最后一次交换的位置，将其作为下一次循环的截止位置。
//     * @param array
//     */
//    static void bubbleSort3(Integer[] array) {
//        for (int end = array.length - 1; end > 0; end--) {
//            // sortedIndex的初始值在数组完全有序的时候有用
//            int sortedIndex = 1;
//            for (int begin = 1; begin <= end; begin++) {
//                if (array[begin] < array[begin - 1]) {
//                    int tmp = array[begin];
//                    array[begin] = array[begin - 1];
//                    array[begin - 1] = tmp;
//                    sortedIndex = begin;
//                }
//            }
//            end = sortedIndex;
//        }
//    }
//

}
