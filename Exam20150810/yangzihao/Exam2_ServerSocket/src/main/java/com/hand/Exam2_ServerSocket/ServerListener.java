package com.hand.Exam2_ServerSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener extends Thread {

	private boolean flag=true;
	public void setFlag(boolean flag){
		this.flag=flag;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ServerSocket serverSocket;
		try {
	    	///////////////////////////////打开监听器///////////////////////////////////////
	    	serverSocket = new ServerSocket(12345);//绑定
	    	System.out.println("==========ServerListener open==========");
			while(flag)
			{
			    Socket socket=serverSocket.accept();         //从连接请求队列中取出一个连接
			    //注意：程序会一直被阻塞在这一步直到有连接为止
			    System.out.println("==========Client link==========");
			    JOptionPane.showMessageDialog(null,"有客户端链接到本机");
			    ChatSocket cs=new ChatSocket(socket);      //创建线程
			    cs.start();            //启动线程
			    ChatManager.getChatManager().add(cs);      //将cs添加到聊天管理器中
			}
			
			
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
