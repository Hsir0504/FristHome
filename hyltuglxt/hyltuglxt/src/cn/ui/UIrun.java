package cn.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import cn.ceshi.Sele;
import cn.connect.Connect;
import cn.dao.UserDao;
import cn.dome.User;

public class UIrun extends JPanel{
	JLabel lab = new JLabel("管理员系统");
	JLayeredPane layer = new JLayeredPane();
	JPanel jpanel = new JPanel(null);
	JButton jbutton = new JButton("查询用户");
	JButton jbutton1 = new JButton("删除用户");
	JButton jbutton2= new JButton("增加图书");
	JButton jbutton3 = new JButton("删除图书");
	JButton jbutton4 = new JButton("修改图书信息");
	JButton jbutton5 = new JButton("权限管理");
	public UIrun() {
		this.setLayout(new GridLayout(1, 1));
		
		layer = new JLayeredPane() {
			public void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				
				ImageIcon image = new ImageIcon("img/25.jpg");
				
				image.setImage(image.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
				
				g.drawImage(image.getImage(), 0, 0, this);
			}
		};
		
		this.add(layer);
		init();
		layer.add(jpanel, JLayeredPane.DRAG_LAYER);
		
		jbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				Connect conn = new Connect();
//				UserDao ud = new UserDao();
//				User u = new User();
//				try {
//					Connection con = conn.getCon();
//					ud.inquire(con, u);
//				}
//				catch (Exception e3) {
//					// TODO: handle exception
//					e3.printStackTrace();
//					System.out.println("数据库连接失败");
//				}
				new Sele();
				
			}
		});
		
		jbutton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new UIdeluser();
			}
		});
		
		jbutton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new UIjiabooks();
				
			}
		});
		
		jbutton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new UIdel();
				
			}
		});
		jbutton4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new UIupdatebook();
			}
		});
		jbutton5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new UIdongjie();
			}
		});
		
	}
	void init() {
		jbutton.setFont(new Font("黑体",Font.CENTER_BASELINE,30));
		jbutton.setContentAreaFilled(false);
		jbutton.setForeground(Color.CYAN);
		jbutton.setBounds(20, 20, 200, 40);
		jbutton.setOpaque(false);
		
		jbutton1.setFont(new Font("黑体",Font.CENTER_BASELINE,30));
		jbutton1.setContentAreaFilled(false);
		jbutton1.setForeground(Color.CYAN);
		jbutton1.setBounds(20, 70, 200, 40);
		
		jbutton2.setFont(new Font("黑体",Font.CENTER_BASELINE,30));
		jbutton2.setContentAreaFilled(false);
		jbutton2.setForeground(Color.CYAN);
		jbutton2.setBounds(20, 120, 200, 40);
		
		jbutton3.setFont(new Font("黑体",Font.CENTER_BASELINE,30));
		jbutton3.setContentAreaFilled(false);
		jbutton3.setForeground(Color.CYAN);
		jbutton3.setBounds(20, 170, 200, 40);
		
		jbutton4.setFont(new Font("黑体",Font.CENTER_BASELINE,30));
		jbutton4.setContentAreaFilled(false);
		jbutton4.setForeground(Color.CYAN);
		jbutton4.setBounds(20, 220, 250, 40);
		
		jbutton5.setFont(new Font("黑体",Font.CENTER_BASELINE,30));
		jbutton5.setContentAreaFilled(false);
		jbutton5.setForeground(Color.CYAN);
		jbutton5.setBounds(20, 270, 200, 40);
		
		
		jpanel.add(jbutton);
		jpanel.add(jbutton1);
		jpanel.add(jbutton2);
		jpanel.add(jbutton3);
		jpanel.add(jbutton4);
		jpanel.add(jbutton5);
		jpanel.setOpaque(false);
		jpanel.setBounds(0, 0, 1000, 1000);
		
		this.add(jpanel);
	}

}
