package wsdcoding.tree;

import java.util.Comparator;

/**
 * @Description: 红黑树, 其实也是二叉搜索树
 * @Authror Shiko
 * @Date 2020/5/25 14:07
 */
public class RBTree<E> extends BBST<E> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    /**
     * B树中，新元素必定是添加到叶子节点中。
     * @param node 新添加的节点
     */
    @Override
    protected void afterAdd(Node<E> node) { //后面不管怎么情况，都是将grand转为红色 red(grand);
        //先拿到父节点
        Node<E> parent = node.parent;
        //添加的是根节点 或者 上溢达到了根节点
        if (parent == null) {
            black(node);
            return;
        }
        //如果父节点是黑色，不用做任何操的四种情况，直接返回
        if (isBlack(parent)) {
            return;
        }

        //另外8种，拿到叔父节点
        Node<E> uncle = parent.sibling();
        //拿到祖父节点
        Node<E> grand = red(parent.parent);//直接在这里red
        if (isRed(uncle)) {
            //叔父节点是红色，【B树节点上溢】
            black(parent);
            black(uncle);
            //afterAdd(red(grand));
            afterAdd(grand);
            return;
        }
        /**
         * 叔父节点不是红色
         */
        if (parent.isLeftChild()) { //L
            if (node.isLeftChild()) { //LL
                black(parent);
            } else { //LR
                black(node);
                rotateLeft(parent);
            }
            rotateRight(grand);
        } else { //R
            if (node.isLeftChild()) { //RL
                black(node);
                rotateRight(parent);
            } else { //RR
                black(parent);
            }
            rotateLeft(grand);
        }
    }

    /**
     * B树中，最后真正被删除的元素都在叶子节点上。
     * 1.红色节点直接删除：不做任何处理
     * 2.黑色节点有三种情况
     * （1）.拥有两个RED子节点的BLACK节点（红黑红）：不可能被直接删除，
     * 因为会找它的自己点代替删除，在BST里面度为2的节点会找打它的前驱或者后继来取代
     * （2）.拥有1个RED子节点的BLACK节点（黑红、红黑）：需要处理，判断是否是拥有一个红子节点的黑色节点的条件是：
     * 用以代替子节点的是红色
     * 3.黑色 叶子 节点：需要处理
     *
     * @param node 被删除的节点
     */
    @Override
    protected void afterRemove(Node<E> node, Node<E> replacement) {
        if (isRed(node)) {
            return;
        }
        //用于取代node的节点是红色
        if (isRed(replacement)) {
            black(replacement);
            return;
        }

        Node<E> parent = node.parent;
        //删除的是根节点
        if (node.parent == null) {
            return;
        }
        //删除的是黑色叶子节点[下溢],以被删除节点兄弟作为开头
        //判断被删除的node是左还是右
        boolean left = parent.left == null || node.isLeftChild();
        Node<E> sibliing = left ? parent.right : parent.left;
        if (left) { //被删除的节点在左边，星弟节点在右边
            if (isRed(sibliing)) { //兄弟节点是红色
                black(sibliing);
                red(parent);
                rotateLeft(parent);
                //更换兄弟
                sibliing = parent.right;
            }
            // 兄弟节必然是黑色
            if (isBlack(sibliing.right) && isBlack(sibliing.left)) {
                //兄弟节点没哟一个红色节点，父节点要向下跟兄弟节点合并
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibliing);
                if (parentBlack) {
                    afterRemove(parent, null);
                }
            } else {    //兄弟节点至少有一个是红色节点,向兄弟借节点元素
                //兄弟节点的左边是黑色，兄弟需要先旋转
                if (isBlack(sibliing.right)) {
                    rotateRight(sibliing);
                    sibliing = parent.right;
                }
                color(sibliing, colorOf(parent));
                black(sibliing.right);
                black(parent);
                rotateLeft(parent);
            }
        } else { //被删除的节点在右边。兄弟节点在左边
            if (isRed(sibliing)) { //兄弟节点是红色
                black(sibliing);
                red(parent);
                rotateRight(parent);
                //更换兄弟
                sibliing = parent.left;
            }
            // 兄弟节必然是黑色
            if (isBlack(sibliing.left) && isBlack(sibliing.right)) {
                //兄弟节点没哟一个红色节点，父节点要向下跟兄弟节点合并
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibliing);
                if (parentBlack) {
                    afterRemove(parent, null);
                }
            } else {    //兄弟节点至少有一个是红色节点,向兄弟借节点元素
                //兄弟节点的左边是黑色，兄弟需要先旋转
                if (isBlack(sibliing.left)) {
                    rotateLeft(sibliing);
                    sibliing = parent.left;
                }
                color(sibliing, colorOf(parent));
                black(sibliing.left);
                black(parent);
                rotateRight(parent);
            }

        }
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new RBNode<>(element, parent);
    }

    /**
     * @Description: 构建一个红黑节点，默认为hongs
     * @return
     */
    private static class RBNode<E> extends Node<E> {
        boolean color = RED; //默认添加新节点为红色能够快速满足红黑树性质

        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }

        @Override
        public String toString() {
            String str = "";
            if (color == RED) {
                str = "R_";
            }
            return str + element.toString();
        }
    }

    //节点染色, 谁染色，谁返回，所以是Node<E>
    private Node<E> color(Node<E> node, boolean color) {
        if (node == null) {
            return node;
        }
        ((RBNode<E>) node).color = color;
        return node;
    }

    //将节点染为红色
    private Node<E> red(Node<E> node) {
        return color(node, RED);
    }

    //将节点染为红色
    private Node<E> black(Node<E> node) {
        return color(node, BLACK);
    }

    //查看节点的颜色
    private boolean colorOf(Node<E> node) {
        return node == null ? BLACK : ((RBNode<E>) node).color;
    }

    //是否为黑色的节点
    private boolean isBlack(Node<E> node) {
        return colorOf(node) == BLACK;
    }

    //是否为红色节点
    private boolean isRed(Node<E> node) {
        return colorOf(node) == RED;
    }


}
