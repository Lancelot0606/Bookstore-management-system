package user;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connect.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class vExchange extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7592585676008707167L;
	private JPanel contentPane;
    private int score;
	/**
	 * Create the frame.
	 */
	public vExchange(String userId) {
		score=Score(userId);
		setTitle("积分兑换");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 550) / 2, (d.height - 540) / 2, 550,540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel_4 = new JLabel("您拥有积分  "+score);
		lblNewLabel_4.setBounds(31, 101, 433, 18);
		contentPane.add(lblNewLabel_4);
		JLabel lblNewLabel_2 = new JLabel("牛皮笔记本");
		lblNewLabel_2.setFont(new Font("幼圆", Font.BOLD, 20));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(60, 150, 200, 60);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("任意挑选总价值50元的图书");
		lblNewLabel_3.setFont(new Font("幼圆", Font.BOLD, 15));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(60, 235, 250, 60);
		contentPane.add(lblNewLabel_3);
		JLabel label_1 = new JLabel("");
		label_1.setBounds(338, 152, 126, 112);
		contentPane.add(label_1);
		JLabel lblNewLabel_1 = new JLabel(" 积分兑换");
		lblNewLabel_1.setFont(new Font("幼圆", Font.BOLD, 40));
		lblNewLabel_1.setBounds(151, 13, 257, 77);
		contentPane.add(lblNewLabel_1);
		JLabel label = new JLabel("");
		label.setBounds(43, 152, 124, 112);
		contentPane.add(label);
		
		JButton btnNewButton_2 = new JButton("500积分 兑换");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(score>=500) {
					Change(userId,500,score);
				    score=score-500;
					JOptionPane.showMessageDialog(null,"兑换成功！","状态",1);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"对不起，您的积分不足，无法兑换","状态",1);
				}
			}
		});
		btnNewButton_2.setBounds(360, 250, 113, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("100积分 兑换");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(score>=100) {
					Change(userId,100,score);
				    score=score-100;
					JOptionPane.showMessageDialog(null,"兑换成功！","状态",1);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"对不起，您的积分不足，无法兑换","状态",1);
				}
			}
		});
		btnNewButton_3.setBounds(360, 165, 113, 27);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("退出");
		btnNewButton_1.setBounds(209, 417, 113, 27);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setVisible(true); 
	}
	
	public int Score(String userId) {
		String sql="select * from [user] where UNum='"+userId+"'"  ;
        Statement stm=new Connect().Connects();
		try {
			 ResultSet rs = stm.executeQuery(sql);
			 rs.next();
			 int score= Integer.parseInt(rs.getString("score"));
			 return score;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
        }
	
	public void Change(String userId,int tariff,int score) {
		int a=score-tariff;
			String sql="update [user]  set score= '"+a+"' where UNum='"+userId+"'";
	        Statement stm=new Connect().Connects();
			try {
				stm.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null,"兑换成功！剩余积分"+a,"状态",1);
		}
	public void Changevip(String userId) {
		    boolean a=true;
			String sql="update [user] set vip= '"+a+"' where UNum='"+userId+"'";
	        Statement stm=new Connect().Connects();
			try {
				stm.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	
	}
