/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.Window;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.styled.PrimaryButton;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectEvent;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectHandler;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.core.client.ui.widget.tooltip.config.TooltipConfig;
import com.talmadge.bwt.core.client.ui.widget.tooltip.trigger.TooltipTrigger;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah
 *
 */
public class WidgetsView extends BwtExampleView
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
	public WidgetsView (WidgetsExample presenter)
	{
		super(presenter, "Add widgets to tooltips");
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
		final Button button = new PrimaryButton("Click");
		button.setWidth(75);
		
		Button tooltipButton = new Button("Click me");
		tooltipButton.addSelectHandler(new SelectHandler<Button>(){
			public void onSelect (SelectEvent<Button> event){
				Window.alert("Clicked");
				button.getTooltip().close();
			}
		});
		
		
		TooltipConfig tooltipConfig = new TooltipConfig();
		tooltipConfig.setInteractive(true);
		tooltipConfig.setTrigger(TooltipTrigger.CLICK);
		tooltipConfig.setContent(tooltipButton);
		
		
		button.setTooltip(tooltipConfig);
		
		tab.add(button);
		
    	//<=
	}
}