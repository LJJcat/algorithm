package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lijingjing
 * @date 2021/6/28 17:34
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring main = new LengthOfLongestSubstring();
        int result = main.lengthOfLongestSubstring("abcdee");
        System.out.println("result:" + result);
    }


    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int end = 0;
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            // 不断向右移动 右指针
            while (end < s.length() && !occ.contains(s.charAt(end))){
                occ.add(s.charAt(end));
                end++;
            }
            int length = end - i;
            if (result < length) {
                result = length;
            }

        }
        return result;
    }

    /**
     * 效率太低
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int result = 0;
        int length = 0;
        int nextEndStart = 0;

        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }

            // 不断向右移动 右指针
            for (int end = nextEndStart; end < s.length(); end++) {
                if (occ.contains(s.charAt(end))) {
                    length = end - i;
                    nextEndStart = end;
                    break;
                }
                occ.add(s.charAt(end));
                if(end == s.length() - 1){
                    length =  end - i + 1;
                }
            }
            if (result < length) {
                result = length;
            }
        }

        System.out.println("result:" + result);
        return result;
    }

}