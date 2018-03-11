import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Creates menu bar for frame and adds functionality to menu bar items
 * 
 * @author shannonholmes
 *
 */
public class MyMenubar extends JMenuBar
{
	
	/**
	 * The constructor class to create the menu bar for the frame
	 */
	public MyMenubar()
	{
		/**
		 * A menu bar, a menu and menu items
		 */
		JMenu file = new JMenu("File");
		JMenuItem about = new JMenuItem("About");
		JMenuItem empty = new JMenuItem("Empty");
		JMenuItem exit = new JMenuItem("Exit");
		
		file.setMnemonic(KeyEvent.VK_F); //adds keyboard shortcuts to menus 
		file.getAccessibleContext().setAccessibleDescription
			("The File menu.");
			
		about.setMnemonic(KeyEvent.VK_A);
		about.getAccessibleContext().setAccessibleDescription
			("Some information about this program.");
		about.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						//calls dialogue method to display dialogue box when clicked
						aboutDialogue();
					}
				});
		file.add(about);
		
		empty.setMnemonic(KeyEvent.VK_C);
		empty.getAccessibleContext().setAccessibleDescription
			("To empty the currently displayed data structure.");
		empty.addActionListener(new ActionListener() //determines events on this menu item
		{
			public void actionPerformed(ActionEvent e) 
			{
				emptyCurrent();
			}
		});
		file.add(empty);
		
		file.addSeparator(); 
		
		exit.setMnemonic(KeyEvent.VK_X);
		exit.getAccessibleContext().setAccessibleDescription
			("To exit the program.");
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				exitProgram();
			}
		});
		file.add(exit);
		
		this.add(file);
		
	}

	/**
	 * Empties the currently displayed data structure
	 */
	public void emptyCurrent() 
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * Generates a dialog box with an 'about' message regarding how to use the application
	 */
	public void aboutDialogue() 
	{
		String about = "To use this application, please select an option \n"
				+ "from the tab menu to display"
				+ " some information about each data structure"; 
		JOptionPane.showMessageDialog(null, about, "About", JOptionPane.INFORMATION_MESSAGE);
		
	}

	/**
	 * Exits the program / closes application window
	 */
	public void exitProgram() 
	{
		System.exit(0);
	}


}
