package com.kangren.cpr.receiveMessage;

public  interface IReceiveMessage {
	
	/*
	 * ��ȡ��Ϣ����
	 */
	ReceiveMessageType getMsgType();
	
	/**
	 * ��ȡʱ���
	 * @return
	 */
	 long getTime();
	 void setTime(long time);
}

