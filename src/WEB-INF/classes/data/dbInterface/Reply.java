
package dbInterface;

import java.sql.Timestamp;
/*
 * A class that stores
 * the data stored for one
 * reply.
 */

public class Reply{

	private int id;

	private Timestamp timeCreated;

	private int threadId, numReplies, numUpVotes, numDownVotes,
		userId, replyId;

	private AttachmentType attachmentType;

	private String attachmentName, body;

	/*
	 * Constructor.
	 */

	public Reply( int idTmp, Timestamp timeCreatedTmp,
			int threadIdTmp,
			int numRepliesTmp, int numUpVotesTmp,
			int numDownVotesTmp, int userIdTmp,
			int replyIdTmp,
			AttachmentType attachmentTypeTmp,
			String attachmentNameTmp,
			String bodyTmp ){

		id = idTmp;

		timeCreated = timeCreatedTmp;

		threadId = threadIdTmp;

		numReplies = numRepliesTmp;

		numUpVotes = numUpVotesTmp;

		numDownVotes = numDownVotesTmp;

		userId = userIdTmp;

		replyId = replyIdTmp;

		attachmentType = attachmentTypeTmp;

		attachmentName = attachmentNameTmp;

		body = bodyTmp;

	}

	/*
	 * Getters.
	 */

	public int getId(){ return id; }

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

	public String getBody(){ return body; }

}
