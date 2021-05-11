package algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * 示例 1：输入：A = [1,2,0,0], K = 34 输出：[1,2,3,4] 解释：1200 + 34 = 1234
 * 示例 2 输入：A = [2,7,4], K = 181 输出：[4,5,5] 解释：274 + 181 = 455
 * 示例 3 输入：A = [2,1,5], K = 806 输出：[1,0,2,1] 解释：215 + 806 = 102
 *
 * Created by MoncozGC on 2021/5/11
 */
public class QB989 {
    public static void main(String[] args) {
        Solution989 solution989 = new Solution989();
        int[] num = new int[]{1, 2, 0, 0};
        int k = 11134;
        System.out.println(solution989.addToArrayForm_01(num, k));
        System.out.println(solution989.addToArrayForm_02(num, k));
        System.out.println(solution989.addToArrayForm_03(num, k));
    }
}

class Solution989 {
    public List<Integer> addToArrayForm_01(int[] num, int k) {
        int n = num.length;
        ArrayList<Integer> res = new ArrayList<>();
        int i = n - 1, sum = 0, carry = 0;
        while (i >= 0 || k != 0) {
            int x = i >= 0 ? num[i] : 0;
            int y = k != 0 ? k % 10 : 0;

            sum = x + y + carry;
            carry = sum / 10;
            k = k / 10;

            i--;
            res.add(0, sum % 10);
        }
        if (carry != 0) res.add(0, carry);
        return res;
    }

    public List<Integer> addToArrayForm_02(int[] num, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = num.length;
        // k /= 10 以进位的形式加入下一位
        for (int i = n - 1; i >= 0 || k > 0; --i, k /= 10) {
            if (i >= 0) {
                // 整个加数 k 加入数组表示的数的最低位
                k += num[i];
            }
            res.add(k % 10);
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> addToArrayForm_03(int[] num, int k) {
        // 初始化参数
        List<Integer> res = new ArrayList<Integer>();
        int n = num.length;

        // 1. 从后往前逐位相加
        for (int i = n - 1; i >= 0; i--) {
            // 1.1 逐位相加
            int sum = num[i] + k % 10;         // 每次重置sum
            k /= 10;
            // 1.2 处理两位相加 进位的情况
            if (sum >= 10) {
                k++;                        // 进位到K的末尾
                sum -= 10;                  // 进位清掉
            }
            // 1.2 当前相加的结果 添加到结果集
            res.add(sum);
        }

        // 2. K的数字长度大于数组的数字长度
        for (; k > 0; k /= 10) {                // 每次K左移一位
            res.add(k % 10);                // 添加到结果集
        }

        // 3. 将结果集翻转即是所求答案
        Collections.reverse(res);
        return res;
    }
}