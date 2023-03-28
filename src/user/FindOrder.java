package user;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connect.Connect;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class FindOrder extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3360756777379235242L;
	private JPanel contentPane;
	DefaultTableModel TableMode =new DefaultTableModel();
	private JTable table=new JTable(TableMode);
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public FindOrder(String userId) {
		setTitle("订单查询");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 1050) / 2, (d.height - 540) / 2, 1050,540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true); 
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(60, 152, 908, 288);
		contentPane.add(scrollPane);
		TableMode.addColumn("订单编号");
		TableMode.addColumn("图书编号");
		TableMode.addColumn("订购本数");
		TableMode.addColumn("总价");
		
		JLabel lblNewLabel = new JLabel(" 个人订单");
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 40));
		lblNewLabel.setBounds(374, 0, 272, 78);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(521, 106, 222, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		DisplayData(userId);

		JButton btnNewButton = new JButton("按图书编号查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField.getText().length()==0) {
						TableMode.setRowCount(0);
						DisplayData(userId);
					}
					else {
					TableMode.setRowCount(0);
					String sql="select * from [order_user] where UNum='"+userId+"' AND Bid='"+Integer.parseInt(textField.getText())+"'"  ;
					
			        Statement stm=new Connect().Connects();
			        ResultSet rs=stm.executeQuery(sql);
			        while(rs.next()){ 
			        	   String id= rs.getString("OrderNum");
						   String Nid = rs.getString("Bid");
						   String subscribe = rs.getString("subscriptions");
						   String Total = rs.getString("Total");

						   String[] str = {id,Nid,subscribe,Total};
						   TableMode.addRow(str);
			        }
			        }
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(774, 106, 194, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(855, 453, 113, 27);
		contentPane.add(btnNewButton_1);
	}
	
	public void DisplayData(String userId) {
		try {
			String sql="select * from [order_user] where UNum='"+userId+"'";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){ 
	        	 String id= rs.getString("OrderNum");
				   String Nid = rs.getString("Bid");
				   String subscriptions= rs.getString("subscriptions");
				   String Total = rs.getString("Total");

				   String[] str = {id,Nid,subscriptions,Total};
				   TableMode.addRow(str);
	        }
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
			
	}
}
