package com.tjzhic.entity;

public class Stage {
  //阶段编号
  private int stagenum;

  //阶段名称
  private String stagename;

  //开始时间
  private String starttime;

  //结束时间
  private String endtime;

  //阶段说明
  private String note;


  public int getStagenum() {
    return stagenum;
  }
  public void setStagenum(int stagenum) {
    this.stagenum = stagenum;
  }
  public String getStagename() {
    return stagename;
  }
  public void setStagename(String stagename) {
    this.stagename = stagename;
  }
  public String getStarttime() {
    return starttime;
  }
  public void setStarttime(String starttime) {
    this.starttime = starttime;
  }
  public String getEndtime() {
    return endtime;
  }
  public void setEndtime(String endtime) {
    this.endtime = endtime;
  }
  public String getNote() {
    return note;
  }
  public void setNote(String note) {
    this.note = note;
  }
  
}
