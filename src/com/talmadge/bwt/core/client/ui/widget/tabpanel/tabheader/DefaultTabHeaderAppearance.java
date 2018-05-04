package com.talmadge.bwt.core.client.ui.widget.tabpanel.tabheader;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.talmadge.bwt.core.client.ui.util.BwtWidgetUtils;
import com.talmadge.bwt.core.client.ui.widget.appearance.DefaultBwtWidgetAppearance;

/**
 * @author Noah
 *
 */
public class DefaultTabHeaderAppearance extends DefaultBwtWidgetAppearance implements TabHeaderAppearance
{
    /**
     */
    private Element anchor;

    /**
	 */
	private Element dropdownIcon;
	
	/**
	 */
	private Element dropdownMenu;

	/**
     */
    private boolean isGroup;
    
    
    
    /**
     * Constructor
     *
     */
    public DefaultTabHeaderAppearance ()
    {
        super(Document.get().createLIElement());
    }


    /**
     * 
     * @param tabHeader TabHeader
     */
	public void add (TabHeader tabHeader)
	{
		this.dropdownMenu.appendChild(tabHeader.getElement());
	}


	/**
     *
     * @param active boolean
     */
    public void setActive (boolean active)
    {
        this.toggleCssName("active", active);
    }


    /**
     * 
     * @param isGroup boolean
     */
	public void setIsTabGroup (boolean isGroup)
	{
		if (!this.isGroup && isGroup)
		{
			this.isGroup = isGroup;
			
			this.ensureCssName("dropdown");
			
			this.anchor.setAttribute("href", "#");
			this.ensureCssName(this.anchor, "dropdown-toggle");
			this.anchor.setAttribute("data-toggle", "dropdown");
			
			this.anchor.appendChild(this.ensureDropdownIconElement());
			
			this.dropdownMenu = Document.get().createULElement();
			this.dropdownMenu.addClassName("dropdown-menu");
			this.dropdownMenu.setId(this.anchor.getId() + "-contents");
			
			this.getElement().appendChild(this.dropdownMenu);
		}
	}


	/**
     *
     * @param text String
     */
    public void setText (String text)
    {
        this.anchor.setInnerHTML(text);

    }


	/**
	 * 
	 * @param target Element 
	 */
	public void setTarget (Element target)
	{
		 this.anchor.setAttribute("href", "#" + target.getId());
	}


	/**
	 * 
	 */
	protected void build ()
	{
		this.anchor = Document.get().createAnchorElement();
		this.anchor.setAttribute("data-toggle", "tab");
		this.anchor.setId(BwtWidgetUtils.uniqueId());

		this.getElement().appendChild(this.anchor);

	}
	
	
	/**
	 * 
	 * @return Element
	 */
	protected Element ensureDropdownIconElement ()
	{
		if (this.dropdownIcon == null)
		{
			this.dropdownIcon = Document.get().createSpanElement();
			this.dropdownIcon.addClassName("caret");
		}
		
		return this.dropdownIcon;
	}
}
