package com.kangren.cpr.entity;

public class Setting {
	
	
	public int flowYiwu=2;
	public int flowMaibo=2;
	public int flowHujiao=2;
	public int flowHuxi=2;
	
	public int flowYishi=2;
	public int flowCPR=90;
	
	/*
	 * 单次循环按压次数
	 */
	public int anyacishu=30;
	/*
	 * 单次循环吹气次数 
	 */
	public int chuiqicishu=2; 
	/*
	 * 按压合格率
	 */
	public int anyahegelv=60;
	/*
	 * 按压频率上限
	 */
	public int anyapinlvMax=130; 
	
	/*
	 * 按压频率下限
	 */
	public int anyapinlvMin=100;
	
	/*
	 * 按压深度上限
	 */
	public int anyashenduMax=6;
	/*
	 * 按压深度下限
	 */
	public int anyashenduMin=5;
	
	/*
	 * 吹气合格率
	 */
	public int chuiqihegelv=60;
	
	/*
	 * 吹气量上限
	 */
	public int chuiqiliangMax=1000;
	
	/*
	 * 吹气量下限
	 */
	public int chuiqiliangMin=500;
	public int time=250;
	

	/*
	 * 循环次数
	 */
	public int xunhuancishu=5;
	
	/*
	 * 0先吹后按 1先按后吹
	 */
	public int anchuishunxu=1;
	
	
	public String pwd="admin";
	
	   /// <summary>
    /// 1为英语，0为简体中文
    /// </summary>
    public int language=0;
}
