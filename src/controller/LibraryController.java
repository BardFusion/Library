package controller;

import java.util.ArrayList;
import java.util.List;

import model.Library;
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
	
//	public List<String> getUserNames()
//	{
//		List<String> userNames = new ArrayList<String>();
//		
//		for (User user : library.getUsers())
//		{
//			userNames.add(user.getName());
//		}
//		
//		return userNames;
//	}
	
	public List<User> getUsers()
	{
		return library.getUsers();
	}
}
