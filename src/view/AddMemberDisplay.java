package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddMemberDisplay extends JPanel{
	private JLabel nameLabel;
	private JLabel addressLabel;
	private JTextField nameTextField;
	private JTextField addressTextField;
	
	private JPanel namePanel;
	private JPanel addressPanel;
	
	public AddMemberDisplay()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		namePanel = new JPanel();
		namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		addressPanel = new JPanel();
		addressPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		nameLabel = new JLabel("Name:");
		nameTextField = new JTextField();
		nameTextField.setColumns(20);
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);
		
		addressLabel = new JLabel("Address");
		addressTextField = new JTextField();
		addressTextField.setColumns(20);
		addressPanel.add(addressLabel);
		addressPanel.add(addressTextField);
		
		add(namePanel);
		add(addressPanel);
	}
	
	public String getNameEntered()
	{
		return nameTextField.getText();
	}
	
	public String getAddressEntered()
	{
		return addressTextField.getText();
	}
	
	public void clear()
	{
		nameTextField.setText("");
		addressTextField.setText("");
	}
}
