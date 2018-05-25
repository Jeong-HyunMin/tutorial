//Made By 전자회로설계과 20116 정현민

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.io.*;

public class FileManager extends JFrame implements ItemListener {

	int c, d, e, f;
	String language[] = { "한국어", "English" };
	JPanel p1 = new JPanel(); // 상단바
	JPanel p2 = new JPanel(); // 폴더 목록
	JPanel p3 = new JPanel(); // 하단바
	JPanel p4 = new JPanel(); // 파일 목록
	JButton b1 = new JButton ("Show Item in the Folder");
	JButton b2 = new JButton ("Copy");
	JButton b3 = new JButton ("Paste");
	JButton b4 = new JButton ("Delete");
	JComboBox<String> cb1 = new JComboBox<String>(language);
	JLabel label1 = new JLabel("파일 관리자");
	JLabel space = new JLabel("                                                                                                               ");
	JScrollPane sp1 = new JScrollPane();
	JTextArea temp_ta = new JTextArea("파일 목록 / 하위폴더 목록이 표시될 부분\n                        아직 준비중");			//임시 조치
	JTree tree1;
	JTree tree2;
	JTree tree3;
	JTree tree4;
	JPopupMenu pm1 = new JPopupMenu();
	DefaultTreeModel treeModel1;
	DefaultTreeModel treeModel2;
	DefaultTreeModel treeModel3;
	DefaultTreeModel treeModel4;

