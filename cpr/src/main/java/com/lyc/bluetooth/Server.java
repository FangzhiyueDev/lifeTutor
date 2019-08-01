package com.lyc.bluetooth;

import java.io.IOException;


import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;

@SuppressLint("NewApi")  
public class Server {
	BluetoothServerSocket serverSocket;
	private BluetoothAdapter btAdapt = null;
	private IConnectedListener connectedListener;
	private boolean isListening=false;
	public Server(){
		btAdapt = BluetoothAdapter.getDefaultAdapter();
	
	//	setDiscoverableTimeout(1000);
	}
	public void listen() throws Exception{
	
		if (btAdapt.getState() != BluetoothAdapter.STATE_ON) {// 如果蓝牙还没开启
			throw new Exception("蓝牙未开启");
		}
		if (btAdapt == null) {
			throw new Exception("本机无蓝牙，连接失败");

		}
		if (btAdapt.getState() != BluetoothAdapter.STATE_ON) {
			throw new Exception("本机蓝牙状态不正常，连接失败");
		}
		isListening=true;
		 if(!btAdapt.isEnabled()){

		//弹出对话框提示用户是后打开
		//	Intent enabler = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);

			//startActivityForResult(enabler, BluetoothAdapter.ACTION_REQUEST_ENABLE);

			      //不做提示，强行打开

			 btAdapt.enable();
			

			}
		 new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				accept();
			}
		}).start();
	
	}
	public void setIConnectedListener(IConnectedListener connectedListener)
	{
		this.connectedListener=connectedListener;
	}
	public void stop(){
		isListening=false;
		if(serverSocket!=null)
			try {
				
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
	}
	private void accept(){
		BluetoothSocket btSocket=null;
		
		try {
			btAdapt.cancelDiscovery();
			serverSocket = btAdapt.listenUsingInsecureRfcommWithServiceRecord("smallPad",BluetoothToolConfig.PRIVATE_UUID);
			
			while(isListening){
				btSocket=serverSocket.accept();
			
				if(connectedListener!=null){
					ConnectedEvent me = new ConnectedEvent( btSocket,	btSocket.getRemoteDevice().getName());
					connectedListener.Done(me);
				}
			}
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block n
			e.printStackTrace();
		}
	
	}
	
}
