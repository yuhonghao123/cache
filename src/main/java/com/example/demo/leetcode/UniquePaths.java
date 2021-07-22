package com.example.demo.leetcode;

/*
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths=new UniquePaths();
        int m=3;
        int n=7;
        int result=uniquePaths.uniquePaths(m,n);
        System.out.println(result);
        int m1=3;
        int n1=3;
        result=uniquePaths.uniquePaths(m1,n1);
        System.out.println(result);
    }
}
