package model;

import java.util.ArrayList;
import java.util.List;

public class Member extends User{
	private String address;
	private List<Item> posession;
	
	public Member(String name, String address)
	{
		super(name);
		
		this.address = address;		
		posession = new ArrayList<Item>();
	}
	
	public void addItem(Item item)
	{
		posession.add(item);
	}
	
	public void removeItem(Item item)
	{
		posession.remove(item);
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public List<Item> getPosession()
	{
		return posession;
	}
}
