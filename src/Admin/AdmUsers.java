package Admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import supplier.BookIn;
import supplier.BookNumber;
import supplier.BorderFind;
import supplier.BorderDel;
import supplier.supplierAdd;
import supplier.supplierDel;
import supplier.supplierEdit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

public class AdmUsers extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8754716623385454504L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdmUsers() {
		setTitle("����Ա");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 1050) / 2, (d.height - 545) / 2, 1050, 545);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true); 
		
		JLabel lblNewLabel_1 = new JLabel("��ӭʹ��Hi Story������ϵͳ");
		lblNewLabel_1.setFont(new Font("��Բ", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(5, 50, 800, 56);
		contentPane.add(lblNewLabel_1);
	
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 1032, 50);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("       ͼ����Ϣ����       ");
		menuBar.add(mnNewMenu);
		JMenuItem menu = new JMenuItem("����ͼ����Ϣ");
		mnNewMenu.add(menu);
		JMenuItem menu1 = new JMenuItem("ɾ��ͼ����Ϣ");
		mnNewMenu.add(menu1);
		JMenuItem menu2 = new JMenuItem("�޸�ͼ����Ϣ");
		mnNewMenu.add(menu2);
		JMenuItem menu4 = new JMenuItem("ͼ����Ϣ��ѯ");
		mnNewMenu.add(menu4);
		menu4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		       new newspaperFind();
		       }
		     });
		
		JMenu mnNewMenu_1 = new JMenu("       ͼ�������       ");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("ͼ�����");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("�����Ϣ");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("       �û���Ϣ����       ");
		menuBar.add(mnNewMenu_2);
		JMenuItem menu8 = new JMenuItem("�û���ѯ��Ϣ");
		mnNewMenu_2.add(menu8);
		menu8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 new userFind();
		       }
		     });
		JMenuItem menu6 = new JMenuItem("ע���û�");
		mnNewMenu_2.add(menu6);
		JMenuItem menu7 = new JMenuItem("�༭�û�");
		mnNewMenu_2.add(menu7);
		
		JMenu mnNewMenu_3 = new JMenu("       ��������Ϣ����       ");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("��ӹ�����");
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("�޸Ĺ�����");
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("ɾ��������");
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_4 = new JMenu("       ��������       ");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("��ⶩ����ѯ");
		mnNewMenu_4.add(mntmNewMenuItem_8);
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("��ⶩ������");
		mnNewMenu_4.add(mntmNewMenuItem_9);
		JMenuItem menu11 = new JMenuItem("�û�������ѯ");
		mnNewMenu_4.add(menu11);
		JMenuItem menu12 = new JMenuItem("�û���������");
		mnNewMenu_4.add(menu12);
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		         new BookIn();
		           }
		         });
		
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		         new BookNumber();
		           }
		         });
		
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		         new supplierAdd();
		           }
		         });
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new supplierEdit();
		           }
		         });
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		         new supplierEdit();
		         new supplierDel();
		           }
		         });
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		         new BorderFind();
		           }
		         });
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		         new BorderDel();
		           }
		         });
		 menu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		         new newspaperAdd();
		           }
		         });
		 
		 menu1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		         new newspaperDel();
		           }
		         });
		 menu2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		         new newspaperEdit();
		           }
		         });
		 
		    menu6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		           new userDel();
		           }
		         });
		    menu7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 new userEdit();
		           }
		         });
		    menu11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new orderFind();
		           }
		         });
		    menu12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new orderDel();
		           }
		         });

	}
}
