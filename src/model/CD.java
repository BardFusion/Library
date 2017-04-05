package model;

public class CD extends Item{
	private MusicGenre genre;
	
	public CD(int code, MusicGenre genre)
	{
		super(code);
		
		this.genre = genre;
	}
}
