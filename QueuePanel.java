import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Shows Queue data structure through graphics and information
 * 
 * @author shannonholmes
 *
 */
public class QueuePanel extends Panel
{
	private JTextField input;
	private String frontVal, backVal;
	
	private Queue<String> queue = new LinkedList<String>();

	/**
	 * Queue Panel constructor
	 */
	QueuePanel()
	{
		super(); 
		//Buttons for Queue functionality
		JButton enqueue = new JButton("Enqueue");
		JButton dequeue = new JButton("Dequeue");
		JButton front = new JButton("Front");
		JButton back = new JButton("Back");
		JButton clear = new JButton("Clear");
		
		//input text field
		input = new JTextField();
		JLabel inputLbl = new JLabel("Enter something: ");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 2));
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout());
		
		buttonPanel.add(enqueue);
		buttonPanel.add(dequeue);
		buttonPanel.add(front);
		buttonPanel.add(back);
		buttonPanel.add(clear);
		
		enqueue.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 enqueue();

			 }
		});
		
		dequeue.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 try 
				 {
					dequeue();
				}
				catch (EmptyQueue e1) 
				{
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}

			 }
		});
		
		front.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 try 
				 {
					front();
				 } 
				 catch (EmptyQueue e1) 
				 {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			 }
		});
		
		back.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 try 
				 {
					back();
				 } 
				 catch (EmptyQueue e1) 
				 {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			 }
		});
		
		clear.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 try 
				 {
					clear();
				}
				catch (EmptyQueue e1) 
				{
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}

			 }
		});
		
		inputPanel.add(inputLbl, BorderLayout.NORTH);
		inputPanel.add(input, BorderLayout.CENTER);
		
		ops.add(buttonPanel, BorderLayout.NORTH);
		ops.add(inputPanel, BorderLayout.SOUTH);
		
		
	}

	/**
	 * Returns item from back of Queue
	 */
	protected void back() throws EmptyQueue
	{
		if(queue.size() > 0)
		{
			backVal = ((LinkedList<String>) queue).peekLast();
			JOptionPane.showMessageDialog(null, "The value at the back of the queue is ' " + backVal + " '", "Back", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			throw new EmptyQueue();
		}
		
	}

	@Override
	public String getInformation() 
	{
		return "A queue is an abstract data type that use a First In First Out (FIFO) structure.\n"
				+ "A queue adds items to the 'rear' and removes items from the 'front': \n"
				+ "The first element added to the queue will be the first one to be removed.\n"
				+ "A queue uses the same concept as a real-life queue for a checkout at a \n"
				+ "supermarket, post office, etc.";
	}

	/**
	 * Adds a new item to the queue
	 */
	public void enqueue() 
	{		
		//add content to queue
		queue.add(input.getText());
			
		//convert queue to array to send to panel and display content 
		String[] arrayQ = queue.toArray(new String[0]);
			
		//update panel
		graphics.setContent(arrayQ);

	}	
	
	/**
	 * Removes an item from the front of the queue
	 * 
	 * @throws EmptyQueue When the queue is empty and user attempts to remove an item 
	 */
	public void dequeue() throws EmptyQueue
	{		
		
		if(queue.size() > 0)
		{
			queue.remove(queue.element());
			
			//convert queue to array to send to panel and display content 
			String[] arrayQ = queue.toArray(new String[0]);

			//update the panel content		
			graphics.setContent(arrayQ);
		}
		else
		{
			throw new EmptyQueue();
		}
	}
	
	/**
	 * Displays the item at the front of the queue
	 * 
	 * @throws EmptyQueue When the queue is empty and user attempts to show an item in the queue
	 */
	public void front() throws EmptyQueue 
	{
		if(queue.size() > 0)
		{
			frontVal = queue.peek();
			JOptionPane.showMessageDialog(null, "The value at the front of the queue is ' " + frontVal + " '", "Front", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			throw new EmptyQueue();
		}
	
	}
	
	/**
	 * Clears all elements from Queue
	 * 
	 * @throws EmptyQueue if user tries to remove items from empty Queue
	 */
	protected void clear() throws EmptyQueue
	{
		input.setText("");
		
		if(queue.size() > 0)
		{
			queue.clear();
		
			//convert set to array to send to panel and display content 
			String[] queueQ = queue.toArray(new String[0]);
				
			//update panel
			graphics.setContent(queueQ);
		}
		else
			throw new EmptyQueue();
	}
	
}
