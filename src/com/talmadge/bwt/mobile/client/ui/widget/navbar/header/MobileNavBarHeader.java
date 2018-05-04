package com.talmadge.bwt.mobile.client.ui.widget.navbar.header;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 *
 */
public class MobileNavBarHeader extends BwtWidgetContainer 
{
	/**
	 */
	private Html button;


	
	/**
	 * Constructor
	 * 
	 */
	public MobileNavBarHeader ()
	{
		this((MobileNavBarHeaderAppearance) GWT.create(DefaultMobileNavBarHeaderAppearance.class));
	}
	

	/**
	 * Constructor
	 * 
	 * @param appearance MobileNavBarHeaderAppearance
	 */
	protected MobileNavBarHeader (MobileNavBarHeaderAppearance appearance)
	{
		super(appearance);
		
		this.button = Html.button();
		
		this.button.setAttribute("type", "button");
		this.button.ensureCssName("drawer-toggle");
		this.button.ensureCssName("navbar-toggle");
		
		this.button.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		
	
		
		
		this.button.add(Html.span().ensureCssName("icon-bar"));
		this.button.add(Html.span().ensureCssName("icon-bar"));
		this.button.add(Html.span().ensureCssName("icon-bar"));
		
		
		
		this.add(this.button);
		

	
		
		
		
		/*
		<button type="button" class="drawer-toggle navbar-toggle">
    	<span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    	*/
		
	}
	
}
