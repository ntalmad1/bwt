package com.talmadge.bwt.core.client.app.endpoint.presenter.view;

import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * @author Noah
 *
 */
public interface BwtViewInterface 
{
    /**
     * 
     * @param html String
     */
    void add (String html);
    
    /**
     * 
     * @param widget
     */
    void add (Widget widget);
    
	/**
     * @return String
     */
    String getId ();
    
    /**
     * 
     * @return boolean
     */
    boolean hasId ();


	/**
     * 
     */
    void mask ();

	/**
     * @param id String
     */
    void setId (String id);
    
    /**
     * 
     */
	void go ();
		
	/**
	 * 
	 */
	void unmask ();

	void setTarget (BwtWidgetContainer target);
}
