
public class EmptyTree extends Exception 
{
	/**
	 * Passes error message to Exception class, to output in getMessage catch
	 *  when Tree is empty and user attempts to pop
	 *  
	 * @param msg The exception error message
	 */
	public EmptyTree() 
	{
		//creates a message to display when the tree is empty
		super("The tree is empty");
	}
}
