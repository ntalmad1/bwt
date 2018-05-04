package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups;

import com.talmadge.bwt.demo.client.lib.example.BwtExampleGroup;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups.basic.BasicPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups.dropdowns.DropdownsPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups.justified.JustifiedPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups.sizing.SizingPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups.toolbars.ToolbarsPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups.vertical.VerticalPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 * @author Noah
 *
 */
public class ButtonGroupsPresenter extends BwtExampleGroup
{

	
	/**
	 * Constructor
	 * 
	 * @param sidebar BwtDemoSidebar
	 */
	public ButtonGroupsPresenter (BwtDemoSidebar sidebar)
	{
		super();
		this.setView(new ButtonGroupsView(this)); 
		
		this.addExample(new BasicPresenter());
		this.addExample(new ToolbarsPresenter());	
		this.addExample(new SizingPresenter());
		this.addExample(new DropdownsPresenter());
		this.addExample(new JustifiedPresenter());	
		this.addExample(new VerticalPresenter());
	
		this.populateSideNav(sidebar);
	}
}
