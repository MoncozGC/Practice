package com.moncozgc.algorithms;

import com.moncozgc.utils.Examination;

import java.util.Arrays;

/**
 * 求数组的中间位置
 * 类型: 数组
 *
 * Created by MoncozGC on 2021/11/29
 */
public class LC1991 {

    public int findMiddleIndex01(int[] nums) {
        // 返回数组中值的和
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            // sum +  +nums[i]
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    public int findMiddleIndex02(int[] nums) {
        // 计算nums数组中的所有元素总和
        int sum = Arrays.stream(nums).sum();
        System.out.println("sum " + sum);

        // 前缀和
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 前缀和 + nums[i] + 后缀和 = 总和
            // if(前缀和 == 后缀和) return i;
            // 所以: if(2 * 前缀和 = 总和 - nums[i]) return i;
            // 如果前缀和的两倍等于总和减去当前值则表示找到数组的中间位置
            /**
             *
             * 0 * 2 = 28 - 1 ×
             * 1 * 2 = 28 - 7 ×
             * 8 * 2 = 28 - 3 ×
             * 11 * 2 = 28 - 6 => 22 = 22 √
             */
            if (preSum * 2 == sum - nums[i]) {
                return i;
            }
            // 更新前缀和
            preSum += nums[i];
            System.out.println("preSum " + preSum);
        }
        return -1;
    }

    public static void main(String[] args) {
        Examination.start();
        int nums[] = {1, 7, 3, 6, 5, 6};

        LC1991 lc1991 = new LC1991();
        System.out.println(lc1991.findMiddleIndex01(nums));
        System.out.println(lc1991.findMiddleIndex02(nums));
        Examination.end();

    }
}
