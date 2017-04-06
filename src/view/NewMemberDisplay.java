package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.User;

public class NewMemberDisplay extends JPanel{
	private JLabel nameLabel;
	private JLabel addressLabel;
	private JTextField nameTextField;
	private JTextField addressTextField;
	private JButton confirmButton;
	
	private JPanel namePanel;
	private JPanel addressPanel;
	private JPanel buttonPanel;
	
	public NewMemberDisplay()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		namePanel = new JPanel();
		namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		addressPanel = new JPanel();
		addressPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel = new JPanel();
		buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

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
		
		confirmButton = new JButton("Confirm");
		confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Confirming");
			}
		});
		buttonPanel.add(confirmButton);
		
		add(namePanel);
		add(addressPanel);
		add(buttonPanel);
	}
}
