package com.tjzhic.dao;
import com.tjzhic.entity.School;

public interface SchoolDao {

  // 添加学校主体
  public int add(School school);

  // 查找学校主题
  public School getSchool();
}
