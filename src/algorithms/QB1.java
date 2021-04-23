package algorithms;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * 1. 数组中的每个值都需要计算,然后和target进行比较 for if
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * Created by MoncozGC on 2021/4/23
 */
class Solution01 {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; ++i) {
                if (hashMap.containsKey(target - nums[i])) {
                    return new int[]{hashMap.get(target - nums[i]), i};
                }
                hashMap.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
}

/**
 * {2, 7, 11, 15}  13
 * 遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
 * 如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
 * 如果最终都没有结果则抛出异常
 * (nums[i],i) => (数组下标作为key, 下标)
 *
 * 2  7  11  15
 * 0  1  2   3
 *
 * 13-11=2,改key存在, 方法2的下标0和11的下标2
 */
public class QB1 {
    public static void main(String[] args) {
        Solution01 solution01 = new Solution01();
        int nums[] = {2, 7, 11, 15};
        System.out.println(solution01.twoSum(nums, 13));
    }
}
