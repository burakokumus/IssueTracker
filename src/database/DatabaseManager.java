package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Issue;

public class DatabaseManager
{

	// Constant SQL statements
	private final String URL = "jdbc:sqlite:C:\\Users\\burak\\eclipse-workspace\\IssueTracker\\IssueTrackerDatabase.db";
	private final String USER_INSERT_STATEMENT = "INSERT INTO users(password, user_name) VALUES(?, ?)";
	private final String ISSUE_INSERT_STATEMENT = "INSERT INTO issues(title, type, priority, author, description) VALUES(?, ?, ?, ?, ?)";
	private final String GET_ISSUE_STATEMENT = "SELECT * from issues WHERE title = ?";

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

	public boolean addIssue(String title, String type, int priority, String author, String description)
	{
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(ISSUE_INSERT_STATEMENT))
		{
			pstmt.setString(1, title);
			pstmt.setString(2, type);
			pstmt.setInt(3, priority);
			pstmt.setString(4, author);
			pstmt.setString(5, description);
			pstmt.executeUpdate();
			System.out.println("data added");
			return true;

		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Issue getIssue(String title)
	{
		int issueID = -1;
		String issueTitle = "";
		String issueType = "";
		int issuePriority = -1;
		String issueAuthor = "";
		String issueDescription = "";
		String issueState = "";
		
		
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(GET_ISSUE_STATEMENT))
		{

			pstmt.setString(1, title);
			ResultSet executeQuery = pstmt.executeQuery();
			if(executeQuery.next())
			{
				issueID = executeQuery.getInt("issue_id");
				issueTitle = executeQuery.getString("title");
				issueType = executeQuery.getString("type");
				issuePriority = executeQuery.getInt("priority");
				issueAuthor = executeQuery.getString("author");
				issueDescription = executeQuery.getString("description");
				issueState = executeQuery.getString("state");
			}
			
			Issue result = new Issue(issueID, issueTitle, issueType, issuePriority, 
					issueAuthor, issueDescription, issueState);
			return result;
			
			
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
}
