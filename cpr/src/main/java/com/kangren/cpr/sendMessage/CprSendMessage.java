package com.kangren.cpr.sendMessage;

public class CprSendMessage implements ISendMessage {

	
	
	
	/**
	 * 0停止  1开始  2暂停
	 */
	public int cprflag;
	
	/**
	 * 0停止搏动  1开始搏动
	 */
	public int neckflag=1;
	
	/**
	 * 0散大 1正常
	 */
	public int eyeflag=1;
	
	
	@Override
	public SendMessageType getMsgType() {
		// TODO Auto-generated method stub
		return  SendMessageType.Cpr;
	}

}
