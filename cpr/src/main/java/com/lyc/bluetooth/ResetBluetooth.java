package com.lyc.bluetooth;


import com.lyc.utils.LogUtil;

import android.bluetooth.BluetoothAdapter;

public class ResetBluetooth {
	private BluetoothAdapter btAdapt = BluetoothAdapter.getDefaultAdapter();
	private IResetCompletedListener resetCompleted;
	private boolean resetState=false;//该状态为true时再打开蓝牙 即重启完毕
	public void reset(){
		
		if(btAdapt.getState()==BluetoothAdapter.STATE_OFF){
			resetState=true;
		}
		else{
			btAdapt.disable();
		}
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				while(true){
					
					LogUtil.WriteLog(btAdapt.getState()+"");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(!resetState&&btAdapt.getState()!=BluetoothAdapter.STATE_OFF){
						continue;
					}
					
					resetState=true;
					btAdapt.enable();
					if(btAdapt.getState()==BluetoothAdapter.STATE_ON){
						if(resetCompleted!=null)
							resetCompleted.Done();
						break;
					}
					
				}
			}
		}).start();
		
	}
	
	
	
	public IResetCompletedListener getResetCompleted() {
		return resetCompleted;
	}



	public void setResetCompleted(IResetCompletedListener resetCompleted) {
		this.resetCompleted = resetCompleted;
	}



	public interface IResetCompletedListener {
		void Done(); 
	}


}
