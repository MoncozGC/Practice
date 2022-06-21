package com.moncozgc.DataStructuresAtguigu;

/**
 * 二维数组与稀疏数组的转换
 *
 * Created by MoncozGC on 2022/6/16
 */
public class A01_SparseArray {
    public static void main(String[] args) {
        // 创建原始的二维数组 11 * 11
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[2][4] = 2;

        System.out.println("输出原始的二维数组: ");
        // 取每一行
        for (int[] row : chessArr1) {
            // 取具体的数据
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            // 每打印一行换一行
            System.out.println();
        }

        // 将二维数组转换成 稀疏数组
        // 1. 遍历二维数组, 得到非0数据的个数
        int chessCount = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    chessCount++;
                }
            }
        }
        System.out.println("总条数: " + chessCount);

        // 2. 创建对应的稀疏数组
        int[][] sparseArr = new int[chessArr1.length][chessArr1.length];
        // 赋值
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1.length;
        sparseArr[0][2] = chessCount;

        // 遍历二维数组, 将非0的值存放到 sparseArr中
        // 记录第几个是非0数据
        int sparseCount = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseCount++;
                    sparseArr[sparseCount][0] = i;
                    sparseArr[sparseCount][1] = j;
                    sparseArr[sparseCount][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println("稀疏数组: ");
        System.out.printf("%s\t%s\t%s\n", "row", "col", "value");
        for (int[] item : sparseArr) {
            // 输出非空数据
            if (item[0] != 0) {
                System.out.printf("%d\t%d\t%d\t", item[0], item[1], item[2]);
                System.out.println();
            }
        }

        // 稀疏数组转换成二维数组
        // 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("输出二维数组: ");
        for (int[] rows : chessArr2) {
            for (int data : rows) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
