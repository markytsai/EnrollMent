package com.tjzhic.dao;
import java.util.ArrayList;
import com.tjzhic.entity.Adminuser;

/**
 *  @Auther caizhenya
 *  @version 1.0
 *
 */
public interface AdminuserDao {
  //管理员登陆验证
  public Adminuser validateLogin(String adminname,String adminpass);

  // 添加管理员
  public int add(Adminuser adminuser);

  // 删除管理员
  public int deleteByAdminname(String adminname);

  // 查找所有的管理员
  public ArrayList<Adminuser> findAll();

  // 根据姓名查找管理员
  public Adminuser findByAdminname(String adminname);

  // 修改管理员密码
  public int passModify(String adminname,String newpass);
}