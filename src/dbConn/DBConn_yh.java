package dbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn_yh {
	public static synchronized Connection getConnection() throws Exception{
	    try{
	    	String driver="oracle.jdbc.driver.OracleDriver";
	    	String url="jdbc:oracle:thin:@10.70.128.22:1521:jfyhtst1";
	    	String name="product";
	    	String pwd="product";
	    	Class.forName(driver);
	      return DriverManager.getConnection(url, name, pwd);
	    }
	    catch(SQLException e){
	    	System.out.println("链接数据库有误，请检查数据库是否打开");
	    	throw e;
	    }
	  }
}
