package view;

import java.awt.Component;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import model.Item;

public class RemoveItemDisplay extends JPanel{
	private JComboBox<Item> itemSelector;
	
	public RemoveItemDisplay()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		itemSelector = new JComboBox<Item>();
		itemSelector.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(itemSelector);
	}
	
	public void updateItemSelection(List<Item> items)
	{
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
}
