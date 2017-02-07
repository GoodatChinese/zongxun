package mystu_dao;

public class Test {
	public static void main(String[] args){
		UserDao userdao=new UserDao();
		userdao.delete(2);
		userdao.insert("daxun", 8989, "admin");
		userdao.update(13, "kaka",6689, "putong");
				
	}

}
