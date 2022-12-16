package db;

import java.sql.*;


public class Connect {

	public static void main (String[] args ) {
		
		try { Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		Connection con = DriverManager.getConnection("jdbc:sqlserver://hildur.ucn.dk:1433; databaseName=DMA-CSD-V222_10434655;user=DMA-CSD-V222_10434655;password=Password1!;encrypt=false"); 
		System.out.println("works");
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
