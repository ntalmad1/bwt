package com.talmadge.bwt.demo.client.lib.example;

import com.talmadge.bwt.core.client.ui.widget.BwtHasText;
import com.talmadge.bwt.core.client.ui.widget.component.DefaultBwtComponentView;
import com.talmadge.bwt.core.client.ui.widget.pageheader.PageHeader;

/**
 * 
 * @author Noah
 *
 */
public abstract class BwtExampleGroupView extends DefaultBwtComponentView
{
	/**
	 */
	private BwtHasText header;


	/**
	 * Constructor 
	 *
	 * @param presenter BwtDemoPresenter
	 * @param header String	
	 */
	public BwtExampleGroupView (BwtExampleGroup presenter, String header)
	{
		super(presenter);
		
		this.header = this.createHeader(header);		
		this.add(this.getHeader());
	}

	
	/**
	 * 
	 * @return BwtHasText
	 */
	public BwtHasText getHeader ()
	{
		return this.header;
	}

	
	/**
	 * 
	 * @param header String
	 * @return BwtHasText
	 */
	protected BwtHasText createHeader (String header)
	{
		return new PageHeader(header);		
	}
}
