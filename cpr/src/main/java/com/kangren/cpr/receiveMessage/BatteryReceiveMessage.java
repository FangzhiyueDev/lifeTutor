package com.kangren.cpr.receiveMessage;

public class BatteryReceiveMessage  implements IReceiveMessage{

	
	
	/*
	 * 
	 * �ٷֱ�
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
		return String.format("��ص���%s",num);
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
