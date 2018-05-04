package com.talmadge.bwt.core.client.app.endpoint;

import com.google.gwt.user.client.ui.Panel;
import com.talmadge.bwt.core.client.app.BwtApplication;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 *
 */
public interface Endpoint
{
	/**
	 * @throws Exception
	 */
	void go () throws Exception;;

	/**
	 * @param app BwtApplication
	 */
	void setApp (BwtApplication app);
	
	/**
	 * @param target BwtWidgetContainer
	 */
	void setTarget (BwtWidgetContainer target);
	
	/**
	 * @param panel
	 * @throws Exception 
	 */
	void setTarget (Panel panel) throws Exception;
	
	/**
	 * @param path String
	 */
	void setPath (String path);
}
