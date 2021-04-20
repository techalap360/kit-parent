package com.kit.api;

/**
 * @author Zubayer Ahamed
 * @since Dec 28, 2020
 */
public interface KITSessionManager {

	public void addToMap(String key, Object value);

	public Object getFromMap(String key);

	public void removeFromMap(String key);

	//public LoggedInUserDetails getLoggedInUserDetails();

	public String getBusinessId();
}
