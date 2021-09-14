package leetcode;

import java.util.LinkedList;

/**
 * 32.最长有效括号
 *
 * @author lijingjing
 * @date 2021/8/4 10:42
 */
public class LongestValidParentheses32 {


    public static void main(String[] args) {
        LongestValidParentheses32 result = new LongestValidParentheses32();
        System.out.println(result.longestValidParentheses("()()()))))))))(((()()"));
    }



    /**
     * 【方法 1：栈】
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     *
     *
     * 时间复杂度： O(n)，n 是给定字符串的长度。我们只需要遍历字符串一次即可。
     *
     * 空间复杂度： O(n)。栈的大小在最坏情况下会达到 n，因此空间复杂度为 O(n) 。
     *
     */
    public int longestValidParentheses(String s) {

        int maxLen = 0;
        int length = s.length();

        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.addLast(-1);

        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.addLast(i);
            }
            if (ch == ')') {
                stack.removeLast();
                if (stack.isEmpty()) {
                    // 未匹配到 "("
                    stack.addLast(i);
                } else {
                    // 匹配到 "("
                    if ((i - stack.getLast()) > maxLen) {
                        maxLen = i - stack.getLast();
                    }
                }
            }
        }

        return maxLen;

    }


}