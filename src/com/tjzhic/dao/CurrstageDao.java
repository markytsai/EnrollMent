package com.tjzhic.dao;

import com.tjzhic.entity.Currstage;


public interface CurrstageDao {
  public int set(String adminname,String currstage);
  public Currstage findCurrent();
}
