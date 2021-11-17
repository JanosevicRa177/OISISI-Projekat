package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Mytoolbar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Mytoolbar() {
		super(SwingConstants.HORIZONTAL);
		setPreferredSize(new Dimension(100,40));
		setBackground(new Color(42, 101, 159));
		
		JPanel panLeft =new JPanel(new FlowLayout(FlowLayout.LEFT));
		panLeft.setBackground(new Color(42, 101, 159));
		panLeft.setPreferredSize(new Dimension(100,30));
		add(Box.createHorizontalStrut(10)); 
		
		JButton Add = new JButton();
		Add.setToolTipText("Add");
		ImageIcon Add_icon = new ImageIcon("images/Add.png");
		Image Scaled_Add_icon = Add_icon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
		ImageIcon Add_icon_real = new ImageIcon(Scaled_Add_icon);
		Add.setIcon(Add_icon_real);
		Add.setPreferredSize(new Dimension(25,25));
		panLeft.add(Add);
		
		panLeft.add(Box.createHorizontalStrut(10)); 
		
		JButton Edit = new JButton();
		
		Edit.setToolTipText("Edit");
		ImageIcon Edit_icon = new ImageIcon("images/Edit_2.png");
		Image Scaled_Edit_icon = Edit_icon.getImage().getScaledInstance(23, 23,Image.SCALE_DEFAULT);
		ImageIcon Edit_icon_real = new ImageIcon(Scaled_Edit_icon);
		Edit.setIcon(Edit_icon_real);
		
		Edit.setPreferredSize(new Dimension(25,25));
		add(Edit);
		panLeft.add(Edit);
		
		panLeft.add(Box.createHorizontalStrut(10)); 
		
		JButton Delete = new JButton();
		
		Delete.setToolTipText("Delete");
		ImageIcon Delete_icon = new ImageIcon("images/Delete_2.png");
		Image Scaled_Delete_icon = Delete_icon.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
		ImageIcon Delete_icon_real = new ImageIcon(Scaled_Delete_icon);
		Delete.setIcon(Delete_icon_real);
		
		Delete.setPreferredSize(new Dimension(25,25));
		panLeft.add(Delete);
		panLeft.add(Box.createHorizontalStrut(10)); 
		add(panLeft,BorderLayout.WEST);
		
		
		JPanel panCenter =new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panCenter.setBackground(new Color(42, 101, 159));
		
		JTextArea Search_text_area = new JTextArea();
		Search_text_area.setPreferredSize(new Dimension(150,20));
		panCenter.add(Search_text_area);
		panCenter.add(Box.createHorizontalStrut(10)); 
		
		JButton Search = new JButton();
		
		Search.setToolTipText("Search");
		ImageIcon Search_icon = new ImageIcon("images/Search.png");
		Image Scaled_Search_icon = Search_icon.getImage().getScaledInstance(18, 18,Image.SCALE_DEFAULT);
		ImageIcon Search_icon_real = new ImageIcon(Scaled_Search_icon);
		Search.setIcon(Search_icon_real);
		
		Search.setPreferredSize(new Dimension(25,25));
		panCenter.add(Search);
		panCenter.add(Box.createHorizontalStrut(10)); 
		add(panCenter,BorderLayout.CENTER);
		setFloatable(false);
	}

}