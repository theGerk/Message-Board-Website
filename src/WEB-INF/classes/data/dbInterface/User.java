
package dbInterface;

import java.sql.Timestamp;

/*
 * A class that stores
 * the data stored for one
 * user.
 */

public class User{

	private int dbId;

	private Timestamp timeCreated;

	private String username, password;

	/*
	 * Constructor.
	 */

	public User( int dbIdTmp,
			Timestamp timeCreatedTmp,
			String usernameTmp,
			String passwordTmp ){

		dbId = dbIdTmp;

		timeCreated = timeCreatedTmp;

		username = usernameTmp;

		password = passwordTmp;

	}

	/*
	 * Getters.
	 */

	public int getDbId(){ return dbId; }

	public Timestamp getTimeCreated(){ return timeCreated; }

	public String getUsername(){ return username; }

	public String getPassword(){ return password; }

}
