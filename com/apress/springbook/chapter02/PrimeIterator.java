package com.apress.springbook.chapter02;

import org.apache.commons.lang.ArrayUtils;

public class PrimeIterator {
    private int start = 2;
    private int current = 0;
    private int[] primesFound = new int[] { 2, 3 };


    public void setStart(int start) {
        if (start < 2) {
            throw new IllegalArgumentException("Start should not be less than 2!");
        }
        this.start = start;
    }

    public int getNextPrime() {
        if (current < 2) {
            current = 3;
            if (current > start) {
                return current;
            }
        }
        for (;;) {
            current = current + 2;
            int highestToCheck = (int)(current ^ (1/2));
            boolean isPrime = true;

            for (int i = 0; i < primesFound.length; i++) {
                int prime = primesFound[i];
                if (prime > highestToCheck) {
                    break;
                }
                if (current % prime == 0) {
                    isPrime = false;
                    break;
                }
            }


            if (isPrime && current < start) {
                addToPrimesFound();
            } else if (isPrime) {
                break;
            }
        }

        addToPrimesFound ();

        return current;
    }

    private void addToPrimesFound() {
        primesFound = ArrayUtils.add(primesFound, current);
    }
}
