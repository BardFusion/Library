package model;

import java.util.ArrayList;
import java.util.List;

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
}
