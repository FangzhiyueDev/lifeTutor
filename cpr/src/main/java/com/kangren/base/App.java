package com.kangren.base;

import com.lyc.socket.client.Client;

import android.app.Application;

public class App  extends Application {
	
	public  Client client;
	 @Override  
	    public void onCreate() {  
	        super.onCreate();  
	       CrashHandler.getInstance().init(this);  
	    }  
}
