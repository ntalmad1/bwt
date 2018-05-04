package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttons;

import com.talmadge.bwt.demo.client.lib.example.BwtExampleGroup;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttons.block.ButtonBlockPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttons.sizes.ButtonSizesPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttons.states.ButtonStatesPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttons.styles.ButtonStylesPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 * @author Noah
 *
 */
public class ButtonsExamples extends BwtExampleGroup
{

	
	/**
	 * Constructor
	 * 
	 */
	public ButtonsExamples (BwtDemoSidebar sidebar)
	{
		super();
		this.setView(new ButtonsView(this)); 
		
		this.addExample(new ButtonStylesPresenter());
		this.addExample(new ButtonSizesPresenter());
		this.addExample(new ButtonBlockPresenter());
		this.addExample(new ButtonStatesPresenter());
		
		this.populateSideNav(sidebar);
	}
}
