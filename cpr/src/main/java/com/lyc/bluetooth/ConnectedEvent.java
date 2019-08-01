package com.lyc.bluetooth;

import android.bluetooth.BluetoothSocket;

public class ConnectedEvent {

	private BluetoothSocket btSocket = null;
	private String name = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BluetoothSocket getBtSocket() {
		return btSocket;
	}

	public void setBtSocket(BluetoothSocket btSocket) {
		this.btSocket = btSocket;
	}
	public ConnectedEvent( BluetoothSocket btSocket,String name) {
	
		this.btSocket = btSocket;
		this.name=name;
	}
	public ConnectedEvent(Object source, BluetoothSocket btSocket) {
	
		this.btSocket = btSocket;
		// TODO Auto-generated constructor stub
	}
}
