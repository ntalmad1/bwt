/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.mouse;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.styled.PrimaryButton;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.core.client.ui.widget.tooltip.config.TooltipConfig;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah
 *
 */
public class MouseView extends BwtExampleView
{
	/**
	 */
	protected interface Resources extends ClientBundle, BwtExampleView.Resources
	{
		/**
		 */
		Resources INSTANCE = GWT.create(Resources.class); 
		
		/**
		 * 
		 * @return TextResource
		 */
		TextResource code ();
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param presenter ButtonBlockPresenter
	 */
	public MouseView (MouseExample presenter)
	{
		super(presenter, "Mouse tracking");
	}

	

	/**
	 * 
	 * @return String
	 */
	protected String getCodeRawText ()
	{
		return Resources.INSTANCE.code().getText();
	}



	/**
	 * 
	 * @param tab Tab
	 */
	protected void populateExamplesTab (Tab tab)
	{
		//=>
		Button button = new PrimaryButton("Hover");
		button.setWidth(75);
		
		TooltipConfig tooltipConfig = new TooltipConfig();
		tooltipConfig.setContent("Bacon ipsum dolor amet ham hock.");
		tooltipConfig.setMouseTracking(true);
		
		button.setTooltip(tooltipConfig);
		
		tab.add(button);
		
    	//<=
	}
}