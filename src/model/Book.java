package model;

public class Book extends Item{
	private BookType type;
	
	public Book(int code, BookType type)
	{
		super(code);
		
		this.type = type;
	}
}
