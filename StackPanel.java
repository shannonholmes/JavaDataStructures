import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Shows Stack data structure through graphics and information
 * 
 * @author shannonholmes
 *
 */
public class StackPanel extends Panel
{
	//always consider exceptions when developing this class - e.g. nothing to pop on stack
	
	private static String [] content = new String [] {};
	private String peekVal;
	private JLabel peekLbl;
	private JTextField input;
	
	StackPanel()
	{
		super(); 
		//Buttons for Stack functionality
		JButton push = new JButton("Push");
		JButton pop = new JButton("Pop");
		JButton peek = new JButton("Peek");
		
		//input text field
		input = new JTextField();
		JLabel inputLbl = new JLabel("Enter something: ");
		
		//panels for border layout in ops panel
		JPanel buttonPanel = new JPanel();
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout());
		
		buttonPanel.add(push);
		buttonPanel.add(pop);
		buttonPanel.add(peek);
		
		push.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 push();

			 }
		});
		
		pop.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 try 
				 {
					pop();
				}
				catch (EmptyStack e1) 
				{
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}

			 }
		});
		
		peek.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 try 
				 {
					peek();
				 } 
				 catch (EmptyStack e1) 
				 {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			 }
		});
		
		inputPanel.add(inputLbl, BorderLayout.NORTH);
		inputPanel.add(input, BorderLayout.CENTER);
		
		ops.add(buttonPanel, BorderLayout.WEST);
		ops.add(inputPanel, BorderLayout.SOUTH);

	}



	@Override
	public String getInformation() 
	{
		return "A stack is a data structure capable of 'holding' items in a last in first out (LIFO) manner. \n"
				+ "Adding an item to the stack is called 'pushing', removing is called 'popping' and viewing the \n"
				+ "top item on the stack is called 'peeking'.";
	}
	
	/**
	 * Adds an item onto the stack
	 */
	public void push()
	{			
		// extend array size by 1
		content = Arrays.copyOf(content, content.length + 1);
		
		// add a new value to end of the array
		content[content.length-1] = input.getText();
		
		// update the panel content		
		graphics.setContent(content);
	}
	
	/**
	 * Removes an item from the stack
	 * 
	 * @throws EmptyStack When user tries to remove an item from an empty stack
	 */
	public void pop() throws EmptyStack 
	{		
		if(content.length > 0)
		{
			// decrement array size by 1
			content = Arrays.copyOf(content, content.length - 1);
			
			// update the panel content		
			graphics.setContent(content);
		}
		else
		{
			throw new EmptyStack();
		}
	}
	
	/**
	 * Shows the item at the top of the stack
	 * 
	 * @throws EmptyStack When user tries to display item from an empty stack 
	 */
	public void peek() throws EmptyStack 
	{
		if(content.length > 0)
		{
			peekVal = (content[content.length - 1]);
			JOptionPane.showMessageDialog(null, "The value on the top of the stack is ' " + peekVal + " '", "Peek", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			throw new EmptyStack();
		}
		

		
	}
}
