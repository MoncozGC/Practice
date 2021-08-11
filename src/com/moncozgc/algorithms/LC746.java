package com.moncozgc.algorithms;

/**
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1：输入：cost = [10, 15, 20]输出：15解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * 示例 2输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]输出：6解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6
 *
 * 提示：
 * cost 的长度范围是 [2, 1000]。
 * cost[i] 将会是一个整型数据，范围为 [0, 999] 。
 *
 * Created by MoncozGC on 2021/6/24
 */
public class LC746 {
}
class Solution746 {
    /**
     分析：在首尾都加一个0分别代表地面，和楼顶
     数组的每一个数字代表从当前楼梯迈出所需要耗费的体力
     从地面开始，第一步可以选择第0阶或者第1阶，都不费力
     最终要求到达最后一个0（楼顶）所耗费的体力最少。
     */
    public int minCostClimbingStairs(int[] cost) {
        // 要达到天台，并且保证天台的体力值最小，那么就可以划分成若干个子问题
        // 即求第i个楼梯的体力值问题 --》动态规划问题
        // dp[i] 代表达到第i个楼梯所耗费的体力值
        int[] dp = new int[cost.length+1];
        // 情况一
        // dp[0] =  cost[0];
        // dp[1] =  cost[1];

        // 情况二：
        dp[0] = 0;dp[1] = 0;
        /**
         - 情况一：下标为[2,n],状态转移方程dp[i] = Math.min(dp[i-1],dp[i-2])+(i==cost.length?0:cost[i])
         使用该方程的话，那么要求初始dp[0]和dp[1]是cost[0]和cost[1]
         - 情况二：下标为[2,n],状态转移方程dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
         使用该方程的话，那么要求初始dp[0]和dp[1]是0
         */
        for(int i = 2; i <= cost.length; i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        // 最后返回天台处的体力值（天台的下标为cost.length）
        return dp[cost.length];
    }
}
