/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.smart;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.jqueryui.JQueryUi;
import com.talmadge.bwt.core.client.ui.jqueryui.event.JQueryUiActionHandler;
import com.talmadge.bwt.core.client.ui.jqueryui.interaction.Interaction;
import com.talmadge.bwt.core.client.ui.jqueryui.interaction.draggable.DraggableConfig;
import com.talmadge.bwt.core.client.ui.jqueryui.interaction.helper.InteractionHelper;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.styled.PrimaryButton;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.core.client.ui.widget.tooltip.Tooltip;
import com.talmadge.bwt.core.client.ui.widget.tooltip.config.TooltipConfig;
import com.talmadge.bwt.core.client.ui.widget.tooltip.trigger.TooltipTrigger;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah
 *
 */
public class SmartView extends BwtExampleView
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
	public SmartView (SmartExample presenter)
	{
		super(presenter, "Smart positioning");
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
		Button button = new PrimaryButton("Drag");
		button.setWidth(75);
		
		final DraggableConfig draggableConfig = new DraggableConfig();
		draggableConfig.setGrid(1, 1);
		draggableConfig.setHelper(InteractionHelper.CLONE);
		draggableConfig.setRevert(true);
		draggableConfig.setScroll(false);
		draggableConfig.setCancel(false);
		draggableConfig.setStart(new JQueryUiActionHandler(){
			public void onJQueryUiAction (NativeEvent event, JQueryUi ui) {
				
				TooltipConfig config = new TooltipConfig();
				config.setContent("Move my origin next to the edges of the screen and see how I adapt.<br />Besides, there are several options to tune my behavior.");
				config.setContentAsHtml(true);
				config.setTrackerInterval(10);
				config.setTrackOrigin(true);
				config.setTrigger(TooltipTrigger.CUSTOM); 
				
				
				
				Tooltip tooltip = new Tooltip(ui.getElement(), config);
				tooltip.show();
				
			}
		});
		
		Interaction.draggable(button, draggableConfig);
		
		tab.add(button);
		
    	//<=
	}
}