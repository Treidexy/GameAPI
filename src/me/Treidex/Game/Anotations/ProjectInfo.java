package me.Treidex.Game.Anotations;


/**
 * There is always a Project
 * to work on;
 * so, why don't we
 * tell you about it?
 * 
 * @author Treidex
 *
 */
public @interface ProjectInfo {
	
	/**
	 * Describe the name
	 * of the Project.
	 */
	String Name();
	
	/**
	 * Who contributed to
	 * this Project?
	 */
	String[] Authors();
	
	/**
	 * Which Version is the
	 * Project on.
	 */
	String Version();
	
	/**
	 * Give a description
	 * about the Project.
	 */
	String[] Description();
	
	/**
	 * Is there a Project Page
	 * GitHub, maybe?
	 */
	String Page();
}
