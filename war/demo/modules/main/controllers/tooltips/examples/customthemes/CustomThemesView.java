/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.customthemes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
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
public class CustomThemesView extends BwtExampleView
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
	public CustomThemesView (CustomThemesExample presenter)
	{
		super(presenter, "Custom themes & animations");
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
		Button button = new PrimaryButton("Click");
		button.setWidth(75);
		
		TooltipConfig tooltipConfig = new TooltipConfig();
		tooltipConfig.setAnimation(TooltipAnimation.GROW);
		tooltipConfig.setTheme(TooltipTheme.LIGHT);
		
		Tooltip tooltip = button.setTooltip("Build custom themes and CSS powered animations", tooltipConfig);
		tooltip.setCloseOnKeypress(true); 
		
		
		tab.add(button);
		
    	//<=
	}
}