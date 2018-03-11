import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * A simple JPanel that paints the contents of a string array to the canvas as a vertical stack.
 * 
 * @author mdixon (& Shannon Holmes)
 */
@SuppressWarnings("serial")
public class GraphicPanel extends JPanel 
{

	/**
	 * The width of each displayed cell
	 */
	private final static int CELL_WIDTH = 100;
	
	/**
	 * The height of each displayed cell
	 */
	private final static int CELL_HEIGHT = 20;

	/**
	 * The content to be painted as a vertical stack of values.
	 */
	private String[] content;
	
	JPanel graphics;
	
	/**
	 * Constructor
	 */
	public GraphicPanel(JPanel graphics) 
	{
		//accesses graphics panel
		graphics = new JPanel();
		this.graphics = graphics;

		graphics.setPreferredSize(new Dimension(600, 300));
		graphics.setBackground(Color.white);
	}

	
	@Override
	protected void paintComponent(Graphics g) 
	{
		// this is called when the panel needs to be painted.
		
		super.paintComponent(g);

		// Calc the starting x,y position of the first cell
		int x = this.getWidth() / 2 - CELL_WIDTH / 2;
		int y = this.getHeight() - 10;

		if (content != null && content.length > 0) 
		{
			
			// iterate over each available string and paint it in a rectangular area
			for (int i = 0; i < content.length; i++) 
			{
				
				y = y - CELL_HEIGHT;	// move up one level
				
				g.drawRect(x, y, CELL_WIDTH, CELL_HEIGHT);
				g.drawString(content[i], x + CELL_WIDTH/2 - 10, y + 18);				
			}
		} 
		else 
		{
			// no content set
			g.drawString("No content available", x, y);
		}
	}

	
	/**
	 * Sets the current content.
	 * 
	 * @param content the array of string values to be painted
	 */
	public void setContent(String[] content) 
	{

		this.content = content;
		
		repaint();
	}

}