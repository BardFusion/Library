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

public class MainDisplay {
	private LibraryController libraryController;
	
	private JFrame frame;
	private JPanel controlPanel;
	private JComboBox<String> userSelector;
	
	private JButton borrowButton;
	private JButton returnButton;
	private JButton addButton;
	private JButton removeButton;
	private JButton editButton;
	
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
		frame.getContentPane().add(controlPanel, BorderLayout.WEST);
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));		
		
		addButton = new JButton("Add");
		addButton.setAlignmentX(Component.CENTER_ALIGNMENT);		
		removeButton = new JButton("Remove");
		removeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		editButton = new JButton("Edit");
		editButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		borrowButton = new JButton("Borrow");
		borrowButton.setAlignmentX(Component.CENTER_ALIGNMENT);		
		returnButton = new JButton("Return");
		returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		userSelector = new JComboBox<String>();		
		for (String userName : libraryController.getUserNames())
		{
			userSelector.addItem(userName);
		}
		userSelector.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		userSelector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchUser((String)userSelector.getSelectedItem());
			}
		});		
		
		JSeparator separator = new JSeparator();

		controlPanel.add(userSelector);
		controlPanel.add(separator);
		
		switchUser(libraryController.getUserNames().get(0));
		
		WelcomeDisplay welcomeDisplay = new WelcomeDisplay();
		frame.getContentPane().add(welcomeDisplay, BorderLayout.CENTER);
	}
	
	private void switchUser(String userName)
	{
		if (userName.startsWith("Librarian"))
		{
			removeButtonFromParent(borrowButton);
			removeButtonFromParent(returnButton);
			
			addButtonToControl(addButton);
			addButtonToControl(removeButton);
			addButtonToControl(editButton);
		}
		if (userName.startsWith("Member"))
		{
			removeButtonFromParent(addButton);
			removeButtonFromParent(removeButton);
			removeButtonFromParent(editButton);
			
			addButtonToControl(borrowButton);
			addButtonToControl(returnButton);
		}
		
		frame.revalidate();
		frame.repaint();
	}
	
	private void removeButtonFromParent(JButton button)
	{
		if (button.getParent() != null)
		{

			System.out.println("Removing button");
			button.getParent().remove(button);
		}
	}
	
	private void addButtonToControl(JButton button)
	{
		if (button.getParent() != controlPanel)
		{
			controlPanel.add(button);
		}
	}
}
