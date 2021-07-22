package com.example.demo.leetcode;

/*
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles=new UniquePathsWithObstacles();
        int[][] obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
        int result=uniquePathsWithObstacles.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(result);
        int[][] obstacleGrid1={{0,1},{0,0}};
        result=uniquePathsWithObstacles.uniquePathsWithObstacles(obstacleGrid1);
        System.out.println(result);
    }
}
