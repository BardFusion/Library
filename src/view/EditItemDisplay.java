package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Book;
import model.BookType;
import model.CD;
import model.DVD;
import model.Item;
import model.Member;
import model.MovieCategory;
import model.MusicGenre;

public class EditItemDisplay extends JPanel{
	private JLabel nameLabel;
	private JTextField nameTextField;
	
	private JComboBox<Item> itemSelector;
	private JComboBox<BookType> bookTypeSelector;
	private JComboBox<MovieCategory> movieCategorySelector;
	private JComboBox<MusicGenre> musicGenreSelector;
	
	private JPanel namePanel;
	private JPanel additionalPanel;
	
	public EditItemDisplay()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		itemSelector = new JComboBox<Item>();		
		itemSelector.setAlignmentX(Component.CENTER_ALIGNMENT);		
		itemSelector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchItem((Item)itemSelector.getSelectedItem());
			}
		});	
		
		bookTypeSelector = new JComboBox(BookType.values());
		movieCategorySelector = new JComboBox(MovieCategory.values());
		musicGenreSelector = new JComboBox(MusicGenre.values());
		
		namePanel = new JPanel();
		namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		namePanel.setVisible(false);		
		additionalPanel = new JPanel();
		additionalPanel.setAlignmentX(Component.CENTER_ALIGNMENT);		
		
		nameLabel = new JLabel("Name:");
		nameTextField = new JTextField();
		nameTextField.setColumns(20);
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);		
		
		add(itemSelector);
		add(namePanel);
		add(additionalPanel);
	}
	
	public void updateItemSelection(List<Item> items)
	{
		if (items.size() > 0)
		{
			itemSelector.setVisible(true);
		}
		else
		{
			itemSelector.setVisible(false);
		}		
		itemSelector.removeAllItems();
		for (Item item : items)
		{
			itemSelector.addItem(item);
		}
	}
	
	public Item getSelectedItem()
	{
		return (Item)itemSelector.getSelectedItem();
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
	
	private void switchItem(Item item)
	{
		additionalPanel.removeAll();
		if (item != null)
		{
			nameTextField.setText(item.getName());
			namePanel.setVisible(true);
			
			if (item instanceof Book)
			{
				Book selectedBook = (Book)item;
				bookTypeSelector.setSelectedItem(selectedBook.getType());
				additionalPanel.add(bookTypeSelector);
			}
			else if (item instanceof DVD)
			{
				additionalPanel.add(movieCategorySelector);
				DVD selectedDVD = (DVD)item;
				movieCategorySelector.setSelectedItem(selectedDVD.getCategory());
			}
			else if (item instanceof CD)
			{
				additionalPanel.add(musicGenreSelector);
				CD selectedCD = (CD)item;
				musicGenreSelector.setSelectedItem(selectedCD.getGenre());
			}					
		}
	}
}
