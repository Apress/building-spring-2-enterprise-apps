package com.apress.springbook.chapter07;

/**
 * Created by IntelliJ IDEA.
 * User: stevend
 * Date: 2-feb-2006
 * Time: 20:45:31
 * To change this template use File | Settings | File Templates.
 */
public class Point {
    private boolean server = true;

    public Point() {
    }

    public Point(boolean server) {
        this.server = server;
    }

    public boolean isServerPoint() {
        return this.server;
    }

    public boolean isAce() {
        return false;
    }
}
