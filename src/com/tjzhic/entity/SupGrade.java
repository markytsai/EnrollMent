package com.tjzhic.entity;

public class SupGrade extends Grade{

	// 学生姓名
	private String sname;

	// 学科名称
	private String coursename;

	public void setSname(String sname){
		this.sname = sname;
	}
	public String getSname(String sname){
		return this.sname;
	}
	public void setCname(String coursename){
		this.coursename = coursename;
	}
	public String getCname(){
		return this.coursename;
	}
}
