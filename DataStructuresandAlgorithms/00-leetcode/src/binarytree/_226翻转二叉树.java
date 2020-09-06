package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 前、中、后、层次遍历实现二叉树翻转
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * @Authror Mohanjun
 * @Date 2020/5/22 17:10
 */
public class _226翻转二叉树 {
    /**
     * 前序遍历就把 invert 后的三行调到前面invertTreeNode前面。
     * 后序同理
     * 中序遍历 把inver后面的放到两个invertTreeNode的中间
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null ) {
            return root;
        }
        //invert
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }
    /**
     * 层次遍历实现
     */
    public TreeNode levelTraversal(TreeNode root){
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
