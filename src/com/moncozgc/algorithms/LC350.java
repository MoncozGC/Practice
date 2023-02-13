package com.moncozgc.algorithms;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * Created by MoncozGC on 2023/2/8
 */
public class LC350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        // 将形参num2置为最大数组长度位置
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        // 使用hash表来存储元素出现的位置
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // 将数组1中的值放入到hash表中
        for (int i : nums1) {
            // 存储hash表中的元素及出现的次数, 出现一次则 +1
            int count = hashMap.getOrDefault(i, 0) + 1;
            hashMap.put(i, count);
        }

        // 两个数组中的短板, 觉得最终结果数组的长度.
        int[] resultIntersect = new int[nums1.length];
        // 记录重复的个数, 也用来记录最终结果数组的长度
        int index = 0;
        for (int i : nums2) {
            // nums2的元素去匹配nums1中的元素, 如果没有对应的值则返回0, 否则返回元素出现的次数
            int count = hashMap.getOrDefault(i, 0);
            if (count > 0) {
                // 进入该循环则表示该元素在两个数组中都出现了, 则可以写入数组中了
                resultIntersect[index++] = i;
                count--;
                if (count > 0) {
                    // 出现多次的元素, 则重新写入元素出现的次数. hashMap(4, 2); -> 经过 count-- -> hashMap(4, 1); 重新写入hash表中
                    hashMap.put(i, count);
                } else {
                    // 已经记录过的元素则删除
                    hashMap.remove(i);
                }
            }
        }
        // 复制数组, 返回一个新的数组. 数组的长度由index记录. 这样即可排除元素为 0 的数据.
        return Arrays.copyOfRange(resultIntersect, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5, 5, 3, 8};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
