/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttons.block;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.styled.DefaultButton;
import com.talmadge.bwt.core.client.ui.widget.button.styled.PrimaryButton;
import com.talmadge.bwt.core.client.ui.widget.container.well.Well;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah
 *
 */
public class ButtonBlockView extends BwtExampleView
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
	public ButtonBlockView (ButtonBlockPresenter presenter)
	{
		super(presenter, "Block level");
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
    	Button btnOne = new PrimaryButton("Block level button");
    	btnOne.setBlock(true);
    	
    	Button btnTwo = new DefaultButton("Block level button");
    	btnTwo.setBlock(true);
    	
    	Well well = new Well();
    	well.setCentered(true);
    	well.setMaxWidth(400);
    	
    	well.add(btnOne);
    	well.add(btnTwo);
    	
    	tab.add(well);
    	//<=
	}
}