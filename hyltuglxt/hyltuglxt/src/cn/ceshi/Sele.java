package cn.ceshi;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.connect.Connect;
import cn.dao.UserDao;
import cn.dome.User;

public class Sele extends JFrame{
	JLabel lab = new JLabel("序号");
	JLabel lab1 = new JLabel("书名");
	JLabel lab2= new JLabel("作者");
	static JTextField text = new JTextField();
	
	static JTextField text1 = new JTextField();
	static JTextField text2= new JTextField();
	JButton button = new JButton("查询");
	JButton button1 = new JButton();
	JPanel jp = new JPanel(null);
	public void init() {
		lab.setBounds(150, 150, 200, 30);
		lab.setFont(new Font("宋体",Font.BOLD,30));
		lab1.setBounds(150, 250, 100, 30);
		lab1.setFont(new Font("宋体",Font.BOLD,30));
		lab2.setBounds(150, 350, 100, 30);
		lab2.setFont(new Font("宋体",Font.BOLD,30));

		text.setBounds(300,150,250,50);
		text.setFont(new Font("宋体",Font.BOLD,30));
		text1.setBounds(300,250,250,50);
		text1.setFont(new Font("宋体",Font.BOLD,30));
		text2.setBounds(300,350,250,50);
		text2.setFont(new Font("宋体",Font.BOLD,30));
		button.setBounds(250, 550, 150, 50);
		button.setFont(new Font("宋体",Font.BOLD,30));
		
		jp.add(lab);
		jp.add(lab1);
		jp.add(lab2);
	
		jp.add(text);
		jp.add(text1);
		jp.add(text2);

		jp.add(button);
		jp.setBounds(0, 0, 750, 750);
		this.add(jp);
	}
	
	public Sele() {
		init();
		addinit();
		this.setTitle("");
		this.setBounds(100, 100, 750, 750);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	public void addinit() {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String id = text.getText();
				String name = text1.getText();
				String room = text2.getText();
				Vector v = new Vector();
				User u = new User();
				u.setId(id);
				u.setName(name);
				u.setRoom(room);
				Connect conn = new Connect();
				UserDao ud = new UserDao();
				try {
					Connection con = conn.getCon();
					System.out.println(ud.inquire(con, u));
					new SeleForm();
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println("数据库连接失败");
				}
				
			}
		});
	}
	
}
