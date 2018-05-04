package com.talmadge.bwt.core.client.ui.widget.layout.panel;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ContentAlign;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerInterface;

/**
 * @author Noah
 *
 */
public interface BwtPanelInterface extends BwtWidgetContainerInterface
{
	/**
	 * 
	 * @param widget IsWidget
	 * @param margins Margins...
	 */
	void add (IsWidget widget, Margins... margins);
	
	
	/**
	 * 
	 * @param widget Widget
	 * @param margins Margins...
	 */
	void add (Widget widget, Margins... margins);


	/**
	 * 
	 * @return Element
	 */
	Element getElement ();
	
	
	/**
	 *
	 * @return String
	 */
	String getId ();

	/**
	 * 
	 * @param cssName String
	 */
	void ensureCssName (String cssName);


	/**
	 * 
	 * @return boolean
	 */
    boolean isAttached ();
    
    /**
     * 
     */
    void mask ();

    /**
     * 
     */
    void mask (String message);

	/**
     * 
     * @param isCentered boolean 
     */
    void setCentered (boolean isCentered);

    /**
     * 
     * @param align
     */
    void setContentAlign (ContentAlign align);

    /**
     * 
     * @param inlineBlock Display
     */
    void setDisplay (Display display);


	/**
     * 
     * @param height String
     */
    void setHeight (String height);


	/**
     * 
     * @param id String
     */
    void setId (String id);
    
    
    /**
     * 
     * @param height int
     */
    void setMinHeight (int height);

    
    /**
     * 
     * @param align VerticalAlign
     */
	void setVerticalAlign (VerticalAlign align);

	
	/**
	 * 
	 */
	void unmask ();
}
