package bot;

import java.io.*;
import java.sql.*;
import java.util.*;

public class SQLConnection {
	InputStream inputStream;
	
	public Connection getConnection() {
	       try {
	    	   Properties prop = new Properties();
				String propFileName = "config.properties";
	 
				inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
	 
				if (inputStream != null) {
					prop.load(inputStream);
				} else {
					throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
				}
	 
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String pass = prop.getProperty("pass");
	    	   
	    	   Connection conn = DriverManager.getConnection(url, user, pass);
	    	   return conn;
	       } 
	      catch (Exception e) {
	    	  System.out.println("Something's wrong...");
	           return null;
	       }
	   }
}