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
			System.out.println("���ݿ����ӳɹ�");
		} catch (ClassNotFoundException e) {
			System.out.println("δ�ҵ�����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���ݿ�����ʧ��");
			e.printStackTrace();
		}
		return conn;
	}
	//�ر����ݿ⣬�ͷ���Դ
	public void closeCon(){
		if(conn!=null){
			try {
				conn.close();
				System.out.println("���ݿ�رճɹ�");
			} catch (SQLException e) {
				System.out.println("���ݿ�ر�ʧ��");
				e.printStackTrace();
			}
		}
	}

}

