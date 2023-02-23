package com.moncozgc.algorithms;

/**
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 *
 * 给你一个由二维数组 mat 表示的m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 *
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例1:
 * 1 2
 * --------> 1, 2, 3, 4
 * 3 4
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reshape-the-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by MoncozGC on 2023/2/13
 */
public class LC566 {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        for (int[] ints : mat) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2}, {3, 4}};
        int r = 1, c = 4;
        matrixReshape(mat, r, c);
    }
}
