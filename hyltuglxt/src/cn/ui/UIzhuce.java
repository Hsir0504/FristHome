package cn.ui;
import cn.connect.*;
import cn.dao.*;
import cn.dome.*;
import cn.opinion.Opinion;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UIzhuce extends JPanel {
	
	private JLayeredPane layer;
	JTextField text = new JTextField(15);
	JTextField text1 = new JTextField(15);
	JTextField text2 = new JTextField(15);
	JPasswordField text3 = new JPasswordField(15);
	//JTextField text4 = new JTextField(15);
	JPasswordField text4 = new JPasswordField(15);
	JButton butt = new JButton("确定");
	JButton butt1 = new JButton("重置");
	JLabel bel1 = new JLabel("学号");
	JLabel bel2 = new JLabel("姓名");
	JLabel bel3 = new JLabel("班级");
	JLabel bel4 = new JLabel("密码");
	JLabel bel5 = new JLabel("确认密码");

	JPanel jp1 = new JPanel(null);
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	JPanel jp4 = new JPanel();
	JPanel jp5 = new JPanel();
//	public void UIzhicejm(){
//		setLayout(new GridLayout(1, 1));
//		
//		jp = new JPanel() {
//			public void paintComponent(Graphics g) {
//				super.paintComponent(g);
//				ImageIcon image = new ImageIcon("img/27.jpg");
//				image.setImage(image.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
//				g.drawImage(image.getImage(), 0, 0, this);
//			}
//		};
//		
//		this.add(jp);
//
//
//	}

	
	void init() {
		text.setFont(new Font("宋体",Font.BOLD,30));
		text1.setFont(new Font("宋体",Font.BOLD,30));
		text2.setFont(new Font("宋体",Font.BOLD,30));
		text3.setFont(new Font("宋体",Font.BOLD,30));
		text4.setFont(new Font("宋体",Font.BOLD,30));
		
		
		bel1.setFont(new Font("宋体",Font.BOLD,30));
		bel2.setFont(new Font("宋体",Font.BOLD,30));
		bel3.setFont(new Font("宋体",Font.BOLD,30));
		bel4.setFont(new Font("宋体",Font.BOLD,30));
		bel5.setFont(new Font("宋体",Font.BOLD,30));
		
		butt.setFont(new Font("宋体",Font.BOLD,30));
		butt1.setFont(new Font("宋体",Font.BOLD,30));
		
		bel1.setBounds(100, 50, 70, 50);
		text.setBounds(220, 50, 250, 50);
		
		
		bel2.setBounds(100,150,70,50);
		text1.setBounds(220,150,250,50);
		
		bel3.setBounds(100,250,70,50);
		text2.setBounds(220,250,250,50);
		
		bel4.setBounds(100,350,70,50);
		text3.setBounds(220,350,250,50);
		
		bel5.setBounds(100,450,130,50);
		text4.setBounds(260,450,250,50);
		
		butt.setBounds(100,550,100,50);
		butt1.setBounds(300,550,100,50);
		butt.setContentAreaFilled(false);
		butt1.setContentAreaFilled(false);
		
		
		jp1.add(bel3);
		jp1.add(text2);

		jp1.add(bel2);
		jp1.add(text1);
		
		jp1.add(bel1);
		jp1.add(text);
		
		jp1.add(butt);
		jp1.add(butt1);
		
		jp1.add(bel4);
		jp1.add(text3);
		
		jp1.add(bel5);
		jp1.add(text4);
		
		
		
		jp1.setOpaque(false);
		jp1.setBounds(100, 100, 1000, 1000);
		
		this.add(jp1);
		
		

		
//		jp3.add(bel3);
//		jp3.add(text2);
//		jp3.setBounds(200, 50, 200, 200);
//		jp3.setOpaque(false);
//		
//		
//		jp4.add(text3);
//		jp4.add(bel4);
		
	}
	public UIzhuce() {

		setLayout(new GridLayout(1, 1)); //设置只有一行一列
		layer = new JLayeredPane() {       
			public void paintComponent(Graphics g) {  
				super.paintComponent(g);
				ImageIcon image = new ImageIcon("img/27.jpg");
				image.setImage(image.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
				g.drawImage(image.getImage(), 0, 0, this);
			}
		};
		this.add(layer);
		init();
		layer.add(jp1, JLayeredPane.DEFAULT_LAYER);
		butt.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	
			
			String id,name,room,password,passwords;
			id = text.getText();
			name = text1.getText();
			room = text2.getText();
			password = new String(text3.getPassword());
			passwords = new String(text4.getPassword());
			String state = "";
			if(Opinion.sky(id))
			{
				JOptionPane.showMessageDialog(null, "账号不能为空");
				return;
			}
			else if(Opinion.sky(name))
			{
				JOptionPane.showMessageDialog(null, "姓名不能为空");
				return;
			}
			else if(Opinion.sky(password))
			{
				JOptionPane.showMessageDialog(null, "密码不能为空");
				return;
			}
			else if(Opinion.sky(passwords))
			{
				JOptionPane.showMessageDialog(null, "密码设置不一致");
				return;
			}
			else {
				User user = new User();
				user.setId(id);
				user.setRoom(room);
				user.setName(name);
				user.setPassword(password);
				user.setPasswords(passwords);
				user.setState(state);
				
				UserDao ud = new UserDao();
				Connect du = new Connect();
				try {
					Connection con = du.getCon();
					if(ud.insert(con, user)==0) {
					      JOptionPane.showMessageDialog(null, "账号已存在");
						
					     } else {
					    	 
					      JOptionPane.showMessageDialog(null, "注册成功");
					     }

	
					
				} catch (Exception e1) {
					e1.printStackTrace();
					System.out.println("数据库连接失败");
				}
			}
		}
	});
	butt1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			text.setText("");
			text1.setText("");
			text2.setText("");
			text3.setText("");
			text4.setText("");
			// TODO Auto-generated method stub
			}
	});
}
}