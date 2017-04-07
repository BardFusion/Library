package view;

import java.awt.Component;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import model.Member;

public class RemoveMemberDisplay extends JPanel{
	private JComboBox<Member> memberSelector;
	
	public RemoveMemberDisplay()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		memberSelector = new JComboBox<Member>();		
		memberSelector.setAlignmentX(Component.CENTER_ALIGNMENT);		
		
		add(memberSelector);
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
}
