
import org.junit.*;
import static org.junit.Assert.*;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.*;

import dbInterface.*;

public class testDbInterface{
	
	/*
	 * Initialize the DataSource object
	 * in DBInterface.
	 */

	@BeforeClass
	public static void createDataSource()
		throws SQLException {

		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser( "jack" );
		dataSource.setPassword( "jackMySQLPass" );
		dataSource.setServerName( "localhost" );
		dataSource.setDatabaseName( "message_board_website_test" );

		DBInterface.setDataSource( dataSource );

	}

	/*
	 * Delete everything we added
	 * to the test db.
	 */

	@AfterClass
	public static void clearTables()
		throws SQLException {

		/*
		 * Rather than awkwardly save the MysqlDataSource
		 * we already made and gave to DBInterface, make 
		 * a new one.
		 */

		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser( "jack" );
		dataSource.setPassword( "jackMySQLPass" );
		dataSource.setServerName( "localhost" );
		dataSource.setDatabaseName( "message_board_website_test" );

		Connection conn = dataSource.getConnection();

		Statement stmt = conn.createStatement();

		stmt.executeUpdate( "DELETE FROM users" ); 
		
		stmt.executeUpdate( "DELETE FROM threads" ); 
		
		stmt.executeUpdate( "DELETE FROM replies" ); 

		stmt.close();

		conn.close();

	}

	@Test
	public void addReadUser(){

		String username1 = "jack",
		       password1 = "hello";

		try{

			DBInterface.addUser( username1, password1 );

			User user1 = DBInterface.getUser( username1 );

			assertEquals( user1.getPassword(), password1 );

		}catch(Exception e ){

			System.out.println( e );

			assertTrue( false );

		}

	}

	@Test
	public void addReadThreads1(){
	
		/*
		 * Add a first user.
		 */

		String username1 = "ray",
		       password1 = "fried";

		User user1 = null;

		try{

			DBInterface.addUser( username1, password1 );

			user1 = DBInterface.getUser( username1 );

			assertEquals( user1.getPassword(), password1 );

		}catch(Exception e ){

			System.out.println( e );

			assertTrue( false );

		}
		
		/*
		 * Add a second user.
		 */

		String username2 = "us2",
		       password2 = "s3cret";

		User user2 = null;

		try{

			DBInterface.addUser( username2, password2 );

			user2 = DBInterface.getUser( username2 );

			assertEquals( user2.getPassword(), password2 );

		}catch(Exception e ){

			System.out.println( e );

			assertTrue( false );

		}

		//Add a first thread.

		AttachmentType attachmentType = AttachmentType.NONE;

		String attachmentName = "";

		String title = "This post sucks.";

		String body = "This is a body of a post.";

		try{

			DBInterface.addThread( user1.getId(),
					attachmentType,
					attachmentName,
					title,
					body );

		}catch( Exception e ){

			System.out.println( e );

			assertTrue( false );

		}

		//Add another

		AttachmentType attachmentType2 = AttachmentType.NONE;

		String attachmentName2 = "";

		String title2 = "This post ALSO sucks.";

		String body2 = "This is a body of ANOTHER post.";

		try{

			DBInterface.addThread( user2.getId(),
					attachmentType2,
					attachmentName2,
					title2,
					body2 );

		}catch( Exception e ){

			System.out.println( e );

			assertTrue( false );

		}

		//Get the last 10 threads.

		ArrayList< ReplyThread > threads = null;

		try{

			threads = DBInterface.getRecentThreads( 0, 10 );

		}catch( Exception e ){

			System.out.println( e );

		}

		//make sure they are the same ones we put in

		ReplyThread thread2 = threads.get( 0 ),
		       thread1 = threads.get( 1 );

		assertEquals( threads.size(), 2 );

		assertEquals( thread2.getUserId(),
				user2.getId() );

		assertEquals( thread1.getUserId(),
				user1.getId() );

	}

}


