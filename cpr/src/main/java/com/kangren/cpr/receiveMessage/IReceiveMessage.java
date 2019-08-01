package com.kangren.cpr.receiveMessage;

public  interface IReceiveMessage {
	
	/*
	 * 获取消息类型
	 */
	ReceiveMessageType getMsgType();
	
	/**
	 * 获取时间戳
	 * @return
	 */
	 long getTime();
	 void setTime(long time);
}

