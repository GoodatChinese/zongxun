package mystu_bean;

public class User {
int user_id;
String user_name;
String user_pwd;
String user_quanxian;
public User(){}
User(int id,String name,String pwd,String quanxian ){
	this.user_id=id;
	this.user_name=name;
	this.user_pwd=pwd;
	this.user_quanxian=quanxian;
}
public int getUser_id() {
	return user_id;
}
public String getUser_name() {
	return user_name;
}
public String getUser_pwd() {
	return user_pwd;
}
public String getUser_quanxian() {
	return user_quanxian;
}
public void setUser_id(int user_id){
	this.user_id=user_id;
}
public void setUser_name(String user_name){
	this.user_name=user_name;
}
public void setUser_pwd(String user_pwd){
	this.user_pwd=user_pwd;
}
public void setUser_quanxian(String userquanxian){
	this.user_quanxian=user_quanxian;
}


}
