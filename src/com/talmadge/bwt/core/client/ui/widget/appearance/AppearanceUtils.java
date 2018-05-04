package com.talmadge.bwt.core.client.ui.widget.appearance;

import com.google.gwt.dom.client.Element;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.IconAlign;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.util.BwtElementUtils;

/**
 * 
 * @author Noah
 *
 */
public final class AppearanceUtils
{
	/**
	 * 
	 * @param parent HasIcon
	 * @param icon Glyphicon
	 * @param iconAlign  Glyphicon
	 */
	public static void setIcon (HasIcon parent, Glyphicon icon, IconAlign iconAlign)
	{
		Element iconElement = parent.ensureIconElement();
	    
		if (parent.getIconParentElement().isOrHasChild(iconElement))
		{
			parent.getIconParentElement().removeChild(iconElement);
		}
		
		
	    BwtElementUtils.removeCssNames(iconElement, Glyphicon.values());
	    BwtElementUtils.removeCssNames(iconElement, IconAlign.values());
		
	    BwtElementUtils.ensureCssName(iconElement, icon.getCssName());
	    BwtElementUtils.ensureCssName(iconElement, iconAlign.getCssName());
	    
	    switch (iconAlign)
	    {
	    	case ABOVE:
	    		parent.getIconParentElement().insertFirst(iconElement);
	    		break;
	    		
	    	case BELOW:
	    		parent.getIconParentElement().appendChild(iconElement);
	    		break;
	    		
	    	case LEFT:
	    		parent.getIconParentElement().insertFirst(iconElement);
	    		break;
	    		
	    	case RIGHT:
	    		parent.getIconParentElement().appendChild(iconElement);
	    		break;
	    		
			default:
				break;
	    }
	}
	
	/**
	 * Hidden Constructor 
	 * 
	 */
	private AppearanceUtils ()
	{
		
	}
}
