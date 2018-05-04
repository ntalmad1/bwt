/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttons.styles;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.widget.button.styled.DangerButton;
import com.talmadge.bwt.core.client.ui.widget.button.styled.DefaultButton;
import com.talmadge.bwt.core.client.ui.widget.button.styled.InfoButton;
import com.talmadge.bwt.core.client.ui.widget.button.styled.LinkButton;
import com.talmadge.bwt.core.client.ui.widget.button.styled.PrimaryButton;
import com.talmadge.bwt.core.client.ui.widget.button.styled.SuccessButton;
import com.talmadge.bwt.core.client.ui.widget.button.styled.WarningButton;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.BwtPanelInterface;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.flowpanel.BwtFlowPanel;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah
 *
 */
public class ButtonStylesView extends BwtExampleView 
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
	 * @param presenter ButtonsPresenter
	 */
	public ButtonStylesView (ButtonStylesPresenter presenter)
	{
		super(presenter, "Styles");
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
		BwtPanelInterface panel = new BwtFlowPanel();
		
		panel.add(new DefaultButton("Default"));
		panel.add(new PrimaryButton("Primary"), new Margins(0, 0, 0, 5));
		panel.add(new SuccessButton("Success"), new Margins(0, 0, 0, 5));
		panel.add(new InfoButton("Info"), new Margins(0, 0, 0, 5));
		panel.add(new WarningButton("Warning"), new Margins(0, 0, 0, 5));
		panel.add(new DangerButton("Danger"), new Margins(0, 0, 0, 5));
		panel.add(new LinkButton("Link"), new Margins(0, 0, 0, 5));
		
		tab.add(panel);
		//<=
	}

}