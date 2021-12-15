package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame(){
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int width = screenSize.width;
	int height = screenSize.height;
	setSize(width*3/4,height*3/4);
	setLocationRelativeTo(null);
	MenuBar mb = new MenuBar();
	this.setJMenuBar(mb);
	mb.setVisible(true);
	Mytoolbar toolbar = new Mytoolbar();
	add(toolbar, BorderLayout.NORTH);
	setVisible(true);
	StatusBar sb = new StatusBar();
	add(sb,BorderLayout.SOUTH);
	sb.setVisible(true);
	setVisible(true);
	}
}