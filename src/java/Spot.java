
/*
 * A class storing the data needed
 * for the webpage for a spot.
 * 
 * When a user navigates to a spot's
 * webpage, an instance of this
 * class is initialized for the spot.
 * Then this class' getters are
 * used to build the webpage.
 */

import java.util.List;

public class Spot{

	/*
	 * The id of this spot
	 * in the 'Spots' sql table.
	 */

	private long int uniqueId;

	/*
	 * The latitude and
	 * longitude of the spot.
	 */

	private float longitude, latitude;

	/*
	 * The most relevant n comments on this
	 * spot.
	 */

	private List< Comment > comments;

	/*
	 * The main constructor initializes
	 * the above variables from the given
	 * uniqueId. It loads
	 * numComments comments.
	 */

	public SpotData( int uniqueIdTmp, int numComments ){

		uniqueId = uniqueIdTmp;









