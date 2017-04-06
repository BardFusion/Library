package model;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Item> inventory;
	private List<User> users;
	
	public Library()
	{
		inventory = new ArrayList<Item>();
		users = new ArrayList<User>();
	}
	
	public List<User> getUsers()
	{
		return users;
	}
	
	public void addItem(Item item)
	{
		inventory.add(item);
	}
	
	public void addLibrarian(String name)
	{
		users.add(new Librarian(name));
	}
	
	public void addMember(String name, String address)
	{
		users.add(new Member(name, address));
	}
}
