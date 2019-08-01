package com.lyc.bluetooth;

/**
 * 蓝牙查找发现设备时 所用的实体类
 * @author 李永超
 *
 */
public class DeviceEvent {

	private String mac;
	private String name;

	/**
	 * 获取设备mac地址
	 * @return 设备mac地址
	 */
	public String getMac() {
		return mac;
	}
	
	/**
	 * 设置mac地址
	 * @param mac mac地址
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
	 * 获取设备名称
	 * @return 设备名称
	 */
	public String getName() {
		return name; 
	}

	/**
	 * 设置设备名称
	 * @param name 设备名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 根据mac地址和设备名称实例化一个新对象
	 * @param name 设备名称
	 * @param mac 设备mac地址
	 */
	public DeviceEvent( String name, String mac) {
		
		this.mac = mac;
		this.name = name;
		// TODO Auto-generated constructor stub
	}
}
