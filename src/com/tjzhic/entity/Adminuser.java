package com.tjzhic.entity;

public class Adminuser {
  // 管理员ID
  private int adminid;

  // 管理员名称
  private String adminname;

  // 管理员密码
  private String adminpass;

  // 管理员所属组
  private String admingroup;


  public int getAdminid() {
    return adminid;
  }
  public void setAdminid(int adminid) {
    this.adminid = adminid;
  }
  public String getAdminname() {
    return adminname;
  }
  public void setAdminname(String adminname) {
    this.adminname = adminname;
  }
  public String getAdminpass() {
    return adminpass;
  }
  public void setAdminpass(String adminpass) {
    this.adminpass = adminpass;
  }
  public String getAdmingroup() {
    return admingroup;
  }
  public void setAdmingroup(String admingroup) {
    this.admingroup = admingroup;
  }

}
