
package mystu_dao;

public class TestStuD {
	public static void main(String[] args){
		StudentDao studentdao=new StudentDao();
		studentdao.delete(1);
		studentdao.insert("lily", 4, "f", 16,"90");
		studentdao.update(3, "kaka", "m", 17, "88");
		
				
	}
}
