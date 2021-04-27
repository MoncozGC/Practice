package algorithms;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 示例 1：输入：x = 123 输出：321
 * 示例 2：输入：x = -123输出：-321
 * 示例 3：输入：x = 120 输出：21
 * 示例 4：输入：x = 0输出：0
 * Created by MoncozGC on 2021/4/26
 */
class Solution07 {
    /**
     * 思路:
     * 1、将12345 % 10 得到5，之后将12345 / 10
     * 2、将1234 % 10 得到4，再将1234 / 10
     * 3、将123 % 10 得到3，再将123 / 10
     * 4、将12 % 10 得到2，再将12 / 10
     * 5、将1 % 10 得到1，再将1 / 10
     *
     * @param x 输入值
     * @return 返回反转后的结果
     */
    public int reverse(int x) {
        // 初始化数值
        int res = 0;
        while (x != 0) {
            // 拿到末尾的数值, 进行取模运算
            int tmp = x % 10;
            // 大于32位的最大值[2147483647], 返回0. res等于214748364_, 如果它的尾数还大于7, 那么这个数值肯定就大于32位的最大值
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            // 小于32位的最小值[-2147483648], 返回0. res等于-214748364_, 如果它的尾数还大于-8, 那么这个数值肯定就小于32位的最小值
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }

            System.out.println(res);
            System.out.println(tmp);
            System.out.println(res * 10 + tmp);

            /**
             * 输入: 836
             * --
             * res 0
             * tmp 6
             * res * 10 + tmp 6
             * --
             * 6
             * 3
             * 63
             * --
             * 63
             * 8
             * 638
             * --
             */
            // 进行末位数反转"拼接", *10 是为了进位
            res = res * 10 + tmp;
            // 再次循环时, 去掉末尾的数值进行取模操作
            x /= 10;
            System.out.println("--");
        }
        return res;
    }
}

public class QB07 {
    public static void main(String[] args) {
        Solution07 solution07 = new Solution07();
        int enter = -214748364;
        System.out.println("输入值: " + enter);
        System.out.println("反转值: " + solution07.reverse(enter));
    }
}
