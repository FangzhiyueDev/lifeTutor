package com.kangren.cpr.sendMessage;

public class CprSendMessage implements ISendMessage {

	
	
	
	/**
	 * 0ֹͣ  1��ʼ  2��ͣ
	 */
	public int cprflag;
	
	/**
	 * 0ֹͣ����  1��ʼ����
	 */
	public int neckflag=1;
	
	/**
	 * 0ɢ�� 1����
	 */
	public int eyeflag=1;
	
	
	@Override
	public SendMessageType getMsgType() {
		// TODO Auto-generated method stub
		return  SendMessageType.Cpr;
	}

}
