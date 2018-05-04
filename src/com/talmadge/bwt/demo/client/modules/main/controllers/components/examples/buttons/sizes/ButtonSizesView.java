/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttons.sizes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonSize;
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
public class ButtonSizesView extends BwtExampleView
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
	 * @param presenter ButtonSizesPresenter
	 */
	public ButtonSizesView (ButtonSizesPresenter presenter)
	{
		super(presenter, "Sizes");
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
		/* large buttons */
		Button lgPrimaryBtn = new PrimaryButton("Large Button");
		lgPrimaryBtn.setButtonSize(ButtonSize.LARGE);
		
		Button lgDefaultBtn = new DefaultButton("Large Button");
		lgDefaultBtn.setButtonSize(ButtonSize.LARGE);
		
		/* normal buttons */
		Button normPrimaryBtn = new PrimaryButton("Default Button");
		normPrimaryBtn.setButtonSize(ButtonSize.NORMAL);
	
		Button normDefaultBtn = new DefaultButton("Default Button"); 
		normDefaultBtn.setButtonSize(ButtonSize.NORMAL);
		
		/* small buttons */
		Button smPrimaryBtn = new PrimaryButton("Small Button");
		smPrimaryBtn.setButtonSize(ButtonSize.SMALL);
		
		Button smDefaultBtn = new DefaultButton("Small Button");
		smDefaultBtn.setButtonSize(ButtonSize.SMALL);
		
		/* xtra small buttons */
		Button xsPrimaryBtn = new PrimaryButton("Extra Small Button");
		xsPrimaryBtn.setButtonSize(ButtonSize.SMALL);
		
		Button xsDefaultBtn = new DefaultButton("Extra Small Button");
		xsDefaultBtn.setButtonSize(ButtonSize.SMALL);
		
		/* add buttons to the tab */
		tab.add(lgPrimaryBtn);
		tab.add(lgDefaultBtn, new Margins(0, 0, 0, 5));

		tab.br(10);
		
		tab.add(normPrimaryBtn);
		tab.add(normDefaultBtn, new Margins(0, 0, 0, 5));
		
		tab.br(10);
		
		tab.add(smPrimaryBtn);
		tab.add(smDefaultBtn, new Margins(0, 0, 0, 5));
		
		tab.br(10);
		
		tab.add(xsPrimaryBtn);
		tab.add(xsDefaultBtn, new Margins(0, 0, 0, 5));
		//<=
		
	}
}