package com.tjzhic.dao;

import java.util.ArrayList;

import com.tjzhic.entity.SupGrade;

public interface GradeDao {
	// 添加年级
	public int gradeAdd(SupGrade supgrade);

	// 查找准考证号
	public ArrayList<SupGrade> findByCardnum(String testcardnum);
}
