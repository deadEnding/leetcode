package L204_CountPrimes;

/**
 * @author: deadend
 * @date: 6:59 PM 7/21/16
 * @version: 1.0
 * @description: Leetcode 204. Count Primes
 */

public class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++)
            isPrime[i] = true;

        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i])
                continue;
            for (int j = i * i; j < n; j += i)
                isPrime[j] = false;
        }

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrime[i])
                count++;

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(10));
    }
}

class OtherSolution {
    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrime(i))
                count++;
        return count;
    }
}
