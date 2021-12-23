package GUI;

import java.awt.Color;
import java.awt.Dimension;
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
	
	private String lbl = "";

	public static StatusBar getInstance() {
		if (instance == null) {
			instance = new StatusBar();
		}
		return instance;
	}
	
	private StatusBar()
	{
	
	this.setBackground(new Color(42, 101, 159));
	BoxLayout box=new BoxLayout(this, BoxLayout.X_AXIS);
	this.setLayout(box);
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int width = screenSize.width;
	int height = screenSize.height;
	this.setPreferredSize(new Dimension(width,height*1/40));
	String jlbl;
	if(TabsWithTabels.getInstance().getFocus().equals("Students")) {
		jlbl = "Studentska sluzba - Students";
	}else if(TabsWithTabels.getInstance().getFocus().equals("Professors")) {
		jlbl = "Studentska sluzba - Professors";
	} else {
		jlbl = "Studentska sluzba - Subjects";
	}
    JLabel label=new JLabel(jlbl);
    label.setPreferredSize(new Dimension(200,20));
    this.add(Box.createHorizontalStrut(10));
    this.add(label);
    this.add(Box.createHorizontalGlue());
    String timeStamp = new SimpleDateFormat("HH:mm dd.MM.yyyy").format(Calendar.getInstance().getTime());
    this.add(new JLabel(timeStamp));
    this.add(Box.createHorizontalStrut(30));
	
	
	
	 
	}
	
	public void setLbl(String newlbl)
	{
		lbl = newlbl;
	}
	
	
}
