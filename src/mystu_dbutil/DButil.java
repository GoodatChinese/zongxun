package mystu_dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	//
	static Connection conn=null;
	//
	public static Connection getCon(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wyx", "root", "123456");
			System.out.println("数据库连接成功");
		} catch (ClassNotFoundException e) {
			System.out.println("未找到驱动");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		return conn;
	}
	//关闭数据库，释放资源
	public void closeCon(){
		if(conn!=null){
			try {
				conn.close();
				System.out.println("数据库关闭成功");
			} catch (SQLException e) {
				System.out.println("数据库关闭失败");
				e.printStackTrace();
			}
		}
	}

}

