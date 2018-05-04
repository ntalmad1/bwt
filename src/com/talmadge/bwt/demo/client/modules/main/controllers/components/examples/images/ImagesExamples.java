package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.images;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 * @author Noah
 *
 */
public class ImagesExamples extends BwtExamplePresenter
{

	
	/**
	 * Constructor
	 * 
	 */
	public ImagesExamples (BwtDemoSidebar sidebar)
	{
		super();
		this.setView(new ImagesView(this)); 
	
		this.populateSideNav(sidebar);
	}
}
