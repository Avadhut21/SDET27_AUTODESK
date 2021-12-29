package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJdbc {

	public static void main(String[] args) throws SQLException {
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		 
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		Statement state = con.createStatement();
		//state.executeUpdate("")
		

	}

}
