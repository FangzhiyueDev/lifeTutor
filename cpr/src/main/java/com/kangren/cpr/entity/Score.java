package com.kangren.cpr.entity;

import java.util.UUID;

public class Score {
	
	
	public OprateRecordTable[] tables;
	public String id;
	public String stu_name;
	public String stu_class;
	public String exam_date;
	//���ڲ�ѯ
	public long exam_data_long;
	public String exam_type;
	public int score;
	//��ʾ�����Ƿ��ϴ�
	public boolean isUpload;
	
	public String path;
	public Score(){
		id=UUID.randomUUID().toString();
	}
	
	
	
}
