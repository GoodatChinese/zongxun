package mystu_dbutil;

public class Test {
public static void main(String[] args){
	DButil db=new DButil();
	db.getCon();
	db.closeCon();
}
}
