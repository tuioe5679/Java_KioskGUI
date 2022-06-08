package item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
	
	private static final String dbDriver = "com.mysql.cj.jdbc.Driver";
	private static final String dbUrl = "jdbc:mysql://localhost:3306/pos?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8";
	private static final String id = "root";
	private static final String pw = "1234";
	private static Connection conn = null;

//	public static void main(String[] args) throws InterruptedException {
//		connect();
//		Thread.sleep(2000);
//		close();
//	}
	
	public static Connection connect() {
		
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, id, pw);
			
			if(conn!=null)
				System.out.println("DB ���� ����!");
			else
				System.out.println("DB ���� ����!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close() {		
		try {
			if(conn!=null) {
				conn.close();
				System.out.println("DB ���� ����!");
			}
		}catch(Exception e) {
			System.out.println("DB close() ����!");
		}
	}
}
