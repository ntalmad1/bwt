package com.talmadge.bwt.core.client.ui.widget.html.abbr;

import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 * @author Noah
 *
 */
public class Abbr extends Html
{
	/**
	 * Constructor 
	 *
	 */
	public Abbr ()
	{
		this.setCell(new AbbrCell());
		this.initWidget(this.getCell());
	}
	
	
	/**
	 * Constructor 
	 *
	 * @param abbr String
	 */
	public Abbr (String abbr)
	{
		this();
		this.setInnerHtml(abbr);
	}
	
	
	/**
	 * Constructor 
	 *
	 * @param abbr String
	 * @param fullForm String
	 */
	public Abbr (String abbr, String fullForm)
	{
		this(abbr);
		this.setTitle(fullForm);
	}
	
	
	/**
	 * 
	 * @param isInitialism boolean
	 * @return Abbr
	 */
	public Abbr setInitialism (boolean isInitialism)
	{
		this.getCell().setInitialism(isInitialism);
		return this;
	}


	/**
	 * 
	 * @return AbbrCell
	 */
	protected AbbrCell getCell ()
	{
		return (AbbrCell) super.getCell();
	}
}
