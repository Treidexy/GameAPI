package me.Treidex.GameAPI.GameObject.Components;

@Deprecated
public class ComponentNoIDException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2769703782317520898L;

	public ComponentNoIDException() {
		super();
	}

	public ComponentNoIDException(String message) {
		super(message);
	}

	public ComponentNoIDException(Throwable cause) {
		super(cause);
	}

	public ComponentNoIDException(String message, Throwable cause) {
		super(message, cause);
	}

	public ComponentNoIDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
