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
}
