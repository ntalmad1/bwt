package com.talmadge.bwt.core.client.ui.widget.html.address;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.html.cell.HtmlCell;

/**
 * 
 * @author Noah
 *
 */
public class AddressCell extends HtmlCell
{
	/**
	 * Constructor 
	 *
	 */
	public AddressCell ()
	{
		this((DefaultAddressAppearance) GWT.create(DefaultAddressAppearance.class));
	}
	
	/**
	 * Constructor 
	 *
	 * @param html String
	 */
	public AddressCell (String html)
	{
		this();
		this.setInnerHtml(html);
	}
	
	
	/**
	 * 
	 * @param appearance AbbrCellAppearance
	 */
	protected AddressCell (AddressAppearance appearance)
	{
		super(appearance);
	}
	
	
	/**
	 * 
	 * @return AbbrCellAppearance
	 */
	public AddressAppearance getAppearance ()
	{
		return (AddressAppearance) super.getAppearance();
	}
}
