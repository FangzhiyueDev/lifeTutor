package com.lyc.bluetooth;

/**
 * �������ҷ����豸ʱ ���õ�ʵ����
 * @author ������
 *
 */
public class DeviceEvent {

	private String mac;
	private String name;

	/**
	 * ��ȡ�豸mac��ַ
	 * @return �豸mac��ַ
	 */
	public String getMac() {
		return mac;
	}
	
	/**
	 * ����mac��ַ
	 * @param mac mac��ַ
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
	 * ��ȡ�豸����
	 * @return �豸����
	 */
	public String getName() {
		return name; 
	}

	/**
	 * �����豸����
	 * @param name �豸����
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ����mac��ַ���豸����ʵ����һ���¶���
	 * @param name �豸����
	 * @param mac �豸mac��ַ
	 */
	public DeviceEvent( String name, String mac) {
		
		this.mac = mac;
		this.name = name;
		// TODO Auto-generated constructor stub
	}
}
