package com.kangren.cpr.receiveMessage;
/**
 * 用于添加回放的第一帧 和最后一帧
 * @author Administrator
 *
 */
public class PlayBackEndOrStartMessage implements IReceiveMessage {

	private long time;
	@Override
	public ReceiveMessageType getMsgType() {
		// TODO Auto-generated method stub
		return ReceiveMessageType.PlayBackEndOrStart;
	}

	@Override
	public long getTime() {
		// TODO Auto-generated method stub
		return this.time;
	}

	@Override
	public void setTime(long time) {
		// TODO Auto-generated method stub
		this.time=time;
	}

}
