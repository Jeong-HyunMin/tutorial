//Made By ����ȸ�μ���� 20116 ������

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FileManager extends JFrame{

	String language [] = {"�ѱ���", "English"};
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JComboBox<String> cb1 = new JComboBox<String>(language);
	
	public FileManager() {
		super ("FileManager");
		setLayout (new BorderLayout());
		add (p1, BorderLayout.NORTH);
		add (p2, BorderLayout.WEST);
		add (p3, BorderLayout.SOUTH);
		add (p4, BorderLayout.CENTER);
		p3.add (cb1);
		setSize (600, 400);				//1366*768 �ػ� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible (true);
		
	}

	public static void main(String[] args) {
		new FileManager();
	}
	

}
