package com.kangren.cpr.sendMessage;

import com.kangren.cpr.receiveMessage.ReceiveMessageType;

public class ConnectSendMessage implements ISendMessage {


	
	

	@Override
	public SendMessageType getMsgType() {
		// TODO Auto-generated method stub
		return SendMessageType.Connect;
	}

}
