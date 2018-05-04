package com.talmadge.bwt.core.client.ui.widget.form.datepartfield;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.DOM;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.FormElementSize;
import com.talmadge.bwt.core.client.ui.widget.form.element.AbstractFormElementAppearance;
import com.talmadge.bwt.core.client.ui.widget.form.option.Item;
import com.talmadge.bwt.core.client.ui.widget.form.simpleselect.SimpleSelect;

/**
 * 
 *
 */
public class DefaultDatePartFieldAppearance extends AbstractFormElementAppearance implements DatePartFieldAppearance
{
	/**
	 */
	private SimpleSelect<String> daySelect;
	
	/**
	 */
	private SimpleSelect<Item<String>> monthSelect;
	
	
	/**
	 */
	private SimpleSelect<String> yearSelect;
	
	/**
	 */
	private Element wrapper;
	
	
	/**
	 * 
	 * @param daySelect SimpleSelect<String>
	 * @param monthSelect SimpleSelect<Option<String>>
	 * @param yearSelect SimpleSelect<String>
	 */
	public void init (SimpleSelect<String> daySelect, SimpleSelect<Item<String>> monthSelect, SimpleSelect<String> yearSelect)
	{
		this.daySelect = daySelect;
		this.monthSelect = monthSelect;
		this.yearSelect = yearSelect;
		
		Element label = this.getLabelElement();
		label.addClassName("col-xs-12");
		label.getStyle().setPaddingLeft(0, Unit.PX);
		label.getStyle().setPaddingRight(0, Unit.PX);

		monthSelect.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		monthSelect.getElement().getStyle().setMarginRight(15, Unit.PX);
		monthSelect.getElement().getStyle().setMarginBottom(0, Unit.PX);
		
		daySelect.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		daySelect.getElement().getStyle().setMarginRight(15, Unit.PX);
		daySelect.getElement().getStyle().setMarginBottom(0, Unit.PX);
		
		yearSelect.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		yearSelect.getElement().getStyle().setWidth(100, Unit.PX);
		yearSelect.getElement().getStyle().setMarginBottom(0, Unit.PX);
		
		this.wrapper = DOM.createDiv();
		this.wrapper.getStyle().setDisplay(Display.INLINE_BLOCK);
		
		this.wrapper.appendChild(monthSelect.getElement());
		this.wrapper.appendChild(daySelect.getElement());
		this.wrapper.appendChild(yearSelect.getElement());
		
		this.append(this.wrapper);
	}

	
	/**
	 * 
	 */
	@Override
	public void setSize (FormElementSize size)
	{
		this.daySelect.setSize(size);		
		this.monthSelect.setSize(size);
		this.yearSelect.setSize(size);
	}
	
	
	/**
	 * 
	 * @param helpBlock Element
	 */
	protected void attachHelpBlock (Element helpBlock)
	{
		super.attachHelpBlock(helpBlock);
		
		int selectWidth = this.wrapper.getClientWidth();
		int parentWidth = this.wrapper.getParentElement().getClientWidth();
		int helpWidth = helpBlock.getClientWidth();
		
		if ((parentWidth - selectWidth) < helpWidth)
		{
			int pct = (100 * (selectWidth - (helpWidth + 3))) / selectWidth;
			
			int yearSelectWidth = this.yearSelect.getElement().getClientWidth();
			yearSelect.getElement().getStyle().setWidth(yearSelectWidth - (helpWidth + 3), Unit.PX);
			
			this.wrapper.getStyle().setWidth(pct, Unit.PCT);
			
			
		}
	}
	
	
	/**
	 * 
	 * @param helpBlock Element
	 */
	protected void detachHelpBlock (Element helpBlock)
	{
		int helpWidth = helpBlock.getClientWidth();
		int yearSelectWidth = this.yearSelect.getElement().getClientWidth();
		
		super.detachHelpBlock(helpBlock);
		this.wrapper.getStyle().setWidth(100, Unit.PCT);
		yearSelect.getElement().getStyle().setWidth(yearSelectWidth + (helpWidth + 3), Unit.PX);
	}
}
