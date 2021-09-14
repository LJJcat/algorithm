package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lijingjing
 * @date 2021/6/28 17:34
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome main = new LongestPalindrome();
        String result = main.longestPalindrome("dddddababad");
        System.out.println("result:" + result);
    }


    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }
        int begin = 0;
        int maxLen = 1;

        boolean[][] result = new boolean[len][len];

        char[] charArray = s.toCharArray();
        // 初始化
        for (int i = 0; i < len; i++) {
            result[i][i] = true;
        }

        for (int sbLen = 2; sbLen <= len; sbLen++) {
            for (int i = 0; i < len; i++) {
                int end = i + sbLen - 1;
                // 小心数组越界
                if (end >= len) {
                    break;
                }

                if (charArray[i] == charArray[end]) {
                    // 长度为 2 且字符相同
                    if (sbLen == 2) {
                        result[i][end] = true;
                    } else {
                        result[i][end] = result[i + 1][end - 1];
                    }
                } else {
                    result[i][end] = false;
                }

                // 取最大长度
                if (result[i][end] && maxLen < sbLen) {
                    maxLen = sbLen;
                    begin = i;
                }
            }


        }


        return s.substring(begin, begin + maxLen);
    }

}