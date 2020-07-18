package me.Treidex.GameAPI.GameObject;

/**
 * A template for Creating Multiple Instances
 * of one Game Object.
 * 
 * @author Treidex
 *
 */
public interface Prefab {
	
	/**
	 * What Happens when you Instansiate the Prefab.
	 * 
	 * @return A copy Game Object.
	 */
	public GameObject instansiate();
}
