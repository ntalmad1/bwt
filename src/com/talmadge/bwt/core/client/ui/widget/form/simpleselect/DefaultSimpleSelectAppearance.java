package com.talmadge.bwt.core.client.ui.widget.form.simpleselect;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SelectElement;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.DOM;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.FormElementSize;
import com.talmadge.bwt.core.client.ui.widget.form.element.AbstractFormElementAppearance;
import com.talmadge.bwt.core.client.ui.widget.form.option.select.SelectOption;

/**
 * 
 * @author Noah
 *
 */
public class DefaultSimpleSelectAppearance extends AbstractFormElementAppearance implements SimpleSelectAppearance
{
	/**
	 */
	private Element placeHolderElement;

	/**
	 */
	private Element selectElement;

	/**
	 * 
	 */
	protected void build ()
	{
		super.build();
		
		this.selectElement = DOM.createSelect();
		this.ensureCssName(this.selectElement, "form-control");
		
		this.getLabelElement().getStyle().setDisplay(Display.BLOCK);
		this.selectElement.getStyle().setDisplay(Display.INLINE_BLOCK);
		
		this.getElement().appendChild(this.selectElement);
	}
	

	/**
	 * 
	 * @param option SelectOption<?> 
	 */
	public void addOption (SelectOption<?> option)
	{
		this.selectElement.appendChild(option.getElement());
	}
	
	
	/**
	 */
	public void clear ()
	{
		SelectElement select = (SelectElement) this.selectElement;
		select.setSelectedIndex(0);
		
		if (this.placeHolderElement != null)
		{
			select.setValue(placeHolderElement.getInnerHTML());
			this.setPlaceholderSelected(true);
		}
		
	}


	/**
	 * 
	 * @return Element
	 */
	public Element getSelectElement ()
	{
		return this.selectElement;
	}


	/**
	 * 
	 * @return boolean
	 */
	public boolean hasPlaceholder ()
	{
		return this.placeHolderElement != null;
	}
	

	/**
	 * 
	 * @param disabled boolean
	 */
	public void setDisabled (boolean disabled)
	{
		if (disabled)
		{
			this.selectElement.setAttribute("disabled", "");
		}
		else
		{
			if (this.selectElement.hasAttribute("disabled"))
			{
				this.selectElement.removeAttribute("disabled");
			}
		}
	}
	
	
	/**
	 * 
	 * @param hasSelection boolean
	 */
	public void setHasSelection (boolean hasSelection)
	{
		this.toggleCssName(this.selectElement, "no-selection", !hasSelection);
	}


	/**
	 * 
	 * @param label String
	 */
	public void setPlaceholder (String label)
	{
		if (this.placeHolderElement != null)
		{
			this.placeHolderElement.setInnerHTML(label);
		}
		else
		{
			this.placeHolderElement = DOM.createOption();
			
			this.ensureCssName(this.placeHolderElement, "placeholder");
			
			this.placeHolderElement.setAttribute("disabled", "");
			this.placeHolderElement.setInnerHTML(label);
			
			this.selectElement.insertFirst(this.placeHolderElement);
		}
		
		this.getElement().setAttribute("placeholder", label);
		
	}


	/**
	 * 
	 * @param selected boolean
	 */
	public void setPlaceholderSelected (boolean selected)
	{
		if (this.placeHolderElement != null)
		{
			if (selected)
			{
				this.placeHolderElement.setAttribute("selected", "");
				this.setHasSelection(false);
			}
			else
			{
				if (this.placeHolderElement.hasAttribute("selected"))
				{
					this.placeHolderElement.removeAttribute("selected");
				}
			}
		}
		
	}

	
	
	/**
	 * 
	 */
	@Override
	public void setSize (FormElementSize size)
	{
		this.removeCssNames(this.selectElement, FormElementSize.values()); 
		this.ensureCssName(this.selectElement, size.getCssName());
	}
	
	
	/**
	 * 
	 * @param helpBlock Element
	 */
	protected void attachHelpBlock (Element helpBlock)
	{
		super.attachHelpBlock(helpBlock);
		
		int selectWidth = this.selectElement.getClientWidth();
		int parentWidth = this.selectElement.getParentElement().getClientWidth();
		int helpWidth = helpBlock.getClientWidth();
		
		if ((parentWidth - selectWidth) < helpWidth)
		{
			int pct = (100 * (selectWidth - (helpWidth + 3))) / selectWidth;
			
			this.selectElement.getStyle().setWidth(pct, Unit.PCT);
		}
	}
	
	
	/**
	 * 
	 * @param helpBlock Element
	 */
	protected void detachHelpBlock (Element helpBlock)
	{
		super.detachHelpBlock(helpBlock);
		this.selectElement.getStyle().setWidth(100, Unit.PCT);
	}
}
