/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups.sizing;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonSize;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.group.ButtonGroup;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.flowpanel.BwtFlowPanel;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah
 *
 */
public class SizingView extends BwtExampleView
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
	 * @param presenter DirectionPresenter
	 */
	public SizingView (SizingPresenter presenter)
	{
		super(presenter, "Sizing");
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
		// Large
		ButtonGroup lgGroup = new ButtonGroup();
		lgGroup.setButtonSize(ButtonSize.LARGE);
		
		lgGroup.add(new Button("Left"));
		lgGroup.add(new Button("Middle"));
		lgGroup.add(new Button("Right"));
		
		tab.add(new BwtFlowPanel(lgGroup), new Margins(0, 0, 0, 5));
		
		// Normal
		ButtonGroup group = new ButtonGroup();
		
		group.add(new Button("Left"));
		group.add(new Button("Middle"));
		group.add(new Button("Right"));
		
		tab.add(new BwtFlowPanel(group), new Margins(10, 0, 0, 5));
		
		// Small
		ButtonGroup smGroup = new ButtonGroup();
		smGroup.setButtonSize(ButtonSize.SMALL);
		
		smGroup.add(new Button("Left"));
		smGroup.add(new Button("Middle"));
		smGroup.add(new Button("Right"));
		
		tab.add(new BwtFlowPanel(smGroup), new Margins(10, 0, 0, 5));
		
		// X-small
		ButtonGroup xsGroup = new ButtonGroup();
		xsGroup.setButtonSize(ButtonSize.XSMALL);
		
		xsGroup.add(new Button("Left"));
		xsGroup.add(new Button("Middle"));
		xsGroup.add(new Button("Right"));
		
		tab.add(new BwtFlowPanel(xsGroup), new Margins(10, 0, 0, 5));
		//<=
		
	}
}