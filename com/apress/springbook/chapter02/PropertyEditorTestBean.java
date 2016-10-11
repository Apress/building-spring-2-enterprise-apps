package com.apress.springbook.chapter02;

import java.math.BigDecimal;
import java.io.File;
import java.io.InputStream;
import java.util.Properties;
import java.net.URL;

public class PropertyEditorTestBean {
    private int myNumber;
    private boolean myToggle;
    private byte[] myBytes;
    private String[] myStrings;
    private BigDecimal myAmount;
    private Class myClass;
    private File myFile;
    private InputStream myInputStream;
    private Properties myProperties;
    private URL myUrl;

    public int getMyNumber() {
        return myNumber;
    }
    public void setMyNumber(int myNumber) {
        this.myNumber = myNumber;
    }

    public boolean isMyToggle() {
        return myToggle;
    }
    public void setMyToggle(boolean myToggle) {
        this.myToggle = myToggle;
    }

    public byte[] getMyBytes() {
        return myBytes;
    }
    public void setMyBytes(byte[] myBytes) {
        this.myBytes = myBytes;
    }

    public String[] getMyStrings() {
        return myStrings;
    }
    public void setMyStrings(String[] myStrings) {
        this.myStrings = myStrings;
    }

    public BigDecimal getMyAmount() {
        return myAmount;
    }
    public void setMyAmount(BigDecimal myAmount) {
        this.myAmount = myAmount;
    }

    public Class getMyClass() {
        return myClass;
    }
    public void setMyClass(Class myClass) {
        this.myClass = myClass;
    }

    public File getMyFile() {
        return myFile;
    }
    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

    public InputStream getMyInputStream() {
        return myInputStream;
    }
    public void setMyInputStream(InputStream myInputStream) {
        this.myInputStream = myInputStream;
    }

    public Properties getMyProperties() {
        return myProperties;
    }
    public void setMyProperties(Properties myProperties) {
        this.myProperties = myProperties;
    }

    public URL getMyUrl() {
        return myUrl;
    }
    public void setMyUrl(URL myUrl) {
        this.myUrl = myUrl;
    }
}
