/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.multiple;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.util.Position;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.styled.PrimaryButton;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.core.client.ui.widget.tooltip.Tooltip;
import com.talmadge.bwt.core.client.ui.widget.tooltip.animation.TooltipAnimation;
import com.talmadge.bwt.core.client.ui.widget.tooltip.config.TooltipConfig;
import com.talmadge.bwt.core.client.ui.widget.tooltip.theme.TooltipTheme;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah
 *
 */
public class MultipleView extends BwtExampleView
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
	public MultipleView (MultipleExample presenter)
	{
		super(presenter, "Multiple tooltips on a single element");
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
		
		TooltipConfig northTooltipConfig = new TooltipConfig(); 
		northTooltipConfig.setAnimation(TooltipAnimation.SWING);
		northTooltipConfig.setContent("North");
		northTooltipConfig.setPosition(Position.TOP);
		northTooltipConfig.setTheme(TooltipTheme.BORDERLESS);
		
		TooltipConfig eastTooltipConfig = new TooltipConfig();
		eastTooltipConfig.setAnimation(TooltipAnimation.FADE);
		eastTooltipConfig.setContent("East");
		eastTooltipConfig.setMultiple(true);
		eastTooltipConfig.setSide(Position.RIGHT);
		eastTooltipConfig.setTheme(TooltipTheme.LIGHT);
		
		
		TooltipConfig southTooltipConfig = new TooltipConfig();
		southTooltipConfig.setAnimation(TooltipAnimation.GROW);
		southTooltipConfig.setContent("South");
		southTooltipConfig.setMultiple(true);
		southTooltipConfig.setSide(Position.BOTTOM);
		southTooltipConfig.setTheme(TooltipTheme.NOIR);
		
		TooltipConfig westTooltipConfig = new TooltipConfig();
		westTooltipConfig.setAnimation(TooltipAnimation.FALL);
		westTooltipConfig.setContent("West");
		westTooltipConfig.setMultiple(true);
		westTooltipConfig.setSide(Position.LEFT);
		westTooltipConfig.setTheme(TooltipTheme.SHADOW);
		
		Tooltip.tooltip(button, northTooltipConfig);
		Tooltip.tooltip(button, eastTooltipConfig);
		Tooltip.tooltip(button, southTooltipConfig);
		Tooltip.tooltip(button, westTooltipConfig);
		
		tab.add(button);
		
    	//<=
	}
}