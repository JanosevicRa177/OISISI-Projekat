package GUI;


import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.MenuKeyEvent;
import java.awt.Image;
import java.awt.event.KeyEvent;


public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	
	private static MenuBar instance = null;

	public static MenuBar getInstance() {
		if (instance == null) {
			instance = new MenuBar();
		}
		return instance;
	}
	
		private MenuBar() {

			JMenu file = new JMenu("File");
			JMenu edit = new JMenu("Edit");
			JMenu help = new JMenu("Help");
			file.setMnemonic(KeyEvent.VK_F);
			edit.setMnemonic(KeyEvent.VK_E);
			help.setMnemonic(KeyEvent.VK_H);
			
			
			
			
			JMenuItem fiNew = new JMenuItem("New");
			JMenuItem fiClose = new JMenuItem("Close");
			JMenuItem fiSave = new JMenuItem("Save");
			
			JMenu open = new JMenu("Open");

			file.add(fiNew);
			file.addSeparator();
			file.add(fiSave);
			file.addSeparator();
			file.add(open);
			file.addSeparator();
			file.add(fiClose);
			
			ImageIcon IconArrow = new ImageIcon("images/arrow.jpg");
			Image scalearrow = IconArrow.getImage().getScaledInstance(15, 15,Image.SCALE_DEFAULT);
			ImageIcon scaledArrow = new ImageIcon(scalearrow);
			
			
			ImageIcon Iconnew = new ImageIcon("images/new.jpg");
			Image scaleImage = Iconnew.getImage().getScaledInstance(15, 15,Image.SCALE_DEFAULT);
			ImageIcon scaledIcon = new ImageIcon(scaleImage);
			
			ImageIcon IconOpen = new ImageIcon("images/open.jpg");
			Image scaleopen = IconOpen.getImage().getScaledInstance(15, 15,Image.SCALE_DEFAULT);
			ImageIcon scaledOpen = new ImageIcon(scaleopen);
			
			ImageIcon IconClose = new ImageIcon("images/close.jpg");
			Image scaleclose = IconClose.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
			ImageIcon scaledClose = new ImageIcon(scaleclose);
			
			ImageIcon IconSave = new ImageIcon("images/save.jpg");
			Image scalesave = IconSave.getImage().getScaledInstance(15, 15,Image.SCALE_DEFAULT);
			ImageIcon scaledSave = new ImageIcon(scalesave);
			
			fiNew.setAccelerator(KeyStroke.getKeyStroke('N',MenuKeyEvent.CTRL_DOWN_MASK));
			fiNew.setIcon(scaledIcon);
			fiNew.setMnemonic(KeyEvent.VK_N);
			open.setIcon(scaledOpen);
			open.setMnemonic(KeyEvent.VK_O);
			fiClose.setAccelerator(KeyStroke.getKeyStroke('C',MenuKeyEvent.CTRL_DOWN_MASK));
			fiClose.setIcon(scaledClose);
			fiClose.setMnemonic(KeyEvent.VK_C);
			fiSave.setAccelerator(KeyStroke.getKeyStroke('S',MenuKeyEvent.CTRL_DOWN_MASK));
			fiSave.setIcon(scaledSave);
			fiSave.setMnemonic(KeyEvent.VK_S);
			
			JMenuItem fiSt = new JMenuItem("Studenti");
			fiSt.setAccelerator(KeyStroke.getKeyStroke('S',MenuKeyEvent.CTRL_DOWN_MASK));
			fiSt.setMnemonic(KeyEvent.VK_S);
			JMenuItem fiPre = new JMenuItem("Predmeti");
			fiPre.setAccelerator(KeyStroke.getKeyStroke('P',MenuKeyEvent.CTRL_DOWN_MASK));
			fiPre.setMnemonic(KeyEvent.VK_P);
			JMenuItem fiPro = new JMenuItem("Profesori");
			fiPro.setAccelerator(KeyStroke.getKeyStroke('R',MenuKeyEvent.CTRL_DOWN_MASK));
			fiPro.setMnemonic(KeyEvent.VK_R);
			JMenuItem fiKa = new JMenuItem("Katedre");
			fiKa.setAccelerator(KeyStroke.getKeyStroke('K',MenuKeyEvent.CTRL_DOWN_MASK));
			fiKa.setMnemonic(KeyEvent.VK_K);
			
			fiSt.setIcon(scaledArrow);
			fiPre.setIcon(scaledArrow);
			fiPro.setIcon(scaledArrow);
			fiKa.setIcon(scaledArrow);
			
			
			
			open.add(fiSt);
			open.add(fiPre);
			open.add(fiPro);
			open.add(fiKa);
			
			JMenuItem edEdit = new JMenuItem("Edit");
			JMenuItem edDelete = new JMenuItem("Delete");
			edEdit.setAccelerator(KeyStroke.getKeyStroke('I',MenuKeyEvent.CTRL_DOWN_MASK));
			edEdit.setMnemonic(KeyEvent.VK_I);
			edDelete.setAccelerator(KeyStroke.getKeyStroke('D',MenuKeyEvent.CTRL_DOWN_MASK));
			edDelete.setMnemonic(KeyEvent.VK_D);
			
			ImageIcon IconEdit = new ImageIcon("images/edit.jpg");
			Image scaleedit = IconEdit.getImage().getScaledInstance(15, 15,Image.SCALE_DEFAULT);
			ImageIcon scaledEdit = new ImageIcon(scaleedit);
			
			ImageIcon IconDelete = new ImageIcon("images/delete.jpg");
			Image scaledelete = IconDelete.getImage().getScaledInstance(15, 15,Image.SCALE_DEFAULT);
			ImageIcon scaledDelete = new ImageIcon(scaledelete);
			
			edit.add(edEdit);
			edit.addSeparator();
			edit.add(edDelete);
			
			edEdit.setIcon(scaledEdit);
			edDelete.setIcon(scaledDelete);
			
			JMenuItem heHelp = new JMenuItem("Help");
			JMenuItem heAbout = new JMenuItem("About");
			
			heHelp.setAccelerator(KeyStroke.getKeyStroke('L',MenuKeyEvent.CTRL_DOWN_MASK));
			heHelp.setMnemonic(KeyEvent.VK_L);
			heAbout.setAccelerator(KeyStroke.getKeyStroke('A',MenuKeyEvent.CTRL_DOWN_MASK));
			heAbout.setMnemonic(KeyEvent.VK_A);
			
			ImageIcon IconHelp = new ImageIcon("images/help.jpg");
			Image scalehelp = IconHelp.getImage().getScaledInstance(15, 15,Image.SCALE_DEFAULT);
			ImageIcon scaledHelp = new ImageIcon(scalehelp);
			
			ImageIcon IconAbout = new ImageIcon("images/about.jpg");
			Image scaleabout = IconAbout.getImage().getScaledInstance(14, 14,Image.SCALE_DEFAULT);
			ImageIcon scaledAbout = new ImageIcon(scaleabout);
			
			help.add(heHelp);
			help.addSeparator();
			help.add(heAbout);

			heHelp.setIcon(scaledHelp);
			heAbout.setIcon(scaledAbout);
			
			add(file);
			add(edit);
			add(help);
		}
		

	}


