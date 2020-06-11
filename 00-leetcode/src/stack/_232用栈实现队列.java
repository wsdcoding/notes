package stack;

import java.util.Stack;

/**
 * @Description: 用栈实现队列：
 * 准备2个栈： inStack、outStack, 入队时，push到inStack中，
 * 出队时如果outStack为空，将inStack所有元素逐一弹出，push到outStack中。outStack弹出栈顶元素，
 * 如果outStack不为空，outStack弹出栈顶元素
 * @Authror Mohanjun
 * @Date 2020/5/17 12:13
 */
public class _232用栈实现队列 {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    /** Initialize your data structure here. */
    public _232用栈实现队列() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /** 入队 */
    public void push(int x) {
        inStack.push(x);
    }

    /** 出队 */
    public int pop() {
        checkOutStack();
        return outStack.pop();
    }

    /** 获取队头元素 */
    public int peek() {
        checkOutStack();
        return outStack.peek();
    }

    /** 是否为空 */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void checkOutStack() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

}
