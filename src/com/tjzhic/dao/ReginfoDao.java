package com.tjzhic.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.tjzhic.entity.Major;
import com.tjzhic.entity.Reginfo;

public interface ReginfoDao {

	// 添加注册信息
	public int add(Reginfo reginfo);

	// 根据用户名查找用户
	public Reginfo findByUser(String username);

	public Reginfo findByIdcode(String idcode);

	public ArrayList<Reginfo> findAll();

	public int addCode(String username, String testcardnum);

	public ArrayList<Reginfo> findByIncrease();


	public HashMap<String, Integer> staticByMajor(ArrayList<Major> majors);

	public int update(Reginfo reginfo);

	public int update(String idcode, int confirm);

	public int update(String str, String username);

	public int update(String username, String examroom, int seatnum);

	
}
