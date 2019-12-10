package cn.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.connect.Connect;
import cn.dao.BooksDao;
import cn.dao.UserDao;
import cn.dome.Books;
import cn.dome.User;
import cn.opinion.Opinion;

public class UIupdateuser extends JFrame{
	UIinterface inter= new UIinterface();
	JPanel jp   = new JPanel(null);
	JLabel lab  = new JLabel("id:");
	JLabel lab1 = new JLabel("新姓名");
	JLabel lab2 = new JLabel("新班级");
	JLabel lab3 = new JLabel("新密码");
	JLabel lab4 = new JLabel(inter.he);
//	JTextField text = new JTextField();
	JTextField text1 = new JTextField();
	JTextField text2 = new JTextField();
	JTextField text3 = new JTextField();
	JButton button = new JButton("确定");
	JButton button1 = new JButton("");
	public void init() {
		lab.setBounds(250, 150, 200, 50);
		lab.setFont(new Font("黑体",Font.BOLD,50));
		lab1.setBounds(150, 250, 100, 30);
		lab1.setFont(new Font("宋体",Font.BOLD,30));
		lab2.setBounds(150, 350, 100, 30);
		lab2.setFont(new Font("宋体",Font.BOLD,30));
		lab3.setBounds(150, 450, 100, 50);
		lab3.setFont(new Font("宋体",Font.BOLD,30));
		lab4.setBounds(400,150,200,50);
		lab4.setFont(new Font("黑体",Font.BOLD,50));
		text1.setBounds(300,250,250,50);
		text1.setFont(new Font("宋体",Font.BOLD,30));
		text2.setBounds(300,350,250,50);
		text2.setFont(new Font("宋体",Font.BOLD,30));
		text3.setBounds(300,450,250,50);
		text3.setFont(new Font("宋体",Font.BOLD,30));
		button.setBounds(250, 550, 150, 50);
		button.setFont(new Font("宋体",Font.BOLD,30));
		
		jp.add(lab);
		jp.add(lab1);
		jp.add(lab2);
		jp.add(lab3);
		jp.add(lab4);
		jp.add(text1);
		jp.add(text2);
		jp.add(text3);
		jp.add(button);
		jp.setBounds(0, 0, 750, 750);
		this.add(jp);
	}
	public UIupdateuser() {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String id = inter.he;
				String name = text1.getText();
				String room	 = text2.getText();
				String password = text3.getText();

				User u = new User();
				u.setId(id);
				u.setName(name);
				u.setRoom(room);
				u.setPassword(password);
				Connect conn = new Connect();
				UserDao ud = new UserDao();
				try {
					Connection con = conn.getCon();
					if(ud.update(con, u)==0) {
					JOptionPane.showMessageDialog(null, "此编号为空");					
					}
					else
					{
						JOptionPane.showMessageDialog(null, "修改成功");
					}
					
					
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println("数据库连接失败");
				}
			}
		});
		
		
		init();
		this.setTitle("");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 750, 750);
		this.setVisible(true);
	}
}
