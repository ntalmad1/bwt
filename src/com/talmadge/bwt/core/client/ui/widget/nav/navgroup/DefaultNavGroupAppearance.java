package com.talmadge.bwt.core.client.ui.widget.nav.navgroup;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.NavGroupOrientation;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.NavGroupStyle;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultNavGroupAppearance extends DefaultBwtWidgetContainerAppearance implements NavGroupAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultNavGroupAppearance ()
	{
		super(Document.get().createULElement());
	}

	
	/**
	 * 
	 * @return boolean 
	 */
	public boolean isAffix ()
	{
		return this.hasCssName("affix");
	}


	/**
	 * 
	 * @param affix boolean
	 */
	public void setAffix (boolean affix)
	{
		this.toggleCssName("affix", affix);	
		
		if (affix)
		{
		    this.getElement().setAttribute("data-spy", "affix");
		}
		else
		{
		    this.getElement().removeAttribute("data-spy");
		}
	}


	/**
	 * 
	 * @param justified boolean
	 */
	public void setJustified (boolean justified)
	{
		this.toggleCssName("nav-justified", justified);		
	}


	/**
	 * 
	 * @param style NavGroupStyle
	 */
	public void setNavGoupStyle (NavGroupStyle style)
	{
		this.removeCssNames(NavGroupStyle.values());
		
		this.ensureCssName(style.getCssName());
	}
	
	
	/**
	 * 
	 * @param offset int
	 */
	public void setOffsetBottom (int offset)
	{
		this.getElement().setAttribute("data-offset-bottom", "" + offset);		
	}
	

	/**
	 * 
	 * @param offset int
	 */
	public void setOffsetTop (int offset)
	{
		this.getElement().setAttribute("data-offset-top", "" + offset);		
	}


	/**
	 * 
	 * @param orientation NavGroupOrientation
	 */
	public void setOrientaion (NavGroupOrientation orientation)
	{
		this.removeCssNames(NavGroupOrientation.values());
		
		this.ensureCssName(orientation.getCssName());
	}


	/**
	 * 
	 */
	protected void build ()
	{
		this.getElement().addClassName("nav");	
	}
}
