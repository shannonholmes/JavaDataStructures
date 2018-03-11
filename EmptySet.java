
public class EmptySet extends Exception 
{

	/**
	 * Constructor called when set is empty and user attempts to access
	 */
	EmptySet()
	{
		super("The set is empty");
	}
}
