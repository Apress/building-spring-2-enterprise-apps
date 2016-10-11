package  com.apress.springbook.chapter08.domain;

public class PhoneNumber {

  public enum Type { HOME, WORK, CELL };
    
  private Integer id;
  private String areaCode;
  private String number;
  private Type type;
  private Member player;
    
  public Type getType() {
    return type;
  }
  public void setType(Type type) {
    this.type = type;
  }
  public String getAreaCode() {
    return areaCode;
  }
  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }
  public String getNumber() {
    return number;
  }
  public void setNumber(String number) {
    this.number = number;
  }
  public Integer getId() {
    return id;
  }
  void setId(Integer id) {
    this.id = id;
  }
  public void setMember(Member player) {
    this.player = player;
  }
  public Member getMember() {
    return player;
  }
}
