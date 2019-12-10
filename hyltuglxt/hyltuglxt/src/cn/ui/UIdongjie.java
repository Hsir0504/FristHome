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

public class UIdongjie extends JFrame {
	JPanel pan = new JPanel(null);
	JLabel lab = new JLabel("请选择账号:");
	JTextField jtext = new JTextField();
	JButton butt = new JButton("冻结");
	JButton butt1 = new JButton("解除冻结");
	public void init() {
		lab.setFont(new Font("宋体",Font.BOLD,30));
		lab.setBounds(10, 10, 250, 40);
		pan.add(lab);
		
		jtext.setFont(new Font("宋体",Font.BOLD,30));
		jtext.setBounds(200, 10, 170, 40);
		pan.add(jtext);
		
		butt.setFont(new Font("宋体",Font.BOLD,30));
		butt.setBounds(30, 70, 100, 40);
		pan.add(butt);
		
		butt1.setFont(new Font("宋体",Font.BOLD,30));
		butt1.setBounds(160,70,200,40);
		pan.add(butt1);
		
		pan.setBounds(0, 0, 400, 170);
		this.add(pan);
		
	}
	public UIdongjie() {
		init();
		this.setTitle("");
		this.setBounds(500,500 , 400,170);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		butt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = jtext.getText();
				String state = "1";
				
				User u = new User();
				System.out.println(state);
				u.setId(id);
				u.setState(state);
				System.out.println(u.getState());
				UserDao ud = new UserDao();
				Connect conn = new Connect();
				try {
					Connection con = conn.getCon();
					if(ud.dongjie(con, u)==0)
					{
						JOptionPane.showMessageDialog(null, "此编号为空");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "账号已冻结");
					}
				}
				catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
					System.out.println("数据库连接失败");
				}
			}
		});
		butt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = jtext.getText();
				String state = "2";
				
				User u = new User();
				System.out.println(state);
				u.setId(id);
				u.setState(state);
				System.out.println(u.getState());
				UserDao ud = new UserDao();
				Connect conn = new Connect();
				try {
					Connection con = conn.getCon();
					if(ud.dongjie(con, u)==0)
					{
						JOptionPane.showMessageDialog(null, "此编号为空");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "账号已解除冻结");
					}
				}
				catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
					System.out.println("数据库连接失败");
				}
			}
				
			
		});
	}
}
