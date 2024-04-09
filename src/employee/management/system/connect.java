package employee.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class connect {

	Connection connection;
	Statement statement;
	public connect()
	{
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeemanagement","root","");
			statement=connection.createStatement();
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
}
