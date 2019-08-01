package com.kangren.cpr.analyzer;

import java.util.List;

import com.kangren.cpr.receiveMessage.*;
import com.kangren.cpr.sendMessage.ISendMessage;

public interface IAnalyzer {
	
	public List<IReceiveMessage> parse(byte[] buffer);
	public byte[] unParse(ISendMessage msg);
	
}
