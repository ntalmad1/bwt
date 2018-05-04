package com.talmadge.bwt.core.client.ui.widget.nav;

import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.widget.nav.event.HasItemAddHandlers;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;

/**
 * 
 * @author Noah
 *
 */
public interface Nav extends HasItemAddHandlers
{
	/**
	 * @param navItem NavItem
	 */
	void add (NavItem navItem);

	
	/**
	 * @return Widget
	 */
	Widget asWidget ();


	/**
	 * @return String
	 */
	String getId ();

	
	/**
	 * 
	 * @param navItem NavItem
	 */
	void setActive (NavItem navItem);

}
