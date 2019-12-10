package cn.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import cn.connect.Connect;
import cn.dao.UserDao;
import cn.dome.User;
import cn.opinion.Opinion;

public class UIinterface extends JPanel{
	JLayeredPane pane;
	//使用的
	
	JLabel label = new JLabel("学号");
	JLabel label1 = new JLabel("密码");
	JPanel panel = new JPanel(null);
	JTextField field = new JTextField();
	JPasswordField field1 = new JPasswordField();
	JButton Land = new JButton("登  陆");
	JButton register = new JButton("注  册");
	ImageIcon image;
	public static String he;
	public void windows() {

		
		field.setFont(new Font("宋体",Font.BOLD,40));
		field.setForeground(Color.blue);
		label.setFont(new Font("黑体",Font.BOLD,40));
		label.setForeground(Color.blue);
		field.setBounds(400, 200, 250, 50);
		label.setBounds(300, 200, 100, 50);
		panel.add(label);
		panel.add(field);
		
		field1.setFont(new Font("宋体",Font.BOLD,40));
		field1.setForeground(Color.BLUE);
		label1.setFont(new Font("黑体",Font.BOLD,40));
		label1.setForeground(Color.BLUE);
		field1.setBounds(400, 300, 250, 50);
		label1.setBounds(300, 300, 100, 50);
		panel.add(label1);
		panel.add(field1);
		
		
		
		
		Land.setFont(new Font("黑体",Font.BOLD,30));
		Land.setForeground(Color.BLUE);

		Land.setBounds(410, 400, 150, 50);

		Land.setContentAreaFilled(false);

		panel.add(Land);

		
		
		panel.setOpaque(false);
		panel.setBounds(100, 100, 1000, 1000);
		this.add(panel);

	}
		public UIinterface() {
			setLayout(new GridLayout(1, 1));
			pane = new JLayeredPane() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					ImageIcon image = new ImageIcon("img/29.jpg");
					image.setImage(image.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
					g.drawImage(image.getImage(), 0, 0, this);
				}
			};
			this.add(pane);
			this.windows();

			pane.add(panel, JLayeredPane.DEFAULT_LAYER);
			
		

			Land.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean a = new Boolean(true);
				String id,possword;
				id = field.getText();
				he=id;
				possword = new String(field1.getPassword());
				User use = new User();
				use.setId(id);
				use.setPassword(possword);
				UserDao he = new UserDao();
				Connect hee = new Connect();
				try {
					Connection con = hee.getCon();
					if(he.ustate(con, use) == true)
					{
						JOptionPane.showMessageDialog(null, "账号已被冻结");
					}
					else
					{	
						if(he.login(con, use) == true){
							new UIenter();
						}
						else
							JOptionPane.showMessageDialog(null, "账号不存在或者密码错误");
					}
				}catch(Exception e1) {
					e1.printStackTrace();
					System.out.println("数据库连接失败");
				}
				
				
				
				
				// TODO Auto-generated method stub
			
		}
		});
			
		


		} 
		
		
		
		
		
		
	}
			


