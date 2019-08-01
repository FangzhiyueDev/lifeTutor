package com.lyc.bluetooth;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

import com.lyc.bluetooth.MessageDevice.MsgEvent;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

public class Client {
	//private Activity context;
	private String name; 
	private String mac;
	private BluetoothAdapter btAdapt = null;
	private BluetoothSocket btSocket = null;
	private IConnectedListener connectedListener;
	private IConnectedListener failListener;

	private BluetoothDevice btDev;

	public Client(String mac) {
		this.mac=mac;
	//	this.context = context;
		btAdapt = BluetoothAdapter.getDefaultAdapter();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public void setConnectedListener(IConnectedListener connectedListener) {
		this.connectedListener = connectedListener;

	}

	public void setFailListener(IConnectedListener failListener) {
		this.failListener = failListener;

	}

	public void connection() throws Exception {

		if (this.mac == "") {
			throw new Exception("请先设置MAC地址");
		}
		if (btAdapt.getState() != BluetoothAdapter.STATE_ON) {// 如果蓝牙还没开启
			throw new Exception("蓝牙未开启");
		}
		if (btAdapt == null) {
			throw new Exception("本机无蓝牙，连接失败");

		}

		if (btAdapt.getState() != BluetoothAdapter.STATE_ON) {
			throw new Exception("本机蓝牙状态不正常，连接失败");
		}
		connect();
	}

	public void close(){
		try {
			btSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void connect() {
		btDev = btAdapt.getRemoteDevice(mac);
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				ConnectedEvent me=null;
				try {
					Thread.sleep(500);
					btSocket = btDev.createRfcommSocketToServiceRecord(BluetoothToolConfig.PRIVATE_UUID);
					btAdapt.cancelDiscovery();//连接前一定要取消搜索蓝牙
					btSocket.connect();
				//	btDev.createBond();
					if(btSocket!=null){
						me = new ConnectedEvent(this, btSocket);
						if(connectedListener!=null)
							connectedListener.Done(me);
					}
				} catch (Exception e) {
					me = new ConnectedEvent(this, null);
					if(failListener!=null)
						failListener.Done(me);
				}
			}
		}).start();
	
		
	}

	


	
}
