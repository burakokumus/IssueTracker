package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager
{

	// Constant SQL statements
	private final String URL = "jdbc:sqlite:C:\\Users\\burak\\eclipse-workspace\\IssueTracker\\IssueTrackerDatabase.db";
	private final String USER_INSERT_STATEMENT = "INSERT INTO users(password, user_name) VALUES(?, ?)";

	/**
	 * Provides connection to the SQL server
	 * 
	 * @return Connection
	 */
	private Connection connect()
	{
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(URL);
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public boolean addUser(String password, String userName)
	{
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(USER_INSERT_STATEMENT))
		{
			pstmt.setString(1, password);
			pstmt.setString(2, userName);
			pstmt.executeUpdate();
			return true;
			
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

}
