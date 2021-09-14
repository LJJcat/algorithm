package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 20.有效的括号
 *
 * @author lijingjing
 * @date 2021/8/3 19:12
 */
public class Valid20 {

    public static void main(String[] args) {
        Valid20 valid20 = new Valid20();
        boolean result = valid20.isValid("()[]{}");
        System.out.println(result);
    }


    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int n = s.length();

        // 奇数不满足
        if (n % 2 != 0) {
            return false;
        }
        // 存放右括号
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        // 栈，先进后出，存放左括号
        LinkedList<Character> stack = new LinkedList<Character>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                stack.addLast(ch);
            } else {
                if(stack.isEmpty() || stack.getLast() != map.get(ch)){
                    return false;
                }
                stack.removeLast();
            }

        }

        return stack.isEmpty();


    }


}