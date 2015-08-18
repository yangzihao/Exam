package com.hand.Exam2_ServerSocket;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

public class ChatManager {

	private ChatManager(){}    //类不能被外部实例化，只能调用其内部Static元素
	//将聊天管理器内定义成最终类，防止错误声明
	private static final ChatManager cm=new ChatManager();
	public static ChatManager getChatManager(){return cm;};//通过内部方法实例化对象
	Vector<ChatSocket>  vector=new Vector<ChatSocket>(); //新建线程数组
	public void add(ChatSocket cs)         //将新建线程统计到线程数组里
	{
	    vector.add(cs);
	} 
	public void publish(ChatSocket cs,BufferedInputStream bis) throws UnsupportedEncodingException, IOException      //广发信息
	{

	}

}
