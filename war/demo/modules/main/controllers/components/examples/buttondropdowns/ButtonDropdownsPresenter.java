package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttondropdowns;

import com.talmadge.bwt.demo.client.lib.example.BwtExampleGroup;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttondropdowns.direction.DirectionPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttondropdowns.singlebuttons.SingleButtonsPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttondropdowns.sizing.SizingPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttondropdowns.splitbuttons.SplitButtonsPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttondropdowns.submenus.SubmenusPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 * @author Noah
 *
 */
public class ButtonDropdownsPresenter extends BwtExampleGroup
{

	
	/**
	 * Constructor
	 * 
	 * @param sidebar BwtDemoSidebar
	 */
	public ButtonDropdownsPresenter (BwtDemoSidebar sidebar)
	{
		super();
		this.setView(new ButtonDropdownsView(this)); 
		
		this.addExample(new SingleButtonsPresenter());	
		this.addExample(new SplitButtonsPresenter());	
		this.addExample(new SizingPresenter());
		this.addExample(new DirectionPresenter());
		this.addExample(new SubmenusPresenter());

		this.populateSideNav(sidebar);
	}
}
