package main;

import java.awt.EventQueue;
import view.MainDisplay;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainDisplay mainDisplay = new MainDisplay();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
