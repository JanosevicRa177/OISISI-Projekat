package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static StatusBar instance = null;
	
	private String lbl;
	private static JPanel panLeft =new JPanel();
	private static JLabel p = new JLabel("currentTab");

	public static StatusBar getInstance() {
		if (instance == null) {
			instance = new StatusBar();
		}
		return instance;
	}
	
	private StatusBar()
	{
	setLayout(new BorderLayout());
	this.setBackground(new Color(42, 101, 159));
	//	Toolkit kit = Toolkit.getDefaultToolkit();
//    Dimension screenSize = kit.getScreenSize();
//    int width = screenSize.width;
//    int height = screenSize.height;
//    this.setPreferredSize(new Dimension(width,height*1/40));
	
	String jlbl = "Studentska sluzba - ";
	
    JLabel label=new JLabel(jlbl);
    panLeft.add(label);
    panLeft.setBackground(new Color(42, 101, 159));
    JPanel panRight =new JPanel();
    add(panLeft,BorderLayout.WEST);
    JLabel dateLabel = new JLabel();
    JLabel timeLabel = new JLabel();
    TimerThread tt = new TimerThread(dateLabel,timeLabel);
    tt.start();
    panRight.setBackground(new Color(42, 101, 159));
    panRight.add(timeLabel);
    panRight.add(dateLabel);
    panRight.setBackground(new Color(42, 101, 159));
    
    add(Box.createHorizontalGlue());
    
    
   
    add(panRight,BorderLayout.EAST);
    //this.add(Box.createHorizontalStrut(30));
    //this.add(Box.createVerticalStrut(10));
	
	
	setLbl(1);
	 
	}
	
	public void setLbl(int newlbl)
	{
		System.out.println("Usao u funkciju");
		String tmp = "";
		switch(newlbl)
		{
		case 1:
			tmp = "Students";
			break;
		case 2:
			tmp = "Professors";
			break;
		case 3:
			tmp = "Subjects";
			break;
		}
		setCurrent(tmp);
	}
	public void setCurrent(String s)
	{
		panLeft.remove(p);
		p = new JLabel(s);
		panLeft.add(p,BorderLayout.WEST);
		
	}
	
	
}
