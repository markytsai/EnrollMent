package com.tjzhic.dao;

import java.util.ArrayList;

import com.tjzhic.entity.Stage;

public interface StageDao {

  // 添加阶段
  public int add(Stage stage);

  // 根据阶段编号删除阶段
  public int deleteByStagenum(int stagenum);

  // 查找所有的阶段
  public ArrayList<Stage> findAll();

  // 根据阶段编号查找阶段
  public Stage findByStagenum(int stagenum);
  
}
