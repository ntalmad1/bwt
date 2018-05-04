package com.talmadge.bwt.core.client.ui.widget.table.footer.column;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.html.th.ThCell;
import com.talmadge.bwt.core.client.ui.widget.table.footer.callback.event.FooterCallbackEvent;

/**
 * 
 *
 */
public class FooterColumn<T extends JavaScriptObject> extends ThCell
{
	/**
	 * Constructor
	 * 
	 */
	public FooterColumn ()
	{
		this((FooterColumnAppearance) GWT.create(DefaultFooterColumnAppearance.class));
	}
	
	
	/**
	 * 
	 * @param html String
	 */
	public FooterColumn (String html)
	{
		this();
		
		this.setInnerHtml(html);
	}


	/**
	 * Hidden Constructor
	 * 
	 * @param appearance FooterColumnAppearance
	 */
	protected FooterColumn (FooterColumnAppearance appearance)
	{
		super(appearance);		
	}

	
	/**
	 * 
	 * @param event FooterCallbackEvent
	 */
	public void onFooterCallback (FooterCallbackEvent event)
	{
		
	}	
}
