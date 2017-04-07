package model;

public class CD extends Item{
	private MusicGenre genre;
	
	public CD(String name, int code, MusicGenre genre)
	{
		super(name, code);
		
		this.genre = genre;
	}
	
	public void setGenre(MusicGenre genre)
	{
		this.genre = genre;
	}
	
	public MusicGenre getGenre()
	{
		return genre;
	}
}
