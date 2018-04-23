package com.tjzhic.entity;
public class Stu {
  //用户ID
  private int userid;

  //用户名
  private String username;

  //密码
  private String password;

  //注册IP
  private String regip;

  //注册时间
  private String regtime;


  public int getUserid() {
    return userid;
  }
  public void setUserid(int userid) {
    this.userid = userid;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getRegip() {
    return regip;
  }
  public void setRegip(String regip) {
    this.regip = regip;
  }
  public String getRegtime() {
    return regtime;
  }
  public void setRegtime(String regtime) {
    this.regtime = regtime;
  }
}
