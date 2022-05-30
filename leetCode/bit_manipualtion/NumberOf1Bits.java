package leetCode.bit_manipualtion;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class NumberOf1Bits {
    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;

        System.out.println(hammingWeight(n));

    }

    private static int hammingWeight(int n) {
        int count = 0; // initialize count to 0
        while (n != 0) { // while n is not 0
            n = n & (n - 1); // set the least significant bit to 0
            count++; // increment count
        }
        return count; // return count
    }
}
