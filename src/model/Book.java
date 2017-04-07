package model;

public class Book extends Item{
	private BookType type;
	
	public Book(String name, int code, BookType type)
	{
		super(name, code);
		
		this.type = type;
	}
	
	public void setType(BookType type)
	{
		this.type = type;
	}
	
	public BookType getType()
	{
		return type;
	}
}
