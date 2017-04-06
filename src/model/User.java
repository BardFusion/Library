package model;

public abstract class User {
	private String name;
	
	public User(String name)
	{
		if (this instanceof Librarian)
		{
			this.name = "Librarian " + name;
		}
		else if (this instanceof Member)
		{
			this.name = "Member " + name;
		}
		else
		{
			this.name = "Unknown " + name;
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override 
	public String toString()
	{
		return name;
	}
}
