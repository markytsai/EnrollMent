package com.tjzhic.dao;
import java.util.ArrayList;
import com.tjzhic.entity.Stu;
public interface StuDao {
  // 添加学生主体
  public int add(Stu stu);

  // 根据学生姓名查找学生
  public Stu findByUsername(String username);

  // 验证学生登陆信息
  public Stu validateLogin(String username,String password);

  // 修改密码
  public int passModify(String username,String newpass);

  // 根据姓名模糊查询
  public ArrayList<Stu> findStusLikeUsername(String username);

  // 根据编号模糊查询
  public ArrayList<Stu> findStusLikeIdcode(String idcode);
}