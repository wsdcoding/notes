package com.wsdcoding.二叉搜索树;

import com.wsdcoding.二叉搜索树.tree.BinarySearchTree;
import com.wsdcoding.二叉搜索树.printer.BinaryTrees;

/**
 * @Description:
 * @Authror Mohanjun
 * @Date 2020/5/19 19:05
 */
public class Main {


    static void test1() {
        Integer data[] = new Integer[]{
                34, 7, 93, 64, 98, 44, 28, 4, 94, 76, 40, 18
        };

        BinarySearchTree<Integer> avl = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            avl.add(data[i]);
        }
        BinaryTrees.println(avl);

    }

    public static void main(String[] args) {
        test1();
    }

}
