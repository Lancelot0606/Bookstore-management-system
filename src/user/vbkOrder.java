package user;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connect.Connect;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;

public class vbkOrder extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8264561208106956243L;
	private JPanel contentPane;
	DefaultTableModel TableMode =new DefaultTableModel();
	private JTable table=new JTable(TableMode);
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	double discount=0.8;
	
	/**
	 * Create the frame.
	 */
	public vbkOrder(String userId) {
		setTitle("购买图书");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 1050) / 2, (d.height - 540) / 2, 1050,540);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" 图 书 列 表");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 40));
		lblNewLabel.setBounds(565, 21, 315, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("图书名称");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_1.setBounds(14, 108, 72, 18);
		JLabel lblNewLabel_2 = new JLabel("图书编号");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_2.setBounds(14, 156, 72, 18);
		JLabel lblNewLabel_4 = new JLabel("图书单价");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_4.setBounds(14, 213, 83, 18);
		JLabel lblNewLabel_5 = new JLabel("购买数量");
		lblNewLabel_5.setBounds(14, 372, 72, 18);
		JLabel lblNewLabel_7 = new JLabel("图书类别");
		lblNewLabel_7.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_7.setBounds(14, 269, 72, 18);
		JLabel lblNewLabel_9 = new JLabel("请输入订单信息：");
		lblNewLabel_9.setForeground(new Color(255, 0, 0));
		lblNewLabel_9.setBounds(14, 321, 127, 18);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel_5);
		contentPane.add(lblNewLabel_7);
		contentPane.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(155, 105, 154, 24);
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(155, 153, 154, 24);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(155, 210, 154, 24);
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(155, 369, 154, 24);
		textField_6 = new JTextField();
		textField_6.setBounds(416, 79, 232, 30);
		textField_6.setColumns(10);
		textField_7 = new JTextField();
		textField_7.setBounds(155, 266, 154, 24);
		textField_7.setColumns(10);
		contentPane.add(textField);
		contentPane.add(textField_1);
		contentPane.add(textField_3);
		contentPane.add(textField_4);
		contentPane.add(textField_6);
		contentPane.add(textField_7);
		textField.setEditable(false);
		textField_1.setEditable(false);
		textField_3.setEditable(false);
		textField_7.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		TableMode.setRowCount(0);
		scrollPane.setBounds(343, 122, 689, 294);
		contentPane.add(scrollPane);

		TableMode.addColumn("图书编号");
		TableMode.addColumn("图书名称");
		TableMode.addColumn("图书单价");
		TableMode.addColumn("图书作者");
		DisplayData();
		RowsData();

		JButton btnNewButton = new JButton("购买");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try {
			    	Random random = new Random();
			        Integer r = random.nextInt(900000000) + 100000000;
			        String sql="insert into [order_user] values('"+r+"','"+userId+"','"+Integer.parseInt(textField_1.getText())+"','"+Integer.parseInt(textField_4.getText())+"','"+(char)Integer.parseInt(textField_4.getText())*(Integer.parseInt(textField_3.getText())*8/10)+"')";
			        Statement stm=new Connect().Connects();
					stm.executeUpdate(sql);
					addScore(Integer.parseInt(textField_4.getText())*Integer.parseInt(textField_3.getText())*8/10,userId);
					JOptionPane.showMessageDialog(null,"订单添加成功！赠送您"+Integer.parseInt(textField_4.getText())*(Integer.parseInt(textField_3.getText())*8/10)+"积分！","尊敬的用户",1);
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(28, 440, 113, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(196, 440, 113, 40);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("按名称筛选图书");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_6.getText().length()==0) {
					TableMode.setRowCount(0);
					DisplayData();
				}
				else
				DisplayDataName();
			}
		});
		btnNewButton_2.setBounds(755, 79, 175, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("确定选中");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RowsData();
			}
		});
		btnNewButton_4.setBounds(884, 440, 134, 40);
		contentPane.add(btnNewButton_4);
		setVisible(true);
	}
	
	public void DisplayData() {
		try {
			String sql="select * from Book";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){ 
	        	String Nid= rs.getString("Bid");
				   String name = rs.getString("BName");
				   String publish = rs.getString("Price");
				   String date = rs.getString("Author");

				   String[] str = {Nid,name,publish,date};
				   TableMode.addRow(str);
	        }
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
			
	}
	
	public void DisplayDataName() {
		try {
			TableMode.setRowCount(0);
			String sql="select * from [Book] where BName='"+textField_6.getText()+"'";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){
	        	String Nid= rs.getString("Bid");
				   String name = rs.getString("BName");
				   String publish = rs.getString("Price");
				   String date = rs.getString("Author");

				   String[] str = {Nid,name,publish,date};
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

		
		textField_1.setText(s0);
		textField.setText(s1);
		textField_3.setText(s2);
		textField_7.setText(s3);
	}
	
	public void addScore(int addScore,String userId) {
		String sql="select * from [user] where UNum='"+userId+"'";
		 Statement stm=new Connect().Connects();
	        try {
	        	 ResultSet rs=stm.executeQuery(sql);
				 rs.next();
				 int score=rs.getInt("score");
				 int newScore=score+addScore;
				 String sql1="update [user]  set score ='"+newScore+"' where UNum='"+userId+"'";
				 Statement stm1=new Connect().Connects();
				 stm1.executeUpdate(sql1);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}
	}
