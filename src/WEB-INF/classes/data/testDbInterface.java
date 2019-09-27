
import org.junit.*;
import static org.junit.Assert.*;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import dbInterface.*;

public class testDbInterface{

	@BeforeClass
	public static void setup()
		throws SQLException {

		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser( "jack" );
		dataSource.setPassword( "jackMySQLPass" );
		dataSource.setServerName( "localhost" );
		dataSource.setDatabaseName( "message_board_website_test" );

		DBInterface.setDataSource( dataSource );

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

}


