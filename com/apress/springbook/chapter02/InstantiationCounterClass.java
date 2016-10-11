package com.apress.springbook.chapter02;

import java.util.concurrent.atomic.AtomicInteger;

public class InstantiationCounterClass {
    private static AtomicInteger instantiationCounter = new AtomicInteger(0);

    public static int getNumberOfInstantiations() {
        /* returns the internal int value */
        return instantiationCounter.get();
    }

    public InstantiationCounterClass() {
        /* increment the internal int value with one */
        instantiationCounter.incrementAndGet();
    }
}
