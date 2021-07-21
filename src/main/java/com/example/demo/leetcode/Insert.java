package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    给你一个 无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）
 */
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                ansList.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Insert insert=new Insert();
        int[][] intervals = {{1,3}, {6,9}};
        int[] newInterval={2,5};
        int[][] result=insert.insert(intervals,newInterval);
        System.out.println(Arrays.deepToString(result));
        int[][] intervals1 = {{1,2}, {3,5},{6,7},{8,10},{12,16}};
        int[] newInterval1={4,8};
        result=insert.insert(intervals1,newInterval1);
        System.out.println(Arrays.deepToString(result));
        int[][] intervals2 = {};
        int[] newInterval2={5,7};
        result=insert.insert(intervals2,newInterval2);
        System.out.println(Arrays.deepToString(result));
    }
}
