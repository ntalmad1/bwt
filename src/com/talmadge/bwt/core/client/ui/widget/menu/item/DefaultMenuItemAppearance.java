package com.talmadge.bwt.core.client.ui.widget.menu.item;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.IconAlign;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.appearance.AppearanceUtils;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;
import com.talmadge.bwt.core.client.ui.widget.html.a.A;
import com.talmadge.bwt.core.client.ui.widget.menu.Menu;

/**
 * 
 * @author Noah
 *
 */
public class DefaultMenuItemAppearance extends DefaultBwtWidgetContainerAppearance implements MenuItemAppearance
{
	/**
	 */
	private A anchor;

	/**
	 */
	private Glyphicon icon;

	/**
	 */
	private IconAlign iconAlign = IconAlign.LEFT;

	/**
	 */
	private Element iconElement;
	
	/**
	 */
	private Menu menu;

	/**
	 */
	private String text;

	
	/**
	 * Constructor
	 *  
	 * @param element
	 */
	public DefaultMenuItemAppearance ()
	{
		super(Document.get().createLIElement());
	}

	/**
	 * 
	 * @return A
	 */
	public A getAnchor ()
	{
		return this.anchor;
	}
	
	/**
	 * 
	 * @return Glyphicon
	 */
	public Glyphicon getIcon ()
	{
		return this.icon;
	}


	/**
	 * 
	 * @return IconAlign
	 */
	public IconAlign getIconAlign ()
	{
		return this.iconAlign;
	}


	/**
	 * 
	 * @return Element
	 */
	public Element getIconParentElement ()
	{
		return this.anchor.getElement();
	}


	/**
	 * 
	 * @return String
	 */
	public String getText ()
	{
		return this.text;
	}
	
	
	/**
	 * 
	 * @return Element
	 */
	public Element ensureIconElement ()
	{
		if (this.iconElement == null)
		{
			this.iconElement = Document.get().createSpanElement();
			this.iconElement.addClassName("glyphicon");
		}
		
		return this.iconElement;
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean hasIcon ()
	{
		if (this.iconElement != null)
		{
			return this.anchor.getElement().isOrHasChild(this.iconElement);
		}
		
		return false;
	}
	
	
	/**
	 * 
	 * @param icon Glyphicon
	 */
	public void setIcon (Glyphicon icon)
	{
		this.icon = icon;
		
		AppearanceUtils.setIcon(this, this.getIcon(), this.getIconAlign());		
	}


	/**
	 * 
	 * @param iconAlign IconAlign
	 */
	public void setIconAlign (IconAlign iconAlign)
	{
		this.iconAlign = iconAlign;
		
		AppearanceUtils.setIcon(this, this.getIcon(), this.getIconAlign());	
	}


	/**
	 * 
	 * @param menu Menu
	 */
	public void setMenu (Menu menu)
	{
		this.ensureCssName("dropdown-submenu");
		
		this.menu = menu;
		this.menu.ensureCssName("dropdown-menu");
		
		this.getElement().appendChild(this.menu.getElement());
	}


	/**
	 * 
	 * @param text String
	 */
	public void setText (String text)
	{
		this.text = text;
		
		boolean hasIcon = this.hasIcon();
		
		this.anchor.setInnerHTML(text);
		
		if (text == null || text.isEmpty())
		{
			this.removeCssName("hasText");
		}
		else
		{
			this.ensureCssName("hasText");
		}
		
		if (hasIcon)
		{
			AppearanceUtils.setIcon(this, this.getIcon(), this.getIconAlign());	
		}
	}


	/**
	 * 
	 */
	protected void build ()
	{
		this.anchor = new A();
		
		this.getElement().appendChild(this.anchor.getElement());
	}

}
