package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	
	public static Properties loadPropertiesFile() throws IOException {
		Properties prop = new Properties();
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}
	
	public static Connection getConnection() throws IOException  {
		Connection conn = null;
		Properties prop = null;
		try {
			prop = loadPropertiesFile();
					
		}
		
		catch(Exception e1) {
			e1.printStackTrace();
		}
		
		final String driver = prop.getProperty("driver");
		System.out.println(driver);
		final String url = prop.getProperty("url");
		System.out.println(url);
//		final String username = prop.getProperty("username");
//		final String password = prop.getProperty("password");
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
