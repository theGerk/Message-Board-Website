
package dbInterface;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

/*
 * A bunch of static
 * functions for reading
 * and writing the db.
 */

public class DBInterface{

	private static MysqlDataSource dataSource;

	/*
	 * Initialize the DataSource object.
	 */

	public static void setDataSource( MysqlDataSource dataSourceTmp ){

		dataSource = dataSourceTmp;

	}

	/*
	 * Add a user to the
	 * database.
	 */

	public static void addUser( String username,
			String password )
		throws SQLException {

		/*
		 * Get a connection to
		 * the database.
		 */

		Connection conn = dataSource.getConnection();

		/*
		 * Write the insert statement.
		 */

		PreparedStatement stmt = conn.prepareStatement
			( "INSERT INTO users (username, password)"
			+ " VALUES (?, ?)" );

		stmt.setString( 1, username );

		stmt.setString( 2, password );

		//run it

		stmt.executeUpdate();

		//clean up

		stmt.close();

		conn.close();

	}
	
	/*
	 * Add a reply thread to the
	 * database.
	 */

	public static void addThread( int userId,
			AttachmentType attachmentType,
		        String attachmentName,
			String title,
			String body )
		throws SQLException {

		/*
		 * Get a connection to
		 * the database.
		 */

		Connection conn = dataSource.getConnection();

		/*
		 * Write the insert statement.
		 */

		PreparedStatement stmt = conn.prepareStatement
			( "INSERT INTO threads (user_id, attachment_type,"
			  + " attachment_name, title, body)"
			+ " VALUES (?, ?, ?, ?, ?)" );

		stmt.setInt( 1, userId );

		stmt.setString( 2, attachmentType.toString() );
		
		stmt.setString( 3, attachmentName );
		
		stmt.setString( 4, title );
		
		stmt.setString( 5, body );

		//run it

		stmt.executeUpdate();

		//clean up

		stmt.close();

		conn.close();

	}

	/*
	 * Add a reply to the
	 * database.
	 */

	public static void addReply( MysqlDataSource dataSource,
			int threadId,
			int userId,
			int replyId,
			AttachmentType attachmentType,
		        String attachmentName,
			String body )
		throws SQLException {

		/*
		 * Get a connection to
		 * the database.
		 */

		Connection conn = dataSource.getConnection();

		/*
		 * Write the insert statement.
		 */

		PreparedStatement stmt = conn.prepareStatement
			( "INSERT INTO reply_threads (thread_id, user_id, reply_id,"
			  + " attachment_type, attachment_name, body)"
			+ " VALUES (?, ?, ?, ?, ?, ?)" );

		stmt.setInt( 1, threadId );
		
		stmt.setInt( 2, userId );
		
		stmt.setInt( 3, replyId );

		stmt.setString( 4, attachmentType.toString() );
		
		stmt.setString( 5, attachmentName );
		
		stmt.setString( 6, body );
		
		//run it

		stmt.executeUpdate();

		//clean up

		stmt.close();

		conn.close();

	}

	/*
	 * Get a user from its id.
	 */

	public static User getUser( int id )
		throws SQLException {

		//Get a connection.

		Connection conn = dataSource.getConnection();

		//Write the select statement.

		PreparedStatement stmt = conn.prepareStatement(
				"SELECT * FROM users WHERE id=?" );

		stmt.setInt( 1, id );

		ResultSet rs = stmt.executeQuery();

		rs.next();

		User user = new User( rs.getInt( "id" ),
				Timestamp.valueOf( rs.getString( "date" ) ),
				rs.getString( "username" ),
				rs.getString( "password" ) );

		return user;

	}

	/*
	 * Get a user from its name.
	 */

	public static User getUser( String username )
		throws SQLException {

		//Get a connection.

		Connection conn = dataSource.getConnection();

		//Write the select statement.

		PreparedStatement stmt = conn.prepareStatement(
				"SELECT * FROM users WHERE username=?" );

		stmt.setString( 1, username );

		ResultSet rs = stmt.executeQuery();

		rs.next();

		User user = new User( rs.getInt( "id" ),
				Timestamp.valueOf( rs.getString( "date" ) ),
				rs.getString( "username" ),
				rs.getString( "password" ) );

		return user;

	}

}
