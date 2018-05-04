package com.talmadge.bwt.demo.client.modules.main.controllers.main;

import com.talmadge.bwt.core.client.app.endpoint.presenter.view.BwtView;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoBody;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoFooter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoHeader;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoNavBar;

/**
 * 
 *
 */
public class MainView extends BwtView
{
	/**
	 */
	private BwtDemoBody body;
	
	/**
	 */
	private BwtDemoFooter footer;
	
	/**
	 */
	private BwtDemoHeader header;
	
	/**
	 */
	private BwtDemoNavBar navBar;
	

	
	/**
	 * Constructor
	 * 
	 * @param controller MainController
	 */
	public MainView (MainController controller)
	{
		super(controller);
	}

	
	/**
	 * 
	 */
	@Override
	protected void init ()
	{
		this.header = new BwtDemoHeader();
		
		this.navBar = new BwtDemoNavBar();
		
		this.body = new BwtDemoBody();
		
		this.footer = new BwtDemoFooter();
	}


	/**
	 * 
	 */
	@Override
	public void go ()
	{
		if (this.header.isAttached())
		{
			return;
		}
		
		this.clear();
		this.ensureCssName("bwt-demo-view");
		
		this.add(this.header);
		this.add(this.navBar);
		this.add(this.body);
		this.add(this.footer);
	}
}
