package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.glyphicons;

import com.talmadge.bwt.demo.client.lib.example.BwtExampleGroup;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;


/**
 * 
 * @author Noah
 *
 */
public class GlyphiconsExamples extends BwtExampleGroup
{
	/**
	 * 
	 * @param sidebar BwtDemoSidebar
	 */
	public GlyphiconsExamples (BwtDemoSidebar sidebar)
	{
		super();
		
		this.setView(new GlyphiconsView(this));
		
		this.populateSideNav(sidebar);
	}


	/**
	 * 
	 * @return GlyphiconsView
	 */
	public GlyphiconsView getView ()
	{
		return (GlyphiconsView) super.getView();
	}
}
