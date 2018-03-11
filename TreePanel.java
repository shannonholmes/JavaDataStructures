import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.TreeNode;

/**
 * Shows Stack data structure through graphics and information
 * 
 * @author shannonholmes
 *
 */
public class TreePanel extends Panel
{
	private JTextField input;
	private HashMap<Integer, String> tree = new HashMap<Integer, String>();
	
	/**
	 * To increment through hashmap keys when adding to the map/tree 
	 */
	int click = 0;

	TreePanel()
	{
		super();
		
		//Buttons for Tree functionality
		JButton add = new JButton("Add");
		JButton remove = new JButton("Remove");
		JButton getParentNode = new JButton("Get Parent Node");
		JButton isLeaf = new JButton("Check if Item is Leaf");
		JButton clear = new JButton("Clear");
		
		//input text field
		input = new JTextField();
		JLabel inputLbl = new JLabel("Enter something: ");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 2));
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout());
		
		buttonPanel.add(add);
		buttonPanel.add(remove);
		buttonPanel.add(getParentNode);
		buttonPanel.add(isLeaf);
		buttonPanel.add(clear);
		
		add.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			 {
				 add();

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
				catch (EmptyTree e1) 
				{
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}

			 }
		});
	
	
	getParentNode.addActionListener(new ActionListener()
	{
		 public void actionPerformed(ActionEvent e) 
		 {
			 try 
			 {
				getParentNode();
			}
			catch (EmptyTree e1) 
			{
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

			}

		 }
	});
	
	isLeaf.addActionListener(new ActionListener()
	{
		 public void actionPerformed(ActionEvent e) 
		 {
			 try 
			 {
				isLeaf();
			}
			catch (EmptyTree e1) 
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
			catch (EmptyTree e1) 
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
	 * Returns the parent node of input value 
	 * 
	 * @throws EmptyTree if tree is empty 
	 */
	protected void getParentNode() throws EmptyTree
	{
	/*
		if(tree.size() == 0)
		{
			if(!input.getText().equals(null))
			{
				int num = Integer.parseInt(input.getText());
				
				if(tree.containsValue(num))
				{
					String[] treeAr = tree.values().toArray(new String[0]);
					for(int i=0; i < treeAr.length; i++)
					{
						int treeNums = Integer.parseInt(treeAr[i]);
						
						if(num < treeNums)
						{
							
						}
						else if(num > treeNums)
						{
							
						}
						else
							JOptionPane.showMessageDialog(null, "This value is a parent", "Info", JOptionPane.INFORMATION_MESSAGE);

					}
				}
			}
			else
				JOptionPane.showMessageDialog(null, "Please enter a valid value", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			throw new EmptyTree();
	*/
	}

	/**
	 * Checks if input value is a leaf on this tree
	 * 
	 * @throws EmptyTree if tree is empty 
	 */
	protected void isLeaf() throws EmptyTree
	{
		if(!tree.isEmpty())
		{
			if(tree.containsValue(input.getText()))
			{
				JOptionPane.showMessageDialog(null, "This value is a leaf in this tree", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null, "This value isn't a leaf in this tree", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			throw new EmptyTree();

	}

	/**
	 * Removes an item from the Tree
	 * 
	 * @throws EmptyTree if trying to remove from empty Tree
	 */
	protected void remove() throws EmptyTree
	{
		//remove item from tree
		tree.remove(input.getText());
		
		//convert hashmap to string array
		String[] treeAr = tree.values().toArray(new String[tree.size()-1]);
		
		//generate graphics through tree array
		graphics.setContent(treeAr);
		
	}

	/**
	 * Adds an item to the Tree
	 */
	protected void add() 
	{
		//add new item to hashmap
		tree.put(click, input.getText());
		
		//convert hashmap to string array
		String[] treeAr = tree.values().toArray(new String[click]);
		
		//increment 'click' to increment array/hashmap key
		click++;

		//generate graphics through tree array
		graphics.setContent(treeAr);
		
	}
	
	/**
	 * Clears all elements from Tree and input box 
	 * 
	 * @throws EmptyTree if user tries to remove items from empty Tree
	 */
	protected void clear() throws EmptyTree
	{
		input.setText("");
		
		if(tree.size() > 0)
		{
			tree.clear();
				
			String[] emptyArray = null;
			
			//update panel
			graphics.setContent(emptyArray);
		}
		else
			throw new EmptyTree();
	}

	
	@Override
	public String getInformation() 
	{
		// TODO Auto-generated method stub
		return "A Tree is a data structure storing elements to form a heirarchy with 'root' values and sub-child elements, without a 'cycle'.\n"
				+ "The elements are considered nodes linked together, the elements are added in no particular order.\n"
				+ "The parent nodes point to the child nodes, but child nodes don't need to point to parent nodes.\n"
				+ "Time Complexity for the given operations:\n"
				+ "- Clear: is constant, O(1). Determines a boolean value then continues onto statements.\n"
				+ "- Add: is constant, O(1). Statements are ran to add to a hashmap. \n"
				+ "- Remove: is constant, O(1). Statements are ran to remove from hashmap.\n"
				+ "- isLeaf: is linear, O(n). Checks for an item in a tree.";
	}

	
}
