package mystu_frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import mystu_bean.Student;
import mystu_bean.User;
import mystu_dao.StudentDao;
import mystu_dao.UserDao;

public class StudentFrame extends JFrame {
JScrollPane tablePanel;
JPanel mainPanel,editPanel;
JLabel Label1, Label2,Label3,Label4;
JTextField text1,text2,text3,text4;
JTable table1;
Vector titleVector,rowVector;
//JScrollPane ;
JButton addButton,dropButton,alterButton,resetButton;
StudentFrame() throws SQLException {
	
    titleVector=new Vector();
    titleVector.add("����");
//    titleVector.add("����");
    titleVector.add("ѧ��");
    titleVector.add("�Ա�");
    titleVector.add("�ɼ�");
    showTable();
     table1=new JTable  (rowVector, titleVector);
     System.out.println(rowVector);
	tablePanel=new JScrollPane();
   
    tablePanel.getViewport().setView(table1);
    //
    
	
	
	mainPanel=new JPanel();

	editPanel=new JPanel();


	Label1=new JLabel("����");
    text1=new JTextField(10);
    Label2=new JLabel("ѧ��");
    text2=new JTextField(10);
    Label3=new JLabel("�Ա�");
    text3=new JTextField(10);
    Label4=new JLabel("�ɼ�");
    text4=new JTextField(10);
//    Label5=new JLabel("����");
//    text5=new JTextField(10);
    addButton=new JButton("���");
    dropButton=new JButton("ɾ��");
    alterButton=new JButton("�޸�");
    resetButton=new JButton("����");
    
    
    editPanel.setLayout(null);
    Label1.setBounds(20,20,80,40);
    text1.setBounds(120,20, 80, 40);
    Label2.setBounds(240,20,80,40);
    text2.setBounds(340,20,80,40);
    Label3.setBounds(20,80,80,40);
    text3.setBounds(120,80,80,40);
    Label4.setBounds(240,80,80,40);
    text4.setBounds(340,80,80,40);
  
    addButton.setBounds(20, 140, 80,40);
    dropButton.setBounds(140, 140,80,40);
    alterButton.setBounds(260,140,80,40);
    resetButton.setBounds(380, 140,80,40);
   
   
    	editPanel.add(Label1);  
    	editPanel.add( text1);
    	editPanel.add(Label2);
    	editPanel.add( text2);
    	editPanel.add( Label3);
    	editPanel.add(text3);
	    editPanel.add( Label4);
	    editPanel.add( text4);
	    editPanel.add(addButton);
	    editPanel.add(dropButton);
	    editPanel.add(alterButton);
	    editPanel.add(resetButton);
	    

	mainPanel.setLayout(null);
	tablePanel.setBounds(100, 30,600,250);//����С
//	tablePanel.setBackground(Color.WHITE);
	

   
     
	 editPanel.setBounds(150,400, 600, 400);//���������С
//	 editPanel.setBackground(Color.GRAY);
	 

	 mainPanel.setBounds(0, 0,800, 600);
//	 mainPanel.setBackground(Color.YELLOW);
	 
	
	 mainPanel.add(tablePanel);//�������ӱ��
    mainPanel.add(editPanel);
   
	 
    add(mainPanel);//������Ӵ����
    setSize(800, 600);
    setResizable(false);
    setVisible(true);
	
	
	
}

private  void showTable() throws SQLException {
	StudentDao udao=new StudentDao();
	ArrayList list=udao.selectAll();
	for(int i=0;i<list.size();i++){
		Student stu=(Student)list.get(i);
		Vector rowVector=new Vector();
		rowVector.add(stu.getStu_name());
		rowVector.add(stu.getStu_id());
		rowVector.add(stu.getStu_sex());
		rowVector.add(stu.getStu_grade());
		System.out.println(rowVector.toString());
		
	}
}
public void check_input(){
	if(Label2.getText().equals("")){
		JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��");
	}
}

public static void main(String[] args) {
try {
	new StudentFrame();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}



}
