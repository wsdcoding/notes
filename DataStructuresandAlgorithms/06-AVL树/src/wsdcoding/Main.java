package wsdcoding;

import wsdcoding.printer.BinaryTrees;
import wsdcoding.tree.AVLTree;
import wsdcoding.tree.BinarySearchTree;

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
                //85, 19, 69, 7, 3, 99, 95, 2, 1, 70, 44, 58, 11, 21, 14, 93, 57, 4, 56
                //31, 98, 68, 89, 94, 63, 73, 10, 34, 45, 88, 36, 27, 100, 56, 15
                //13,14,15,12,11,17,16,8,9,1
                85, 19, 69, 7, 3, 99, 95
        };

        AVLTree<Integer> avl = new AVLTree<>();
        for (int i = 0; i < data.length; i++) {
            avl.add(data[i]);
            //System.out.println("[" + data[i] + "]");
            BinaryTrees.println(avl);
            //System.out.println("---------------------------- ");
            System.out.println("添加完了");
        }
        for (int i = 0; i < data.length; i++) {
            avl.remove(data[i]);
            System.out.println("[" + data[i] + "]");
            BinaryTrees.println(avl);
            System.out.println("---------------------------- ");
        }

    }

    static void testfuzashijian() {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 100_0000; i++) {
            data.add((int) (Math.random() * 100_0000));
        }
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.size(); i++) {
            bst.add(data.get(i));
        }
    }

    public static void main(String[] args) {
        test1();

    }

}
