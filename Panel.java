import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.RootPaneContainer;
/**
 * Creates content layout in panels for each data structure
 * 
 * @author shannonholmes
 *
 */
public abstract class Panel extends JPanel
{
	/**
	 * Operation, information and graphics panels
	 */
	JPanel ops, info;
	GraphicPanel graphics;
	
	/**
	 *  Creates the three necessary panels for each Data Structure:
	 *  Operations, Graphics and Information
	 */
	public Panel() 
	{				
		/* Three panels made to contain operations for user, 
		 * information on data structures, and graphically represent the structure.
		 */
		ops = new JPanel();
		info = new JPanel();
		graphics = new GraphicPanel(graphics);
		
		/**
		 * Contains the information about the Data Structure
		 */
		JTextArea infoArea = new JTextArea(getInformation());
		
	    this.setLayout(new BorderLayout());
		
		//CONTENT LAYOUT 
	    JLabel lbl1 = new JLabel("Operations");
	    JLabel lbl2 = new JLabel("Graphics");
	    JLabel lbl3 = new JLabel("Information");
	    
	    this.setLayout(new BorderLayout());
	    
	    lbl1.setBorder(BorderFactory.createLineBorder(Color.black));
	    lbl2.setBorder(BorderFactory.createLineBorder(Color.black));
	    lbl3.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    ops.setBorder(BorderFactory.createLineBorder(Color.black));
	    graphics.setBorder(BorderFactory.createLineBorder(Color.black));
	    info.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    info.setLayout(new BorderLayout());
	    ops.setLayout(new BorderLayout());
	    graphics.setLayout(new BorderLayout());

	    info.add(infoArea, BorderLayout.CENTER);
	    
	    this.add(ops, BorderLayout.WEST);
	    this.add(graphics, BorderLayout.CENTER);
	    this.add(info, BorderLayout.SOUTH);
		    ops.add(lbl1, BorderLayout.NORTH);
		    graphics.add(lbl2, BorderLayout.NORTH);
		    info.add(lbl3, BorderLayout.NORTH);
	    
		/*
		 * Borders are added to each panel to create a clear layout structure
		 */
	    this.setBorder(BorderFactory.createLineBorder(Color.black));

	}

	/**
	 * Gets the relevant information to describe the Data Structure
	 * 
	 * @return the relevant information to describe the Data Structure
	 */
	public abstract String getInformation();

}
		
