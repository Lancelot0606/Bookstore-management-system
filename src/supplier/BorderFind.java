package supplier;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connect.Connect;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class BorderFind extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2752481374291268498L;
	private JPanel contentPane;
	private JTextField textField;
	DefaultTableModel TableMode =new DefaultTableModel();
	private JTable table=new JTable(TableMode);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorderFind frame = new BorderFind();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BorderFind() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 500) / 2, (d.height - 545) / 2, 500, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel label = new JLabel(" �ɹ�����");
		label.setFont(new Font("��Բ", Font.BOLD, 40));
		label.setBounds(120, 0, 328, 67);
		contentPane.add(label);
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(14, 80, 145, 24);
		contentPane.add(textField);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 117, 482, 381);
		contentPane.add(scrollPane);
		TableMode.addColumn("�������");
		TableMode.addColumn("ͼ����");
		TableMode.addColumn("�����̱��");
		TableMode.addColumn("�������");
		DisplayData();
		JButton button = new JButton("�������̺Ų�ѯ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplaySup();
			}
		});
		button.setBounds(173, 80, 155, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("��ͼ��Ų�ѯ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayBk();
			}
			
		});
		button_1.setBounds(341, 79, 141, 27);
		contentPane.add(button_1);
		setVisible(true);
	}
	
	public void DisplayData() {
		try {
			TableMode.setRowCount(0);
			String sql="select * from [Order_Sup]";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){ 
	        	   String id= rs.getString("OrderNum");
	        	   String Uid= rs.getString("Bid");
				   String Nid = rs.getString("SupNum");
				   String Num = rs.getString("InNum");
				   String[] str = {id,Uid,Nid,Num};
				   
				   TableMode.addRow(str);
	        }
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
			
	}
	
	public void DisplaySup() {
		try {
			String s=textField.getText();
			TableMode.setRowCount(0);
			String sql="select * from [Order_Sup] where SupNum='"+s+"'";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){ 
	        	   String id= rs.getString("OrderNum");
	        	   String Uid= rs.getString("Bid");
				   String Nid = rs.getString("SupNum");
				   String Num = rs.getString("InNum");
				   String[] str = {id,Uid,Nid,Num};
				   
				   TableMode.addRow(str);
	        }
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
			
	}
	
	public void DisplayBk() {
		try {
			String s=textField.getText();
			TableMode.setRowCount(0);
			String sql="select * from [Order_Sup] where Bkid='"+s+"'";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){ 
	        	   String id= rs.getString("OrderNum");
	        	   String Uid= rs.getString("Bid");
				   String Nid = rs.getString("SupNum");
				   String Num = rs.getString("InNum");
				   String[] str = {id,Uid,Nid,Num};
				   
				   TableMode.addRow(str);
	        }
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
			
	}
}
