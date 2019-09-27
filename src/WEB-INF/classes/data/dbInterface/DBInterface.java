
package dbInterface;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import java.util.ArrayList;

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

		Connection conn = dataSource.getConnection();

		PreparedStatement stmt = conn.prepareStatement
			( "INSERT INTO users (username, password)"
			+ " VALUES (?, ?)" );

		stmt.setString( 1, username );

		stmt.setString( 2, password );

		stmt.executeUpdate();

		stmt.close();

		conn.close();

	}
	
	/*
	 * Add a thread to the
	 * database.
	 */

	public static void addThread( int userId,
			AttachmentType attachmentType,
		        String attachmentName,
			String title,
			String body )
		throws SQLException {

		Connection conn = dataSource.getConnection();

		PreparedStatement stmt = conn.prepareStatement
			( "INSERT INTO threads (user_id, attachment_type,"
			  + " attachment_name, title, body)"
			+ " VALUES (?, ?, ?, ?, ?)" );

		stmt.setInt( 1, userId );

		stmt.setString( 2, attachmentType.toString() );
		
		stmt.setString( 3, attachmentName );
		
		stmt.setString( 4, title );
		
		stmt.setString( 5, body );

		stmt.executeUpdate();

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

		Connection conn = dataSource.getConnection();

		PreparedStatement stmt = conn.prepareStatement
			( "INSERT INTO replies (thread_id, user_id, reply_id,"
			  + " attachment_type, attachment_name, body)"
			+ " VALUES (?, ?, ?, ?, ?, ?)" );

		stmt.setInt( 1, threadId );
		
		stmt.setInt( 2, userId );
		
		stmt.setInt( 3, replyId );

		stmt.setString( 4, attachmentType.toString() );
		
		stmt.setString( 5, attachmentName );
		
		stmt.setString( 6, body );
		
		stmt.executeUpdate();

		stmt.close();

		conn.close();

	}

	/*
	 * Get a user from its id.
	 */

	public static User getUser( int id )
		throws SQLException {

		Connection conn = dataSource.getConnection();

		PreparedStatement stmt = conn.prepareStatement(
				"SELECT * FROM users WHERE id=?" );

		stmt.setInt( 1, id );

		ResultSet rs = stmt.executeQuery();

		rs.next();

		User user = new User( rs.getInt( "id" ),
				Timestamp.valueOf( rs.getString( "date" ) ),
				rs.getString( "username" ),
				rs.getString( "password" ) );

		stmt.close();

		conn.close();

		return user;

	}

	/*
	 * Get a user from its name.
	 */

	public static User getUser( String username )
		throws SQLException {

		Connection conn = dataSource.getConnection();

		PreparedStatement stmt = conn.prepareStatement(
				"SELECT * FROM users WHERE username=?" );

		stmt.setString( 1, username );

		ResultSet rs = stmt.executeQuery();

		rs.next();

		User user = new User( rs.getInt( "id" ),
				Timestamp.valueOf( rs.getString( "date" ) ),
				rs.getString( "username" ),
				rs.getString( "password" ) );

		stmt.close();

		conn.close();

		return user;

	}

	/*
	 * Get the a ... b most
	 * recent threads.
	 */

	public static ArrayList< ReplyThread > getRecentThreads( int offset, int num )
		throws SQLException {

		Connection conn = dataSource.getConnection();

		PreparedStatement stmt = conn.prepareStatement(
				String.format(
					"SELECT * FROM threads ORDER BY id DESC LIMIT %d, %d",
					offset, num ) );

		ResultSet rs = stmt.executeQuery();

		ArrayList< ReplyThread > threads = new ArrayList< ReplyThread >( num );

		for( int i = 0; rs.next(); i++ ){

			threads.add( i, new ReplyThread( rs.getInt( "id" ),
					Timestamp.valueOf( rs.getString( "date" ) ),
					rs.getInt( "num_replies" ),
					rs.getInt( "num_up_votes" ),
					rs.getInt( "num_down_votes" ),
					rs.getInt( "user_id" ),
					AttachmentType
					.valueOf( rs.getString( "attachment_type" ) ),
					rs.getString( "attachment_name" ),
					rs.getString( "title" ),
					rs.getString( "body" ) ) );

		}

		rs.close();

		stmt.close();

		return threads;

	}

	/*
	 * Get the a ... b most
	 * recent threads from some user.
	 */

	public static ArrayList< ReplyThread > getRecentThreadsFromUser( User user, int offset, int num )
		throws SQLException {

		Connection conn = dataSource.getConnection();

		PreparedStatement stmt = conn.prepareStatement(
				String.format(
					"SELECT * FROM threads WHERE user_id=? ORDER BY id DESC LIMIT %d, %d",
					offset, num ) );

		stmt.setInt( 1, user.getId() );

		ResultSet rs = stmt.executeQuery();

		ArrayList< ReplyThread > threads = new ArrayList< ReplyThread >( num );

		for( int i = 0; rs.next(); i++ ){

			threads.add( i, new ReplyThread( rs.getInt( "id" ),
					Timestamp.valueOf( rs.getString( "date" ) ),
					rs.getInt( "num_replies" ),
					rs.getInt( "num_up_votes" ),
					rs.getInt( "num_down_votes" ),
					rs.getInt( "user_id" ),
					AttachmentType
					.valueOf( rs.getString( "attachment_type" ) ),
					rs.getString( "attachment_name" ),
					rs.getString( "title" ),
					rs.getString( "body" ) ) );

		}

		rs.close();

		stmt.close();

		return threads;

	}
	/*
	 * Get the a ... b most
	 * recent replies on some thread.
	 */

	public static ArrayList< Reply > getRecentRepliesOnThread( ReplyThread thread, int offset, int num )
		throws SQLException {

		Connection conn = dataSource.getConnection();

		PreparedStatement stmt = conn.prepareStatement(
				String.format(
					"SELECT * FROM replies WHERE thread_id=? ORDER BY id DESC LIMIT %d, %d",
					offset, num ) );

		stmt.setInt( 1, thread.getId() );

		ResultSet rs = stmt.executeQuery();

		ArrayList< Reply > replies = new ArrayList< Reply >( num );

		for( int i = 0; rs.next(); i++ ){

			replies.add( 1, new Reply( rs.getInt( "id" ),
					Timestamp.valueOf( rs.getString( "date" ) ),
					rs.getInt( "thread_id" ),
					rs.getInt( "num_replies" ),
					rs.getInt( "num_up_votes" ),
					rs.getInt( "num_down_votes" ),
					rs.getInt( "user_id" ),
					rs.getInt( "reply_id" ),
					AttachmentType
					.valueOf( rs.getString( "attachment_type" ) ),
					rs.getString( "attachment_name" ),
					rs.getString( "body" ) ) );

		}

		rs.close();

		stmt.close();

		return replies;

	}

}
