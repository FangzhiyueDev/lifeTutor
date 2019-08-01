package com.kangren.cpr.receiveMessage;

public class RaiseHeadReceiveMessage implements IReceiveMessage{
	
	/**
	 * true仰头 false 平躺
	 */
	public boolean headState;
	@Override
	public ReceiveMessageType getMsgType() {
		// TODO Auto-generated method stub
		return ReceiveMessageType.RaiseHead;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("头部状态%s",headState?"仰头 ":"平躺"); 
	}
	private long time;
	@Override
	public long getTime() {
		// TODO Auto-generated method stub
		return  time;
	}
	@Override
	public void setTime(long time) {
		// TODO Auto-generated method stub
		this.time=time;
		
	}
}
