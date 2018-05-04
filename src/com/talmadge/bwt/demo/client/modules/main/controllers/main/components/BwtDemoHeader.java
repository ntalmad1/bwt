package com.talmadge.bwt.demo.client.modules.main.controllers.main.components;

import com.talmadge.bwt.core.client.ui.widget.container.jumbotron.Jumbotron;
import com.talmadge.bwt.core.client.ui.widget.layout.container.LayoutContainer;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.templates.Templates;
import com.talmadge.bwt.template.client.TemplateFactory;


/**
 * 
 *
 */
public class BwtDemoHeader extends Jumbotron
{
	/**
	 * 
	 */
	public BwtDemoHeader ()
	{
		super();
		this.addClassName("bwt-demo-masthead");
		this.setCornerRadius(0);
    
		LayoutContainer contentContainer = new LayoutContainer();
		contentContainer.add(TemplateFactory.compile(Templates.INSTANCE.masterHead()).renderHtml());
		
		this.add(contentContainer);
	}
}
