package com.wsdcding;

import com.wsdcding.set.ListSet;
import com.wsdcding.set.Set;
import com.wsdcding.set.TreeSet;
import sun.reflect.generics.tree.Tree;

/**
 * @Description:
 * @Authror Shiko
 * @Date 2020/5/25 20:31
 */
public class Main {
    public static void main(String[] args) {
        Set<Integer> listSet = new ListSet<>();
//        listSet.add(11);
//        listSet.add(22);
//        listSet.add(33);
//        listSet.add(33);

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(12);
        treeSet.add(11);
        treeSet.add(11);
        treeSet.add(13);
        treeSet.add(22);
        treeSet.traversal(new Set.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.println(element);
                return false;
            }
        });
    }
}
