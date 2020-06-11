package linkedlist;

/**
 * @Description: https://leetcode-cn.com/problems/reverse-linked-list/
 * @Authror Mohanjun
 * @Date 2020/5/14 14:49
 */
public class _206反转链表 {

    /**
     * 方法 1 用递归方式
     * @Author Mohanjun
     * @param head :
     * @return LinkedList.ListNode
     * @Date 2020/5/14 14:55
     */

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    /**
     * 迭代（非递归）
     * @Author Mohanjun
     * @param head :
     * @return linkedList.ListNode
     * @Date 2020/5/14 15:05
     */

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        while (head != null) {
            ListNode  tmp = head.next;
            head.next = newHead;
            head = tmp;
        }
        return newHead;
    }
}
