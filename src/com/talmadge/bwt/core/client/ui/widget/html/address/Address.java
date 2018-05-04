package com.talmadge.bwt.core.client.ui.widget.html.address;

import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 * @author Noah
 *
 */
public class Address extends Html
{
	/**
	 * Constructor 
	 *
	 */
	public Address ()
	{
		this.setCell(new AddressCell());
		this.initWidget(this.getCell());
	}
	

	/**
	 * 
	 * @return AbbrCell
	 */
	protected AddressCell getCell ()
	{
		return (AddressCell) super.getCell();
	}
}
