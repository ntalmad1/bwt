package com.talmadge.bwt.core.client.ui.widget.container.contentpanel;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ContentPanelStyle;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;

/**
 * 
 *
 */
public class PrimaryContentPanel extends BwtContentPanel
{
	/**
	 * Constructor
	 * 
	 */
	public PrimaryContentPanel ()
	{
		super();
		this.setContentPanelStyle(ContentPanelStyle.PRIMARY);
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param title String
	 */
	public PrimaryContentPanel (String title)
	{
		this();
		this.setTitle(title);
	}


	/**
	 * Constructor
	 * 
	 * @param icon Glyphicon
	 * @param string String
	 */
	public PrimaryContentPanel (Glyphicon icon, String title)
	{
		this(title);
		
		this.getHead().setIcon(icon);
	}

}
