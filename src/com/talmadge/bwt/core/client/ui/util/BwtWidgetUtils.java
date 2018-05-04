package com.talmadge.bwt.core.client.ui.util;

import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.Bwt;

/**
 * 
 * @author Noah
 *
 */
public final class BwtWidgetUtils
{
	/**
	 *
	 * @param widget Widget
	 */
	public static native void attachWidget (Widget widget)/*-{
	    if ((widget != null) && !widget.@com.google.gwt.user.client.ui.Widget::isAttached()())
	    {
	        widget.@com.google.gwt.user.client.ui.Widget::onAttach()();
	    }
	}-*/;


	/**
	 *
	 * @param widget Widget
	 */
	public static native void detachWidget (Widget widget) /*-{
	    if ((widget != null) && widget.@com.google.gwt.user.client.ui.Widget::isAttached()())
	    {
	        widget.@com.google.gwt.user.client.ui.Widget::onDetach()();
	    }
	}-*/;

	
	/**
     * 
     * @param widget Widget
     * @param cssName String
     */
    public static void ensureCssName (Widget widget, String cssName)
    {
        BwtElementUtils.ensureCssName(widget.getElement(), cssName); 
    }


    /**
	 * 
	 * @param string String
	 * @return int
	 */
	public static int extractNumValue (String string)
    {
	    if (string != null && !string.isEmpty())
        {
            RegExp p = RegExp.compile("\\d+");
            MatchResult m = p.exec(string); 
            
            if (m != null)
            {
                return Integer.parseInt(m.getGroup(0));
            }
        }
        
        return 0;
    }


    /**
	 *
	 * @return String
	 */
	public static String uniqueId ()
	{
		String id = "bwt-" + DOM.createUniqueId();
		
		if (id.equals("bwt-gwt-uid-1066"))
		{
			Bwt.log(new Exception(id));
		}
		
		return id;
	}


	/**
	 * Hidden Constructor
	 *
	 */
	private BwtWidgetUtils ()
	{

	}
}
