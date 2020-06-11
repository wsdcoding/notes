package linkedlist;

/**
 * @Description: https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @Authror Mohanjun
 * @Date 2020/5/14 14:35
 */
public class _237删除链表中的节点 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
