package com.talmadge.bwt.core.client.ui.widget.container.dialog.parts.header;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;
import com.talmadge.bwt.core.client.ui.widget.html.HtmlTag;

/**
 * 
 *
 */
public class DefaultBwtDialogHeaderAppearance extends DefaultBwtWidgetContainerAppearance implements BwtDialogHeaderAppearance
{
	/**
	 */
	private final static HtmlTag DEFAULT_TITLE_SIZE = HtmlTag.H4; 

	/**
	 */
	private Element iconElement;
	
	/**
	 */
	private Element titleElement;	
	
	
	
	/**
	 * Constructor
	 * 
	 */
	public DefaultBwtDialogHeaderAppearance ()
	{
		super(Document.get().createDivElement());
	}
	
	
	/**
	 * 
	 */
	@Override
	protected void build ()
	{
		this.ensureCssName("modal-header");
		
		this.ensureCssName("panel-heading");
	}

	
	/**
	 * 
	 * @param icon Glyphicon
	 */
	@Override
	public void setIcon (Glyphicon icon)
	{
		this.ensureIconElement();
		
		this.iconElement.removeAllChildren();
				
		this.iconElement.appendChild(Glyphicon.create(icon).getElement());
	}


	/**
	 * 
	 * @param title String
	 */
	@Override
	public void setTitle (String title)
	{
		this.ensureTitleElement();
		
		Element span = Document.get().createSpanElement();
		span.setInnerHTML(title);
		
		this.titleElement.appendChild(span);
	}
	
	
	/**
	 * 
	 */
	protected void ensureIconElement ()
	{
		if (this.iconElement == null)
		{
			this.ensureTitleElement();
			
			this.iconElement = Document.get().createSpanElement();
			this.ensureCssName(this.iconElement, "bwt-modal-icon");
			this.titleElement.insertFirst(this.iconElement);
		}
	}
	
	
	/**
	 * 
	 */
	protected void ensureTitleElement ()
	{
		this.ensureTitleElement(DEFAULT_TITLE_SIZE);
	}
	
	
	/**
	 * 
	 */
	protected void ensureTitleElement (HtmlTag tag)
	{
		if (this.titleElement == null)
		{
			this.titleElement = Document.get().createElement(tag.getTagName());
			this.titleElement.getStyle().setDisplay(Display.INLINE_BLOCK);
			this.ensureCssName(this.titleElement, "modal-title");
			
			this.append(this.titleElement);
		}
	}
}
