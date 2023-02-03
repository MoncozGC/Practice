package com.moncozgc.algorithms;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by MoncozGC on 2023/2/1
 */
public class LC53 {
    public static int maxSubArray(int[] nums) {
        // 初始化数据, ans: 结果数据; sum: 最大连续子序列的和
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            // 当sum>0, 则表示有增益效果, 则sum数值保留并加上当前遍历的数值
            if (sum > 0) {
                sum += num;
                // 当sum<=0, 则表示没有增益效果, 需要舍弃, 则sum更新为当前遍历的数值
            } else {
                sum = num;
            }
            // 每次比较sum和ans的大小, 将最大值置为ans 其为最大和
            ans = Math.max(ans, sum);
        }
        return ans;
    }


    /**
     * [-2, 3, -1, 3, -3]
     * 步骤演示:
     * sum =  0 + (-2), num = -2, max(sum + num, num) = -2
     * maxAns = -2, sum = -2, max(maxAns, sum) = -2
     *
     * sum = -2 + 3, num = 3, max(sum + num, num) = 3
     * maxAns = -2, sum = 3, max(maxAns, sum) = 3
     *
     * sum = 3 + (-1), num = -1, max(sum + num, num) = 2
     * maxAns = 3, sum = 2, max(maxAns, sum) = 3
     *
     * sum = 2 + 3, num = 3, max(sum + num, num) = 5
     * maxAns = 3, sum = 5, max(maxAns, sum) = 5
     *
     * sum = 5 + (-3), num = -3, max(sum + num, num) = 2
     * maxAns = 5, sum = 2, max(maxAns, sum) = 5
     */
    public static int maxSubArrayTo(int[] nums) {
        int sum = 0, maxAns = nums[0];
        for (int num : nums) {
            // 个比个: 数组值进行累加和当前数组值进行比较
            sum = Math.max(sum + num, num);
            // 和比个:
            maxAns = Math.max(maxAns, sum);
        }
        return maxAns;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-2, 3, -1, 3, -3};

        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArrayTo(nums));
    }
}
