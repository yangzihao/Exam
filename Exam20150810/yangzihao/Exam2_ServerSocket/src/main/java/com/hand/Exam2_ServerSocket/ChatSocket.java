package com.hand.Exam2_ServerSocket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChatSocket extends Thread {

	Socket socket;
    public ChatSocket(Socket s)      //初始化时获取客户端线程
    {
        this.socket=s;
    }
    public void out() throws Exception    //发数据到新客户端线程
    {   
    	File f=new File("SimpleChapter1.pdf");
    	FileInputStream fis=new FileInputStream(f);
    	BufferedInputStream bis=new BufferedInputStream(fis);
    	OutputStream os=socket.getOutputStream();
    	BufferedOutputStream bos=new BufferedOutputStream(os);
    	System.out.println("==========Server send start==========");
    	byte b[]=new byte[2];
    	while(bis.read(b)!=-1)
    	{
    		bos.write(b);
    	}
    	if(bis.read()==-1)
    	{
    		System.out.println("==========Server send complete==========");
    	}
    	bos.close();os.close();bis.close();fis.close();
    }
    public void in() throws Exception    //客户端传入服务端的数据
    {
    	
    }
    public void run()    //run方法只调用in方法接收数据
    {

    	try {
			out();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
