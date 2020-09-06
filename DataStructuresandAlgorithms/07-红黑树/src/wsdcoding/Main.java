package wsdcoding;

import wsdcoding.printer.BinaryTrees;
import wsdcoding.tree.AVLTree;
import wsdcoding.tree.BinarySearchTree;
import wsdcoding.tree.RBTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: AVL树测试类
 * @Authror Shiko
 * @Date 2020/5/23
 */
public class Main {


    static void test1() {
        Integer data[] = new Integer[]{
                55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50
        };

        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
            System.out.println("【" + data[i] + "】");
            BinaryTrees.println(rb);
            System.out.println("------------------------");
        }
    }

    static void test2() {
        Integer data[] = new Integer[]{
                55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50
        };

        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
        }
        BinaryTrees.println(rb);
        for (int i = 0; i < data.length; i++) {
            rb.remove(data[i]);
            System.out.println("------------------------");
            System.out.println("【" + data[i] + "】");
            BinaryTrees.println(rb);
        }
    }

    public static void main(String[] args) {
        test2();

    }

}
