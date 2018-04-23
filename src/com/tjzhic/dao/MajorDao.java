package com.tjzhic.dao;
import java.util.ArrayList;

import com.tjzhic.entity.Major;

public interface MajorDao {
  // 添加专业
  public int add(Major major);

  // 根据课程编号删除课程
  public int deleteByMcode(String mcode);

  // 查找所有课程
  public ArrayList<Major> findAll();

  // 根据课程编号修改课程
  public int update(int mcode);

  // 根据课程编号查找课程
  public Major findByMcode(String mcode);

  // 根据课程名查找课程
  public int getByName(String mname);
}
