package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentUpdate {
	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/poc", "root" , "$anjay@161101");
			
			System.out.println("Database connection successful!\n");
			
			
			myStmt = myConn.createStatement();
			
			
			myRs = myStmt.executeQuery("select S.*, D.departmentName from Student S\r\n"
					+ "inner join Department D on\r\n"
					+ "S.departmentid = D.departmentid;");
			
			
			while (myRs.next()) {
				System.out.println(myRs.getString("studentid") + ", " + myRs.getString("fullName")+ ", " + myRs.getString("lastName")
				+ ", " + myRs.getString("departmentName")+ ", " + myRs.getString("joiningDate")+ ", " + myRs.getString("studentDob")
				+ ", " + myRs.getString("mobileNo")+ ", " + myRs.getString("email"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
	}
}
