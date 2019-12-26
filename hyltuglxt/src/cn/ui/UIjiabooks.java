package cn.ui;

import java.awt.Dimension;
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
import cn.opinion.Opinion;

public class UIjiabooks extends JFrame{
	public JLabel lab,lab1,lab2,lab3,lab4;
	public JButton butt,butt1;
	public JTextField text = new JTextField();
	public JTextField text1 = new JTextField();
	public JTextField text2= new JTextField();
	public JTextField text3= new JTextField();
	public JPanel jpanel = new JPanel();
	public JPanel jpanel1 = new JPanel();
	public JPanel jpanel2 = new JPanel();
	public JPanel jpanel3 = new JPanel();
	public JPanel jpanel4 = new JPanel();
	public JPanel jpanel5 = new JPanel();
	public UIjiabooks() {
		this.setLayout(null);
		lab = new JLabel("图书编号");
		lab.setFont(new Font("宋体",Font.BOLD,30));
		Dimension dis = new Dimension(250,50);
		text.setPreferredSize(dis);
		text.setFont(new Font("宋体",Font.BOLD,30));
		jpanel.add(lab);
		jpanel.add(text);
		jpanel.setBounds(100, 150, 500, 300);
		
		lab1 = new JLabel("图书名字");
		lab1.setFont(new Font("宋体",Font.BOLD,30));
		text1.setPreferredSize(dis);
		text1.setFont(new Font("宋体",Font.BOLD,30));
		jpanel1.add(lab1);
		jpanel1.add(text1);
		jpanel1.setBounds(100, 250, 500, 300);
		
		lab2 = new JLabel("作者姓名");
		lab2.setFont(new Font("宋体",Font.BOLD,30));
		text2.setPreferredSize(dis);
		text2.setFont(new Font("宋体",Font.BOLD,30));
		jpanel2.add(lab2);
		jpanel2.add(text2);
		jpanel2.setBounds(100, 350, 500, 300);
		
		lab3 = new JLabel("图书数量");
		lab3.setFont(new Font("宋体",Font.BOLD,30));
		text3.setPreferredSize(dis);
		text3.setFont(new Font("宋体",Font.BOLD,30));
		jpanel3.add(lab3);
		jpanel3.add(text3);
		jpanel3.setBounds(100, 450, 500, 300);
		
		
		butt = new JButton("添加");
		butt.setFont(new Font("宋体",Font.BOLD,30));
		butt1 = new JButton("取消");
		butt1.setFont(new Font("宋体",Font.BOLD,30));
		jpanel4.add(butt);
		jpanel4.add(butt1);
		jpanel4.setBounds(120, 550, 500, 300);
		
		lab4 = new JLabel("增加图书");
		lab4.setFont(new Font("宋体",Font.BOLD,50));
		jpanel5.add(lab4);
		jpanel5.setBounds(120, 50, 500, 300);
		
		this.add(jpanel4);
		this.add(jpanel3);
		this.add(jpanel2);
		this.add(jpanel1);
		this.add(jpanel);
		this.add(jpanel5);
		
		butt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String number,math,bookname,writer;
				number = text.getText();
				bookname = text1.getText();
				writer = text2.getText();
				math = text3.getText();
				
				Books books = new Books();
				books.setNumber(Integer.valueOf(number));
				
				books.setBookname(bookname);
				books.setWriter(writer);
				books.setMath(Integer.valueOf(math));
				
				
				if(Opinion.sky(number))
				{
					JOptionPane.showMessageDialog(null, "图书编号不能为空");
					return;
				}
				else if(Opinion.sky(bookname))
				{
					JOptionPane.showMessageDialog(null, "图书名字不能为空");
					return;
				}
				else if(Opinion.sky(math))
				{
					JOptionPane.showMessageDialog(null, "图书个数不能为空");
					return;
				}
				else
				{
					BooksDao bu = new BooksDao();
					Connect buu = new Connect();
					try {
						Connection co = buu.getCon();
						if(bu.ition(co, books)!=0)
							JOptionPane.showMessageDialog(null, "添加成功");
						else
							JOptionPane.showMessageDialog(null,"图书已存在");
					}
					catch (Exception e1) {
						// TODO: handle exception
						e1.printStackTrace();
						System.out.println("数据库连接失败");
					}
					
				}
				
				
			}
		});
		butt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				
			}
		});
		
	    this.setTitle("增加图书");
	    this.setBounds(100, 100, 750, 750);
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    this.setVisible(true);
	}

}
