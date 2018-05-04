package com.talmadge.bwt.core.client.ui.widget.container.contentpanel;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ContentPanelStyle;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.container.contentpanel.body.BwtContentPanelBody;
import com.talmadge.bwt.core.client.ui.widget.container.contentpanel.foot.BwtContentPanelFoot;
import com.talmadge.bwt.core.client.ui.widget.container.contentpanel.head.BwtContentPanelHead;

/**
 * 
 *
 */
public class BwtContentPanel extends BwtWidgetContainer
{
	/**
	 */
	private BwtContentPanelBody body;
	
	/**
	 */
	private BwtContentPanelFoot foot;
	
	/**
	 */
	private BwtContentPanelHead head;
	
	
	
	/**
	 * Constructor
	 * 
	 */
	public BwtContentPanel ()
	{
		this((BwtContentPanelAppearance) GWT.create(DefaultBwtContentPanelAppearance.class));
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param title String
	 */
	public BwtContentPanel (String title)
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
	public BwtContentPanel (Glyphicon icon, String title)
	{
		this(title);
		
		this.getHead().setIcon(icon);
	}

	/**
	 * Hidden Constructor
	 * 
	 * @param appearance BwtContentPanelAppearance
	 */
	protected BwtContentPanel (BwtContentPanelAppearance appearance)
	{
		super(appearance);
		
		this.head = new BwtContentPanelHead();
		this.body = new BwtContentPanelBody();
		this.foot = new BwtContentPanelFoot();
		
		this.add(this.head);
		this.add(this.body);
		this.add(this.foot);
		
		this.foot.hide();
	}
	
	
	/**
	 * 
	 * @return BwtContentPanelBody
	 */
	public BwtContentPanelBody getBody ()
	{
		return this.body;
	}
	
	
	/**
	 * 
	 * @return BwtContentPanelFoot
	 */
	public BwtContentPanelFoot getFoot ()
	{
		return this.foot;
	}


	/**
	 * 
	 * @return BwtContentPanelHead
	 */
	public BwtContentPanelHead getHead ()
	{
		return this.head;
	}

	/**
	 * 
	 * @param style ContentPanelStyle
	 */
	public void setContentPanelStyle (ContentPanelStyle style)
	{
		this.getAppearance().setContentPanelStyle(style);		
	}

	
	/**
	 * 
	 * @param padding int
	 */
	public void setPadding (int padding)
	{
		this.getBody().setPadding(padding);
	}
	

	/**
	 * 
	 * @param title String
	 */
	public void setTitle (String title)
	{
		this.getHead().setTitle(title);
	}
	
	
	/**
	 * 
	 * @return BwtContentPanelAppearance
	 */
	protected BwtContentPanelAppearance getAppearance ()
	{
		return (BwtContentPanelAppearance) super.getAppearance();
	}
}
