package mystu_frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import mystu_dao.StudentDao;


public class MyLayout extends JFrame{
	//
	JPanel editPanel;//mainPanel,
	JTable table;
	JLabel label1,label2,label3,label4;
	JTextField text1,text2,text3,text4;
	JButton b1,b2,b3,b4;
	JScrollPane panel;
	Vector titleVector,rowVector;
	int id;
	String name,sex,grade;
	//
	MyLayout()throws SQLException{
		this.setTitle("ѧ������");
		//mainPanel=new JPanel();
		
		panel=new JScrollPane();
		titleVector=new Vector();
		rowVector=new Vector();
		titleVector.add("ѧ��");
		titleVector.add("����");
		titleVector.add("���");
		titleVector.add("����");
//		Stu stu=new Stu();
//		stu.setStu_id(1);
//		stu.setStu_name("zhuqiaoning");
//		stu.setStu_sex("m");
//		stu.setStu_grade(null);
		showTable();
		
		table=new JTable(rowVector,titleVector);
		

		panel.getViewport().add(table);
		
		
		
		editPanel=new JPanel();
		
		editPanel.setLayout(null);
		
		//mainPanel.setBounds(0, 0, 1000, 1000);
		
		panel.setBounds(20,20,800,280);
		editPanel.setBounds(250, 320, 1000, 400);
		
		label1=new JLabel("ѧ��");
		text1=new JTextField(10);
		label2=new JLabel("����");
		text2=new JTextField(10);
		label3=new JLabel("�Ա�");
		text3=new JTextField(10);
		label4=new JLabel("�ɼ�");
		text4=new JTextField(10);
		b1=new JButton("���");
		b2=new JButton("ɾ��");
		b3=new JButton("�޸�");
		b4=new JButton("����");
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				check_input();
				id=Integer.parseInt(text1.getText());
				name=text2.getText().trim();
				sex=text3.getText().trim();
				grade=text4.getText().trim();
				StudentDao studao=new StudentDao();
																			
				studao.insert(name, id, sex,  id, grade);
				rowVector.clear();
		
				try {
					showTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.updateUI();
				
				
			}
		});
		
		
		
		label1.setBounds(20,20,80,40);
		text1.setBounds(120,20,100,40);
		label2.setBounds(240,20,80,40);
		text2.setBounds(340,20,100,40);
		label3.setBounds(20,80,80,40);
		text3.setBounds(120,80,100,40);
		label4.setBounds(240,80,80,40);
		text4.setBounds(340,80,100,40);
		b1.setBounds(20,140,100,40);
		b2.setBounds(140,140,100,40);
		b3.setBounds(260,140,100,40);
		b4.setBounds(380,140,100,40);
		editPanel.add(label1);
		editPanel.add(text1);
		editPanel.add(label2);
		editPanel.add(text2);
		editPanel.add(label3);
		editPanel.add(text3);
		editPanel.add(label4);
		editPanel.add(text4);
		editPanel.add(b1);
		editPanel.add(b2);
		editPanel.add(b3);
		editPanel.add(b4);
		
		
		this.setLayout(null);
		this.setLayout(null);
		this.add(panel);
		this.add(editPanel);
		//this.add(mainPanel);
		this.setSize(1000,1000);
		//this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void showTable() throws SQLException{
		StudentDao studao=new StudentDao();
		ArrayList list=studao.selectAll();
		for(int i=0;i<list.size();i++){
			Student stu=(Student)list.get(i);
			Vector v= new Vector();
			v.add(stu.getStu_id());
			v.add(stu.getStu_name());
			v.add(stu.getStu_sex());
			v.add(stu.getStu_grade());
			rowVector.add(v);
		}
	}
	public void check_input(){
		if(label1.getText().equals("")){
			JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��");
		}
	}

}

