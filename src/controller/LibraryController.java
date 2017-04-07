package controller;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.BookType;
import model.CD;
import model.DVD;
import model.Item;
import model.Library;
import model.Member;
import model.MovieCategory;
import model.MusicGenre;
import model.User;

public class LibraryController {
	private Library library;
	
	public LibraryController()
	{
		library = new Library();
		
		library.addLibrarian("John");
		library.addMember("Alex", "HappyStreet 52");
		library.addMember("Mark", "Streetlane 122");
	}
	
	public List<User> getUsers()
	{
		return library.getUsers();
	}
	
	public List<Item> getItems()
	{
		return library.getItems();
	}
	
	public List<Member> getMembers()
	{
		List<Member> members = new ArrayList<Member>();
		
		for (User user : getUsers())
		{
			if (user instanceof Member)
			{
				members.add((Member)user);
			}
		}
		
		return members;
	}
	
	public void addMember(String name, String address)
	{
		library.addMember(name, address);
	}
	
	public void removeMember(Member member)
	{
		library.removeMember(member);
	}
	
	public void addBook(String name, BookType type)
	{
		library.addBook(name, type);
	}
	
	public void addDVD(String name, MovieCategory category)
	{
		library.addDVD(name, category);
	}
	
	public void addCD(String name, MusicGenre genre)
	{
		library.addCD(name, genre);
	}
	
	public void removeItem(Item item)
	{
		library.removeItem(item);
	}
	
	public void incrementItem(Item item)
	{
		library.incrementItem(item);
	}
	
	public void decrementItem(Item item)
	{
		library.decrementItem(item);
	}
	
	public double getAmountToPay(Member member, Item item)
	{
		return 10;
	}
}
