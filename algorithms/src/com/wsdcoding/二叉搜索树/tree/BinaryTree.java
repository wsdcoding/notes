package com.wsdcoding.二叉搜索树.tree;

import com.wsdcoding.二叉搜索树.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 二叉树
 * @Authror Mohanjun
 * @Date 2020/5/23 11:46
 */
public class BinaryTree<E> implements BinaryTreeInfo {
    protected int size; // 元素的个数
    protected Node<E> root; // 根节点
    // 元素的数量
    public int size() {
        return size;
    }

    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 清空所有元素
    public void clear() {
        root = null;
        size = 0;
    }
    /**
     * 递归实现 前序遍历 2
     */
    public void preorder(Visitor<E> visitor) {
        preorder(root, visitor);
    }

    private void preorder(Node<E> node, Visitor<E> visitor) {
        // 退出条件
        if (node == null || visitor == null) {
            return;
        }
        visitor.visit(node.element);
        preorder(node.left, visitor);
        preorder(node.right, visitor);
    }

    /**
     * 递归实现 中序遍历 2
     */
    public void inorder(Visitor<E> visitor) {
        inorder(root, visitor);
    }

    private void inorder(Node<E> node, Visitor<E> visitor) {
        // 退出条件
        if (node == null || visitor == null) {
            return;
        }
        inorder(node.left, visitor);
        visitor.visit(node.element);
        inorder(node.right, visitor);
    }

    /**
     * 递归实现 后序遍历 2
     */
    public void postorder(Visitor<E> visitor) {
        postorder(root, visitor);
    }

    private void postorder(Node<E> node, Visitor<E> visitor) {
        // 退出条件
        if (node == null || visitor == null) {
            return;
        }
        postorder(node.left, visitor);
        postorder(node.right, visitor);
        visitor.visit(node.element);
    }

    /**
     * 定义层次遍历接口
     */

    public void levelOder(Visitor<E> visitor) {
        // 如果根节点为空，直接返回
        if (root == null || visitor == null) {
            return;
        }
        // 创建存储节点的队列
        Queue<Node<E>> queue = new LinkedList<>();
        //将头节点入队列
        queue.offer(root);
        //退出条件，当队列为空
        while (!queue.isEmpty()) {
            //取出队列头元素
            Node<E> node = queue.poll();
            visitor.visit(node.element);
            //打印头元素
            //System.out.println(node.element);
            //如果头元素左子树不为空
            if (node.left != null) {
                //将头元素左子树入队
                queue.offer(node.left);
            }
            //如果头元素右子树不为空
            if (node.right != null) {
                //将头元素右子树入队
                queue.offer(node.right);
            }
        }
    }

    /**
     * 958. 二叉树的完全性检验(这里用层次遍历)
     * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
     *
     * @return
     */
    public boolean isComplete() {
        if (root == null) {
            return false;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        //将头节点入队列
        queue.offer(root);
        boolean leaf = false;
        //退出条件，当队列为空
        while (!queue.isEmpty()) {
            //取出队列头元素
            Node<E> node = queue.poll();
            if (leaf && !node.isLeaf()) {
                return false;
            }
            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) {
                //left == null && node.right != null
                return false;
            }
            if (node.right != null) {
                queue.offer(node.right);
            } else {
                //left == null && node.right == null
                //left != null && node.right == null
                leaf = true;
            }
        }
        return true;
    }

    /**
     * 非递归（迭代）计算树的高度，其实就是层侧遍历
     * 104. 二叉树的最大深度 https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     */
    public int height() {
        if (root == null) {
            return 0;
        }
        int height = 0;
        int levelSize = 1;
        // 创建存储节点的队列
        Queue<Node<E>> queue = new LinkedList<>();
        //将头节点入队列
        queue.offer(root);
        while (!queue.isEmpty()) {
            //取出队列头元素
            Node<E> node = queue.poll();
            levelSize--;
            //如果头元素左子树不为空
            if (node.left != null) {
                //将头元素左子树入队
                queue.offer(node.left);
            }
            //如果头元素右子树不为空
            if (node.right != null) {
                //将头元素右子树入队
                queue.offer(node.right);
            }
            if (levelSize == 0) { //意味着即将要访问下一层
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }

    /**
     * 计算 树 的高度  递归
     */
    public int height2() {
        return height(root);
    }

    public int height(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }


    /**
     * 前驱节点 : 中序遍历时 根的前一个节点
     *
     * @return
     */
    protected Node<E> predecessor(Node<E> node) {
        if (node == null) {
            return null;
        }
        // 前驱节点在左子树当中（left.right.right.right....）
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }
        // 从父节点、祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        // node.parent == null
        // node == node.parent.right
        return node.parent;
    }


    /**
     * 后继节点：中序遍历时的后一个节点
     *
     * @return
     */
    protected Node<E> successor(Node<E> node) {
        if (node == null) {
            return null;
        }
        // 前驱节点在左子树当中（right.left.left.left....）
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        // 从父节点、祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }






    /**
     * 公共遍历接口
     * @param <E>
     */
    public static interface Visitor<E> {
        void visit(E element);
    }

    /**
     * 内部类  节点类
     * @param <E>
     */
    protected static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>) node).element;
    }
}
