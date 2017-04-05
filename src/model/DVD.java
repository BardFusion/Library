package model;

public class DVD extends Item{
	private MovieCategory category;
	
	public DVD(String name, int code, MovieCategory category)
	{
		super(name, code);
		this.category = category;
	}
}
