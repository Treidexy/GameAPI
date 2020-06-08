package me.Treidex.Game.Anotations;

/**
 * Someone had to make this API,
 * and Credit to them.
 * 
 * @author Treidex
 *
 */
public @interface Credit {
	
	/**
	 * Which Author Should
	 * we Credit?
	 */
	String Author();
	
	/**
	 * Which Project did this person
	 * Contribute to?
	 */
	String ProjectName();
	
	/**
	 * Anything about him?
	 * Links to GitHub, maybe?
	 */
	String[] Links();
	
	/**
	 * What description about the Author
	 * is there?
	 * (bio)
	 */
	String[] Description();
	
	/**
	 * Which Version did the Author
	 * work on?
	 */
	String[] Versions();
}