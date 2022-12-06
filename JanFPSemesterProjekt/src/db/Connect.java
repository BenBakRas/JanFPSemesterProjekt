package db;

import java.sql.*;


public class Connect {

	public static void main (String[] args ) {
		
		try { Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		Connection con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433; databaseName=Jpuds;user=sa;password=qmb52xzp;encrypt=false"); 
		printPerson(con); } 
		//printDepartment(con); }
		//printWorks(con);}
		catch (ClassNotFoundException | SQLException e) 
		{ e.printStackTrace();
	
		}
		
	}
	private static void printWorks(Connection con) {
		System.out.println("works");
	}
	
	private static void printDepartment(Connection con) {
		try (
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery ("select * from Department, Dept_Locations");
				){
			System.out.println("dno \t dname \t \t location ");
			System.out.println("--------------------------------" );
			while(rs.next()) {
				System.out.print(rs.getInt("dnumber") + "\t");
				System.out.print(rs.getString( "Dname") + "\t");
				System.out.println(rs.getString( "Dlocation"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	private static void printPerson(Connection con) {
		try (
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery ( "select * from Employee")
				){
			System.out.println("id \t name");
			System.out.println("------------" );
			while(rs.next()) {
				System.out.print(rs.getString("name") + "\t");
				System.out.println(rs.getString( "phone"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
