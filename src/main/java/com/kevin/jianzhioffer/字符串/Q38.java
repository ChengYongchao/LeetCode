package com.kevin.jianzhioffer.字符串;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q38 {
    /*
     * 输入一个字符串，打印出该字符串中字符的所有排列。 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     */
    class Solution {
        Set<String> res = new HashSet<String>();
        char[] c;

        public String[] permutation(String s) {
            c = s.toCharArray();
            dfs(0);

            return res.toArray(new String[res.size()]);
        }

        public void dfs(int x) {
            if (x == c.length - 1) {
                res.add(String.valueOf(c));
            }
            Set<Character> set = new HashSet<Character>();
            for (int i = x; i < c.length; i++) {
                if(set.contains(c[i])) continue;
                set.add(c[i]);
                swap(i,x);
                dfs(x+1);
                swap(i,x);
            }

        }

        private void swap(int a, int b) {
            char s = c[a];
            c[a] = c[b];
            c[b] = s;
        }
    }

    @Test
    public void test1() {
        Solution s = new Solution();
       String[] res =  s.permutation("abc");
        Arrays.stream(res).forEach(s1->{
            System.out.println(s1);
        });
    }
}
