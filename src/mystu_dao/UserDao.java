package mystu_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mystu_bean.User;
import mystu_dbutil.DButil;
import mystu_frame.StudentFrame;

public class UserDao {
	Connection con=DButil.getCon();
	Statement sta=null;
	PreparedStatement pst=null;
	ResultSet rst=null;

	public int loginSelect(String username,String userpwd) throws SQLException{
		User user=new User();
		boolean isMatch=false;
		int i = 0;
		String sql="select * from user where user_name=?and user_pwd=?";
		try{
			pst=con.prepareStatement(sql);
			pst.setString(1, username);	
			pst.setString(2, userpwd);
			rst=pst.executeQuery();
			if(rst.next()){
				String name=rst.getString("user_name");
				if(name.equals(username))//如果输入的名字与数据库中的名字相同，则比较密码
				{
				String p=rst.getString("user_pwd");//密码字段，请按实际情况写
				if(p.equals(userpwd)) //假设密码在数据库中明码保存
				{
				isMatch=true;
				
				}
				}
				}
				if(isMatch)	//如果账户名、密码匹配
				{
					i=1;
				}
				else
				{
				i=0;
				//其他代码
				}
		
			
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		rst.close();
		pst.close();
		System.out.println(user);
        return i;
		}
	//查询所有user表中的数据
	public ArrayList<User> selectAll() throws SQLException{
		ArrayList<User> userList=new ArrayList<User>();
		
		try {
			String sql="select * from user";
			sta=con.createStatement();
			rst=sta.executeQuery(sql);
			while(rst.next()){
				User user=new User();
				user.setUser_id(rst.getInt(1));
				user.setUser_name(rst.getString(2));
				user.setUser_pwd(rst.getString(3));
				user.setUser_quanxian(rst.getString(4));
				userList.add(user);
			}
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		return userList;
		
	}
	public int insert(String username,int pwd,String userquanxian){
		int i=0;
		
		try {
			String sql="insert into user(user_name,user_pwd,user_quanxian)VALUES(?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1,username);
			pst.setInt(2, pwd);
			pst.setString(3, userquanxian);
			i=pst.executeUpdate();
			System.out.println("插入数据"+i+"行");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return i;
	}
	public int update(int userid,String username,int userpwd,String userquanxian){
		String sql="UPDATE USER set user_name=?,user_pwd=?,user_quanxian=? where user_id=?";
		int i=0;
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1,username);
			pst.setInt(2, userid);
			pst.setString(3, userquanxian);
			i=pst.executeUpdate();
			System.out.println("插入数据"+i+"行");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return i;
	}
	
	public int delete( int userid){
		String sql="delete from user where user_id=? ";
		int i=0;
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, userid);
			i=pst.executeUpdate();
			System.out.println("插入数据"+i+"行");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	
}
