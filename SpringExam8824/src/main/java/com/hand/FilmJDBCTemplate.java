package com.hand;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class FilmJDBCTemplate implements FilmDao {
	
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject; 

	@SuppressWarnings("deprecation")
	public FilmJDBCTemplate() {
		// TODO Auto-generated method stub
		Properties prop=new Properties();
		InputStream in=FilmJDBCTemplate.class.getClassLoader()
				.getResourceAsStream("com/hand/dbconfig.properties");
		try {
			prop.load(in);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver=prop.getProperty("driver");
	    dburl=prop.getProperty("dburl");
	    user=prop.getProperty("user");
	    password=prop.getProperty("password");

		dataSource=new DriverManagerDataSource(driver,dburl,user,password);
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public boolean insertFilm(Film film) {
		// TODO Auto-generated method stub
		String SQL ="INSERT INTO film(title,description,language_id) VALUES(?,?,?)";
		System.out.println("INSERT film start");
		int i=jdbcTemplateObject.update(SQL,film.getTitle(),film.getDescription(),film.getLanguage_id());
		
	      if(i>0)
		return true;
	      else
	    	  return false;
	}

}
