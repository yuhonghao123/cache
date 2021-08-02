package com.example.demo.leetcode;

import java.math.BigInteger;

/*
    给定一个整数 n，返回 n! 结果尾数中零的数量
 */
public class TrailingZeroes {
    public int trailingZeroes(int n) {

        BigInteger nFactorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
        }
        int zeroCount = 0;

        while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            nFactorial = nFactorial.divide(BigInteger.TEN);
            zeroCount++;
        }

        return zeroCount;
    }

    public static void main(String[] args) {
        TrailingZeroes trailingZeroes=new TrailingZeroes();
        int n=3;
        int x=trailingZeroes.trailingZeroes(n);
        System.out.println(x);
    }
}
