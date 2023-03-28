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

public class newspaperEdit extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2963345975693200800L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	DefaultTableModel TableMode =new DefaultTableModel();
	private JTable table=new JTable(TableMode);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newspaperEdit frame = new newspaperEdit();
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
	public newspaperEdit() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 500) / 2, (d.height - 700) / 2, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" 图书信息修改");
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 40));
		lblNewLabel.setBounds(70, 13, 325, 73);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 78, 482, 298);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("图书编号");
		lblNewLabel_1.setBounds(44, 486, 72, 18);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("图书名称");
		lblNewLabel_2.setBounds(44, 534, 72, 18);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("图书单价");
		lblNewLabel_3.setBounds(251, 486, 72, 18);
		contentPane.add(lblNewLabel_3);
		JLabel lblNewLabel_5 = new JLabel("图书作者");
		lblNewLabel_5.setBounds(251, 534, 72, 18);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(117, 483, 120, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(117, 531, 120, 24);
		contentPane.add(textField_2);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(337, 483, 120, 24);
		contentPane.add(textField_3);
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(337, 531, 120, 24);
		contentPane.add(textField);
		contentPane.add(textField_2);
		contentPane.add(textField_3);
		contentPane.add(textField_5);
		textField.setEditable(false);
		
		TableMode.addColumn("图书编号");
		TableMode.addColumn("图书类别");
		TableMode.addColumn("图书单价");
		TableMode.addColumn("图书作者");
		DisplayData();
		
		JButton btnNewButton = new JButton("选中");
		btnNewButton.setBounds(355, 389, 113, 27);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RowsData();
			}
		});
		
		JButton btnNewButton_1 = new JButton("确认修改");
		btnNewButton_1.setBounds(80, 595, 113, 27);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveData();
				DisplayData();
			}
		});

		
		JButton btnNewButton_2 = new JButton("退出修改");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(289, 595, 113, 27);
		contentPane.add(btnNewButton_2);
		setVisible(true);
	}
	
	public void DisplayData() {
		TableMode.setRowCount(0);
		try {
			String sql="select * from Book";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){ 
	        	   String Bkid= rs.getString("Bid");
				   String BkName = rs.getString("BName");
				   String Price = rs.getString("Price");
				   String Author=rs.getString("Author");
				   String[] str = {Bkid,BkName,Price,Author};
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
		String s2= (String)TableMode.getValueAt(row, 1);
		String s3= (String)TableMode.getValueAt(row, 2);
		String s5= (String)TableMode.getValueAt(row, 3);
		textField.setText(s0);
		textField_2.setText(s2);
		textField_3.setText(s3);
		textField_5.setText(s5);
	}

	public void SaveData(){
		 try {
			    String s1 = textField.getText();
				String s2 = textField_2.getText();
				String s3 = textField_3.getText();
				String s5 = textField_5.getText();
				String s="update [Book] set BName='"+s2+"',Price='"+s3+"',Author='"+s5+"' where Bid='"+s1+"'";
		        Statement stm=new Connect().Connects();
				stm.executeUpdate(s);
				JOptionPane.showMessageDialog(null,"图书信息修改成功！！！","状态",1);
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
	}
	
}
