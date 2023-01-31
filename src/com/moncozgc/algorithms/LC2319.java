package com.moncozgc.algorithms;

/**
 * 如果一个正方形矩阵满足下述 全部 条件，则称之为一个 X 矩阵 ：
 *
 * 矩阵对角线上的所有元素都 不是 0
 * 矩阵中所有其他元素都是 0
 * 给你一个大小为 n x n 的二维整数数组 grid ，表示一个正方形矩阵。如果 grid 是一个 X 矩阵 ，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-if-matrix-is-x-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by MoncozGC on 2023/1/31
 */
public class LC2319 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 判断数组(矩阵)中的第一个和最后一个(对角线上的元素) 等于 0则不是矩阵
                if (i == j || (i + j) == n - 1) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                    // 判断矩阵中其他位置的元素
                } else if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC2319 lc2319 = new LC2319();
        // [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
//        int[][] x = {{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}};
        // [[5,7,0],[0,3,1],[0,5,0]]
        int[][] x = {{5, 0, 1}, {0, 1, 0}, {1, 0, 1}};
        System.out.println(lc2319.checkXMatrix(x));
    }
}

