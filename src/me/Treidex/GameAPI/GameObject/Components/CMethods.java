package me.Treidex.GameAPI.GameObject.Components;

import me.Treidex.GameAPI.GameObject.GameObject;
import me.Treidex.GameAPI.Util.Methods;

public class CMethods extends Methods {
	/**
	 * Store the Parent Game Object in which
	 * the Component is used inside.
	 */
	protected GameObject parent;
	
	protected CMethods() {
		if (!(this instanceof Component))
			throw new IllegalStateException("Component Methods can only be Super-Class of Components!");
	}
	
	public final void destroy(GameObject go) {
		parent.scene.destroy(go);
	}
	
	public final void destroy(int i) {
		parent.scene.destroy(i);
	}
	
	public final void destroy() {
		parent.scene.destroy(parent);
	}
}
