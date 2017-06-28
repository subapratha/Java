package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.*;
public class Jdbctojava {
public static void main(String[] args){
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql:localhost://3306/test","root","root");
		Statement stmt=(Statement) con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from customer");
		while(rs.next())
		{
			System.out.println(rs.getInt(0)+rs.getString(1)+rs.getInt(2));
		}
				
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
