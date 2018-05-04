package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.code;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 * @author Noah
 *
 */
public class CodeExamples extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public CodeExamples (BwtDemoSidebar sidebar)
	{
		super();
		this.setView(new CodeView(this));
		
		this.populateSideNav(sidebar);
	}
}
