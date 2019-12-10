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

import cn.dao.UserDao;

import cn.dome.User;

public class UIdeluser extends JFrame{
	JPanel pan = new JPanel(null);
	JLabel lab = new JLabel("������ID:");
	JTextField jtext = new JTextField();
	JButton butt = new JButton("ɾ��");
	
	public void init() {
		lab.setFont(new Font("����",Font.BOLD,30));
		lab.setBounds(10, 10, 250, 40);
		pan.add(lab);
		
		jtext.setFont(new Font("����",Font.BOLD,30));
		jtext.setBounds(170, 10, 150, 40);
		pan.add(jtext);
		
		butt.setFont(new Font("����",Font.BOLD,30));
		butt.setBounds(100, 70, 100, 40);
		pan.add(butt);
		
		pan.setBounds(0, 0, 350, 170);
		this.add(pan);
	}
	public UIdeluser() {
		init();
		this.setTitle("");
		this.setBounds(500,500 , 350,170);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		butt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id;
				id = jtext.getText();
				Connect conn = new Connect();
				 User b = new User();
				b.setId(id);
				UserDao bd = new UserDao();
				try {
					Connection con = conn.getCon();
					if(bd.delete(con, b.getId())!=0)
					{
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					}
					else {
						JOptionPane.showMessageDialog(null, "��ID������");
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

