package com.moncozgc.algorithms;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by MoncozGC on 2023/2/1
 */
public class LC217 {
    // 排序后比较前后值, 如果值一致则表示有重复数据
    public static boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // 使用hash. HashSet去重功能, 当hashSet.add失败返回false, 代表里面已经有了重复的数据.
    public static boolean containsDuplicateHash(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 41};
        // 数组排序方法
        System.out.println(containsDuplicateSort(nums));
        // 哈希表
        System.out.println(containsDuplicateHash(nums));
    }
}
