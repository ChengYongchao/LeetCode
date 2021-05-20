package com.kevin.leetcode;

import java.util.*;

/**
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 *  
 * <p>
 * 注意：
 * <p>
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *  
 * <p>
 * 扩展练习：
 * <p>
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q692 {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();
            for (String w : words) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
            PriorityQueue<Object[]> priorityQueue = new PriorityQueue<>(k, (a, b) -> {
                int c1 = (Integer) a[0];
                int c2 = (Integer) b[0];
                if (c1 != c2) return c1 - c2;
                String d1 = (String) a[1];
                String d2 = (String) b[1];
                return d2.compareTo(d1);
            });
            for (String s : map.keySet()) {
                int num = map.get(s);
                if (priorityQueue.size() < k) {
                    priorityQueue.add(new Object[]{num, s});
                } else {
                    Object[] peek = priorityQueue.peek();
                    if (num > (Integer) peek[0]) {
                        priorityQueue.poll();
                        priorityQueue.add(new Object[]{num, s});
                    } else if (num == (Integer) peek[0]) {
                        String peekC = (String) peek[1];
                        if (s.compareTo(peekC) < 0) {
                            priorityQueue.poll();
                            priorityQueue.add(new Object[]{num, s});
                        }
                    }
                }
            }
            List<String> res = new ArrayList<>();
            while (!priorityQueue.isEmpty()) {
                res.add((String) priorityQueue.poll()[1]);
            }
            Collections.reverse(res);
            return res;
        }
    }
}
