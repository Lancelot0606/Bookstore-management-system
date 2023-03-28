package connect;

import java.sql.*;

public class Connect {
	 private static Connection Conn; // 数据库连接对象

	 static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 static String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=书店管理系统";
	 static String userName="sa";
	 static String userPwd="Hao0606.";
	 public Statement stmt;
	 private Connection conn;
	 
	    public static Connection getConnection() {
	        try {
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // 加载驱动
	            System.out.println("加载驱动成功");
	        } catch (ClassNotFoundException e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }

	        try {
	            Conn = DriverManager.getConnection(dbURL, userName, userPwd);
	            System.out.println("连接数据库成功");
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
				 System.out.println("异常："+e.getMessage());
				 }
			 return stmt;
			 }
}
