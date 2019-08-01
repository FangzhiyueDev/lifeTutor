package com.kangren.cpr.entity;

import java.util.UUID;

public class Score {
	
	
	public OprateRecordTable[] tables;
	public String id;
	public String stu_name;
	public String stu_class;
	public String exam_date;
	//用于查询
	public long exam_data_long;
	public String exam_type;
	public int score;
	//标示数据是否上传
	public boolean isUpload;
	
	public String path;
	public Score(){
		id=UUID.randomUUID().toString();
	}
	
	
	
}
