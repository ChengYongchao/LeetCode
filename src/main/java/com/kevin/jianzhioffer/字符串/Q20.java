package com.kevin.jianzhioffer.字符串;

public class Q20 {
    //请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
    class Solution {
        int index = 0;
        public boolean isNumber(String s) {
            return false;
            //int index = 0;
            //sreturn isNUmber(s,index);
        }

        private boolean isNUmber(String s, int index) {
            if(index == s.length())
            {
                return true;
            }
            return false;
        }
    }

}
