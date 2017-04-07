package view;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import model.Item;

public class ReturnItemDisplay extends JPanel{
	private JComboBox<Item> itemSelector;
	
	public ReturnItemDisplay()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		itemSelector = new JComboBox<Item>();
		
		add(itemSelector);
	}
	
	public Item getSelectedItem()
	{
		return (Item)itemSelector.getSelectedItem();
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
}
