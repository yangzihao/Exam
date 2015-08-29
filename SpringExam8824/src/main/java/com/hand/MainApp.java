package com.hand;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = 
	             new FileSystemXmlApplicationContext("ApplicationContext.xml");
		PublishSpring bf=(PublishSpring)context.getBean("before");
		PublishSpring af=(PublishSpring)context.getBean("after");
		System.out.println("Context start");
		FilmJDBCTemplate filmJDBCTemplate = new FilmJDBCTemplate();
		Film film=new Film();
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入电影名称（title）：");
		film.setTitle(scanner.next());
		System.out.println("请输入电影描述（description）：");
		film.setDescription(scanner.next());
		System.out.println("请输入语言id（language_id）：");
		film.setLanguage_id(scanner.nextInt());
		System.out.println(bf.getMessage());
		if( filmJDBCTemplate.insertFilm(film) )
		{
			System.out.println("插入成功");
		}
		else
		{
			System.out.println("插入失败");
		}
		System.out.println(af.getMessage());
		System.out.println("Context stop");

	}

}
