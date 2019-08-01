package com.kangren.bluetooth.Manager;

import java.util.ArrayList;
import java.util.List;

import com.kangren.cpr.AppConfig;
import com.lyc.bluetooth.MessageDevice.IBreakListener;
import com.lyc.bluetooth.Print.IPrintConnectedListener;
import com.lyc.bluetooth.SearchDevice.IFindDeviceListener;
import com.lyc.bluetooth.*;
import com.lyc.utils.LogUtil;

import android.content.Context;

public class BtOperation {
	
	private static BtOperation bt;
	public static BtOperation getInstance(){
		if(bt==null)
			bt=new BtOperation();
		return bt;
	}
	//模型人自动连接次数
	private int mAutoConnectTimes=10;
	//打印机自动连接次数
	private int pAutoConnectTimes=10;
	private boolean modelConnected,printConnected;
	private Print print;
	private Context context;
	private List<IObBt> obList;
	private String printName,modelName;
	private SearchDevice sd;
	private  BtOperation(){}
	public void setPar (Context context, String modelName,String printName){
		this.context=context;
		this.printName=printName;
		this.modelName=modelName;
		obList=new ArrayList<IObBt>();
	}
	
	public void doWork(){
		if(sd==null){
			sd=new SearchDevice(context);
			sd.setFindDeviceListener(new IFindDeviceListener() {
				
				@Override
				public void Done(DeviceEvent me) {
					// TODO Auto-generated method stub
					String name=me.getName();
					if(name==null)
						return;
					if(name.equals(printName)){
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						connectPrint(me.getMac());	
					}
					if(name.equals(modelName)){
						connectModel(me.getMac());
					}
				}
			});
		}
		try {
			sd.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void rework(){
		mAutoConnectTimes=10;
		pAutoConnectTimes=10;
		stop();
		doWork();
	}
	
	public void stop(){
		if(print!=null)
			print.stop();
	}
	public void addOb(IObBt ob){
		
		obList.add(ob);
	}
public void setOb(IObBt ob){
	obList.clear();
		obList.add(ob);
	}
	public void removeOb(IObBt ob){
		obList.remove(ob);
		
	}
	
	private void connectModel(String mac) {
		
		if(AppConfig.getInstance().ModelConnected)
			return;

		final Client conn = new Client(mac);
		
		conn.setConnectedListener(new IConnectedListener() {
			@Override
			public void Done(ConnectedEvent me) {
				// TODO Auto-generated method stub
				MessageDevice md;
				try {
					md = new MessageDevice(me.getBtSocket());
					md.start();
					notifyMsg(BtMsgType.modelConnected,md);
					modelConnected=true;
					if(print!=null&&!printConnected)
						print.connect();
					md.setBreakListener(new IBreakListener() {

						@Override
						public void Done() {  
							modelConnected=false;
							notifyMsg(BtMsgType.modelMiss,null);
						}
					});
				} catch (Exception e) {
					// TODO Auto-generated catch block
				
					LogUtil.WriteLog(e);
				}
			}
		});
		conn.setFailListener(new IConnectedListener() {

			@Override
			public void Done(ConnectedEvent me) {
			
				try {
					modelConnected=false;
					mAutoConnectTimes--;
					if(mAutoConnectTimes>0)
						conn.connection();
				} catch (Exception e) {
					notifyMsg(BtMsgType.modelConnectFaild,null);
				}
			}
		});
		try {
			conn.connection();
		} catch (Exception e) {
		
		
		}
	}
	
	private void notifyMsg(BtMsgType msgType, Object o){
		for(IObBt ob:obList){
			ob.notify(msgType, o);
		}
	}
	private void connectPrint(String mac) {
		if(AppConfig.getInstance().PrintConnected)
			return;
		 print = new Print(context, mac);
		print.setIConnectedListener(new IPrintConnectedListener() {

			@Override
			public void Done() {
				// TODO Auto-generated method stub
				notifyMsg(BtMsgType.printConnected,print);
			}
		});
		print.setIFailToPrintConnectedListener(new IPrintConnectedListener() {

			@Override
			public void Done() {
				// TODO Auto-generated method stub
				notifyMsg(BtMsgType.printConnectFaild,null);
				
				if(mAutoConnectTimes>0)
				if(modelConnected&&pAutoConnectTimes>0)
					print.connect();
			}
		});
		print.connect();
	}
	
	
}

