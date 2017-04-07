package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Library {
	private List<Item> inventory;
	private List<User> users;
	
	private int itemIDCounter;
	
	public Library()
	{
		inventory = new ArrayList<Item>();
		users = new ArrayList<User>();
		
		itemIDCounter = 1000;
	}
	
	public List<User> getUsers()
	{
		return users;
	}
	
	public List<Item> getItems()
	{
		return inventory;
	}
	
	public void addBook(String name, BookType type)
	{
		inventory.add(new Book(name, itemIDCounter, type));
		itemIDCounter += 1;
	}
	
	public void addDVD(String name, MovieCategory category)
	{
		inventory.add(new DVD(name, itemIDCounter, category));
		itemIDCounter += 1;
	}
	
	public void addCD(String name, MusicGenre genre)
	{
		inventory.add(new CD(name, itemIDCounter, genre));
		itemIDCounter += 1;
	}
	
	public void incrementItem(Item item)
	{
		inventory.get(inventory.indexOf(item)).incrementCount();
	}
	
	public void decrementItem(Item item)
	{
		inventory.get(inventory.indexOf(item)).decrementCount();
	}
	
	public void removeItem(Item item)
	{
		inventory.remove(item);
	}
	
	public void addLibrarian(String name)
	{
		users.add(new Librarian(name));
	}
	
	public void addMember(String name, String address)
	{
		users.add(new Member(name, address));
	}
	
	public void removeMember(Member member)
	{
		users.remove(member);
	}
	
	public double getAmountToPay(Item item, Date borrowedDate, Date returnDate)
	{
		double amountToPay = 0;
		long timeDifference = returnDate.getTime() - borrowedDate.getTime();
	    long daysBorrowed = TimeUnit.DAYS.convert(timeDifference, TimeUnit.MILLISECONDS);
		
		if (item instanceof Book)
		{
			Book book = (Book)item;
			if (book.getType() == BookType.NOVEL)
			{
				if (daysBorrowed > 21)
				{
					amountToPay += 0.25 * (daysBorrowed - 21);
				}
			}
			else if (book.getType() == BookType.TEXTBOOK)
			{
				if (daysBorrowed > 30)
				{
					amountToPay += 1 * (daysBorrowed - 30);
				}
			}
		}
		else if (item instanceof DVD)
		{
			DVD dvd = (DVD)item;
			if (dvd.getCategory() == MovieCategory.A)
			{
				amountToPay += 3 * daysBorrowed;
			}
			else if (dvd.getCategory() == MovieCategory.B)
			{
				amountToPay += 2 * (daysBorrowed / 3);
				amountToPay += + 1 * daysBorrowed;
			}
		}
		else if (item instanceof CD)
		{
			CD cd = (CD)item;
			if (cd.getGenre() == MusicGenre.CLASSICAL)
			{
				amountToPay += 2;
				if (daysBorrowed > 10)
				{
					amountToPay += 1.50 * ((daysBorrowed - 10) / 7);
				}
			}
			else if (cd.getGenre() == MusicGenre.POPULAR)
			{
				amountToPay += 1;
				if (daysBorrowed > 10)
				{
					amountToPay += 2 * ((daysBorrowed - 10) / 7);
				}
			}
		}		
		
		return amountToPay;
	}
}
