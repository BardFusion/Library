package model;

import java.util.PriorityQueue;

public abstract class Item {
	private String name;
	private int code;
	private int count;
	private PriorityQueue<Member> reservationList;
	
	public Item(String name, int code)
	{
		this.name = name;
		this.code = code;
		count = 2;
		reservationList = new PriorityQueue<Member>();
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void addToQueue(Member member)
	{
		reservationList.add(member);
	}
	
	public void removeFromQueue()
	{
		reservationList.remove();
	}
	
	public boolean checkQueue()
	{
		if(reservationList.isEmpty())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public Member returnFirstInQueue()
	{
		return reservationList.poll();
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void incrementCount()
	{
		count += 1;
	}
	
	public void decrementCount()
	{
		count -= 1;
	}
	
	@Override
	public String toString()
	{
		if (this instanceof Book)
		{
			return "Book " + code + ": " + name;
		}
		else if (this instanceof DVD)
		{
			return "DVD " + code + ": " + name;
		}
		else if (this instanceof CD)
		{
			return "CD " + code + ": " + name;
		}
		else
		{
			return "Unknown " + code + ": " + name;
		}
	}
}
