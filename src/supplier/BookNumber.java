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
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class BookNumber extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3099798723338873342L;
	private JPanel contentPane;
	DefaultTableModel TableMode =new DefaultTableModel();
	private JTable table=new JTable(TableMode);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookNumber frame = new BookNumber();
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
	public BookNumber() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 500) / 2, (d.height - 545) / 2, 500, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("库存清单");
		label.setFont(new Font("幼圆", Font.BOLD, 40));
		label.setBounds(162, 0, 176, 67);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 119, 482, 326);
		contentPane.add(scrollPane);
		contentPane.add(scrollPane);
		TableMode.addColumn("图书编号");
		TableMode.addColumn("图书名称");
		TableMode.addColumn("图书库存");
		DisplayData();
		setVisible(true);
	}
	public void DisplayData() {
		try {
			TableMode.setRowCount(0);
			String sql="select * from [Book]";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){ 
	        	   String id= rs.getString("Bid");
	        	   String Uid= rs.getString("BName");
				   String Nid = rs.getString("Amount");
				   String[] str = {id,Uid,Nid};
				   TableMode.addRow(str);
	        }
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
			
	}

	
}
