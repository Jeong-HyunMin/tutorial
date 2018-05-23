//Made By 전자회로설계과 20116 정현민

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FileManager extends JFrame{

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	
	public FileManager() {
		super ("FileManager");
		setLayout (new BorderLayout());
		add (p1, BorderLayout.NORTH);
		add (p2, BorderLayout.WEST);
		add (p3, BorderLayout.SOUTH);
		add (p4, BorderLayout.CENTER);
		setSize (600, 400);				//1366*768 해상도 최적
		setVisible (true);
		
	}

	public static void main(String[] args) {
		new FileManager();
	}
	

}
