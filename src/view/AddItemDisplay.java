package view;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.BookType;
import model.ItemType;
import model.MovieCategory;
import model.MusicGenre;

public class AddItemDisplay extends JPanel{
	private JLabel nameLabel;
	private JTextField nameTextField;
	
	private JComboBox<BookType> bookTypeSelector;
	private JComboBox<MovieCategory> movieCategorySelector;
	private JComboBox<MusicGenre> musicGenreSelector;
	
	private JPanel namePanel;
	private JPanel additionalPanel;
	
	public AddItemDisplay()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		namePanel = new JPanel();
		namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);	
		nameLabel = new JLabel("Name:");
		nameTextField = new JTextField();
		nameTextField.setColumns(20);
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);
		
		bookTypeSelector = new JComboBox(BookType.values());
		movieCategorySelector = new JComboBox(MovieCategory.values());
		musicGenreSelector = new JComboBox(MusicGenre.values());
		
		additionalPanel = new JPanel();
		namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);	
		
		add(namePanel);
		add(additionalPanel);
	}
	
	public void setItemType(ItemType type)
	{
		additionalPanel.removeAll();
		switch(type)
		{
			case BOOK:
				additionalPanel.add(bookTypeSelector);
				break;
			case DVD:
				additionalPanel.add(movieCategorySelector);
				break;
			case CD:
				additionalPanel.add(musicGenreSelector);
				break;
		}
	}
	
	public String getNameEntered()
	{
		return nameTextField.getText();
	}
	
	public BookType getBookTypeSelected()
	{
		return (BookType)bookTypeSelector.getSelectedItem();
	}
	
	public MovieCategory getMovieCategorySelected()
	{
		return (MovieCategory)movieCategorySelector.getSelectedItem();
	}
	
	public MusicGenre getMusicGenreSelected()
	{
		return (MusicGenre)musicGenreSelector.getSelectedItem();
	}
	
	public void clear()
	{
		nameTextField.setText("");
	}
}
