package com.talmadge.bwt.core.client.ui.widget.tile;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.IconAlign;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.appearance.AppearanceUtils;
import com.talmadge.bwt.core.client.ui.widget.appearance.DefaultBwtWidgetAppearance;

/**
 * @author Noah
 *
 */
public class DefaultTileAppearance extends DefaultBwtWidgetAppearance implements TileAppearance
{
	/**
	 */
	private Glyphicon icon;
	
	/**
	 */
	private IconAlign iconAlign = IconAlign.ABOVE;
	
    /**
     */
    private Element iconElement;
  
    /**
     */
    private Element textElement;


    
    /**
     * Constructor
     *
     */
    public DefaultTileAppearance ()
    {
        super(Document.get().createLIElement());
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
		return iconAlign;
	}


	/**
	 * 
	 * @return Element
	 */
	public Element getIconParentElement ()
	{
		return getElement();
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
     * @param icon Glyphicon
     */
    public void setIcon (Glyphicon icon)
    {
    	this.icon = icon;
    	
    	
        AppearanceUtils.setIcon(this, this.getIcon(), this.getIconAlign());
    }


    /**
     * Currently does not support IconAlign.RIGHT or IconAlign.LEFT
     * 
     * @param iconAlign IconAlign
     */
	public void setIconAlign (IconAlign iconAlign)
	{
		assert !IconAlign.LEFT.equals(iconAlign);
		assert !IconAlign.RIGHT.equals(iconAlign);
		
		this.iconAlign = iconAlign;
		
		
		if (this.hasIcon())
		{
			AppearanceUtils.setIcon(this, this.getIcon(), this.getIconAlign());
		}
	}


	/**
     *
     * @param text String
     */
    public void setText (String text)
    {
        if (this.textElement == null)
        {
            this.textElement = this.createTextElement();
        }

        this.textElement.setInnerHTML(text);

        if (!this.getElement().isOrHasChild(this.textElement))
        {
            this.getElement().appendChild(this.textElement);
        }
        
        
        if (text == null || text.isEmpty())
        {
        	this.removeCssName("hasText");
        }
        else
        {
        	this.ensureCssName("hasText");
        }
    }


    /**
     * 
     */
	protected void build ()
	{
		this.getElement().addClassName("bwt-tile");
	}


	/**
     *
     * @return Element
     */
    protected Element createTextElement ()
    {
        Element element = Document.get().createSpanElement();
        element.addClassName("bwt-tile-text");

        return element;
    }
}
