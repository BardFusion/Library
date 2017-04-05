package model;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private String name;
	private String address;
	private List<Item> posession;
	
	public Member(String name, String address)
	{
		this.name = name;
		this.address = address;
		
		posession = new ArrayList<Item>();
	}
}
