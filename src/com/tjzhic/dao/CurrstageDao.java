package com.tjzhic.dao;

import com.tjzhic.entity.Currstage;


public interface CurrstageDao {

  // 管理员设置阶段
  public int set(String adminname,String currstage);

  // 查找当前阶段
  public Currstage findCurrent();
}
