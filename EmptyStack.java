/**
 * Exception thrown when stack is empty and user attempts to pop / peek
 * 
 * @author shannonholmes
 *
 */
public class EmptyStack extends Exception
{

	/**
	 * Passes error message to Exception class, to output in getMessage catch
	 *  when Stack is empty and user attempts to pop
	 *  
	 * @param msg The exception error message
	 */
	public EmptyStack() 
	{
		//creates a message to display when the stack is empty
		super("The stack is empty");
	}
}
