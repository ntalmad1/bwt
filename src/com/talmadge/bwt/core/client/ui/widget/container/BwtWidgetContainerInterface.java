package com.talmadge.bwt.core.client.ui.widget.container;

import com.talmadge.bwt.core.client.ui.widget.BwtWidgetInterface;

/**
 * 
 *
 */
public interface BwtWidgetContainerInterface extends BwtWidgetInterface, HasChildren
{
	/**
	 * 
	 * @param id String
	 */
	void setId (String id);
	
	
	/**
	 * 
	 * @return String
	 */
	String getId ();
}
