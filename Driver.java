import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;

/**
 * Driver class for SE Assignment
 * 
 * @author shannonholmes
 *
 */
public class Driver 
{

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Assignment");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		/* Creates an object of the menu bar class,
		 * to allow the menu bar to be set to this frame
		 */
		JMenuBar menu = new MyMenubar();
		frame.setJMenuBar(menu);
		
		frame.validate();
		frame.repaint();
		
		//Creates a tabbed pane which is then added to the frame
		JTabbedPane tp = new JTabbedPane();
	      tp.addTab("Stack", null, new StackPanel(), "Stack");
	      tp.addTab("Queue", null, new QueuePanel(), "Queue");
	      tp.addTab("List", null, new ListPanel(), "List");
	      tp.addTab("Set", null, new SetPanel(), "Set");
	      tp.addTab("Tree", null, new TreePanel(), "Tree");
	      
	    frame.getContentPane().add(tp);
		
	    frame.setPreferredSize(new Dimension(800, 800));
	    frame.pack();
	    frame.setVisible(true);
	}

}
