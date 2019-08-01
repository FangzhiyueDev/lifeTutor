package com.lyc.bluetooth;

import java.util.Set;

import com.lyc.utils.LogUtil;
import com.lyc.utils.ToastUtil;




import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;


	public class SearchDevice {
		
		//用于注册广播的context
		private Context context;
		
		//蓝牙适配器
		private BluetoothAdapter btAdapt;
		private boolean isInit=false;
		
		private IFindDeviceListener findDeviceListener;
		private IFinishedListener finishedListener;
		private boolean starting = false;
		private int timeout=5000; 
		public boolean isStarting() {
			return starting;
		}

		public void setTimeout(int timeout) {
			
		this.timeout=timeout;
		}
		public SearchDevice(Context context) {
			this.context = context;
		
			btAdapt = BluetoothAdapter.getDefaultAdapter();
		}

		public Context getContext() {
			return context;
		}


		public void setContext(Context context) {
			this.context = context;
		}


		/**
		 * 开始查找蓝牙设备
		 * @throws Exception 
		 */
		public boolean start() throws Exception{
			boolean b=false;
			if(!isInit){
				
				
			
			
			if(context==null)
				throw new Exception("context不能为空");
			
			 Handler handler = new Handler();  
			  
		     Runnable runnable= new Runnable() {    
		        public void run() {  
		             
		           
		        	if(starting)
		        		stop();
		        }  
		    }; 
		    handler.postDelayed(runnable,timeout);
			if (btAdapt.getState() != BluetoothAdapter.STATE_ON) {
				btAdapt.enable();
			}
		
			//注册广播
			IntentFilter intent = new IntentFilter();
			intent.addAction(BluetoothDevice.ACTION_FOUND); // 发现设备
			intent.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
			intent.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
			this.context.registerReceiver(searchDevices, intent);
			}
			//获取已绑定设备
			Set<BluetoothDevice> devices = btAdapt.getBondedDevices();
			for (BluetoothDevice device : devices) {

				if (!BluetoothAdapter.checkBluetoothAddress(device.getAddress())) {
					return b;
				}
				if (findDeviceListener == null)
					return b;
				
				LogUtil.WriteLog(device.getName());
				// 发现设备
				DeviceEvent event = new DeviceEvent(device.getName(),
						device.getAddress());
				
				//ToastUtil.showTip(this.context, device.getName());
				//响应事件
				findDeviceListener.Done(event);
			}
			//先取消 后开启查找
			
			 if (btAdapt.isDiscovering()) {  
				 btAdapt.cancelDiscovery();  
		        }  
				   
			b= btAdapt.startDiscovery();
		
			LogUtil.WriteLog(b+"");
				
			isInit=true;
			starting = true;
			return b;
		}
		
		public void restart(){
			btAdapt.cancelDiscovery();
			   
			 btAdapt.startDiscovery();
		}

		/*
		 * 停止搜索
		 */
		public void stop() {
			try{
				starting = false;
				btAdapt.cancelDiscovery();
				this.context.unregisterReceiver(searchDevices);
				finishedListener.Done();
			}
			catch(Exception e){}
		}

		
		
		public void setFindDeviceListener(IFindDeviceListener findDeviceListener) {
			this.findDeviceListener = findDeviceListener;

		}
		public void setFinishedListener(IFinishedListener finishedListener) {
			this.finishedListener = finishedListener;

		}

		private BroadcastReceiver searchDevices = new BroadcastReceiver() {

			public void onReceive(Context context, Intent intent) {
				String action = intent.getAction();
				
				if (action.equals(BluetoothDevice.ACTION_FOUND)) { // found device

					if (findDeviceListener == null)
						return;
					
					
					// 发现设备
					BluetoothDevice device = intent
							.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
					DeviceEvent event = new DeviceEvent( device.getName(),
							device.getAddress());
					LogUtil.WriteLog(device.getName()+"");
					findDeviceListener.Done(event);

				} else if (action
						.equals(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)) {// find finished
					
				//	if(starting)
					//	stop();
//					if(isStarting()){
//						btAdapt.cancelDiscovery();
//						btAdapt.startDiscovery();
//					
//					}
				}
			}
		};

		public static interface IFindDeviceListener {

			void Done(DeviceEvent me);
		}
		public static interface IFinishedListener {

			void Done();
		}
}
