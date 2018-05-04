package com.talmadge.bwt.core.client.app.session;

/**
 * 
 *
 */
public class BwtSession
{
	/**
	 */
	private static BwtSession instance;
	
	
	/**
	 * 
	 * @return BwtSession
	 */
	public static BwtSession getInstance ()
	{
		if (instance == null)
		{
			instance = new BwtSession();
		}
		
		return instance;
	}
	
	
	/**
	 */
	private LogoutActionProvider logoutAction;
	
	
	/**
	 * Hidden Constructor
	 * 
	 */
	protected BwtSession ()
	{
		
	}
	
	
	/**
	 * 
	 * @return LogoutActionProvider
	 */
	public LogoutActionProvider getLogoutAction ()
	{
		return this.logoutAction;
	}

	
	/**
	 * 
	 */
	public void logout ()
	{
		this.getLogoutAction().onLogout();
	}
	

	/**
	 * 
	 * @param logoutAction LogoutActionProvider
	 */
	public void setLogoutAction (LogoutActionProvider logoutAction)
	{
		this.logoutAction = logoutAction;
	}

	
	/**
	 * 
	 */
	public void clear ()
	{
		// TODO: implement clear session		
	}
}