	public FileManager() {
		super("파일관리자");				//임시조치
		
		File dir3 = new File("E://");
		File[] files3;
		FileFilter fileFilter3 = new FileFilter() {
			public boolean accept(File file3) {
				return file3.isDirectory();
			}
		};
		
		File dir4 = new File("F://");
		File[] files4;
		FileFilter fileFilter4 = new FileFilter() {
			public boolean accept(File file4) {
				return file4.isDirectory();
			}
		};
		
		File dir1 = new File("D://");
		File[] file1;
		FileFilter fileFilte1 = new FileFilter() {
			public boolean accept(File file1) {
				return file1.isDirectory();
			}
		};
		File dir2 = new File("C://");
		File[] files2;
		FileFilter fileFilter2 = new FileFilter() {
			public boolean accept(File file2) {
				return file2.isDirectory();
			}
		};
		
		DefaultMutableTreeNode Root = new DefaultMutableTreeNode("내컴퓨터");
		
		try {
			files4 = dir4.listFiles(fileFilter4);
			DefaultMutableTreeNode Fdrive = new DefaultMutableTreeNode("F드라이브");
			treeModel4 = new DefaultTreeModel(Root);
			tree4 = new JTree(treeModel4);
			if (files4.length == 0) {
				System.out.println("Either dir does not exist or is not a directory");
			} else {
				for (f = 0; f < files4.length; f++) {
					File filename4 = files4[f];
					if (filename4.toString().contains("$") || filename4.toString().contains("Recovery")
							|| filename4.toString().contains("System") || filename4.toString().contains("Temp")
							|| filename4.toString().contains("PerfLogs"))
						continue;

					DefaultMutableTreeNode Folders4 = new DefaultMutableTreeNode(filename4.getName());

					treeModel4.insertNodeInto(Folders4, Fdrive, 0);
					treeModel4.insertNodeInto(Fdrive, Root, 0);
				}
			} 
		} catch (Exception e) {
			DefaultMutableTreeNode Fdrive = new DefaultMutableTreeNode("F드라이브");
			DefaultMutableTreeNode Folders4 = new DefaultMutableTreeNode("(찾을 수 없음.)");

			treeModel4.insertNodeInto(Folders4, Fdrive, 0);
			treeModel4.insertNodeInto(Fdrive, Root, 0);
		}
		try {
			files3 = dir3.listFiles(fileFilter3);
			DefaultMutableTreeNode Edrive = new DefaultMutableTreeNode("E드라이브");
			treeModel3 = new DefaultTreeModel(Root);
			tree3 = new JTree(treeModel3);
			if (files3.length == 0) {
				System.out.println("Either dir does not exist or is not a directory");
			} else {
				for (e = 0; e < files3.length; e++) {
					File filename3 = files3[e];
					if (filename3.toString().contains("$") || filename3.toString().contains("Recovery")
							|| filename3.toString().contains("System") || filename3.toString().contains("Temp")
							|| filename3.toString().contains("PerfLogs"))
						continue;

					DefaultMutableTreeNode Folders3 = new DefaultMutableTreeNode(filename3.getName());

					treeModel3.insertNodeInto(Folders3, Edrive, 0);
					treeModel3.insertNodeInto(Edrive, Root, 0);
				}
			} 
		} catch (Exception e) {
			DefaultMutableTreeNode Edrive = new DefaultMutableTreeNode("E드라이브");
			DefaultMutableTreeNode Folders3 = new DefaultMutableTreeNode("(찾을 수 없음.)");

			treeModel4.insertNodeInto(Folders3, Edrive, 0);
			treeModel4.insertNodeInto(Edrive, Root, 0);
		}
		
		try {
			file1 = dir1.listFiles(fileFilte1);
		
			DefaultMutableTreeNode Ddrive = new DefaultMutableTreeNode("D드라이브");
		
			treeModel1 = new DefaultTreeModel(Root);
			tree1 = new JTree(treeModel1);
		
			if (file1.length == 0) {
				System.out.println("Either dir does not exist or is not a directory");
			} else {
				for (d = 0; d < file1.length; d++) {
					File filename1 = file1[d];
					if (filename1.toString().contains("$") || filename1.toString().contains("Recovery")
							|| filename1.toString().contains("System") || filename1.toString().contains("Temp")
							|| filename1.toString().contains("PerfLogs"))
						continue;

					DefaultMutableTreeNode Folders1 = new DefaultMutableTreeNode(filename1.getName());

					treeModel1.insertNodeInto(Folders1, Ddrive, 0);
					treeModel1.insertNodeInto(Ddrive, Root, 0);
				}
			}
		} catch (Exception e) {
			DefaultMutableTreeNode Ddrive = new DefaultMutableTreeNode("D드라이브");
			DefaultMutableTreeNode Folders1 = new DefaultMutableTreeNode("(찾을 수 없음.)");

			treeModel4.insertNodeInto(Folders1, Ddrive, 0);
			treeModel4.insertNodeInto(Ddrive, Root, 0);
		}
		
		files2 = dir2.listFiles(fileFilter2);
		
		DefaultMutableTreeNode Cdrive = new DefaultMutableTreeNode("C드라이브");
		
		treeModel2 = new DefaultTreeModel(Root);
		tree2 = new JTree(treeModel2);
		
		if (files2.length == 0) {
			System.out.println("Either dir does not exist or is not a directory");
		} else {
			for (c = 0; c < files2.length; c++) {
				File filename2 = files2[c];
				if (filename2.toString().contains("$") || filename2.toString().contains("Recovery")
						|| filename2.toString().contains("System") || filename2.toString().contains("Temp")
						|| filename2.toString().contains("PerfLogs"))
					continue;

				DefaultMutableTreeNode Folders2 = new DefaultMutableTreeNode(filename2.getName());

				treeModel2.insertNodeInto(Folders2, Cdrive, 0);
				treeModel2.insertNodeInto(Cdrive, Root, 0);
			}
		}
		
		
		

		cb1.addItemListener(this);
		
		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.WEST);
		add(p3, BorderLayout.SOUTH);
		add(p4, BorderLayout.CENTER);
		pm1.add (b1, JPanel.CENTER_ALIGNMENT);
		pm1.add (b2, JPanel.CENTER_ALIGNMENT);
		pm1.add (b3, JPanel.CENTER_ALIGNMENT);
		pm1.add (b4, JPanel.CENTER_ALIGNMENT);
		//add (pm1);							팝업 메뉴 추가부분
		
		
		sp1.setViewportView(p2);
		sp1.setPreferredSize(new Dimension(150, 100));
		add(sp1, BorderLayout.WEST);
		
		p3.add(label1, JPanel.LEFT_ALIGNMENT);
		p3.add(space);
		p3.add(cb1, JPanel.RIGHT_ALIGNMENT);
		p2.setBackground(Color.white);
		p3.setBackground(Color.white);
		p4.setBackground(Color.GRAY);
		p4.add(temp_ta);
		setBackground(Color.lightGray);
		p2.add(tree4);
		setSize(600, 400); // 1366*768 해상도 최적
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}


	public static void main(String[] args) {
		new FileManager();
	}

}




class ComboboxListener implements ItemListener {		//Combobox 선택으로 언어 변경하는 부분 (아직 구현하지 못함)

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
		if (e.getItem().equals("English"))
		{
			
		}

		else if (e.getItem().equals("한국어"))
		{
			
		}
		
		else
		{
			System.err.println();
			
		}
	
	}
	
	public ComboboxListener () {
		super();
	}
}
