package com.apress.springbook.chapter07;

public class UnknownMatchException extends Exception {
    public int getInvalidMatchIdentifier() {
	return 1;
    }
}
