package com.tjzhic.entity;
public class Record {
  // 记录ID
  private int rid;

  // 用户名
  private String logname;

  // 用户组
  private String usergroup;

  // 登录时间
  private String logtime;

  // 登录ip
  private String logip;

  public int getRid() {
    return rid;
  }
  public void setRid(int rid) {
    this.rid = rid;
  }
  public String getLogname() {
    return logname;
  }
  public void setLogname(String logname) {
    this.logname = logname;
  }
  
  public String getUsergroup() {
    return usergroup;
  }
  public void setUsergroup(String usergroup) {
    this.usergroup = usergroup;
  }
  public String getLogtime() {
    return logtime;
  }
  public void setLogtime(String logtime) {
    this.logtime = logtime;
  }
  public String getLogip() {
    return logip;
  }
  public void setLogip(String logip) {
    this.logip = logip;
  }
  
}
