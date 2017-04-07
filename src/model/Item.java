package model;

public abstract class Item {
	private String name;
	private int code;
	private int count;
	
	public Item(String name, int code)
	{
		this.name = name;
		this.code = code;
		count = 1;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void incrementCount()
	{
		count += 1;
	}
	
	public void decrementCount()
	{
		count -= 1;
	}
	
	@Override
	public String toString()
	{
		if (this instanceof Book)
		{
			return "Book " + code + ": " + name;
		}
		else if (this instanceof DVD)
		{
			return "DVD " + code + ": " + name;
		}
		else if (this instanceof CD)
		{
			return "CD " + code + ": " + name;
		}
		else
		{
			return "Unknown " + code + ": " + name;
		}
	}
}
