package model;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Item> inventory;
	private List<Member> members;
	
	public Library()
	{
		inventory = new ArrayList<Item>();
		members = new ArrayList<Member>();
	}
	
	public void addItem(Item item)
	{
		inventory.add(item);
	}
	
	public void addMember(Member member)
	{
		members.add(member);
	}
}
