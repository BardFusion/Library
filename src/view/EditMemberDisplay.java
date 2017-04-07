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

import model.Member;

public class EditMemberDisplay extends JPanel{
	private JLabel nameLabel;
	private JLabel addressLabel;
	private JTextField nameTextField;
	private JTextField addressTextField;
	
	private JPanel namePanel;
	private JPanel addressPanel;
	
	private JComboBox<Member> memberSelector;
	
	public EditMemberDisplay()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		memberSelector = new JComboBox<Member>();		
		memberSelector.setAlignmentX(Component.CENTER_ALIGNMENT);		
		memberSelector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchMember((Member)memberSelector.getSelectedItem());
			}
		});			
		
		namePanel = new JPanel();
		namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		namePanel.setVisible(false);
		addressPanel = new JPanel();
		addressPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		addressPanel.setVisible(false);

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
		
		add(memberSelector);
		add(namePanel);
		add(addressPanel);
	}
	
	public void updateMemberSelection(List<Member> members)
	{
		if (members.size() > 0)
		{
			memberSelector.setVisible(true);
		}
		else
		{
			memberSelector.setVisible(false);
		}	
		memberSelector.removeAllItems();
		for (Member member : members)
		{
			memberSelector.addItem(member);
		}
	}
	
	public Member getSelectedMember()
	{
		return (Member)memberSelector.getSelectedItem();
	}
	
	public String getNameEntered()
	{
		return nameTextField.getText();
	}
	
	public String getAddressEntered()
	{
		return addressTextField.getText();
	}
	
	private void switchMember(Member member)
	{
		if (member != null)
		{
			nameTextField.setText(member.getName());
			namePanel.setVisible(true);
			addressTextField.setText(member.getAddress());
			addressPanel.setVisible(true);
		}
	}
}
