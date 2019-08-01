package com.lyc.bluetooth;

import java.util.UUID;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

public class BluetoothToolConfig {

	public static final String ACTION_START_DISCOVERY = "ACTION_START_DISCOVERY";
	public static final String ACTION_SELECTED_DEVICE = "ACTION_SELECTED_DEVICE";     
	public static final String DEVICE = "DEVICE"; 
 
	//00001101-0000-1000-8000-00805F9B34FB
	//8ce255c0-200a-11e0-ac64-0800200c9a66 
	public static final UUID PRIVATE_UUID = UUID
			.fromString("00001101-0000-1000-8000-00805F9B34FB"); 

	public static final int MESSAGE_CONNECT_ERROR = 0x00000003; // 杩炴帴澶辫触淇℃�?
	public static final int MESSAGE_CONNECT_SUCCESS = 0x00000002; // 杩炴帴鎴愬姛淇℃�?
	public static final int MESSAGE_READ_OBJECT = 0x00000004; // 璇诲彇鍒颁竴涓璞�?
	public static final int MESSAGE_READ_BYTE= 0x00000005;
	public static final String ACTION_CONNECT_ERROR = "ACTION_CONNECT_ERROR"; // 杩炴帴閿欒骞挎�?
	public static final String ACTION_CONNECT_SUCCESS = "ACTION_CONNECT_SUCCESS"; // 杩炴帴鎴愬姛骞挎�?
	public static final String ACTION_DATA_TO_GAME = "ACTION_DATA_TO_GAME";

	public static final String DATA = "DATA";
 	public static final String ACTION_DATA_TO_SERVICE = "ACTION_DATA_TO_SERVICE"; // 鍒皊ervice鐨勬暟鎹�?

	public static final String ACTION_FOUND_DEVICE = "ACTION_FOUND_DEVICE";

	public static final String ACTION_NOT_FOUND_SERVER = "ACTION_NOT_FOUND_DEVICE"; // 鏈彂鐜拌澶�

	public static final String ACTION_STOP_SERVICE = "ACTION_STOP_SERVICE";
	public static final String ACTION_START_SERVER = "ACTION_STARRT_SERVER";

}
