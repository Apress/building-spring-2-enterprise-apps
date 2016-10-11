package com.apress.springbook.chapter04;

public class UnknownMatchException extends Exception {
    public int getInvalidMatchIdentifier() {
	return 1;
    }
}
