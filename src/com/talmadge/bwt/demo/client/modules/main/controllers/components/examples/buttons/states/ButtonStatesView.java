/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttons.states;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.styled.DefaultButton;
import com.talmadge.bwt.core.client.ui.widget.button.styled.PrimaryButton;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah
 *
 */
public class ButtonStatesView extends BwtExampleView 
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
	public ButtonStatesView (ButtonStatesPresenter presenter)
	{
		super(presenter, "States");
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
		Button normalPrimaryBtn = new PrimaryButton("Normal button");
		Button normalDefaultBtn = new DefaultButton("Normal button");
		
		Button pressedPrimaryBtn = new PrimaryButton("Pressed button");
		pressedPrimaryBtn.setPressed(true);
	
		Button pressedDefaultBtn = new DefaultButton("Pressed button");
		pressedDefaultBtn.setPressed(true);
		
		Button disabledPrimaryBtn = new PrimaryButton("Disabled button");
		disabledPrimaryBtn.setDisabled(true);
		
		Button disabledDefaultBtn = new DefaultButton("Disabled button");
		disabledDefaultBtn.setDisabled(true);
		
		tab.add(normalPrimaryBtn);
		tab.add(normalDefaultBtn, new Margins(0, 0, 0, 5));
		
		tab.br(10);
		
		tab.add(pressedPrimaryBtn);
		tab.add(pressedDefaultBtn, new Margins(0, 0, 0, 5));
		
		tab.br(10);
		
		tab.add(disabledPrimaryBtn);
		tab.add(disabledDefaultBtn, new Margins(0, 0, 0, 5));
		//<=
	}
}