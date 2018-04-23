package com.tjzhic.entity;

public class Grade {
  // 成绩ID
  private int gardeid;

  // 准考证号
  private String testcardnum;

  // 课程代码
  private String ccode;

  // 成绩
  private int score;

  // 备注：正常、缺考、作弊
  private String note;

  // 状态标识：0：可录入  1：不可录入
  private String status;

  public int getGardeid() {
    return gardeid;
  }
  public void setGardeid(int gardeid) {
    this.gardeid = gardeid;
  }
  public String getTestcardnum() {
    return testcardnum;
  }
  public void setTestcardnum(String testcardnum) {
    this.testcardnum = testcardnum;
  }
  public String getCcode() {
    return ccode;
  }
  public void setCcode(String ccode) {
    this.ccode = ccode;
  }
  public int getScore() {
    return score;
  }
  public void setScore(int score) {
    this.score = score;
  }
  public String getNote() {
    return note;
  }
  public void setNote(String note) {
    this.note = note;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  
}
