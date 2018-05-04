package com.talmadge.bwt.demo.client.modules.main.controllers.main.components;

import com.talmadge.bwt.core.client.date.BwtDate;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ContentAlign;
import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.flowpanel.BwtFlowPanel;

/**
 * 
 *
 */
public class BwtDemoFooter extends BwtFlowPanel
{
	/**
	 * Constructor  
	 */
	public BwtDemoFooter ()
	{
		super();
		this.ensureCssName("bwt-demo-footer");
		
		this.setContentAlign(ContentAlign.CENTER);
		this.add((new Html("Copyright &copy; " + BwtDate.newDate().getYear())).setCentered(true));
	}	
}
