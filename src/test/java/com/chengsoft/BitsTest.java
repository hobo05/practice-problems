package com.chengsoft;

import org.junit.Test;

/**
 * Created by tcheng on 4/26/17.
 */
public class BitsTest {

    @Test
    public void mirrorBits() {
        System.out.println(getBit(37));
//        int num = 97;
//        System.out.println(Integer.toBinaryString(num));
//        System.out.println(Integer.toBinaryString(mirrorBits(num)));
    }

    int getBit(int n) {
        int zeroCounts = 0;
        int shifts = 0;
        while (zeroCounts < 2) {
            if (n % 2 == 0) {
                zeroCounts++;
            }
            System.out.printf("zeroCounts=%d, n=%s\n", zeroCounts, Integer.toBinaryString(n));
            n >>= 1;
            shifts++;
        }
        return 1 << shifts-1;
    }

    int mirrorBits(int a) {
        int b = 0;
        while (a > 0) {
            b <<= 1;
            System.out.println("shift: " + Integer.toBinaryString(b));
            System.out.println("a & 1: " + Integer.toBinaryString(a & 1));
            b |= a & 1;
            System.out.println("and: " + Integer.toBinaryString(b));
            a >>= 1;
        }

        return b;
    }


}
