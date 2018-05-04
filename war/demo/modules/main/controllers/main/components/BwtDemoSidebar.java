package com.talmadge.bwt.demo.client.modules.main.controllers.main.components;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.nav.scrollspy.ScrollSpy;
import com.talmadge.bwt.core.client.ui.widget.nav.sidebar.Sidebar;

/**
 * 
 *
 */
public class BwtDemoSidebar extends Sidebar
{
	/**
	 * Constructor
	 * 
	 */
	public BwtDemoSidebar ()
	{
		super();
		
        this.setAffix(true);
        
        ScrollSpy scrollSpy = new ScrollSpy(Document.get().getBody());
        scrollSpy.setOffsetTop(400);
        scrollSpy.setOffsetBottom(300);
        
        this.setScrollSpy(scrollSpy);
	}
}
