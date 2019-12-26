package cn.ceshi;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.connect.Connect;
import cn.dao.BooksDao;
import cn.dao.UserDao;
import cn.dome.Books;
import cn.dome.User;

public class SeleForm extends JFrame{
		 JTable table;
		 JLayeredPane layer;
		 JPanel jp = new JPanel(null);
		 Vector v = new Vector();
		 private int u;
		 public DefaultTableModel newtablemodel = new DefaultTableModel();
		 public void Defult() {
			
		  //列名
		  String[] columnNames = {"id:","姓名","班级","密码","确认密码"};
		  newtablemodel.setColumnIdentifiers(columnNames);

			String id = Sele.text.getText();
			String name = Sele.text1.getText();
			String room = Sele.text2.getText();
		  Connect conn = new Connect();
		  User user = new User();
		  UserDao dao = new UserDao();
		  user.setId(id);
		  user.setName(name);
		  user.setRoom(room);
		   try {
			   Connection con = conn.getCon();
			  u = dao.inquire(con, user).size();
			  //用setColumnIdentifiers替换列（或者说设置列名）
			  for(int i=0;i<u;i++)
			  {
				  v.add(dao.inquire(con,user).get(i));
				  newtablemodel.addRow((Vector) v.get(i));
				  //将vector添加到DefaultTableModel中，用addRow()方法，这是添加行数据到表格中的方法
			 }
		  }
		  catch (Exception e) {
			// TODO: handle exception
			  e.printStackTrace();
				System.out.println("数据库连接失败");
		}
		  
		  JTable table = new JTable(newtablemodel);
		  table.setRowHeight(30);
		  
		  
		//需要把table加入到滑动按钮中才能显示
		  JScrollPane sc = new JScrollPane(table);
		  
		  jp.add(sc);
		  sc.setBounds(0, 0, 500, 500);
		  table.setFont(new Font("宋体",Font.BOLD,30));
		  jp.setBounds(0, 0, 1000, 1000);
		 jp.setOpaque(false);
		  this.add(jp);
		  	
		 }
		public SeleForm(){
           Defult();
           this.setTitle("");
           this.setBounds(450, 450, 500, 500);
           this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
           this.setVisible(true);
		}
}
