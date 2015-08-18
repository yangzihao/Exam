package com.hand.Exam1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	URL url =new URL("http://www.manning.com/gsmith/SampleChapter1.pdf");
    	File f=new File("SimpleChapter1.pdf");
    	if(!f.exists())
    	{
    		f.createNewFile();
    	}
    	URLConnection connection=url.openConnection();        //打开链接
    	InputStream is =connection.getInputStream();         //创建字节流
    	BufferedInputStream bis=new BufferedInputStream(is);
    	FileOutputStream fos=new FileOutputStream(f);
    	BufferedOutputStream bos=new BufferedOutputStream(fos);
    	
    	byte b[]=new byte[2];
    	System.out.println("==========download start==========");
    	while(bis.read(b)!=-1)
    	{
    		bos.write(b);
    	}
    	if(bis.read()==-1)
    	{
    		System.out.println("==========download complete==========");
    	}
    	bos.close();fos.close();bis.close();is.close();

    }
}
