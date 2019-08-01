package com.kangren.cpr.receiveMessage;

public class BatteryReceiveMessage  implements IReceiveMessage{

	
	
	/*
	 * 
	 * 百分比
	 */
	public int num;

	@Override
	public ReceiveMessageType getMsgType() {
		// TODO Auto-generated method stub
		return ReceiveMessageType.Battery;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("电池电量%s",num);
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
