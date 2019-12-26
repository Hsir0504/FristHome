package cn.borrow;

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
import cn.dome.Books;
import cn.ui.UIinterface;

public class UIBorrow extends JFrame{
	JPanel jp = new JPanel(null);
	JLabel lab = new JLabel("借书人");
	JLabel lab1;
	JLabel lab2 = new JLabel("书籍编号");
	JTextField text = new JTextField();
	JButton button = new JButton("借出");
	public void init() {
		lab.setFont(new Font("黑体",Font.BOLD,50));
		lab.setBounds(70, 50, 180, 50);
		jp.add(lab);
		
		lab1 = new JLabel(UIinterface.he);
		lab1.setFont(new Font("黑体",Font.BOLD,50));
		lab1.setBounds(270, 50, 150, 50);
		jp.add(lab1);
		
		lab2.setFont(new Font("宋体",Font.BOLD,30));
		lab2.setBounds(20, 150, 200, 50);
		jp.add(lab2);
		
		text.setFont(new Font("宋体",Font.BOLD,30));
		text.setBounds(170, 150, 200, 50);
		jp.add(text);
		
		button.setFont(new Font("宋体",Font.BOLD,30));
		button.setBounds(130, 250, 150, 50);
		jp.add(button);
		
		
		jp.setBounds(0, 0, 400, 400);
		this.add(jp);
	}
	public UIBorrow() {
		init();
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 String number = text.getText();
				 String borrow = ("已借出");
				 String people = (UIinterface.he);
				 Books b = new Books();
				 b.setNumber(Integer.valueOf(number));
				 b.setBorrow(borrow);
				 b.setPeople(people);
				 BorrowDao bd = new BorrowDao();
				 Connect conn = new Connect();
				 try
				 {
					 Connection con = conn.getCon();
					 if(bd.ustate(con, b)==true) {
						 JOptionPane.showMessageDialog(null, "此书已经借出");
						 
					 }
					 else {	 if(bd.borrow(con, b) == 0)
					 {
						 JOptionPane.showMessageDialog(null, "此书不存在");
					 }
					 
						 else {
						 JOptionPane.showMessageDialog(null, "借书成功");
					 }
					 }
				 }
				 
				 catch (Exception e2) {
					// TODO: handle exception
					 e2.printStackTrace();
					 System.out.println("数据库连接失败");
				}
				 System.out.println(b.getBorrow());
				}
			
			
		});
		this.setBounds(250, 250, 400, 400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("");
		this.setVisible(true);
	}
}
