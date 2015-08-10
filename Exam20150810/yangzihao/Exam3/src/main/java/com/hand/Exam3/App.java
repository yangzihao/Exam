package com.hand.Exam3;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, DocumentException
    {
    	URL url =new URL("http://hq.sinajs.cn/list=sz300170");
    	URLConnection connection=url.openConnection();        //打开链接
    	InputStream is =connection.getInputStream();         //创建字节流
    	InputStreamReader isr=new InputStreamReader(is);
    	BufferedReader br=new BufferedReader(isr);
    	
    	StringBuffer sb=new StringBuffer();
    	while( br.readLine()!=null )
    	{
    		sb.append(br.readLine());
    	}
    	Document document=DocumentHelper.parseText(sb.toString());
    	FileWriter out = new FileWriter( "sz300170.xml" );
    	document.write( out );      //输出xml为新建的文件
    	out = new FileWriter( "sz300170.json" );
    	document.write( out );      //输出json为新建的文件
    	


    }
}
