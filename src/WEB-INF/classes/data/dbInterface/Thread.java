
package dbInterface;

import java.sql.Timestamp;

/*
 * A class that stores
 * the data stored for one
 * thread.
 */

public class Thread{

	private int dbId;

	private Timestamp timeCreated;

	private int numReplies, numUpVotes, numDownVotes,
		userId;

	private AttachmentType attachmentType;

	private String attachmentName, title, body;

	/*
	 * Constructor.
	 */

	public Thread( int dbIdTmp, Timestamp timeCreatedTmp,
			int numRepliesTmp, int numUpVotesTmp,
			int numDownVotesTmp, int userIdTmp,
			AttachmentType attachmentTypeTmp,
			String attachmentNameTmp,
			String titleTmp,
			String bodyTmp ){

		dbId = dbIdTmp;

		timeCreated = timeCreatedTmp;

		numReplies = numRepliesTmp;

		numUpVotes = numUpVotesTmp;

		numDownVotes = numDownVotesTmp;

		userId = userIdTmp;

		attachmentType = attachmentTypeTmp;

		attachmentName = attachmentNameTmp;

		title = titleTmp;

		body = bodyTmp;

	}

	/*
	 * Getters.
	 */

	public int getDbId(){ return dbId; }

	public Timestamp getTimeCreated(){ return timeCreated; }

	public int getNumReplies(){ return numReplies; }

	public int getNumUpVotes(){ return numUpVotes; }
	
	public int getNumDownVotes(){ return numDownVotes; }

	public int getUserId(){ return userId; }

	public AttachmentType getAttachmentType(){

		return attachmentType;

	}

	public String getAttachmentName(){

		return attachmentName;

	}

	public String getTitle(){ return title; }

	public String getBody(){ return body; }

}
