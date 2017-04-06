package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import controller.LibraryController;
import model.BookType;
import model.Item;
import model.ItemType;
import model.Librarian;
import model.Member;
import model.User;

public class MainDisplay {
	private LibraryController libraryController;
	
	private JFrame frame;
	private JPanel controlPanel;
	private JPanel buttonPanel;
	private JPanel addPanel;
	private JPanel removePanel;
	private JPanel editPanel;
	private JPanel displayPanel;
	
	private JComboBox<User> userSelector;
	private JComboBox<String> addSelector;
	private JComboBox<String> removeSelector;
	private JComboBox<String> editSelector;
	
	private JButton borrowButton;
	private JButton returnButton;
	private JButton addButton;
	private JButton removeButton;
	private JButton editButton;
	private JButton confirmButton;
	private JButton backButton;
	
	private WelcomeDisplay welcomeDisplay;
	private AddMemberDisplay addMemberDisplay;
	private AddItemDisplay addItemDisplay;
	private RemoveItemDisplay removeItemDisplay;
	private EditMemberDisplay editMemberDisplay;
	private RemoveMemberDisplay removeMemberDisplay;
	
	public MainDisplay()
	{
		libraryController = new LibraryController();
		
		initialize();
		frame.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		welcomeDisplay = new WelcomeDisplay();
		addMemberDisplay = new AddMemberDisplay();
		addItemDisplay = new AddItemDisplay();
		removeItemDisplay = new RemoveItemDisplay();
		editMemberDisplay = new EditMemberDisplay();
		removeMemberDisplay = new RemoveMemberDisplay();
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));			
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		addPanel = new JPanel();
		addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.X_AXIS));
		removePanel = new JPanel();
		removePanel.setLayout(new BoxLayout(removePanel, BoxLayout.X_AXIS));
		editPanel = new JPanel();
		editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.X_AXIS));
		
		displayPanel = new JPanel();
		displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
		
		addButton = new JButton("Add");
		addButton.setAlignmentX(Component.CENTER_ALIGNMENT);		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchControl("add");
			}
		});		
		removeButton = new JButton("Remove");
		removeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchControl("remove");
			}
		});	
		editButton = new JButton("Edit");
		editButton.setAlignmentX(Component.CENTER_ALIGNMENT);		
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchControl("edit");
			}
		});	
		
		borrowButton = new JButton("Borrow");
		borrowButton.setAlignmentX(Component.CENTER_ALIGNMENT);		
		returnButton = new JButton("Return");
		returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		confirmButton = new JButton("Confirm");
		confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (displayPanel.getComponent(0) instanceof AddMemberDisplay)
				{
					AddMemberDisplay currentDisplay = (AddMemberDisplay)displayPanel.getComponent(0);
					String nameEntered = currentDisplay.getNameEntered();
					String addressEntered = currentDisplay.getAddressEntered();
					if (nameEntered.length() > 0 && addressEntered.length() > 0)
					{						
						libraryController.addMember(nameEntered, addressEntered);
						currentDisplay.clear();
						updateUserSelector();
						switchUser((User)userSelector.getSelectedItem());
					}
				}
				else if (displayPanel.getComponent(0) instanceof RemoveMemberDisplay)
				{
					RemoveMemberDisplay currentDisplay = (RemoveMemberDisplay)displayPanel.getComponent(0);
					Member selectedMember = currentDisplay.getSelectedMember();
					libraryController.removeMember(selectedMember);
					updateUserSelector();
					switchUser((User)userSelector.getSelectedItem());
				}
				else if (displayPanel.getComponent(0) instanceof EditMemberDisplay)
				{
					EditMemberDisplay currentDisplay = (EditMemberDisplay)displayPanel.getComponent(0);
					String nameEntered = currentDisplay.getNameEntered();
					String addressEntered = currentDisplay.getAddressEntered();
					if (nameEntered.length() > 0 && addressEntered.length() > 0)
					{
						Member selectedMember = currentDisplay.getSelectedMember();
						selectedMember.setName(nameEntered);
						selectedMember.setAddress(addressEntered);
						switchUser((User)userSelector.getSelectedItem());
					}					
				}
				else if (displayPanel.getComponent(0) instanceof AddItemDisplay)
				{
					AddItemDisplay currentDisplay = (AddItemDisplay)displayPanel.getComponent(0);
					String nameEntered = currentDisplay.getNameEntered();
					BookType bookTypeEntered = currentDisplay.getBookTypeSelected();
					if (nameEntered.length() > 0)
					{
						libraryController.addBook(nameEntered, bookTypeEntered);
						currentDisplay.clear();
						switchUser((User)userSelector.getSelectedItem());
					}					
				}
				else if (displayPanel.getComponent(0) instanceof RemoveItemDisplay)
				{
					RemoveItemDisplay currentDisplay = (RemoveItemDisplay)displayPanel.getComponent(0);
					Item itemSelected = currentDisplay.getSelectedItem();
					libraryController.removeItem(itemSelected);
					switchUser((User)userSelector.getSelectedItem());
				}
			}
		});
		backButton = new JButton("Back");
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchUser((User)userSelector.getSelectedItem());
			}
		});
		
		userSelector = new JComboBox<User>();		
		userSelector.setAlignmentX(Component.CENTER_ALIGNMENT);		
		userSelector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchUser((User)userSelector.getSelectedItem());
			}
		});	
		
		addSelector = new JComboBox<String>();		
		addSelector.addItem("member");
		addSelector.addItem("book");
		addSelector.addItem("dvd");
		addSelector.addItem("cd");
		addSelector.setAlignmentX(Component.CENTER_ALIGNMENT);	
		removeSelector = new JComboBox<String>();		
		removeSelector.addItem("member");
		removeSelector.addItem("item");
		removeSelector.setAlignmentX(Component.CENTER_ALIGNMENT);	
		editSelector = new JComboBox<String>();		
		editSelector.addItem("member");
		editSelector.addItem("item");
		editSelector.setAlignmentX(Component.CENTER_ALIGNMENT);	
		
		addPanel.add(addButton);
		addPanel.add(addSelector);
		removePanel.add(removeButton);
		removePanel.add(removeSelector);
		editPanel.add(editButton);
		editPanel.add(editSelector);
		
		JSeparator separator = new JSeparator();

		controlPanel.add(userSelector);
		controlPanel.add(separator);
		controlPanel.add(buttonPanel);
		
		updateUserSelector();
		switchUser((User)userSelector.getSelectedItem());
				
		frame.getContentPane().add(controlPanel, BorderLayout.WEST);
		frame.getContentPane().add(displayPanel, BorderLayout.CENTER);
	}
	
	private void switchUser(User newUser)
	{
		if (newUser instanceof Librarian)
		{
			buttonPanel.removeAll();
			
			buttonPanel.add(addPanel);
			buttonPanel.add(removePanel);
			buttonPanel.add(editPanel);
		}
		else if (newUser instanceof Member)
		{
			buttonPanel.removeAll();
			
			buttonPanel.add(borrowButton);
			buttonPanel.add(returnButton);
		}
		
		displayPanel.removeAll();
		displayPanel.add(welcomeDisplay);		
		
		frame.revalidate();
		frame.repaint();
	}
	
	private void switchControl(String newControl)
	{
		switch(newControl)
		{
			case "add":
				buttonPanel.removeAll();	
				buttonPanel.add(confirmButton);
				buttonPanel.add(backButton);
				
				displayPanel.removeAll();
				switch((String)addSelector.getSelectedItem())
				{
					case "member":
						displayPanel.add(addMemberDisplay);
						break;
					case "book":
						displayPanel.add(addItemDisplay);
						addItemDisplay.setItemType(ItemType.BOOK);
						break;
					case "dvd":
						displayPanel.add(addItemDisplay);
						addItemDisplay.setItemType(ItemType.DVD);
						break;
					case "cd":
						displayPanel.add(addItemDisplay);
						addItemDisplay.setItemType(ItemType.CD);
						break;
				}
				break;
			case "remove":
				buttonPanel.removeAll();	
				buttonPanel.add(confirmButton);
				buttonPanel.add(backButton);
				
				displayPanel.removeAll();
				switch((String)removeSelector.getSelectedItem())
				{
					case "member":
						removeMemberDisplay.updateMemberSelection(libraryController.getMembers());
						displayPanel.add(removeMemberDisplay);
						break;
					case "item":
						removeItemDisplay.updateItemSelection(libraryController.getItems());
						displayPanel.add(removeItemDisplay);
						break;
				}
				break;
			case "edit":
				buttonPanel.removeAll();	
				buttonPanel.add(confirmButton);
				buttonPanel.add(backButton);
				
				displayPanel.removeAll();
				switch((String)editSelector.getSelectedItem())
				{
					case "member":
						editMemberDisplay.updateMemberSelection(libraryController.getMembers());
						displayPanel.add(editMemberDisplay);
						break;
					case "item":
						switchUser((User)userSelector.getSelectedItem());
						break;
				}
				break;
			default:
		}
		
		frame.revalidate();
		frame.repaint();
	}
	
	private void updateUserSelector()
	{
		userSelector.removeAllItems();
		for (User user : libraryController.getUsers())
		{
			userSelector.addItem(user);
		}
	}
}
