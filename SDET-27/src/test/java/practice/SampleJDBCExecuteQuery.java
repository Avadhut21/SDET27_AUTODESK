package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {


	public static void main(String[] args) throws SQLException {
		/* step 1 : register the driver*/
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		/* step 2 : get connection with the database - provide db name*/

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		/* step 3: issue create statement*/
		java.sql.Statement state = con.createStatement();
		/* step 4 : execute a query -provide table name*/
		ResultSet result = state.executeQuery("select * from employeeinfo");

		while( result.next())
		{
			System.out.println(result.getString(2)+" "+result.getString(1));
		}
		con.close();

	}

}
