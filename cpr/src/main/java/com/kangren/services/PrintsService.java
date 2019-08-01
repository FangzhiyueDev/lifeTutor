package com.kangren.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.sax.StartElementListener;
import android.widget.Toast;
import btmanager.Pos;

import com.kangren.cpr.AppConfig;
import com.kangren.cpr.MainActivity;
import com.kangren.cpr.analyzer.AnalyzerFactory;
import com.kangren.cpr.analyzer.IAnalyzer;
import com.kangren.cpr.entity.Score;
import com.kangren.cpr.receiveMessage.*;
import com.kangren.cpr.sendMessage.ISendMessage;
import com.lyc.bluetooth.MessageDevice;
import com.lyc.bluetooth.MessageDevice.IRecevedMsgListener;
import com.lyc.bluetooth.MessageDevice.MsgEvent;
import com.lyc.bluetooth.Print;
import com.lyc.utils.LogUtil;

public class PrintsService {
	
	
	private static PrintsService printService;
	public static PrintsService getInstance(){
		if(printService==null)
			printService=new PrintsService();
		return printService;
	}
	private Print print;
	public Print getPrint() {
		return print;
	}
	public void setPrint(Print print) {
		this.print = print;
	}
	
	private String addSpace(Object o,int len){
		String res=o.toString();
	//	while(res.length()<len){
		//	res="　"+res;
	//	}
		return res;
	}
	
	public void print(Score score){
		print.write(addSpace("班级:",5)+score.stu_class);
		print.write(addSpace("姓名:",5)+score.stu_name);
		print.write(addSpace("日期:",5)+score.exam_date);
		print.write(addSpace("模式:",5)+score.exam_type);
		for(int i=0;i<score.tables[0].records.length;i++){
			print.write(addSpace(score.tables[0].records[i].name,5)+":"+addSpace(score.tables[0].records[i].count,5));
		}
		for(int i=0;i<score.tables[1].records.length;i++){
			print.write(addSpace(score.tables[1].records[i].name,5)+":"+addSpace(score.tables[1].records[i].count,5));
		}
	
			print.write("评语:");
			print.write(score.tables[score.tables.length-1].pingyu);
		
			print.write("");
			print.write("");
		
	}
	public void printScore(Score score){
		print(score);
	}
	public void printScorePic(Score score){
		
		
		if(score.path!=null&&score.path!=""){
			File f=new File(score.path);
			if(!f.exists()){
				((MainActivity)print.context).showMsg("波形图片已被删除");
				return;
			}
			print.writePic(score.path);
		}
	}
	public void isConnect(){
	 boolean b=Pos.POS_isConnected();
	 int i=0;
	}
	
	
	
}
