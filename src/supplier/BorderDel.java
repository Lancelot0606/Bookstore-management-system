package supplier;

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

public class BorderDel extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 32538062493818400L;
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
					BorderDel frame = new BorderDel();
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
	public BorderDel() {
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
		JLabel label_1 = new JLabel("要结算的订单编号：");
		label_1.setBounds(10, 403, 135, 18);
		contentPane.add(label_1);
		JLabel label = new JLabel(" 结算订单");
		label.setFont(new Font("幼圆", Font.BOLD, 40));
		label.setBounds(112, 13, 243, 57);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 71, 482, 312);
		contentPane.add(scrollPane);
		TableMode.addColumn("订单编号");
		TableMode.addColumn("图书编号");
		TableMode.addColumn("供应商编号");
		TableMode.addColumn("购入数");
		DisplayData();
		
		
		
		JButton button = new JButton("选中");
		button.setBounds(355, 396, 113, 27);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RowsData();
			}
		});

		
		JButton button_1 = new JButton("退出结算");
		button_1.setBounds(296, 458, 113, 27);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		
		JButton button_2 = new JButton("确认结算");
		button_2.setBounds(91, 458, 113, 27);
		contentPane.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataUp();
				DataDel();
				DisplayData();
				JOptionPane.showMessageDialog(null,"结算订单成功！！！","状态",1);
			}
		});
		setVisible(true);
	}
	
	public void DisplayData() {
		try {
			String sql="select * from [order_sup]";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){ 
	        	 String id= rs.getString("OrderNum");
				   String Bid = rs.getString("Bid");
				   String SupNum = rs.getString("SupNum");
				   String InNum = rs.getString("InNum");

				   String[] str = {id,Bid,SupNum,InNum};
				   TableMode.addRow(str);
	        }
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
	}
	
	public void DataDel() {
		try {
			TableMode.setRowCount(0);
			String s = textField.getText();
			String sql="delete from [order_sup] where OrderNum='"+s+"'";
	        Statement stm=new Connect().Connects();
	        stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public void DataUp() {
		try {
			Statement stm=new Connect().Connects();
			TableMode.setRowCount(0);
			String s = textField.getText();
			String sql="select Bid from [order_sup] where OrderNum='"+s+"'";
	        ResultSet rs1=stm.executeQuery(sql);
	        rs1.next();
	        String Bid1 = rs1.getString("Bid");
	        String sql1="select InNum from [order_sup] where OrderNum='"+s+"'";
	        ResultSet rs2=stm.executeQuery(sql1);
	        rs2.next();
	        String Amount1 = rs2.getString("InNum");
	        String sql2="select Amount from [Book] where Bid='"+Bid1+"'";
	        ResultSet rs3=stm.executeQuery(sql2);
	        rs3.next();
	        String Amount2 = rs3.getString("Amount");
	        int a = Integer.parseInt(Amount1)+Integer.parseInt(Amount2);
	        String sql3="update [Book] set Amount='"+a+"' where Bid='"+Bid1+"'";
	        stm.executeUpdate(sql3);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
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