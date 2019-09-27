
package dbInterface;

import java.sql.Timestamp;

/*
 * A class that stores
 * the data stored for one
 * user.
 */

public class User{

	private int id;

	private Timestamp timeCreated;

	private String username, password;

	/*
	 * Constructor.
	 */

	public User( int idTmp,
			Timestamp timeCreatedTmp,
			String usernameTmp,
			String passwordTmp ){

		id = idTmp;

		timeCreated = timeCreatedTmp;

		username = usernameTmp;

		password = passwordTmp;

	}

	/*
	 * Getters.
	 */

	public int getId(){ return id; }

	public Timestamp getTimeCreated(){ return timeCreated; }

	public String getUsername(){ return username; }

	public String getPassword(){ return password; }

}
