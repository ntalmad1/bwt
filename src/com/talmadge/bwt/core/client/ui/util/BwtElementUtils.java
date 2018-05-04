package com.talmadge.bwt.core.client.ui.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.HasCssName;

/**
 * @author Noah
 *
 */
public final class BwtElementUtils
{
	/**
	 * 
	 * @param element Element
	 * @param cssName String
	 */
	public static void ensureCssName (Element element, String cssName)
	{
		if (cssName == null || cssName.trim().isEmpty())
		{
			return;
		}
		
		if (element.hasClassName(cssName))
		{
			return;
		}
		
		element.addClassName(cssName);
	}
	
	
	/**
     * 
	 * @param element Element
	 * @param cssName String
	 */
	public static void removeCssName (Element element, String cssName)
	{
		if (cssName == null || cssName.trim().isEmpty())
		{
			return;
		}
		
		if (!element.hasClassName(cssName))
		{
			return;
		}
		
		element.removeClassName(cssName);	    
	}	
	
	
	/**
	 * 
	 * @param element Element
	 * @param cssNames HasClassName[]
	 */
	public static void removeCssNames (Element element, HasCssName[] cssNames)
	{
		for (int i = 0; i < cssNames.length; ++i)
		{
			BwtElementUtils.removeCssName(element, cssNames[i].getCssName());
		}
	}
	
	
	/**
	 * 
	 * @param element Element
	 * @param cssName String
	 * @param toggle boolean 
	 */
	public static void toggleCssName (Element element, String cssName, boolean toggle)
	{
		if (toggle)
    	{
    		BwtElementUtils.ensureCssName(element, cssName);
    	}
    	else
    	{
    		BwtElementUtils.removeCssName(element, cssName);
    	}
	}

	
	/**
	 * 
	 * @param elem Element
	 * @return int
	 */
	public static native int getCursorPos (Element elem) /*-{
		try 
		{
			return elem.selectionStart;
		} 
		catch (e) 
		{
			return 0;
		}
	}-*/;


	/**
	 * 
	 * @param elem Element
	 * @return int
	 */
	public static native int getSelectionLength (Element elem) /*-{
		try 
		{
			return elem.selectionEnd - elem.selectionStart;
		} 
		catch (e) 
		{
			return 0;
		}
	}-*/;


	/**
	 * 
	 * @param element JavaScriptObject
	 */
	public static native void hide (JavaScriptObject element) /*-{
		
		$wnd.$(element).hide();
		
	}-*/;
	
	
	/**
	 * 
	 * @param elem Element
	 * @param pos int 
	 * @param length int
	 */
	public static native void setSelectionRange (Element elem, int pos, int length) /*-{
		try 
		{
			elem.setSelectionRange(pos, pos + length);
		} 
		catch (e) 
		{
	
		}
	}-*/;


	/**
	 * 
	 * @param element JavaScriptObject
	 */
	public static native void show (JavaScriptObject element) /*-{
		
		$wnd.$(element).show();
		
	}-*/;
	

    /**
     * Hidden Constructor
     */
    private BwtElementUtils ()
    {

    }
}
