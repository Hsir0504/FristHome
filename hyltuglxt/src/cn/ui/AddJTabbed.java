package cn.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;




public class AddJTabbed extends JFrame{
	private static JTabbedPane jta = new JTabbedPane(JTabbedPane.TOP);

	JLabel jla = new JLabel();
	JPanel jpa = new JPanel();
	
	UIzhuce zc = new UIzhuce();
	UIzhuyemian zjm = new UIzhuyemian();
	//UIenter ent = new UIenter();
	UIinterface face = new UIinterface();
	UIDefult defult = new UIDefult();
	UIrun run = new UIrun();
	 void JTabbed() {
		jta.add("������",zjm);
		jta.add("ע���",zc);
		jta.add("��½��",face);
		jta.add("ͼ���ѯ",defult);
		jta.add("����Աϵͳ",run);
		this.add(jta);
	}
	public AddJTabbed() {
		this.setTitle("ͼ�����ϵͳ");
		this.setSize(1500,1125);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.JTabbed();
		this.setVisible(true);
	}
}


