package model;

public abstract class User {
	private String name;
	
	public User(String name)
	{
		this.name = name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override 
	public String toString()
	{
		if (this instanceof Librarian)
		{
			return "Librarian " + name;
		}
		else if (this instanceof Member)
		{
			return "Member " + name;
		}
		else
		{
			return "Unknown " + name;
		}
	}
}
