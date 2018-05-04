package com.talmadge.bwt.core.client.ui.widget.nav.navitem;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;
import com.talmadge.bwt.core.client.ui.widget.nav.navgroup.NavGroup;


/**
 * 
 * @author Noah
 *
 */
public interface NavItemAppearance extends BwtWidgetContainerAppearance
{
	/**
	 * 
	 */
	void attach ();
	
	/**
	 * 
	 */
	void detach ();

	/**
	 * @return HasClickHandlers
	 */
	HasClickHandlers getHasClickHandlers ();

	/**
	 * @return boolean
	 */
	boolean isScrollTo ();

    /**
	 */
	void removeNavGroup ();

	/**
	 * @param active boolean
	 */
	void setActive (boolean active);
	
	/**
	 * @param navGroup NavGroup
	 */
	void setNavGroup (NavGroup navGroup);
	
	/**
	 * @param isScrollTo boolean
	 */
	void setScrollTo (boolean isScrollTo);

	/**
	 * @param target String
	 */
	void setTarget (String target);

	/**
	 * @param text String
	 */
	void setText (String text);
}
