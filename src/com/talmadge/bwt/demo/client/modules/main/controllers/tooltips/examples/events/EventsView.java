/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.events;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.Bwt;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.styled.PrimaryButton;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.core.client.ui.widget.tooltip.Tooltip;
import com.talmadge.bwt.core.client.ui.widget.tooltip.event.beforeshow.BeforeTooltipShowEvent;
import com.talmadge.bwt.core.client.ui.widget.tooltip.event.beforeshow.BeforeTooltipShowHandler;
import com.talmadge.bwt.core.client.ui.widget.tooltip.event.hide.TooltipHideEvent;
import com.talmadge.bwt.core.client.ui.widget.tooltip.event.hide.TooltipHideHandler;
import com.talmadge.bwt.core.client.ui.widget.tooltip.event.show.TooltipShowEvent;
import com.talmadge.bwt.core.client.ui.widget.tooltip.event.show.TooltipShowHandler;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah
 *
 */
public class EventsView extends BwtExampleView
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
	 * @param presenter EventsExample
	 */
	public EventsView (EventsExample presenter)
	{
		super(presenter, "Event handling");
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
		
		Tooltip tooltip = button.setTooltip("Bacon ipsum dolor amet ham hock.");
		
		tooltip.addBeforeTooltipShowHandler(new BeforeTooltipShowHandler(){
			public void onBeforeTooltipShow (BeforeTooltipShowEvent event){
				Bwt.log("before");				
			}			
		});
		
		
		tooltip.addTooltipShowHandler(new TooltipShowHandler(){
			public void onTooltipShow (TooltipShowEvent event){
				Bwt.log("show");				
			}			
		});
		
		
		tooltip.addTooltipHideHandler(new TooltipHideHandler(){
			public void onTooltipHide (TooltipHideEvent event){
				Bwt.log("hide");				
			}			
		});

		
		tab.add(button);
		
    	//<=
	}
}