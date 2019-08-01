package com.kangren.cpr.receiveMessage;

public class BlowReceiveMessage implements IReceiveMessage{
	public int num;
	/**
	 * 吹气true,呼气为false
	 */
	public boolean isIn;
	
	/**
	 * 气道状态 true 打开 false 未打开
	 */
	public boolean flag;
	@Override
	public ReceiveMessageType getMsgType() {
		// TODO Auto-generated method stub
		return ReceiveMessageType.Blow;
	}
	/**
	 * 亮灯数量
	 */
	public int lights;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		int temp=num&0xff;
		return String.format("吹气量%s 方向%s",Integer.toHexString(temp),isIn?"吹气":"出气"); 
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
