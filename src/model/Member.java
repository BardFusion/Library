package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Member extends User{
	private double money;
	private String address;
	private List<Item> posession;
	private List<Date> borrowingDates;
	private List<Item> outstandingReservations;
	private List<Date> reservationDates;
	
	public Member(String name, String address)
	{
		super(name);
		
		money = 500;
		this.address = address;		
		posession = new ArrayList<Item>();
		borrowingDates = new ArrayList<Date>();
		outstandingReservations = new ArrayList<Item>();
		reservationDates = new ArrayList<Date>();
	}
	
	public boolean hasReservationsReady()
	{
		return !outstandingReservations.isEmpty();
	}
	
	public void pay(double amount)
	{
		money -= amount;
	}
	
	public void addItem(Item item)
	{
		posession.add(item);
		borrowingDates.add(new Date());
	}
	
	public void addReadyReservation(Item item)
	{
		outstandingReservations.add(item);
		reservationDates.add(new Date());
	}
	
	public void removeReadyReservation(Item item)
	{
		reservationDates.remove(outstandingReservations.indexOf(item));
		outstandingReservations.remove(item);
	}
	
	public Date getReadyReservationDate(Item item)
	{
		return reservationDates.get(outstandingReservations.indexOf(item));
	}
	
	public void removeItem(Item item)
	{
		borrowingDates.remove(posession.indexOf(item));
		posession.remove(item);
	}
	
	public Date getBorrowedDate(Item item)
	{
		return borrowingDates.get(posession.indexOf(item));
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
	
	public List<Item> getOutstantingReservations()
	{
		return outstandingReservations;
	}
	
	public double getMoney()
	{
		return money;
	}
}
