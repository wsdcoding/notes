package stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description:
 * @Authror Mohanjun
 * @Date 2020/5/16 17:52
 */
public class _20有效的括号 {
    /**
     * [({})]
     * 1.遇到左字符，将左字符入栈
     * 2.遇见右字符，如果栈是空的，说明括号无效；如果栈不为空，将栈顶字符出栈，与右字符匹配
     *   如果左右字符不匹配，说明括号无效；如果左右字符匹配，继续扫描写一个字符
     * 3.所有字符扫描完毕后， 栈为空说明括号有效，反之无效。
     */
    private static HashMap<Character,Character> map = new HashMap<>();
    static {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }
    public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            String[] strings = {};
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) { //如果是左字符
                stack.push(c);
            } else {    //右括号
                if (stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                if (c != map.get(left)) {
                    return  false;
                }
            }
        }
        return stack.isEmpty();
    }
    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        String[] strings = {};
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' ||c == '[') { //如果是左字符
                stack.push(c);
            } else {    //右括号
                if (stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                if (left == '(' && c != ')') {
                    return false;
                }
                if (left == '{' && c != '}') {
                    return false;
                }
                if (left == '[' && c != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public boolean isValid2(String s) {
        while (s.contains("{}") || s.contains("[]") || s.contains("()")){
            s = s.replace("{}", "");
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }
}
