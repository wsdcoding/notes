package linkedlist;

/**
 * @Description: https://leetcode-cn.com/problems/linked-list-cycle/
 * @Authror Mohanjun
 * @Date 2020/5/14 15:16
 */
public class _141环形链表 {
    //利用快慢指针思想，指针在Java里面叫做引用，不能说Java没有指针
    //什么叫做快慢指针呢？比如：慢指针走一步，快指针走多步

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return true;
    }
}
