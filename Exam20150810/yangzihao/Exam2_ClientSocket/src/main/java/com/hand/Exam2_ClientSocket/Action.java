package com.hand.Exam2_ClientSocket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class Action {

	private JFrameWindow window;
	private String IP;
	private Socket socket;
	
	public void setWindow(JFrameWindow window){
		this.window=window;
	}
	
	public void download() throws Exception{
		FileInputStream fis =  (FileInputStream) socket.getInputStream();  //创建字节流
    	BufferedInputStream bis=new BufferedInputStream(fis);
    	
    	File f=new File("SampleChapter1.pdf");
    	if(!f.exists())
    	    f.createNewFile();
    	
    	FileOutputStream fos=new FileOutputStream(f);
    	BufferedOutputStream bos=new BufferedOutputStream(fos);
    	byte input[]=new byte[2];
    	System.out.println("Client Download start!");
    	while(bis.read(input)!=-1)
    	{
    		bos.write(input);
    	}
    	if(bis.read(input)==-1)
    	{
    		System.out.println("Client Download complete!");
    	}
    	bos.close();
    	fos.close();
    	bis.close();
    	fis.close();
	}
	
	public void connection(String ip){
		this.IP=ip;
		new Thread()
		{

			@Override
			public void run() {
				
				try {
					socket=new Socket(IP,12345);
					window.setState("已连接");

					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// TODO Auto-generated method stub
				super.run();
			}
			
		}.start();
	}
}
