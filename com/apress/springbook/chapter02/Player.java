/*
package com.apress.springbook.chapter02;

public class Player {
  private String fullName;
  private int ranking;

  public Player(String fullName, int ranking) {
    if (fullName == null || fullName.length() == 0) {
      throw new IllegalArgumentException("Full name is required!");
    }
    this.fullName = fullName;
    this.ranking = ranking;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setRanking(int ranking) {
    this.ranking = ranking;
  }


  public String getFullName() {
    return this.fullName;
  }

  public int getRanking() {
    return this.ranking;
  }

}
*/

package com.apress.springbook.chapter02;

public class Player {
   private String fullName;
   private int ranking;

   public Player(String fullName) {
      if (fullName == null || fullName.length() == 0) {
         throw new IllegalArgumentException("Full name is required!");
      }
      this.fullName = fullName;
   }

   public String getFullName() {
      return this.fullName;
   }

   public void setRanking(int ranking) {
      this.ranking = ranking;
   }

   public int getRanking() {
      return this.ranking;
   }
}
