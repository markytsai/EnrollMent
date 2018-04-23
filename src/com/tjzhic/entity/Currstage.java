package com.tjzhic.entity;

public class Currstage {
  // 设置编号
  private int configid;

  // 设置人
  private String adminname;

  // 设置时间
  private String settime;

  // 当前阶段名称
  private String stagename;


  public int getConfigid() {
    return configid;
  }
  public void setConfigid(int configid) {
    this.configid = configid;
  }
  public String getAdminname() {
    return adminname;
  }
  public void setAdminname(String adminname) {
    this.adminname = adminname;
  }
  public String getSettime() {
    return settime;
  }
  public void setSettime(String settime) {
    this.settime = settime;
  }
  public String getStagename() {
    return stagename;
  }
  public void setStagename(String stagename) {
    this.stagename = stagename;
  }
 
  
}
