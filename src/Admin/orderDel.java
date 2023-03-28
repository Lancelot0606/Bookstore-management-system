package Admin;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connect.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class orderDel extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3063538981875855290L;
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
					orderDel frame = new orderDel();
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
	public orderDel() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 500) / 2, (d.height - 545) / 2, 500, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(147, 400, 174, 24);
		contentPane.add(textField);
		JLabel label_1 = new JLabel("Ҫ����Ķ�����ţ�");
		label_1.setBounds(10, 403, 135, 18);
		contentPane.add(label_1);
		JLabel label = new JLabel(" ���㶩��");
		label.setFont(new Font("��Բ", Font.BOLD, 40));
		label.setBounds(112, 13, 243, 57);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 71, 482, 312);
		contentPane.add(scrollPane);
		TableMode.addColumn("�������");
		TableMode.addColumn("�û����");
		TableMode.addColumn("ͼ����");
		TableMode.addColumn("��������");
		TableMode.addColumn("�ܼ�");
		DisplayData();
		
		
		
		JButton button = new JButton("ѡ��");
		button.setBounds(355, 396, 113, 27);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RowsData();
			}
		});

		
		JButton button_1 = new JButton("�˳�����");
		button_1.setBounds(296, 458, 113, 27);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		
		JButton button_2 = new JButton("ȷ�Ͻ���");
		button_2.setBounds(91, 458, 113, 27);
		contentPane.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataDel();
				DisplayData();
				JOptionPane.showMessageDialog(null,"���㶩���ɹ�������","״̬",1);
			}
		});
		setVisible(true);
	}
	
	public void DisplayData() {
		try {
			String sql="select * from [order_user]";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){ 
	        	 String id= rs.getString("OrderNum");
	        	   String Uid= rs.getString("UNum");
				   String Nid = rs.getString("Bid");
				   String subscribe = rs.getString("subscriptions");
				   String Total = rs.getString("Total");

				   String[] str = {id,Uid,Nid,subscribe,Total};
				   TableMode.addRow(str);
	        }
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}	
	}
	
	public void DataDel() {
		try {
			TableMode.setRowCount(0);
			String s = textField.getText();
			String sql="delete from [order_user] where OrderNum='"+s+"'";
	        Statement stm=new Connect().Connects();
	        stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public void RowsData() {
		int[] rows=table.getSelectedRows();
		if(rows.length == 0) return;
		int row = rows[0];
		String s0= (String)TableMode.getValueAt(row, 0);
		textField.setText(s0);
	}
}
