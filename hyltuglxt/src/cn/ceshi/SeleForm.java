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
			
		  //����
		  String[] columnNames = {"id:","����","�༶","����","ȷ������"};
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
			  //��setColumnIdentifiers�滻�У�����˵����������
			  for(int i=0;i<u;i++)
			  {
				  v.add(dao.inquire(con,user).get(i));
				  newtablemodel.addRow((Vector) v.get(i));
				  //��vector��ӵ�DefaultTableModel�У���addRow()������������������ݵ�����еķ���
			 }
		  }
		  catch (Exception e) {
			// TODO: handle exception
			  e.printStackTrace();
				System.out.println("���ݿ�����ʧ��");
		}
		  
		  JTable table = new JTable(newtablemodel);
		  table.setRowHeight(30);
		  
		  
		//��Ҫ��table���뵽������ť�в�����ʾ
		  JScrollPane sc = new JScrollPane(table);
		  
		  jp.add(sc);
		  sc.setBounds(0, 0, 500, 500);
		  table.setFont(new Font("����",Font.BOLD,30));
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
