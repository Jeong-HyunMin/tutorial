//Made By ����ȸ�μ���� 20116 ������

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.io.*;

public class FileManager extends JFrame {

	int i;
	String language[] = { "�ѱ���", "English" };
	JPanel p1 = new JPanel(); // ��ܹ�
	JPanel p2 = new JPanel(); // ���� ���
	JPanel p3 = new JPanel(); // �ϴܹ�
	JPanel p4 = new JPanel(); // ���� ���
	JComboBox<String> cb1 = new JComboBox<String>(language);
	JLabel label1 = new JLabel("���� ������");
	JLabel label2 = new JLabel("File Manager");
	JLabel space = new JLabel("                                                                                                               ");
	JScrollPane sp1 = new JScrollPane();
	JTree tree;
	JTree tree2;
	DefaultTreeModel treeModel1;
	DefaultTreeModel treeModel2;

	public FileManager() {
		super("");
		File dir = new File("D://");
		File[] files;
		FileFilter fileFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};
		File dir2 = new File("C://");
		File[] files2;
		FileFilter fileFilter2 = new FileFilter() {
			public boolean accept(File file2) {
				return file2.isDirectory();
			}
		};
		files = dir.listFiles(fileFilter);

		DefaultMutableTreeNode Root = new DefaultMutableTreeNode("����ǻ��");
		DefaultMutableTreeNode Cdrive = new DefaultMutableTreeNode("D����̺�");

		treeModel1 = new DefaultTreeModel(Root);
		tree = new JTree(treeModel1);
		if (files.length == 0) {
			System.out.println("Either dir does not exist or is not a directory");
		} else {
			for (i = 0; i < files.length; i++) {
				File filename = files[i];
				if (filename.toString().contains("$") || filename.toString().contains("Recovery")
						|| filename.toString().contains("System") || filename.toString().contains("Temp")
						|| filename.toString().contains("PerfLogs"))
					continue;

				DefaultMutableTreeNode Folders1 = new DefaultMutableTreeNode(filename.getName());

				treeModel1.insertNodeInto(Folders1, Cdrive, 0);
				treeModel1.insertNodeInto(Cdrive, Root, 0);
			}
		}

		treeModel2 = new DefaultTreeModel(Root);
		tree2 = new JTree(treeModel2);
		files2 = dir2.listFiles(fileFilter2);
		DefaultMutableTreeNode Ddrive = new DefaultMutableTreeNode("C����̺�");
		if (files2.length == 0) {
			System.out.println("Either dir does not exist or is not a directory");
		} else {
			for (i = 0; i < files2.length; i++) {
				File filename2 = files2[i];
				if (filename2.toString().contains("$") || filename2.toString().contains("Recovery")
						|| filename2.toString().contains("System") || filename2.toString().contains("Temp")
						|| filename2.toString().contains("PerfLogs"))
					continue;

				DefaultMutableTreeNode Folders2 = new DefaultMutableTreeNode(filename2.getName());

				treeModel2.insertNodeInto(Folders2, Ddrive, 0);
				treeModel2.insertNodeInto(Ddrive, Root, 0);
			}
		}


		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.WEST);
		add(p3, BorderLayout.SOUTH);
		add(p4, BorderLayout.CENTER);

		
		sp1.setViewportView(p2);
		sp1.setPreferredSize(new Dimension(150, 100));
		add(sp1, BorderLayout.WEST);
		
		p3.add(space);
		p3.add(cb1, JPanel.RIGHT_ALIGNMENT);
		p2.setBackground(Color.white);
		p3.setBackground(Color.white);
		p4.setBackground(Color.GRAY);
		setBackground(Color.lightGray);
		p2.add(tree);
		setSize(600, 400); // 1366*768 �ػ� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		new FileManager();
	}

}




