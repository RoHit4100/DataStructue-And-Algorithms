package com.BitwiseOperators.Quetions;

public class SeiveOfErosthenesToFindPrime {
    public static void main(String[] args) {
        int n = 40;
        boolean[] primes = new boolean[n + 1];
        seive(n , primes);
    }

    static void seive(int n, boolean[] primes) {
        // start from 2 till 40
        for (int i = 2; i * i <= n; i++) {
            // check every index of primes from i * 2
            if (!primes[i]) {
                // make every j + i index of primes true starting from i * 2;
                // e.g. i == 3 and j == 6
                // check all the element which are multiple by 3 and make them true.
                for (int j = i * 2; j <= n; j += i) {
                    // only change if that element is false
                    if(!primes[j])
                        primes[j] = true;
                }
            }
        }
        // print all the element which are false now.
        for (int i = 2; i <= n; i++) {
            if (!primes[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
