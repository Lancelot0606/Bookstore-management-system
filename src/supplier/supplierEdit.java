package supplier;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connect.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class supplierEdit extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5121290688637811519L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	DefaultTableModel TableMode =new DefaultTableModel();
	private JTable table=new JTable(TableMode);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supplierEdit frame = new supplierEdit();
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
	public supplierEdit() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 500) / 2, (d.height - 700) / 2, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 482, 653);
		contentPane.add(panel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 78, 482, 298);
		panel.add(scrollPane);
		
		JLabel label = new JLabel("供货商信息修改");
		label.setFont(new Font("幼圆", Font.BOLD, 40));
		label.setBounds(96, 13, 299, 73);
		panel.add(label);
		JLabel label_1 = new JLabel("供货商编号");
		label_1.setBounds(31, 486, 85, 18);
		panel.add(label_1);
		JLabel label_2 = new JLabel("供货商地址");
		label_2.setBounds(31, 534, 85, 18);
		panel.add(label_2);
		JLabel label_3 = new JLabel("供货商名称");
		label_3.setBounds(251, 486, 85, 18);
		panel.add(label_3);
		JLabel label_4 = new JLabel("供货商电话");
		label_4.setBounds(251, 534, 85, 18);
		panel.add(label_4);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(117, 483, 120, 24);
		panel.add(textField);
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(117, 531, 120, 24);
		panel.add(textField_1);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(348, 483, 120, 24);
		panel.add(textField_2);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(348, 531, 120, 24);
		panel.add(textField_3);
		
		TableMode.addColumn("供货商编号");
		TableMode.addColumn("供货商名称");
		TableMode.addColumn("供货商地址");
		TableMode.addColumn("供货商电话");
		DisplayData();
		
		JButton button = new JButton("选中");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RowsData();
			}
		});
		button.setBounds(355, 389, 113, 27);
		panel.add(button);
		JButton button_1 = new JButton("确认修改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveData();
				DisplayData();
			}
		});
		button_1.setBounds(80, 595, 113, 27);
		panel.add(button_1);
		JButton button_2 = new JButton("退出修改");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2.setBounds(289, 595, 113, 27);
		panel.add(button_2);
		
		setVisible(true);
	}
	public void DisplayData() {
		TableMode.setRowCount(0);
		try {
			String sql="select * from Supplier";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){ 
	        	   String id= rs.getString("SupNum");
				   String name = rs.getString("SupName");
				   String address = rs.getString("SupAddress");
				   String tel = rs.getString("SupTel");
				   String[] str = {id,name,address,tel};
				   TableMode.addRow(str);
	        }
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
		String s1= (String)TableMode.getValueAt(row, 1);
		String s2= (String)TableMode.getValueAt(row, 2);
		String s3= (String)TableMode.getValueAt(row, 3);
		textField.setText(s0);
		textField_2.setText(s1);
		textField_1.setText(s2);
		textField_3.setText(s3);
	}

	public void SaveData(){
		 try {
			    String s0 = textField.getText();
				String s1 = textField_2.getText();
				String s2 = textField_1.getText();
				String s3 = textField_3.getText();
				String s="update [Supplier] set SupName='"+s1+"',SupAddress='"+s2+"',SupTel='"+s3+"' where SupNum='"+s0+"'";
		        Statement stm=new Connect().Connects();
				stm.executeUpdate(s);
				JOptionPane.showMessageDialog(null,"供货商信息修改成功！","状态",1);
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
	}
}
