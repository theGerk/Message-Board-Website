
/*
 * A class for the
 * data of a comment.
 */

public class Comment{

	/*
	 * The ids for this comment,
	 * the user who posted it,
	 * and the spot it was posted
	 * on.
	 */

	private int id, userId, spotId;

	/*
	 * Optional reply id.
	 */

	private boolean isReply;

	private int replyId;

	/*
	 * The text in the comment.
	 */

	private String text;

	/*
	 * The type of file posted
	 * with this comment and its
	 * name, which does not include
	 * a full path.
	 */

	private AttachmentType attachmentType;

	private String attachmentName;

	/*
	 * The number of up and down
	 * votes for this comment.
	 */

	private int upVotes, downVotes;

	/*
	 * The constructor simply takes
	 * in the above values.
	 */

	public Comments( int idTmp, int userIdTmp, spotIdTmp,
			boolean isReplyTmp, int replyIdTmp,
			String textTmp, 
			AttachmentType attachmentTypeTmp,
			String attachmentNameTmp,
			int upVotesTmp, int downVotesTmp ){

		id = idTmp;

		userId = userIdTmp;

		spotId = spotId;

		isReply = isReplyTmp;

		replyId = replyIdTmp;

		text = textTmp;

		attachmentType = attachmentTypeTmp;

		attachmentName = attachmentNameTmp;
	
		upVotes = upVotesTmp;
		
		downVotes = downVotesTmp;

	}

