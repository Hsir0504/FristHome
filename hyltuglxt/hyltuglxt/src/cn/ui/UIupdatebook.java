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
import cn.dome.Books;
import cn.opinion.Opinion;

public class UIupdatebook extends JFrame{
	JPanel jp   = new JPanel(null);
	JLabel lab  = new JLabel("ѡ����");
	JLabel lab1 = new JLabel("������");
	JLabel lab2 = new JLabel("������");
	JLabel lab3 = new JLabel("������");
	JTextField text = new JTextField();
	JTextField text1 = new JTextField();
	JTextField text2 = new JTextField();
	JTextField text3 = new JTextField();
	JButton button = new JButton("ȷ��");
	JButton button1 = new JButton("");
	public void init() {
		lab.setBounds(150, 150, 200, 30);
		lab.setFont(new Font("����",Font.BOLD,30));
		lab1.setBounds(150, 250, 100, 30);
		lab1.setFont(new Font("����",Font.BOLD,30));
		lab2.setBounds(150, 350, 100, 30);
		lab2.setFont(new Font("����",Font.BOLD,30));
		lab3.setBounds(150, 450, 100, 50);
		lab3.setFont(new Font("����",Font.BOLD,30));
		text.setBounds(300,150,250,50);
		text.setFont(new Font("����",Font.BOLD,30));
		text1.setBounds(300,250,250,50);
		text1.setFont(new Font("����",Font.BOLD,30));
		text2.setBounds(300,350,250,50);
		text2.setFont(new Font("����",Font.BOLD,30));
		text3.setBounds(300,450,250,50);
		text3.setFont(new Font("����",Font.BOLD,30));
		button.setBounds(250, 550, 150, 50);
		button.setFont(new Font("����",Font.BOLD,30));
		
		jp.add(lab);
		jp.add(lab1);
		jp.add(lab2);
		jp.add(lab3);
		jp.add(text);
		jp.add(text1);
		jp.add(text2);
		jp.add(text3);
		jp.add(button);
		jp.setBounds(0, 0, 750, 750);
		this.add(jp);
	}
	public UIupdatebook() {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String number = text.getText();
				String bookname = text1.getText();
				String writer = text2.getText();
				String math = text3.getText();
				if(Opinion.sky(number))
				{
					JOptionPane.showMessageDialog(null, "��Ų���Ϊ��");
				}
				
				
				Books b = new Books();
				b.setNumber(Integer.valueOf(number));
				b.setBookname(bookname);
				b.setWriter(writer);
				b.setMath(Integer.valueOf(math));
				Connect conn = new Connect();
				BooksDao bd = new BooksDao();
				try {
					Connection con = conn.getCon();
					if(bd.update(con, b)==0) {
					JOptionPane.showMessageDialog(null, "û�в�ѯ������");					}
					else
					{
						JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
					}
					
					
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println("���ݿ�����ʧ��");
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
