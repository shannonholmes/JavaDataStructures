import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

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
public class SetPanel extends Panel
{
	
	private JTextField input;
	private LinkedList<String> set = new LinkedList<String>();
	
	/**
	 * Constructor for Set panel
	 * 
	 */
	SetPanel()
	{
		super();
		
		//Buttons for Set functionality
		JButton insert = new JButton("Insert");
		JButton remove = new JButton("Remove");
		JButton contains = new JButton("Check element exists");
		JButton iterate = new JButton("Iterate");
		JButton clear = new JButton("Clear");
		JButton size = new JButton("Size");
		JButton empty = new JButton("Check if empty");

		//input text field
		input = new JTextField();
		JLabel inputLbl = new JLabel("Enter something: ");
				
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 2));
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout());
				
		buttonPanel.add(insert);
		buttonPanel.add(remove);
		buttonPanel.add(contains);
		buttonPanel.add(iterate);
		buttonPanel.add(clear);
		buttonPanel.add(size);
		buttonPanel.add(empty);
		
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
				catch (EmptySet e1) 
				{
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}

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
				catch (EmptySet e1) 
				{
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}

			 }
		});
		
		iterate.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 try 
				 {
					iterate();
				}
				catch (EmptySet e1) 
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
				 catch (EmptySet e1) 
				 {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				 }

			 }
		});
		
		size.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 try 
				 {
					checkSize();
				 } 
				 catch (EmptySet e1) 
				 {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				 }

			 }
		});
		
		empty.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 try 
				 {
					empty();
				 } 
				 catch (EmptySet e1) 
				 {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				 }

			 }
		});
		
		inputPanel.add(inputLbl, BorderLayout.WEST);
		inputPanel.add(input, BorderLayout.SOUTH);

		ops.add(buttonPanel, BorderLayout.NORTH);
		ops.add(inputPanel, BorderLayout.SOUTH);

		
	}
	
	/**
	 * Insert item into Set
	 */
	protected void insert() 
	{
		if(!set.contains(input.getText()))
		{
			//add user input to list
			set.add(input.getText());
			
			//convert queue to array to send to panel and display content 
			String[] setQ = set.toArray(new String[0]);
				
			//update panel
			graphics.setContent(setQ);	
		}
		
		else
			JOptionPane.showMessageDialog(null, "This value is already a member in the set", "Error", JOptionPane.ERROR_MESSAGE);

	}

	/**
	 * Insert item into Set at index point
	 */
	/*
	protected void insertIndex() 
	{
		if(set.size() > 0)
		{
			if(!indexField.equals(null))
			{
				if(!set.contains(input.getText()))
				{
					int i;
					//add user input to set at indexed point
					try
					{
						set.add(i = Integer.parseInt(indexField.getText()),input.getText());
					}
					catch (NumberFormatException e)
					{
						JOptionPane.showMessageDialog(null, "Enter a valid index number to insert at", "Error", JOptionPane.ERROR_MESSAGE);
		
					}
					
					//convert set to array to send to panel and display content 
					String[] setQ = set.toArray(new String[0]);
						
					//update panel
					graphics.setContent(setQ);
				}
				else
					JOptionPane.showMessageDialog(null, "This value is already a member in the set", "Error", JOptionPane.ERROR_MESSAGE);

			}
			else
				JOptionPane.showMessageDialog(null, "Enter an index to insert", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null, "The set isn't big enough to insert at this point yet", "Error", JOptionPane.ERROR_MESSAGE);
				
	}
	*/

	/**
	 * Remove item from Set
	 * 
	 * @throws EmptySet if user tries to remove item from empty Set
	 */
	protected void remove() throws EmptySet
	{

		
		if(set.size() > 0)
		{
			set.remove(set.element());
			
			//convert queue to array to send to panel and display content 
			String[] setQ = set.toArray(new String[0]);

			//update the panel content		
			graphics.setContent(setQ);
			
		}
		else
		{
			throw new EmptySet();
		}		
	}

	/**
	 * Removes item from Set at index point 
	 * 
	 * @throws EmptySet if user tries to remove item from empty Set
	 */
	/*
	protected void removeIndex() throws EmptySet
	{
		if(set.size() > 0)
		{
			if(!indexField.equals(null))
			{
				
				int i;
				//remove element at user input index point from set
				try
				{
					set.remove(i = Integer.parseInt(indexField.getText()));
				}
				catch (IndexOutOfBoundsException | NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Enter a valid index number to remove at", "Error", JOptionPane.ERROR_MESSAGE);
	
				}
				
				//convert set to array to send to panel and display content 
				String[] setQ = set.toArray(new String[0]);
					
				//update panel
				graphics.setContent(setQ);
			}
			else
				JOptionPane.showMessageDialog(null, "Enter an index to remove from", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null, "The set isn't big enough to remove from this point yet", "Error", JOptionPane.ERROR_MESSAGE);
				
	}
	*/

	/**
	 * Checks if Set contains user defined value
	 * 
	 * @throws EmptySet if user tries to access an item from empty Set
	 */
	protected void contains() throws EmptySet
	{
		if(set.size() > 0)
		{
			if(set.contains(input.getText()))
			{
				JOptionPane.showMessageDialog(null, "This value already exists in the Set", "Warning", JOptionPane.ERROR_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null, "The set doesn't contain this value, you can insert it!", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			throw new EmptySet();
		}
		
	}

	/**
	 * Iterates through existing Set
	 * 
	 * @throws EmptySet if user tries to iterate items from empty Set
	 */
	protected void iterate() throws EmptySet
	{
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "The elements of this set in interation: \n" + set.iterator(), "Info", JOptionPane.INFORMATION_MESSAGE);
		
	}

	/**
	 * Clears all elements from Set
	 * 
	 * @throws EmptySet if user tries to remove items from empty Set
	 */
	protected void clear() throws EmptySet
	{
		input.setText("");
		
		if(set.size() > 0)
		{
			set.clear();
		
			//convert set to array to send to panel and display content 
			String[] setQ = set.toArray(new String[0]);
				
			//update panel
			graphics.setContent(setQ);
		}
		else
			throw new EmptySet();
	}

	/**
	 * Returns size of Set
	 * 
	 * @throws EmptySet if user tries to access items from empty Set
	 */
	protected void checkSize() throws EmptySet
	{
		if(set.size() > 0)
		{
			JOptionPane.showMessageDialog(null, "The number of elements in the Set = " + set.size(), "Info", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			throw new EmptySet();
		
	}

	/**
	 * Checks if Set is empty 
	 */
	protected void empty() throws EmptySet
	{
		if(set.size() > 0)
			JOptionPane.showMessageDialog(null, "The set isn't empty", "Info", JOptionPane.INFORMATION_MESSAGE);
		else
			throw new EmptySet();

	}

	@Override
	public String getInformation() 
	{
		return "A Set is a data type capable of storing elements in no particular order. \n"
				+ "A set has no repeated values, so often requires a 'check' when adding elements,\n"
				+ "to see if the value already exists in the set. Sets don't store elements in a \n"
				+ "particular order, iterators can be used to return elements from the set in no specific \n"
				+ "order. Elements are added to the set as the user chooses, for example, an index point can\n"
				+ "be specified.";
	}

	
}
