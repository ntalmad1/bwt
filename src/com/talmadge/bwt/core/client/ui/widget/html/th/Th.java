package com.talmadge.bwt.core.client.ui.widget.html.th;

import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 *
 */
public class Th extends Html
{
	/**
	 * 
	 * @param html String
	 * @return Th
	 */
	public static Th create (String html)
	{
		Th th = new Th(html); 
	
		return th;
	}


	/**
	 */
	private ThCell cell;
	
	
	
	/**
	 * Constructor
	 * 
	 */
	public Th ()
	{
		super();
		
		this.cell = new ThCell();
		
		this.initWidget(this.cell);
	}
	
	
	/**
	 * Constructor 
	 * 
	 * @param html String
	 */
	public Th (String html)
	{
		this();
		this.setInnerHtml(html);
	}


	/**
	 * 
	 * @return ThCell
	 */
	protected ThCell getCell ()
	{
		return this.cell;
	}
}
