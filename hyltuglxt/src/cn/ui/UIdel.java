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

public class UIdel extends JFrame{
	
	JPanel pan = new JPanel(null);
	JLabel lab = new JLabel("������ͼ����:");
	JTextField jtext = new JTextField();
	JButton butt = new JButton("ɾ��");
	
	public void init() {
		lab.setFont(new Font("����",Font.BOLD,30));
		lab.setBounds(10, 10, 250, 40);
		pan.add(lab);
		
		jtext.setFont(new Font("����",Font.BOLD,30));
		jtext.setBounds(270, 10, 150, 40);
		pan.add(jtext);
		
		butt.setFont(new Font("����",Font.BOLD,30));
		butt.setBounds(150, 70, 100, 40);
		pan.add(butt);
		
		pan.setBounds(0, 0, 450, 170);
		this.add(pan);
		
	}
	public UIdel() {
		init();
		this.setTitle("");
		this.setBounds(500,500 , 450,170);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		butt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String number;
				number = jtext.getText();
				Connect conn = new Connect();
				Books b = new Books();
				b.setNumber(Integer.valueOf(number));
				BooksDao bd = new BooksDao();
				try {
					Connection con = conn.getCon();
					if(bd.delete(con, b.getNumber())!=0)
					{
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					}
					else {
						JOptionPane.showMessageDialog(null, "�鼮������");
					}
					
				}
				catch (Exception e3) {
					// TODO: handle exception
					e3.printStackTrace();
					System.out.println("���ݿ�����ʧ��");
				}
				
			}
		});
	}

}
