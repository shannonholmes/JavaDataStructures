import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Shows List data structure through graphics and information
 * 
 * @author shannonholmes
 *
 */
public class ListPanel extends Panel
{
	private JTextField input, indexField;
	private String firstVal, lastVal;
	private LinkedList<String> list = new LinkedList<String>();

	/**
	 * Constructor
	 */
	ListPanel()
	{
		
		
		super();
		
		//Buttons for List functionality
		JButton insert = new JButton("Insert");
		JButton insertIndex = new JButton("Insert at index");
		JButton remove = new JButton("Remove at Front");
		JButton removeEnd = new JButton("Remove at End");
		JButton removeIndex = new JButton("Remove at Index");
		JButton first = new JButton("First");
		JButton last = new JButton("Last");
		JButton clear = new JButton("Clear");
		JButton contains = new JButton("Check item is in List");
		
		
		//input text field
		input = new JTextField();
		JLabel inputLbl = new JLabel("Enter something: ");
		
		//text field to choose index to insert
		indexField = new JTextField();
		JLabel indexLbl = new JLabel("Enter an index position to insert/remove at: ");
				
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 2));
		
		JPanel inputPanel1 = new JPanel();
		inputPanel1.setLayout(new BorderLayout());
		JPanel inputPanel2 = new JPanel();
		inputPanel2.setLayout(new BorderLayout());
				
		buttonPanel.add(insert);
		buttonPanel.add(insertIndex);
		buttonPanel.add(remove);
		buttonPanel.add(removeEnd);
		buttonPanel.add(removeIndex);
		buttonPanel.add(first);
		buttonPanel.add(last);
		buttonPanel.add(clear);
		buttonPanel.add(contains);
		

		
		insert.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 insert();

			 }
		});
		
		remove.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 try 
				 {
					remove();
				}
				catch (EmptyList e1) 
				{
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}

			 }
		});

		removeIndex.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 try 
				 {
					removeIndex();
				}
				catch (EmptyList e1) 
				{
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}

			 }
		});
		
		removeEnd.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 try 
				 {
					removeEnd();
				}
				catch (EmptyList e1) 
				{
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}

			 }
		});
		
		first.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 try 
				 {
					first();
				 } 
				 catch (EmptyList e1) 
				 {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			 }
		});
		
		last.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 try 
				 {
					last();
				 } 
				 catch (EmptyList e1) 
				 {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			 }
		});
		
		insertIndex.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 insertIndex();

			 }
		});
		
		contains.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 try 
				 {
					contains();
				}
				catch (EmptyList e1) 
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
				catch (EmptyList e1) 
				{
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}

			 }
		});
		
		inputPanel1.add(inputLbl, BorderLayout.NORTH);
		inputPanel1.add(input, BorderLayout.CENTER);
		inputPanel2.add(indexLbl, BorderLayout.NORTH);
		inputPanel2.add(indexField, BorderLayout.CENTER);
		
		ops.add(buttonPanel, BorderLayout.NORTH);
		ops.add(inputPanel1, BorderLayout.CENTER);
		ops.add(inputPanel2, BorderLayout.SOUTH);

	}

	/**
	 * Removes an item from the list at an indexed point given by the user
	 * 
	 * @throws EmptyList if user tried to remove item from empty list
	 */
	protected void removeIndex() throws EmptyList
	{
		
		if(list.size() > 0)
		{
			if(!indexField.equals(null))
			{
				
				int i;
				//add user input to list at indexed point
				try
				{
					list.remove(i = Integer.parseInt(indexField.getText()));
				}
				catch (IndexOutOfBoundsException | NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Enter a valid index number to remove at", "Error", JOptionPane.ERROR_MESSAGE);
	
				}
				
				//convert queue to array to send to panel and display content 
				String[] listQ = list.toArray(new String[0]);
					
				//update panel
				graphics.setContent(listQ);
			}
			else
				JOptionPane.showMessageDialog(null, "Enter an index to remove from", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null, "The list isn't big enough to remove from this point yet", "Error", JOptionPane.ERROR_MESSAGE);
		
		
	}

	/**
	 * Removes item from the end of the lsit
	 * 
	 * @throws EmptyList if user tries to remove an item from empty list
	 */
	protected void removeEnd() throws EmptyList
	{
		if(list.size() > 0)
		{
			list.remove(list.getLast());
			
			//convert queue to array to send to panel and display content 
			String[] listQ = list.toArray(new String[0]);

			//update the panel content		
			graphics.setContent(listQ);
		}
		else
		{
			throw new EmptyList();
		}		
	}

	/**
	 * Removes item from list
	 * 
	 * @throws EmptyList if list is empty and user tries to remove
	 */
	protected void remove() throws EmptyList
	{
		if(list.size() > 0)
		{
			list.remove(list.element());
			
			//convert queue to array to send to panel and display content 
			String[] listQ = list.toArray(new String[0]);

			//update the panel content		
			graphics.setContent(listQ);
		}
		else
		{
			throw new EmptyList();
		}		
	}

	/**
	 * Inserts item at user inputted index point of list
	 */
	protected void insertIndex()
	{
		if(list.size() > 0)
		{
			if(!indexField.equals(null))
			{
				
				int i;
				//add user input to list at indexed point
				try
				{
					list.add(i = Integer.parseInt(indexField.getText()),input.getText());
				}
				catch (IndexOutOfBoundsException | NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Enter a valid index number to insert at", "Error", JOptionPane.ERROR_MESSAGE);
	
				}
				
				//convert queue to array to send to panel and display content 
				String[] listQ = list.toArray(new String[0]);
					
				//update panel
				graphics.setContent(listQ);
			}
			else
				JOptionPane.showMessageDialog(null, "Enter an index to insert", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null, "The list isn't big enough to insert at this point yet", "Error", JOptionPane.ERROR_MESSAGE);
		
	}

	/**
	 * Displays last item in list
	 * 
	 * @throws EmptyList if list is empty and user tries to view items
	 */
	protected void last() throws EmptyList 
	{
		if(list.size() > 0)
		{
			lastVal = list.getLast();
			JOptionPane.showMessageDialog(null, "The value at the end of the list is ' " + lastVal + " '", "Last", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			throw new EmptyList();
		}
	}

	/**
	 * Displays first item in list
	 * 
	 * @throws EmptyList if list is empty and user tries to view items
	 */
	protected void first() throws EmptyList
	{
		if(list.size() > 0)
		{
			firstVal = list.getFirst();
			JOptionPane.showMessageDialog(null, "The value at the top of the list is ' " + firstVal + " '", "First", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			throw new EmptyList();
		}		
	}

	/**
	 * Inserts item into list
	 */
	protected void insert() 
	{
		//add user input to list
		list.add(input.getText());
		
		//convert queue to array to send to panel and display content 
		String[] listQ = list.toArray(new String[0]);
			
		//update panel
		graphics.setContent(listQ);
		
	}
	
	/**
	 * Checks if List contains user defined value
	 * 
	 * @throws EmptyList if user tries to access an item from empty List
	 */
	protected void contains() throws EmptyList
	{
		if(list.size() > 0)
		{
			if(list.contains(input.getText()))
			{
				JOptionPane.showMessageDialog(null, "This value already exists in the List", "Info", JOptionPane.ERROR_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null, "The List doesn't contain this value", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			throw new EmptyList();
		}
		
	}
	

	/**
	 * Clears all elements from List
	 * 
	 * @throws EmptyList if user tries to remove items from empty List
	 */
	protected void clear() throws EmptyList
	{
		input.setText("");
		indexField.setText("");
		
		if(list.size() > 0)
		{
			list.clear();
		
			//convert set to array to send to panel and display content 
			String[] listQ = list.toArray(new String[0]);
				
			//update panel
			graphics.setContent(listQ);
		}
		else
			throw new EmptyList();
	}

	
	@Override
	public String getInformation() 
	{
		// TODO Auto-generated method stub
		return "A List is an abstract data type capable of storing elements in an ordered structure. \n"
				+ "The same value may occur more than once. It can be described as a variable containing \n"
				+ "multiple variables. A list can be considered similar to an array. \n"
				+ "A linked list is a series of items linked together using pointers. \n"
				+ "Each item can be a pointer to 'point' to a variable stored in memory.\n"
				+ "Items can be added or removed to any part of the list easily due to the use of pointers.";
	}

}
