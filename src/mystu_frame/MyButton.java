 package mystu_frame;

 import java.awt.BorderLayout;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.sql.SQLException;

 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JOptionPane;
 import javax.swing.JPanel;
 import javax.swing.JPasswordField;
 import javax.swing.JTextField;
import mystu_frame.StudentFrame;
 import mystu_bean.User;
 import mystu_dao.UserDao;

public class MyButton<MyLayout> extends JFrame {
	//����
	JButton loginButton,  exitButton;
	JPanel topPanel, centerPanel;
	JLabel usernameLabel,passwordLabel;
	JTextField uernameInput;
	JPasswordField  passwordInput;
	 
	 
	 
	 MyButton(){
		 usernameLabel=new JLabel("�û���");
		 uernameInput=new JTextField();
		passwordLabel=new JLabel("����");
		passwordInput=new JPasswordField();
		loginButton=new JButton("��¼");
		exitButton=new JButton("�˳�");
		 topPanel=new JPanel();
		centerPanel=new JPanel();

loginButton.addActionListener(new ActionListener() {
			
			@Override//��д����ķ���
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username_Input=uernameInput.getText().trim();
				String userpwd_Input=passwordInput.getText().toString().trim();
				if(username_Input.equals("")){
					JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
					return;
				}
				if(userpwd_Input.equals("")){
					JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
					return;
				}
				UserDao userdao=new UserDao();
				try {
					int i=0;
					i=userdao.loginSelect(username_Input, userpwd_Input);
					if(i==1){
					new StudentFrame();
						dispose();
						
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
		});
		
	
		centerPanel.setLayout(null);
	     usernameLabel.setBounds(10,10,80,40);
		 uernameInput.setBounds(110, 10, 100, 40);
		 passwordLabel.setBounds(10,80,80,40);
		 passwordInput.setBounds(110,80,100,40);
		 loginButton.setBounds(10,180,100,40);
		 exitButton.setBounds(110,180,80,40);
		 centerPanel.add(usernameLabel);
		 centerPanel.add(uernameInput);
		 centerPanel.add(passwordLabel);
		 centerPanel.add(passwordInput);
		 centerPanel.add(loginButton);
		 centerPanel.add(exitButton);
		 centerPanel.setLayout(new BorderLayout());
		 add(topPanel,BorderLayout.NORTH);
		 add(centerPanel,BorderLayout.CENTER);
		 setSize(400, 300);
		 setVisible(true);

	}
	
}

