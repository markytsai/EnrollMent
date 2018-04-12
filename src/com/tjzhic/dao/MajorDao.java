package com.tjzhic.dao;
import java.util.ArrayList;

import com.tjzhic.entity.Major;

public interface MajorDao {
  public int add(Major major);
  public int deleteByMcode(String mcode);
  public ArrayList<Major> findAll();
  public int update(int mcode);
  public Major findByMcode(String mcode);
  public int getByName(String mname);
}
