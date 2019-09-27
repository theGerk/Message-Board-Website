
package dbInterface;

import java.sql.Timestamp;
/*
 * A class that stores
 * the data stored for one
 * reply.
 */

public class Reply{

	private int dbId;

	private Timestamp timeCreated;

	private int threadId, numReplies, numUpVotes, numDownVotes,
		userId, replyId;

	private AttachmentType attachmentType;

	private String attachmentName, title, body;

	/*
	 * Constructor.
	 */

	public Reply( int dbIdTmp, Timestamp timeCreatedTmp,
			int threadIdTmp,
			int numRepliesTmp, int numUpVotesTmp,
			int numDownVotesTmp, int userIdTmp,
			int replyIdTmp,
			AttachmentType attachmentTypeTmp,
			String attachmentNameTmp,
			String titleTmp,
			String bodyTmp ){

		dbId = dbIdTmp;

		timeCreated = timeCreatedTmp;

		threadId = threadIdTmp;

		numReplies = numRepliesTmp;

		numUpVotes = numUpVotesTmp;

		numDownVotes = numDownVotesTmp;

		userId = userIdTmp;

		replyId = replyIdTmp;

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

	public int getThreadId(){ return threadId; }

	public int getNumReplies(){ return numReplies; }

	public int getNumUpVotes(){ return numUpVotes; }
	
	public int getNumDownVotes(){ return numDownVotes; }

	public int getUserId(){ return userId; }
	
	public int getReplyId(){ return replyId; }

	public AttachmentType getAttachmentType(){

		return attachmentType;

	}

	public String getAttachmentName(){

		return attachmentName;

	}

	public String getTitle(){ return title; }

	public String getBody(){ return body; }

}
