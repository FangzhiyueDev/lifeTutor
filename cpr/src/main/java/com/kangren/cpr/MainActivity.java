package com.kangren.cpr;





import java.util.Timer;
import java.util.TimerTask;
import com.kangren.language.*;

import com.example.kanren.cpr.R;
import com.kangren.cpr.entity.*;
import com.kangren.cpr.receiveMessage.BatteryReceiveMessage;
import com.kangren.cpr.receiveMessage.BlowReceiveMessage;
import com.kangren.cpr.receiveMessage.OperationBeforeReceiveMessage;
import com.kangren.cpr.receiveMessage.PressReceiveMessage;
import com.kangren.cpr.receiveMessage.RaiseHeadReceiveMessage;
import com.kangren.cpr.sendMessage.CprSendMessage;
import com.kangren.cpr.viewModel.helper.UploadHelper;
import com.kangren.language.Chinese;
import com.kangren.language.English;
import com.kangren.services.DataService;
import com.kangren.services.PrintsService;
import com.kangren.services.DataService.IReceiver;
import com.kangren.bluetooth.Manager.BtMsgType;
import com.kangren.bluetooth.Manager.BtOperation;
import com.kangren.bluetooth.Manager.IObBt;
import com.lyc.bluetooth.MessageDevice;
import com.lyc.bluetooth.Print;
import com.lyc.db4o.Db;
import com.lyc.hybird.ExtWebView;
import com.lyc.socket.client.Client;
import com.lyc.socket.client.ClientStateChangeListener;
import com.lyc.ui.FilePickerEx;
import com.lyc.utils.JsonUtil;
import com.lyc.utils.LogUtil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentManager.BackStackEntry;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.Config;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.printservice.PrintService;
import android.text.InputType;
import android.text.style.BulletSpan;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener , IObBt {

	
	
	private Toast toast;
	private boolean isPlayBack=false;
	//用于接收电量信息
	private  IReceiver batteryIReceiver;
	private AppConfig appConfig;
	private BtOperation btOpera;
	private View modelView,printView,batteryView,langView;
	private int batteryViewMaxWidth;
	//private boolean isWeb=true;
	private TextView titleTv,title2Tv;
//	private ImageView logoImg;
	private CprFragment cpr;
	private WebViewFragment wf;
	public Score lastScore;
	
	private Setting setting;
	private Language lang;
	public ScoreReceiveMessage lastReceiveMessage;
	//操作结果对象JSON字符串
	public String oprate_obj;
	//webview 引用
	

    @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appConfig=AppConfig.getInstance();
       
        if(!appConfig.IsInit)
        	init();
        appConfig.IsInit=true;
      
        String st=   Build.MODEL;
        Client.ip=appConfig.ip;
        Client.port=appConfig.port;
    	//Thread t=Thread.currentThread();
    	
    	  TimerTask task = new TimerTask() {
              @Override
              public void run() {
            	  Db db=AppConfig.getInstance().db;
             	 setting=db.getFirst(new Setting());
             	 
             	setting.language=0;
             	 runOnUiThread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						if(setting.language==0){
	                      	langView.setBackground(getResources().getDrawable(R.drawable.cn));
	                      	MainActivity.this.lang=new Chinese();
						}
	                      else{
	                      	langView.setBackground(getResources().getDrawable(R.drawable.en));
	                      	MainActivity.this.lang=new English();
	                      }
					}
             		 
             		
             		 
             	 });
                  
              }
          };
          Timer timer = new Timer();
          timer.schedule(task, 300);//3秒后执行Time
          langView.setVisibility(View.GONE);
     
         
     /*
    	Db db=AppConfig.getInstance().db;
    	 setting=db.getFirst(new Setting());;
         if(setting.language==0)
         	langView.setBackground(getResources().getDrawable(R.drawable.cn));
         else
         	langView.setBackground(getResources().getDrawable(R.drawable.en));*/
        //connectServer();
  	
       
    
       
   
    }
    @Override  
    protected void onResume() {  
     /** 
      * 设置为横屏 
      */  
     if(getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){  
      setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);  
     }  
     super.onResume();  
    }  
    public void showMsg(final String msg){
    	runOnUiThread( new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(toast==null)
		    		toast=Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
		    	toast.setText(msg);
		    	//toast.setDuration(Toast.LENGTH_LONG);
		    	toast.show();
			}
		});
    
    	
    }
    /*
    //断线之后每10秒尝试一次连接
    private void connectServer(){
    	
    	final Resources res= getResources();
    	Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				final Client c=	Client.getInstance();
				c.setStateChangeListener(new ClientStateChangeListener() {
					
					@SuppressLint("NewApi") @Override
					public void stateChange(int state) {
						// TODO Auto-generated method stub
						if(state==0){
							runOnUiThread( new Runnable() {
								public void run() {
									printView.setBackground(res.getDrawable(R.drawable.pcx));
								}
							});
						
								//showMsg("未连接到教师机");
							try {
								Thread.sleep(1000*10);
								c.reconnect();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								
							}
							
						}
						else if(state==1){
							c.send(UploadHelper.stringToBytes(Build.MODEL, UploadHelper.NAME_TYPE));
							
							runOnUiThread( new Runnable() {
								public void run() {
									printView.setBackground(res.getDrawable(R.drawable.pc));
								}
							});
						
							//	showMsg("已连接到教师机");
						}
							
							
					}
				});
				
				c.reconnect();
			}
		} );
    	t.start();
    	
    }
    */
    
    @Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}

	@SuppressLint("NewApi") private void init(){
    	
    	
    	 SharedPreferences sp = getSharedPreferences("cpr_config", MODE_PRIVATE);
            appConfig.PrintName=sp.getString("printer_name", "");
            appConfig.ModelName=sp.getString("cpr_name", "");
            appConfig.ip=sp.getString("ip", "");
          //  appConfig.ModelName="kr05";
           // appConfig.PrintName="YZ-P07";
        
  //   appConfig.ModelName="XM-15";
  //  appConfig.PrintName="MPT-II";
  //appConfig.ip="192.168.0.16";
            findView();
            batteryViewMaxWidth=batteryView.getLayoutParams().width;
            setBatteryWidth(0);//默认为0，未连接 或者未获取电量的时候为0
            initBatteryIReceiver();
            initBt();
            DataService.getInstance().addIreceiver(batteryIReceiver);
        	//setBatteryWidth(50);
            wf = new WebViewFragment("cprIndex"); 
           
            //  
              FragmentManager fm = getFragmentManager();  
              FragmentTransaction tx = fm.beginTransaction();   
              tx.add(R.id.content,wf,"web"); 
              //tx.addToBackStack(null);
              tx.commit(); 
              
           //   logoImg.setBackground(getResources().getDrawable(R.id.logo));
    }
    private void shouquan(){
    //
    }
    public void playBack(Score score, ScoreReceiveMessage srm){
    	  FragmentManager fm = getFragmentManager();  
          FragmentTransaction tx = fm.beginTransaction();  
    	  cpr= new CprFragment(score,srm);
    	  isPlayBack=true;
    	  tx.add(R.id.content,cpr,"two");  
    	  tx.addToBackStack(null);
    	  tx.commit();  
    }
    public String getCurrentTitle(){
    	return titleTv.getText().toString();
    }
    public String getCurrentTitle2(){
    	return title2Tv.getText().toString();
    }
    public void updateTitle(String title){
    	if(title==""){ 
    	//	logoImg.setVisibility(View.VISIBLE);
    	}
    	else{
    		//logoImg.setVisibility(View.GONE);
    	}
    	titleTv.setText(title);
    	
    }
    public void updateTitle2(String title){
    	if(title==""){ 
    		title2Tv.setText("");
    	//	findViewById(R.id.version).setVisibility(View.VISIBLE);
        	//logoImg.setVisibility(View.VISIBLE);
    		return;
    	}
    	//logoImg.setVisibility(View.GONE);
    	title2Tv.setText(lang.daojishi+":"+title+lang.miao);
    	//findViewById(R.id.version).setVisibility(View.GONE);
    //logoImg.setVisibility(View.GONE);
    }
    public void updateElapsedTimeTitle(String title){
    	
    	title2Tv.setText(title);
    }
    public void goCpr(CprType cprType){
    	  FragmentManager fm = getFragmentManager();  
          FragmentTransaction tx = fm.beginTransaction();  
    	  cpr= new CprFragment(cprType);
    	//  tx.hide(wf);
    	  tx.add(R.id.content,cpr,"two");  
    	  tx.addToBackStack(null);
    	  tx.commit();  
    }
    public void goWebView(String url){
    	WebViewFragment wf2 = new WebViewFragment(url);
    	
         //  
           FragmentManager fm = getFragmentManager();  
           FragmentTransaction tx = fm.beginTransaction();   
           
           tx.add(R.id.content,wf2,"web"); 
           tx.addToBackStack(null);
           tx.commit(); 
  }
    @Override  
    public boolean onKeyDown(int keyCode, KeyEvent event) {  
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
        	
        	
        	 if(!isPlayBack&&wf.canGoBack()){
            	wf.goBack();
            	return true;  
            }
        	// moveTaskToBack(false);
        }  
        isPlayBack=false;
        return super.onKeyDown(keyCode, event);  
    }  

	private void findView(){
		//logoImg=(ImageView) findViewById(R.id.logo2);
		modelView=findViewById(R.id.modelstate);
		printView=findViewById(R.id.printstate);
		batteryView=findViewById(R.id.battery);
		titleTv=(TextView) findViewById(R.id.title);
		title2Tv=(TextView) findViewById(R.id.title2);
		langView=findViewById(R.id.language);
	}
    private void initBt(){
    	btOpera=BtOperation.getInstance();
    	btOpera.setPar(this, appConfig.ModelName, appConfig.PrintName);
    	
    	 btOpera.setOb(this);
    	 btOpera.doWork();
    }
    private void showListDialog() {
        final String[] items = { "简体中文","English" };
        AlertDialog.Builder listDialog = 
            new AlertDialog.Builder(MainActivity.this);
        listDialog.setTitle("");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // which 下标从0开始
                // ...To-do
            	
            	   if(setting.language!=which){
            		    setting.language=which;
            			Setting newSet= setting;
            			Db db=AppConfig.getInstance().db;
            			Setting old=db.getFirst(new Setting());
            			db.del(old);
            			db.add(newSet);
            			  Toast.makeText(MainActivity.this,setting.language==0?new Chinese().chongqiApp:new English().chongqiApp,
            	                    Toast.LENGTH_SHORT).show();
            	   }
            	   
            	   
              
            }
        });
        listDialog.show();
    }
    
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		
		if(view.getId()==R.id.language){
			showListDialog();
		}
		if(view.getId()==R.id.modelstate){
			 if(appConfig.ModelConnected){
				showMsg(lang.moxingrenlianjie);
				// ToastUtil.showTip(this, "模型人已连接");
				 return;
			 }
			 showMsg(lang.lianjiezhong);
			
			 btOpera.rework();
		}
		if(view.getId()==R.id.printstate){
			//屏蔽打印连接
			if(view.getId()==R.id.printstate)
			 return;
			 if(appConfig.PrintConnected){
				showMsg(lang.dayinjilianjie);
				 return;
			 }
			 showMsg(lang.lianjiezhong);
			 btOpera.rework();
		}
		if(view.getId()==R.id.setting){
			
			
			  final EditText inputServer = new EditText(this);
			  inputServer.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
		        AlertDialog.Builder builder = new AlertDialog.Builder(this);
		        builder.setTitle(lang.qingshuruguanliyuanmima).setIcon(android.R.drawable.ic_dialog_info).setView(inputServer)
		                .setNegativeButton(lang.quxiao, null);
		        builder.setPositiveButton(lang.queren, new DialogInterface.OnClickListener() {

		            public void onClick(DialogInterface dialog, int which) {
		            	Setting setting=AppConfig.getInstance().db.getFirst(new Setting());
		            	if(setting==null)
		            		setting=new Setting();
		            	if(inputServer.getText().toString().equals(setting.pwd)){
		            		Handler handler = new Handler();
		            	    Runnable runnable = new Runnable() {

		            	        @Override
		            	        public void run() {
		            	            // handler自带方法实现定时器
		            	        	runOnUiThread(new  Runnable() {
										public void run() {
											
											goWebView("edit");
										}
									});
		            	        }
		            	    };
		            		
		            	    handler.postDelayed(runnable, 500); 
		            	}
		            	else{
		            		Toast.makeText(MainActivity.this, lang.mimacuowu, 1000).show();
		            	}
		            		
		             }
		        });
		        builder.show();
			
		}
		
	
	}
	private void setBatteryWidth(int num){
		int width=(int)(num/100f* batteryViewMaxWidth);
		LayoutParams  lp=batteryView.getLayoutParams();
		lp.width=width;
		batteryView.setLayoutParams(lp);
	}
	private void initBatteryIReceiver(){
		batteryIReceiver=new IReceiver() { 
			
			@Override
			public void raiseHead(RaiseHeadReceiveMessage raiseHead) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void press(PressReceiveMessage press) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void operationBefore(OperationBeforeReceiveMessage operationBefore) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void blow(BlowReceiveMessage blow) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void battery(final BatteryReceiveMessage battery) {
				// TODO Auto-generated method stub
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						LogUtil.WriteLog(battery.num+"");
						// TODO Auto-generated method stub
						setBatteryWidth(battery.num);
					}
				});
			}

			@Override
			public void palyBackCompeled() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		btOpera.stop();
		android.os.Process.killProcess(android.os.Process.myPid());
		super.onDestroy();
	}
	@SuppressLint("NewApi") @Override
	public void notify(BtMsgType msgType, final Object o) {
		// TODO Auto-generated method stub
		
		final Resources res= this.getResources();
		int i=0;
		if(msgType== BtMsgType.modelConnected){ 
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					appConfig.ModelConnected=true;
					modelView.setBackground(res.getDrawable(R.drawable.modelstate));
					DataService.getInstance().setMessageDevice((MessageDevice)o);
				}
			});
			
			//Toast.makeText(this,"连接到模型人",1000)。show();
		}
		else if(msgType== BtMsgType.modelMiss||msgType== BtMsgType.modelConnectFaild){
				runOnUiThread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					appConfig.ModelConnected=false;
					modelView.setBackground(res.getDrawable(R.drawable.modelstatex));
				}
			});
		
			//Toast.makeText(this,"连接到模型人",1000)。show();
		}
		else if(msgType== BtMsgType.printConnected){ 
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					appConfig.PrintConnected=true;
					PrintsService.getInstance().setPrint((Print)o);
					printView.setBackground(res.getDrawable(R.drawable.printstate));
				}
			});
			
			//Toast.makeText(this,"连接到模型人",1000)。show();
		}
		else if(msgType== BtMsgType.printConnectFaild||msgType== BtMsgType.printMiss){
				runOnUiThread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					appConfig.PrintConnected=false;
					printView.setBackground(res.getDrawable(R.drawable.printstatex));
				}
			});
		
			//Toast.makeText(this,"连接到模型人",1000)。show();
		}
	}

	
	
}
