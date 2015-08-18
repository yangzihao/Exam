package com.hand.Exam3;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.XMLWriter;
import org.xml.sax.XMLFilter;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;

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
    	InputStreamReader isr=new InputStreamReader(is,"gbk");
    	BufferedReader br=new BufferedReader(isr);
    	
    	String line=new String();
    	String str=new String();
    	while( (line=br.readLine())!=null )
    	{

    		str=line+str;
    		
    	}
    	br.close();isr.close();is.close();
    	String StrArray[]=str.split(",");
    	////////////////////设置xml的字符串///////////////////////////
    	String xmlStrArray[]=new String [StrArray.length];
    	String xmlStr=new String();
    	for(int i=0;i<StrArray.length;i++){
    		xmlStrArray[i]="<line"+i+">"+StrArray[i]+"</line"+i+">";
    		System.out.println(xmlStrArray[i]);
    		xmlStr=xmlStr+xmlStrArray[i];
    	}
    	xmlStr="<xml>"+xmlStr+"</xml>";
    	//System.out.println(xmlStr);
    	
    	Document xmlDocument=DocumentHelper.parseText(xmlStr);
    	FileWriter xmlOut = new FileWriter( "sz300170.xml" );
    	XMLWriter xml=new XMLWriter(xmlOut);
    	xml.write(xmlDocument);
    	xmlOut.close();
    	//
        ////////////////////设置xml的字符串///////////////////////////
    	//
    	JsonObject object=new JsonObject();        //获取根目录对象
    	for(int i=0;i<StrArray.length;i++){
    		object.addProperty("line"+i,StrArray[i]);           //添加键值对
    	}
    	String jsonStr=object.toString();      //将object内容以String形式输出
    	System.out.println(jsonStr);
    	
    	FileOutputStream fos=new FileOutputStream("sz300170.json");
    	OutputStreamWriter osw=new OutputStreamWriter(fos);
    	BufferedWriter bw=new BufferedWriter(osw);
    	bw.write(jsonStr);
    	bw.close();osw.close();fos.close();

    }
}
