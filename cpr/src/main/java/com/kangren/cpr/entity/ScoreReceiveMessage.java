package com.kangren.cpr.entity;

import java.util.ArrayList;
import java.util.List;

import com.kangren.cpr.receiveMessage.IReceiveMessage;

/**
 * 保存波形数据
 * @author Administrator
 *
 */
public class ScoreReceiveMessage {

	/**
	 * 成绩ID
	 */
	public String id; 
	
	/**
	 * 耗时
	 */
	public int elapsedTime;
	
	public List<IReceiveMessage> msgList;
	public  ScoreReceiveMessage(String id){
		this.id=id;
		msgList=new ArrayList<IReceiveMessage>();
	}
	public  ScoreReceiveMessage(){}
	
	
}
