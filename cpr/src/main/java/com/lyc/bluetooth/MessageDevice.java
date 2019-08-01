package com.lyc.bluetooth;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import android.bluetooth.BluetoothSocket;
import android.widget.Toast;

import com.kangren.cpr.analyzer.AnalyzerFactory;
import com.kangren.cpr.receiveMessage.IReceiveMessage;
import com.lyc.utils.LogUtil;

public class MessageDevice { 

	private BluetoothSocket btSocket = null;
	private ArrayList<IRecevedMsgListener> recevedMsgListenerList = new ArrayList<IRecevedMsgListener>();
	private IBreakListener breakListener;
	private boolean isStart=false;
	public BluetoothSocket getBtSocket() {
		return btSocket;
	} 

	private OutputStream outStream = null;
	private InputStream inStream = null;   
    private String lastSt; 
	public MessageDevice(BluetoothSocket btSocket) {
		
	
		this.btSocket = btSocket;
		try {
			outStream = btSocket.getOutputStream();
			inStream = btSocket.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		
		}
	}

	List<Integer> list=new ArrayList<Integer>();
	private void print(byte[] data){ 
		
		//Integer[] buffer = new  Integer[20];
		//List<Integer> subList=null;
		
		String st="";
		for (int i : data) {
			//list.add(i);
	 	int temp=i&0xff;
		//	list.add(Integer.toHexString(temp));
			st+=Integer.toHexString(temp);
		}
		//if(list.size()<20){
		//	return;
		//}
		//subList=list.subList(0, 20);
		//for(int i=0;i<20;i++){
		//	int temp=subList.get(i)&0xff;
		//	st+=Integer.toHexString(temp)+" ";
		
		LogUtil.WriteLog(st);
		//subList.toArray(buffer);
		//subList.clear();
		//AnalyzerFactory rmf=AnalyzerFactory.getInstance();
		//List<IReceiveMessage> msgs=rmf.analyze(buffer);
		// for(IReceiveMessage msg :msgs){
		//	 LogUtil.WriteLog(msg.toString());
		// }	
		
	}
	public void start() {
		isStart=true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (isStart) {
					byte res[] = null;
					try {
						byte[] buffer = new byte[1024 * 8];
						int len;
						
						len = inStream.read(buffer);
						res = new byte[len];
						System.arraycopy(buffer, 0, res, 0, len);
						MsgEvent me = new MsgEvent(this, res);
						for(int i=0;i<recevedMsgListenerList.size(); i++){
							recevedMsgListenerList.get(i).Done(me);
						}
				//print(res);
						//LogUtil.WriteLog(len+""); 
					} catch (IOException e) {
						// TODO Auto-generated catch block
						LogUtil.WriteLog(e);
						if (breakListener != null)
							breakListener.Done();
						break;
					}
				}

			}
		}).start();
	}

	public void close(){
		isStart=false;
		try {
			btSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void stop(){
		isStart=false;
	}
	public boolean write(byte[] buffer)  {
		try {
			outStream.write(buffer);
			outStream.flush();
			return true;
			//LogUtil.WriteLog("转发成功"); 
		} catch (IOException e) {
			
			LogUtil.WriteLog(e);
			// TODO Auto-generated catch block
			if (breakListener != null)
				breakListener.Done();
			return false;
		}

	}
	public void removeRecevedMsgListener(IRecevedMsgListener recevedMsgListener){
		if(recevedMsgListenerList.indexOf(recevedMsgListener)>-1)
			recevedMsgListenerList.remove(recevedMsgListener);
	}
	public void setRecevedMsgListener(IRecevedMsgListener recevedMsgListener) {
		if(recevedMsgListenerList.indexOf(recevedMsgListener)==-1)
			recevedMsgListenerList.add(recevedMsgListener);
	}
 
	public void setBreakListener(IBreakListener breakListener) {
		this.breakListener = breakListener;
 
	}
   
	public interface IRecevedMsgListener { 
		// 这里是当事件发生后的响应过程
		void Done(MsgEvent me); 
	}

	public interface IBreakListener {
		// 这里是当事件发生后的响应过程
		void Done();
	}

	public class MsgEvent extends java.util.EventObject {

		private byte[] msg = null;

		public byte[] getMsg() {
			return msg;
		}

		public void setMsg(byte[] msg) {
			this.msg = msg;
		}

		public MsgEvent(Object source, byte[] msg) {
			super(source);
			this.msg = msg;
			// TODO Auto-generated constructor stub
		}
	}
}
