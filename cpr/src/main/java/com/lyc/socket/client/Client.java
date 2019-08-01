package com.lyc.socket.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Client {
	
	private static Client client;
	public static String ip;
	public static int port;
	
	//请确保已经设置 ip 及端口号
	public static Client getInstance(){
		
		if(client==null){
			client=new Client();
			
		}
		
		return client;
	}
	
	

	public int state=0;
	private Socket socket;
	
	private ClientStateChangeListener stateChangeListener;
	private OutputStream os;
	private InputStream ins;
	private  Client(){
		
	}
	private  void connect(){
		state=3;//connecting
		socket=new Socket();
	
		SocketAddress ad=new InetSocketAddress(ip,port);
		
		try {
			socket.connect(ad,5000);
			os=socket.getOutputStream();
			ins=socket.getInputStream();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					 while(true){
						 try {
							ins.read();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							setBreak();
							break;
						}
					 }
				}
			}).start();
			
			
			state=1;
			if(stateChangeListener!=null)
				stateChangeListener.stateChange(state);
		} catch (IOException e) {
			setBreak();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void setBreak(){
		
		state=0;
		if(stateChangeListener!=null)
			stateChangeListener.stateChange(state);
		
	}
	public boolean isConnected(){
		
		return state==1;
	}
	public void reconnect(){
		connect();
	}
	public boolean send(byte[] buffer){
		try {
			if(state==1){
				os.write(buffer);
				os.flush();
			    return true;
			}
			return false;
		} catch (IOException e) {
			setBreak();
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
	}
	/**
	 * 0时连接失败或者断开，1为成功
	 * @param stateChangeListener
	 */
	public void setStateChangeListener(ClientStateChangeListener stateChangeListener) {
		this.stateChangeListener =stateChangeListener;
	}
	

	
	
	
	
}
