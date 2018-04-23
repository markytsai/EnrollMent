package com.tjzhic.dao;

import java.util.ArrayList;
import com.tjzhic.entity.Course;

public interface CourseDao {
  // 添加课程
  public int add(Course course);

  // 根据课程编号删除课程
  public int deleteByCcode(String ccode);

  // 查找所有课程
  public ArrayList<Course> findAll();

  // 根据课程名查找课程
  public ArrayList<Course> findByCmname(String cmname);

  // 根据课程编号查找课程
  public Course findByCcode(String ccode);

  // 根据课程名查找课程编号
  public String findCcode(String cname);
}
