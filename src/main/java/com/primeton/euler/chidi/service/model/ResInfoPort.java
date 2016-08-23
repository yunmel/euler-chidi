package com.primeton.euler.chidi.service.model;

/**
 * 
 * 资源端口信息
 *
 * @author sunyao (mailto:sunyao@primeton.com)
 */
public class ResInfoPort extends LogicalBase {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 6360836915068189194L;
	private int publicPort;
	private int privatePort;
	private String portName;
	
	public int getPublicPort() {
		return publicPort;
	}
	public void setPublicPort(int publicPort) {
		this.publicPort = publicPort;
	}
	public int getPrivatePort() {
		return privatePort;
	}
	public void setPrivatePort(int privatePort) {
		this.privatePort = privatePort;
	}
	public String getPortName() {
		return portName;
	}
	public void setPortName(String portName) {
		this.portName = portName;
	}
}
