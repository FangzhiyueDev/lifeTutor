package com.kangren.cpr.entity;

import java.util.ArrayList;
import java.util.List;

import com.kangren.cpr.receiveMessage.IReceiveMessage;

/**
 * ���沨������
 * @author Administrator
 *
 */
public class ScoreReceiveMessage {

	/**
	 * �ɼ�ID
	 */
	public String id; 
	
	/**
	 * ��ʱ
	 */
	public int elapsedTime;
	
	public List<IReceiveMessage> msgList;
	public  ScoreReceiveMessage(String id){
		this.id=id;
		msgList=new ArrayList<IReceiveMessage>();
	}
	public  ScoreReceiveMessage(){}
	
	
}
