package com.example.demo.leetcode;

/*
    实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）
 */
public class MyPow {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        MyPow myPow=new MyPow();
        double x = 2.00000;
        int n = 10;
        double y=myPow.myPow(x,n);
        System.out.println(y);
        x = 2.10000;
        n = 3;
        y=myPow.myPow(x,n);
        System.out.println(y);
        x = 2.00000;
        n = -2;
        y=myPow.myPow(x,n);
        System.out.println(y);
    }
}
