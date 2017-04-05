package model;

public class DVD extends Item{
	private MovieCategory category;
	
	public DVD(int code, MovieCategory category)
	{
		super(code);
		this.category = category;
	}
}
