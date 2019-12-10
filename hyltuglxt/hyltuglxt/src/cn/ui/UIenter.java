package cn.ui;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import cn.borrow.UIBorrow;
import cn.borrow.UIimback;
import cn.connect.Connect;
import cn.dao.BooksDao;
import cn.dome.Books;

public class UIenter extends JFrame {
	JLayeredPane layer = new JLayeredPane();
	JButton button = new JButton("借阅图书");
	JButton button1 = new JButton("归还图书");
	JButton button2 = new JButton("修改信息");
	JButton button3 = new JButton("退出登陆");
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JLabel lab1;
	ImageIcon imag;
	void init() {
		imag = new ImageIcon("img/401.jpg");
		lab1 = new JLabel(imag);
		panel.setBounds(0, 0, imag.getIconWidth(), imag.getIconWidth());
		panel.add(lab1); 
		
		panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		panel4.setOpaque(false);
		
		button.setFont(new Font("宋体",Font.BOLD,40));
		button.setForeground(Color.red);
		button.setContentAreaFilled(false);
		panel1.add(button);
		panel1.setBounds(400, 200, 200, 60);
		
		button1.setFont(new Font("宋体",Font.BOLD,40));
		button1.setForeground(Color.red);
		button1.setContentAreaFilled(false);
		panel2.add(button1);
		panel2.setBounds(400, 300, 200, 60);
		
		button2.setFont(new Font("宋体",Font.LAYOUT_NO_START_CONTEXT,40));
		button2.setForeground(Color.BLACK);
		button2.setContentAreaFilled(false);
		panel3.add(button2);
		panel3.setBounds(400, 400, 200, 60);
		
		button3.setFont(new Font("宋体",Font.LAYOUT_NO_START_CONTEXT,40));
		button3.setForeground(Color.BLACK);
		button3.setContentAreaFilled(false);
		panel4.add(button3);
		panel4.setBounds(400, 500, 200, 60);
		
		layer.add(panel, JLayeredPane.DEFAULT_LAYER);
		layer.add(panel1, JLayeredPane.DRAG_LAYER);
		layer.add(panel2, JLayeredPane.POPUP_LAYER);
		layer.add(panel3, JLayeredPane.MODAL_LAYER);
		layer.add(panel4, JLayeredPane.PALETTE_LAYER);
		
	}
	public UIenter() {
		this.init();
		this.setTitle("登陆界面");
		this.setBounds(500, 30, imag.getIconWidth(), imag.getIconHeight());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayeredPane(layer);
		this.setVisible(true);
		
		button3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
		}
		});
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new UIupdateuser();
			}		
	});
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new UIimback();
			}
		});
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new UIBorrow();
			}
		});
}
}
