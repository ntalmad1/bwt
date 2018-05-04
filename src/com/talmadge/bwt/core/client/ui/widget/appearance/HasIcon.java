package com.talmadge.bwt.core.client.ui.widget.appearance;

import com.google.gwt.dom.client.Element;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.IconAlign;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;

/**
 * 
 * @author Noah
 *
 */
public interface HasIcon
{
	/**
	 * 
	 * @return Element
	 */
	Element ensureIconElement ();


	/**
	 * 
	 * @return Element
	 */
	Element getIconParentElement ();
	
	
	/**
	 * 
	 * @return Glyphicon
	 */
	Glyphicon getIcon ();
	
	
	/**
	 * 
	 * @return IconAlign
	 */
	IconAlign getIconAlign ();

	
	/**
	 * 
	 * @return boolean
	 */
	boolean hasIcon ();
	
	
	/**
     * @param icon Glyphicon
     */
    void setIcon (Glyphicon icon);
    
    
    /**
     * 
     * @param iconAlign IconAlign
     */
    void setIconAlign (IconAlign iconAlign);
}
