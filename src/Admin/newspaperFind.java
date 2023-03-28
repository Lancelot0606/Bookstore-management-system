package Admin;

import java.awt.Dimension;
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
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class newspaperFind extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1139011502798870617L;
	private JPanel contentPane;
	private JTextField textField;
	DefaultTableModel TableMode =new DefaultTableModel();
	private JTable table=new JTable(TableMode);

	/**
	 * Create the frame.
	 */
	public newspaperFind() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 500) / 2, (d.height - 545) / 2, 500, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ͼ���ѯ");
		lblNewLabel.setFont(new Font("��Բ", Font.BOLD, 40));
		lblNewLabel.setBounds(125, 0, 248, 67);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 117, 482, 381);
		contentPane.add(scrollPane);

		textField = new JTextField();
		textField.setBounds(14, 80, 145, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		TableMode.addColumn("ͼ����");
		TableMode.addColumn("ͼ������");
		TableMode.addColumn("ͼ�鵥��");
		TableMode.addColumn("ͼ������");
		DisplayData();
		
		JButton btnNewButton = new JButton("��ͼ����");
		btnNewButton.setBounds(198, 80, 129, 27);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()==0) {
					DisplayData();
				}
				else
					DisplayDataName();
			}
		});

		
		JButton btnNewButton_1 = new JButton("��ͼ���");
		btnNewButton_1.setBounds(341, 80, 130, 27);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()==0) {
					DisplayData();
				}
				else
				DisplayDataClass();
			}
		});

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
				   String Amount = rs.getString("Amount");
				   String[] str = {Bkid,BkName,Price,Amount};
				   TableMode.addRow(str);
	        }
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
			
	}
	
	public void DisplayDataName() {
		String s=textField.getText();
		TableMode.setRowCount(0);
		try {
			String sql="select * from Book where BName='"+s+"'";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){ 
	        	 String Bkid= rs.getString("Bid");
				   String BkName = rs.getString("BName");
				   String Price = rs.getString("Price");
				   String Amount = rs.getString("Amount");
				   String[] str = {Bkid,BkName,Price,Amount};
				   TableMode.addRow(str);
	        }
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
			
	}
	
	public void DisplayDataClass() {
		String s=textField.getText();
		TableMode.setRowCount(0);
		try {
			String sql="select * from Book where Bid='"+s+"'";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){ 
	        	 String Bkid= rs.getString("Bid");
				   String BkName = rs.getString("BName");
				   String Price = rs.getString("Price");
				   String Amount = rs.getString("Amount");
				   String[] str = {Bkid,BkName,Price,Amount};
				   TableMode.addRow(str);
	        }
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
			
	}
}
