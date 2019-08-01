package com.kangren.cpr;

import java.io.File;

import android.os.Environment;

import com.kangren.cpr.analyzer.ACLSAnalyzer;
import com.kangren.cpr.analyzer.F2800Analyzer;
import com.lyc.db4o.Db;
import com.lyc.socket.client.Client;

public class AppConfig {
	
	
	 
	private  static AppConfig  appConfig;
	public static AppConfig getInstance(){
		
		
		if(appConfig==null){
			appConfig=new AppConfig();
		}
		return appConfig;
	}
	public  Class<?> AnlyzerType=F2800Analyzer.class;
	//蓝牙包长度
	public  int BluetoothPackageLength=20;
	
	public String ip="192.168.0.12";
	public int port=9002;
	
	public boolean IsInit;
	public  String PrintName="";
	public  String ModelName="";
	public  String KnowledgePath=Environment.getExternalStorageDirectory()+"/kangren/Knowledge/";
	public Client  server;
	public String[] moduleInfo=new String[]{
		"理论学习",
		"训练模式",
		"考核模式",
		"实战模式",
		"历史成绩",
		
	};
	
	
	/**
	 * 模型人连接状态
	 */
	public boolean ModelConnected=false;
	
	/**
	 * 打印机连接状态
	 */
	public boolean PrintConnected=false;
	public String BaseDir=Environment.getExternalStorageDirectory()+"/kangren/";
	public String DbFileName=Environment.getExternalStorageDirectory()+ "/kangren/db.db4o";
	public Db db;
	private AppConfig(){
		File baseFile=new File(BaseDir);
		File knowledge=new File(KnowledgePath);
		if(!baseFile.exists()){
			baseFile.mkdirs();
		}
		if(!knowledge.exists()){
			knowledge.mkdirs();
		}
		db=new Db(DbFileName);
	}
	
}
