package com.moncozgc.algorithms;

/**
 * 给你一个字符串 s ，每 两个 连续竖线 '|' 为 一对 。换言之，第一个和第二个 '|' 为一对，第三个和第四个 '|' 为一对，以此类推。
 *
 * 请你返回 不在 竖线对之间，s 中 '*' 的数目。
 *
 * 注意，每个竖线 '|' 都会 恰好 属于一个对。
 *
 * 示例 1：
 * 输入：s = "l|*e*et|c**o|*de|"
 * 输出：2
 * 解释：不在竖线对之间的字符加粗加斜体后，得到字符串："l|*e*et|c**o|*de|" 。
 * 第一和第二条竖线 '|' 之间的字符不计入答案。
 * 同时，第三条和第四条竖线 '|' 之间的字符也不计入答案。
 * 不在竖线对之间总共有 2 个星号，所以我们返回 2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-asterisks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by MoncozGC on 2023/1/31
 */
public class LC2315 {
    // 思路: 根据题意，需要统计第偶数个竖线之后，第奇数个竖线之前，以及第一个竖线之前和最后一个竖线之后的星号。
    // 记录 竖线 的次数, 当偶数时就统计 星号
    public static int countAsterisks(String s) {
        int count = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            // 获取字符串的每一个字符
            char value = s.charAt(i);
            if (value == '|') {
                count++;
            } else if (count % 2 == 0 && value == '*') {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
    }
}
