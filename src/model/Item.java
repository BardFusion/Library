package model;

public abstract class Item {
	private String name;
	private int code;
	
	public Item(String name, int code)
	{
		this.name = name;
		this.code = code;
	}
}
