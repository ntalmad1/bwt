package com.talmadge.bwt.core.client.ui.widget.nav.navitem;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Anchor;
import com.talmadge.bwt.core.client.ui.util.BwtWidgetUtils;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;
import com.talmadge.bwt.core.client.ui.widget.nav.navgroup.NavGroup;

/**
 * 
 * @author Noah
 *
 */
public class DefaultNavItemAppearance extends DefaultBwtWidgetContainerAppearance implements NavItemAppearance
{
	/**
	 */
	private Anchor anchor;
	
	/**
	 */
	private NavGroup navGroup;
	
	
	/**
	 * Constructor 
	 * 
	 */
	public DefaultNavItemAppearance ()
	{
		super(Document.get().createLIElement());
	}

	
	/**
	 * 
	 */
	public void attach ()
	{
		BwtWidgetUtils.attachWidget(this.anchor);
	}
	
	
	/**
	 * 
	 */
	public void detach ()
	{
		BwtWidgetUtils.detachWidget(this.anchor);
	}


	/**
	 * 
	 * @return HasClickHandlers
	 */
	public HasClickHandlers getHasClickHandlers ()
	{
		return this.anchor;
	}


	/**
	 * 
	 * @return boolean
	 */
	public boolean hasNavGroup ()
	{
		return this.navGroup != null;
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
    public boolean isScrollTo ()
    {
        return this.anchor.getElement().hasClassName("scrollclass");
    }


    /**
	 * 
	 */
	public void removeNavGroup ()
	{
		if (this.hasNavGroup())
		{
			this.getElement().removeChild(this.navGroup.getElement());
			this.navGroup = null;
		}
	}


	/**
	 * 
	 * @param active boolean 
	 */
	public void setActive (boolean active)
	{
		this.toggleCssName("active", active);		
	}


	/**
	 * 
	 * @param navGroup NavGroup
	 */
	public void setNavGroup (NavGroup navGroup)
	{
		this.removeNavGroup();
		
		this.navGroup = navGroup;
		
		this.getElement().appendChild(navGroup.getElement());
		
		
	}


	/**
	 * 
	 * @param isScrollTo boolean
	 */
	public void setScrollTo (boolean isScrollTo)
	{
		this.toggleCssName(this.anchor.getElement(), "scrollclass", isScrollTo);		
	}


	/**
	 * Sets the data-target attribute
	 * 
	 * @param target String
	 */
	public void setTarget (String target)
	{
		this.anchor.getElement().setAttribute("data-target", "#" + target);		
	}


	/**
	 * 
	 * @param text String
	 */
	public void setText (String text)
	{
		this.anchor.setHTML(text);		
	}


	/**
	 * 
	 */
	protected void build ()
	{
		this.anchor = new Anchor();
		
		this.getElement().appendChild(this.anchor.getElement());
	}

}
