package  com.apress.springbook.chapter08.domain;

import org.apache.commons.lang.StringUtils;

public class Address {

  private String line1;
  private String line2;
  private String city;
  private String state;
  private String zip;
    
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getLine1() {
    return line1;
  }
  public void setLine1(String line1) {
    this.line1 = line1;
  }
  public String getLine2() {
    return line2;
  }
  public void setLine2(String line2) {
    this.line2 = line2;
  }
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }
  public String getZip() {
    return zip;
  }
  public void setZip(String zip) {
    this.zip = zip;
  }
    
  public String toString() {
    StringBuilder addr = new StringBuilder();
    addr.append(line1);
    if (StringUtils.isNotEmpty(line2)) {
      addr.append(" ");
      addr.append(line2);
    }
    addr.append(" ");
    addr.append(city);
    addr.append(", ");
    addr.append(state);
    addr.append(" ");
    addr.append(zip);
    return addr.toString();
  }  
}
