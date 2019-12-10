package cn.ui;


import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.connect.Connect;
import cn.dao.BooksDao;
import cn.dome.Books;

public class UIDefult extends JPanel{
	 JTable table;
	 JLayeredPane layer;
	 JPanel jp = new JPanel(null);
	 Vector v = new Vector();

	 JLabel lab1 = new JLabel("����");
	 JLabel lab2 = new JLabel("����");

	 JTextField text1 = new JTextField();
	 JTextField text2 = new JTextField();
	 JButton button = new JButton("��ѯ");
	 private int u;
	 public DefaultTableModel newtablemodel = new DefaultTableModel();

	 public void Defult() {
		  JTable table = new JTable(newtablemodel);
		  table.setRowHeight(30);
		  button.setBounds(650, 250, 100, 30);

		  text1.setBounds(550, 200, 100, 30);
		  text2.setBounds(760, 200, 100, 30);

	
		  lab1.setBounds(500, 200, 50, 30);
		  lab1.setFont(new Font("����",Font.BOLD,20));
		  lab2.setBounds(700, 200, 50, 30);
		  lab2.setFont(new Font("����",Font.BOLD,20));
		  
		  
		//��Ҫ��table���뵽������ť�в�����ʾ
		  JScrollPane sc = new JScrollPane(table);
		  
		  jp.add(sc);
		  sc.setBounds(450, 300, 500, 500);
		  table.setFont(new Font("����",Font.BOLD,20));
		  jp.setBounds(0, 0, 1000, 1000);
		  jp.add(button);

		  jp.add(text1);
		  jp.add(text2);

		  jp.add(lab1);
		  jp.add(lab2);
		  jp.setOpaque(false);
		  this.add(jp);
//		  ((DefaultTableModel) table.getModel()).getDataVector().clear();   //����������
//		 ((DefaultTableModel) table.getModel()).fireTableDataChanged();//֪ͨģ�͸���
//		 table.updateUI(); //ˢ�±�� 
		  	}
	public UIDefult() {
		setLayout(new GridLayout(1, 1)); //����ֻ��һ��һ��
		layer = new JLayeredPane() {       
			public void paintComponent(Graphics g) {  
				super.paintComponent(g);
				ImageIcon image = new ImageIcon("img/28.jpg");
				image.setImage(image.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
				g.drawImage(image.getImage(), 0, 0, this);
			}
		};
		this.add(layer);
		Defult();
		layer.add(jp,JLayeredPane.DRAG_LAYER);
		 String[] columnNames = {"���:","����","����","����","״̬"};
		  newtablemodel.setColumnIdentifiers(columnNames);
		  
		  button.addActionListener(new ActionListener() {
			  @Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				  newtablemodel.setRowCount(0);

				  
				  String bookname = text1.getText();
				  String writer = text2.getText();
				  
				  Books boo = new Books();
				  boo.setBookname(bookname);
				  boo.setWriter(writer);
				  Connect conn = new Connect();
				  BooksDao dao = new BooksDao();
				  try {
					  Connection con = conn.getCon();
					  u = dao.inquire(con, boo).size();
					  //��setColumnIdentifiers�滻�У�����˵����������
					  for(int i=0;i<u;i++)
					  {		
						  v=dao.inquire(con,boo);
						  newtablemodel.addRow((Vector) v.get(i));
						  //��vector��ӵ�DefaultTableModel�У���addRow()������������������ݵ�����еķ���
						  }
				  }
				  catch (Exception e) {
					// TODO: handle exception
					  e.printStackTrace();
						System.out.println("���ݿ�����ʧ��");
				}
				
				
			}
		});
	}

}


