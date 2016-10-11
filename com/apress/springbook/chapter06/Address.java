package com.apress.springbook.chapter06;

public class Address {
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zip;

    public void setLine1(String line1) {
	this.line1 = line1;
    }

    public String getLine1() {
	return this.line1;
    }

    public void setLine2(String line2) {
	this.line2 = line2;
    }

    public String getLine2() {
	return this.line2;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getCity() {
	return this.city;
    }

    public void setState(String state) {
	this.state = state;
    }

    public String getState() {
	return this.state;
    }

    public void setZip(String zip) {
	this.zip = zip;
    }

    public String getZip() {
	return this.zip;
    }
}
