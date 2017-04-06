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
	private JButton backButton;
	
	private WelcomeDisplay welcomeDisplay;
	private NewMemberDisplay newMemberDisplay;
	
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
		editButton = new JButton("Edit");
		editButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		borrowButton = new JButton("Borrow");
		borrowButton.setAlignmentX(Component.CENTER_ALIGNMENT);		
		returnButton = new JButton("Return");
		returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		backButton = new JButton("Back");
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchUser((User)userSelector.getSelectedItem());
			}
		});
		
		userSelector = new JComboBox<User>();		
		for (User user : libraryController.getUsers())
		{
			userSelector.addItem(user);
		}
		userSelector.setAlignmentX(Component.CENTER_ALIGNMENT);		
		userSelector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchUser((User)userSelector.getSelectedItem());
			}
		});		
		
		addSelector = new JComboBox<String>();		
		addSelector.addItem("member");
		addSelector.addItem("item");
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
		
		welcomeDisplay = new WelcomeDisplay();
		newMemberDisplay = new NewMemberDisplay();
		
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
				buttonPanel.add(backButton);
				displayPanel.removeAll();
				displayPanel.add(newMemberDisplay);
				break;
			case "remove":
				break;
			case "edit":
				break;
			default:
		}
		
		frame.revalidate();
		frame.repaint();
	}
}
