package connect;

import java.sql.*;

public class Connect {
	 private static Connection Conn; // ���ݿ����Ӷ���

	 static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 static String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=������ϵͳ";
	 static String userName="sa";
	 static String userPwd="Hao0606.";
	 public Statement stmt;
	 private Connection conn;
	 
	    public static Connection getConnection() {
	        try {
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // ��������
	            System.out.println("���������ɹ�");
	        } catch (ClassNotFoundException e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }

	        try {
	            Conn = DriverManager.getConnection(dbURL, userName, userPwd);
	            System.out.println("�������ݿ�ɹ�");
	            return Conn;
	        } catch (SQLException e) {
	            // TODO: handle exception
	            e.printStackTrace();
	            return null;
	        }
	    }
	    

		 public Statement Connects(){
			 try{
				 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				 conn=DriverManager.getConnection(dbURL,"sa","Hao0606.");
				 stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				 }
			 catch(Exception e){
				 System.out.println("�쳣��"+e.getMessage());
				 }
			 return stmt;
			 }
}
