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
		setTitle("管理员");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 1050) / 2, (d.height - 545) / 2, 1050, 545);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true); 
		
		JLabel lblNewLabel_1 = new JLabel("欢迎使用Hi Story书店操作系统");
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(5, 50, 800, 56);
		contentPane.add(lblNewLabel_1);
	
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 1032, 50);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("       图书信息管理       ");
		menuBar.add(mnNewMenu);
		JMenuItem menu = new JMenuItem("增加图书信息");
		mnNewMenu.add(menu);
		JMenuItem menu1 = new JMenuItem("删除图书信息");
		mnNewMenu.add(menu1);
		JMenuItem menu2 = new JMenuItem("修改图书信息");
		mnNewMenu.add(menu2);
		JMenuItem menu4 = new JMenuItem("图书信息查询");
		mnNewMenu.add(menu4);
		menu4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		       new newspaperFind();
		       }
		     });
		
		JMenu mnNewMenu_1 = new JMenu("       图书库存管理       ");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("图书入库");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("库存信息");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("       用户信息管理       ");
		menuBar.add(mnNewMenu_2);
		JMenuItem menu8 = new JMenuItem("用户查询信息");
		mnNewMenu_2.add(menu8);
		menu8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 new userFind();
		       }
		     });
		JMenuItem menu6 = new JMenuItem("注销用户");
		mnNewMenu_2.add(menu6);
		JMenuItem menu7 = new JMenuItem("编辑用户");
		mnNewMenu_2.add(menu7);
		
		JMenu mnNewMenu_3 = new JMenu("       供货商信息管理       ");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("添加供货商");
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("修改供货商");
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("删除供货商");
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_4 = new JMenu("       订单管理       ");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("入库订单查询");
		mnNewMenu_4.add(mntmNewMenuItem_8);
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("入库订单结算");
		mnNewMenu_4.add(mntmNewMenuItem_9);
		JMenuItem menu11 = new JMenuItem("用户订单查询");
		mnNewMenu_4.add(menu11);
		JMenuItem menu12 = new JMenuItem("用户订单结算");
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
