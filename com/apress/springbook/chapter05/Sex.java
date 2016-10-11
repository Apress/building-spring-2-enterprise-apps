package com.apress.springbook.chapter05;

/**
 * Created by IntelliJ IDEA.
 * User: stevend
 * Date: 2-feb-2006
 * Time: 20:00:13
 * To change this template use File | Settings | File Templates.
 */
public abstract class Sex {

    public static final Sex MALE = new Male();
    public static final Sex FEMALE = new Female();

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        return getClass().equals(o.getClass());
    }
}
