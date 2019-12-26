package cn.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class UIzhuyemian extends JPanel {
	 JPanel panel = new JPanel(null);
	 JLayeredPane layer;
	 JLabel lab = new JLabel("everyday欢迎来到知识的海洋");

		public UIzhuyemian() {
			this.setLayout(new GridLayout(1, 1));
			
			layer = new JLayeredPane() {
				public void paintComponent(Graphics g) {
					
					super.paintComponent(g);
					
					ImageIcon image = new ImageIcon("img/22.jpg");
					
					image.setImage(image.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_AREA_AVERAGING));
					
					g.drawImage(image.getImage(), 0, 0, this);
				}
			};
			
			this.add(layer);
			init();
			layer.add(panel, JLayeredPane.DRAG_LAYER);
		}
		void init() {
			lab.setFont(new Font("黑体",Font.CENTER_BASELINE,30));
			lab.setForeground(Color.red);
			lab.setBounds(100, 100, 500, 50);
			
			panel.add(lab);
			panel.setOpaque(false);
			panel.setBounds(100, 100, 800, 800);
			
			this.add(panel);
			
		}


}
