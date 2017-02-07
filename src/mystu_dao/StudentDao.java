package mystu_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mystu_bean.Student;
import mystu_bean.User;
import mystu_dbutil.DButil;
import mystu_frame.StudentFrame;

public class StudentDao {
	Connection con=DButil.getCon();
	Statement sta=null;
	PreparedStatement pst=null;
	ResultSet rst=null;
	public Student loginSelect(String stuname,String stuage) throws SQLException{
		Student student=new Student();
		String sql="select * from admin where user_name=?and usr_age=?";
		try{
			pst=con.prepareStatement(sql);
			pst.setString(1,stuname);
			pst.setString(2, stuage);
			rst=pst.executeQuery();
			if(rst.next()){
				student.setStu_name(rst.getString(1));
				student.setStu_age(rst.getString(2));
				student.setStu_id(rst.getInt(3));
				student.setStu_sex(rst.getString(4));
				student.setStu_grade(rst.getString(5));
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		rst.close();
		pst.close();
		System.out.println(student);
        return student;
		}
	public ArrayList<Student> selectAll() throws SQLException{
		ArrayList<Student> stuList=new ArrayList<Student>();

		try {
		String sql="select * from student";
		sta=con.createStatement();
		rst=sta.executeQuery(sql);
		while(rst.next()){
		Student stu=new Student();
		stu.setStu_name(rst.getString(1));
		stu.setStu_id(rst.getInt(2));
		stu.setStu_sex(rst.getString(3));
		stu.setStu_grade(rst.getString(4));
		stuList.add(stu);
		System.out.println(stu.toString());
		}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		System.out.println(stuList.toString());
		return stuList;
		}
		public int insert(String stuname,int stuid,String stusex,int stuage,String stugrade){
		int i=0;
		String sql="insert into student(stu_name,stu_age,stu_id,stu_sex,stu_grade) VALUES(?,?,?,?,?)";
		try {
		pst=con.prepareStatement(sql);
		pst.setString(1,stuname);
		pst.setInt(2,stuage);
		pst.setInt(3,stuid);
		pst.setString(4,stusex);
		pst.setString(5,stugrade);
		i=pst.executeUpdate();
		System.out.println("插入数据"+i+"行");
		} 	
		 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return i;

		}
		public int update(int stuid,String stuname,String stusex,int stuage,String stugrade){
		String sql="update student set stu_name=?,stu_sex=?,stu_age=?,stu_grade=?,stu_id=?";
		int i=0;
		try {
		pst=con.prepareStatement(sql);
		pst.setString(1,stuname);
		pst.setInt(2,stuage);
		pst.setInt(3,stuid);
		pst.setString(4,stusex);
		pst.setString(5,stugrade);
		i=pst.executeUpdate();
		System.out.println("插入数据"+i+"行");
		} 	
		 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return i;
		}
		public int delete(int stuid){
		String sql="delete from student where stu_id=?";
		int i=0;
		try {
		pst=con.prepareStatement(sql);
		pst.setInt(1,stuid);
		i=pst.executeUpdate();
		System.out.println("插入数据"+i+"行");
		} 	
		 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return i;
		}


		
}
