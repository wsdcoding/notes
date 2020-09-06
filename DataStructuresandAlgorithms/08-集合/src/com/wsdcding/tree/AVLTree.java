package com.wsdcding.tree;

/**
 * @Description: AVL 树
 * @Authror Mohanjun
 * @Date 2020/5/23 12:20
 */
public class AVLTree<E> extends BBST<E> {


    @Override
    protected void afterAdd(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                //更新高度
                updateHeight(node);
            } else {
                // 恢复平衡
                rebalance(node);
                //整颗树恢复平衡
                break;
            }
        }
    }

    @Override
    protected void afterRemove(Node<E> node, Node<E> replacement) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                updateHeight(node);
            } else {
                rebalance(node);
            }
        }
    }

    /**
     * 重写createNode
     *
     * @param
     */
    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode<>(element, parent);
    }

    @Override
    protected void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
        super.afterRotate(grand, parent, child);
        // 更新高度
        updateHeight(grand);
        updateHeight(parent);
    }

    @Override
    protected void rotate(Node<E> r, Node<E> a, Node<E> b, Node<E> c, Node<E> d, Node<E> e, Node<E> f, Node<E> g) {
        super.rotate(r, a, b, c, d, e, f, g);
        updateHeight(b);
        updateHeight(f);
        updateHeight(d);
    }

    /**
     * 恢复平衡
     * @param grand 高度最低的那个不平衡节点
     */
    private void rebalance(Node<E> grand) {
        Node<E> parent = ((AVLNode<E>)grand).tallerChild();
        Node<E> node = ((AVLNode<E>)parent).tallerChild();
        //如果parent是grand的左子节点 L
        if (parent.isLeftChild()) {
            //并且node是parent的左子节点 LL
            if (node.isLeftChild()) {
                rotateRight(grand);
            }
            //并且node是parent的右子节点 LR
            else {
                rotateLeft(parent);
                rotateRight(grand);
            }
        }
        //如果parent是grand的右子节点 R
        else {
            //并且node是parent的左子节点 RL
            if (node.isLeftChild()) {
                rotateRight(parent);
                rotateLeft(grand);
            }
            //并且node是parent的右子节点 RR
            else {
                rotateLeft(grand);
            }
        }
    }

    /**
     * @return
     * @Description: 恢复平衡
     */
    private void rebalance2(Node<E> grand) {
        Node<E> parent = ((AVLNode<E>) grand).tallerChild();
        Node<E> node = ((AVLNode<E>) grand).tallerChild();
        if (parent.isLeftChild()) {
            if (node.isLeftChild()) { //LL
                rotate(grand, node.left, node, node.right, parent, parent.right, grand, grand.right);
            } else { //LR
                rotate(grand, parent.left, parent, node.left, node, node.right, grand, grand.right);
            }
        } else {
            if (node.isLeftChild()) { //RL
                rotate(grand, grand.left, grand, node.left, node, node.right, parent, parent.right);
            } else { //RR
                rotate(grand, grand.left, grand, parent.left, parent, node.left, node, node.right);
            }
        }
    }




    //判断是否平衡
    private boolean isBalanced(Node<E> node) {

        return Math.abs(((AVLNode<E>) node).balanceFactor()) <= 1;
    }

    private void updateHeight(Node<E> node) {
        ((AVLNode<E>) node).updateHeight();
    }

    private static class AVLNode<E> extends Node<E> {

        int height = 1; //AVL树高度属性，用于平衡因素： 左子树减去右子树的高度差不能大于1

        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }

        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
            return leftHeight - rightHeight;
        }

        public void updateHeight() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
            //高度 等于左右子树最大高度+ 1
            height = 1 + Math.max(leftHeight, rightHeight);
        }

        /**
         * @return
         * @Description: 创建tallerChild 节点
         */
        public Node<E> tallerChild() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
            if (leftHeight > rightHeight) {
                return left;
            }
            if (leftHeight < rightHeight) {
                return right;
            }
            return isLeftChild() ? left : right;
        }

        @Override
        public String toString() {
            String parentString = "null";
            if (parent != null) {
                parentString = parent.element.toString();
            }
            return element + "_p(" + parentString + ")_h(" + height + ")";
        }
    }
}
