package com.talmadge.bwt.core.client.ui.widget.button;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonSize;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.IconAlign;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.appearance.AppearanceUtils;
import com.talmadge.bwt.core.client.ui.widget.appearance.DefaultBwtWidgetAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultButtonAppearance extends DefaultBwtWidgetAppearance implements ButtonAppearance
{
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
	 * Constructor
	 * 
	 */
	public DefaultButtonAppearance ()
	{
		this(Document.get().createPushButtonElement());
	}
	
	
	/**
	 * Hidden Constructor
	 * 
	 * @param element Element
	 */
	protected DefaultButtonAppearance (Element element)
	{
		super(element);
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
		return this.getElement();
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
			return this.getElement().isOrHasChild(this.iconElement);
		}
		
		return false;
	}


	/**
	 * 
	 * @param pressed boolean
	 */
	public void setPressed (boolean pressed)
	{
		this.toggleCssName("active", pressed);		
	}


	/**
	 * 
	 * @param block boolean
	 */
	public void setBlock (boolean block)
	{
		this.toggleCssName("btn-block", block);
	}


	/**
	 * 
	 * @param size ButtonSize
	 */
	public void setButtonSize (ButtonSize size)
	{
		this.removeCssNames(ButtonSize.values());
		
		this.ensureCssName(size.getCssName());
	}	


	/**
	 * 
	 * @param style ButtonStyle
	 */
	public void setButtonStyle (ButtonStyle style)
	{
		this.removeCssNames(ButtonStyle.values());
		this.ensureCssName(style.getCssName());
	}


	/**
	 * 
	 * @param disabled boolean
	 */
	public void setDisabled (boolean disabled)
	{
		if (disabled)
		{
			this.getElement().setAttribute("disabled", "disabled");
		}
		else
		{
			this.getElement().removeAttribute("disabled");
		}
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
	 * @param text String
	 */
	public void setText (String text)
	{
		boolean hasIcon = this.hasIcon();
		
		this.getElement().setInnerHTML(text);
		
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
		this.getElement().addClassName("btn");
		this.getElement().addClassName("btn-default");
	}
	
}
