package cn.connect;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Connect {	
	private String dbUrl = "jdbc:mysql://localhost:3306/school?useSSL=false";	
	private String dbUserName = "root";	
	private String dbPassword = "root";	
	private String jdbcName = "com.mysql.jdbc.Driver"; 	
	/*	 * 数据库连接	 */	
	public Connection getCon() throws Exception {		
		Class.forName(jdbcName);		
		Connection con = (Connection) DriverManager.getConnection(dbUrl, dbUserName, dbPassword);		
		return con;	
		}		
	public static void main(String[] args) {		
		Connect conn = new Connect();		
		try {			
			conn.getCon();			
		System.out.println("数据库连接成功");		
		} 
		catch (Exception e) {			 
			e.printStackTrace();			
			System.out.println("数据库连接失败");		
			}	
	}
}


