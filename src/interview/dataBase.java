package interview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//richa is great
public class dataBase {
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Connection con=null;
		Statement statement=null;
		ResultSet result=null;
		
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/richsample","root","Manu@123");
		//insert 
		String Query="INSERT into richtable" + "(id,name,salary)Values"+"(?,?,?)";
		PreparedStatement preStatement=con.prepareStatement(Query);
		preStatement.setInt(1, 15);
		preStatement.setString(2, "giru");
		preStatement.setInt(3, 2000);
		preStatement.executeUpdate();
		
		//update
		Query="update richtable set name=? where id=?";
		preStatement=con.prepareStatement(Query);
		preStatement.setString(1, "akka");
		preStatement.setInt(2, 15);
		preStatement.executeUpdate();
		
		//delete
		statement=con.createStatement();
		//result=statement.executeQuery("delete from richtable where id=15");
		statement.executeUpdate("delete from richtable where id=15");
		
		//select
		statement=con.createStatement();
		result=statement.executeQuery("select * from richtable");
		
		
		
		while(result.next()) {
		System.out.println(result.getString(1)+ result.getString(2)+ result.getString(3));
		}	
		
		
				if(con!=null) {
					try {
						con.close();
					}catch(Exception e){
						
						
					}
		         }	
				if (result != null) {
					try {
						result.close();
					} catch (Exception e) {
					}
				}
				
				if (statement != null) {
					try {
						statement.close();
					} catch (Exception e) {
					}
				}
				
				}
	  }


	
