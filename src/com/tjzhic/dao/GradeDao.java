package com.tjzhic.dao;

import java.util.ArrayList;

import com.tjzhic.entity.SupGrade;

public interface GradeDao {
	public int gradeAdd(SupGrade supgrade);
	public ArrayList<SupGrade> findByCardnum(String testcardnum);
}
