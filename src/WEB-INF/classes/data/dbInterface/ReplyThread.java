
package dbInterface;

import java.sql.Timestamp;

/*
 * A class that stores
 * the data stored for one
 * thread.
 */

public class ReplyThread{

	private int id;

	private Timestamp timeCreated;

	private int numReplies, numUpVotes, numDownVotes,
		userId;

	private AttachmentType attachmentType;

	private String attachmentName, title, body;

	/*
	 * Constructor.
	 */

	public ReplyThread( int idTmp, Timestamp timeCreatedTmp,
			int numRepliesTmp, int numUpVotesTmp,
			int numDownVotesTmp, int userIdTmp,
			AttachmentType attachmentTypeTmp,
			String attachmentNameTmp,
			String titleTmp,
			String bodyTmp ){

		id = idTmp;

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

	public int getId(){ return id; }

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
