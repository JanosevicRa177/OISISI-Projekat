package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;

import IOStream.OutputAddress;
import IOStream.OutputDesk;
import IOStream.OutputMarks;
import IOStream.OutputProffesor;
import IOStream.OutputStudent;
import IOStream.OutputSubject;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static MainFrame instance = null;

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private MainFrame(){
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int width = screenSize.width;
	int height = screenSize.height;
	setSize(width*3/4,height*3/4);
	setLocationRelativeTo(null);
	setTitle("Studentska služba");
	
	MenuBar mb = MenuBar.getInstance();
	this.setJMenuBar(mb);
	mb.setVisible(true);
	
	Mytoolbar toolbar = Mytoolbar.getInstance();
	add(toolbar, BorderLayout.NORTH);
	setVisible(true);
	
	StatusBar sb = StatusBar.getInstance();
	add(sb,BorderLayout.SOUTH);
	sb.setLbl(1);
	sb.setVisible(true);
	
	TabsWithTabels twt = TabsWithTabels.getInstance();
	add(twt,BorderLayout.CENTER);
	twt.focusOnStudent();
	this.validate();
	
	 addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowClosing(java.awt.event.WindowEvent e) {
//        	 try {
//				OutputStudent.getInstance().WriteStudent("Students.txt");
//				OutputProffesor.getInstance().WriteProffesor("Professors.txt");
//				OutputAddress.getInstance().WriteAddresses("Addresses.txt");
//				OutputDesk.getInstance().WriteDesk("Desks.txt");
//				OutputMarks.getInstance().WriteMarks("Marks.txt");
//				OutputSubject.getInstance().WriteSubjects("Subjects.txt");
//				//OutputUnpassed.getInstance().WriteUnpassed("UnpassedSubjects.txt");
//        	} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
             System.exit(0);
         }
     });
	}
}
