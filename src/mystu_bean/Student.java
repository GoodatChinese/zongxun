package mystu_bean;

public class Student {
	String stu_name;
	String stu_age;
	int stu_id;
	String stu_sex;
	String stu_grade;
	public Student(){};
	Student(String name,String age,int id,String sex,String grade){
		this.stu_name=name;
		this.stu_age=age;
		this.stu_id=id;
		this.stu_sex=sex;
		this.stu_grade=grade;
	}

public String getStu_name() {
	return stu_name;
}
public void setStu_name(String stu_name) {
	this.stu_name = stu_name;
}
public String getStu_age() {
	return stu_age;
}
public void setStu_age(String stu_age) {
	this.stu_age = stu_age;
}
public int getStu_id() {
	return stu_id;
}
public void setStu_id(int stu_id) {
	this.stu_id = stu_id;
}
public String getStu_sex() {
	return stu_sex;
}
public void setStu_sex(String stu_sex) {
	this.stu_sex = stu_sex;
}
public String getStu_grade() {
	return stu_grade;
}
public void setStu_grade(String stu_grade) {
	this.stu_grade = stu_grade;
}


}
