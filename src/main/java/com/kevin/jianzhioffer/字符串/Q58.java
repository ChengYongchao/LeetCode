package com.kevin.jianzhioffer.字符串;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 在这里加入功能说明
 *
 * @author chengyongchao
 * @version 1.0, 2020年11月2日
 */
public class Q58
{
    /*
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，
     * 输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     */
    class Solution
    {
        public String reverseLeftWords(String s, int n)
        {
            if (null == s || s.length() == 0)
                return "";

            int index = n % s.length();
            String s1 = s.substring(0, index);
            StringBuffer res = new StringBuffer();
            res.append(s.substring(index));
            res.append(s1);
            return res.toString();
        }
    }

    @Test
    public void test1()
    {
        Solution s1 = new Solution();

        String res = s1.reverseLeftWords("abcdefg", 2);
        assertEquals("cdefgab", res);
    }
}
