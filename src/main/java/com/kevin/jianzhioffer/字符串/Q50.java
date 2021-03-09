package com.kevin.jianzhioffer.字符串;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q50 {
    class Solution {
        public char firstUniqChar(String s) {
            if(s ==null || s.length() ==0){
                return ' ';
            }
            char [] s1 = s.toCharArray();
            int [] charNum = new int [256];
            for(char c : s1){
                charNum[c]++;
            }
            for(char c: s1){
                if(charNum[c] == 1){
                    return c;
                }
            }
            return ' ';
        }
    }
}
