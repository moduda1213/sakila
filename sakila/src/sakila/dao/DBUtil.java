package sakila.dao;

import java.sql.*;

public class DBUtil {
	public static Connection connection() throws Exception {
		
	System.out.println("DBUtil ¡¯¿‘");

	final String URL ="jdbc:mariadb://127.0.0.1:3306/sakila";
	final String DBID ="root";
	final String DBPW ="java1004";
	Connection conn = null;
	
	conn = DriverManager.getConnection(URL,DBID,DBPW);
	conn.setAutoCommit(false);
	
	return conn;
	}
}
