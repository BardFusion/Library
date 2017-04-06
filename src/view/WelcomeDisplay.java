package view;

import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeDisplay extends JPanel{
	private JLabel welcomeLabel;
	
	public WelcomeDisplay()
	{
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		String welcomeMessage = "<html>";
		welcomeMessage += "Welcome to the library!";
		welcomeMessage += "<br><br>";
		welcomeMessage += "Please make your selection to the left";
		welcomeMessage += "</html>";
		
		welcomeLabel = new JLabel(welcomeMessage);
		add(welcomeLabel);
	}
}
