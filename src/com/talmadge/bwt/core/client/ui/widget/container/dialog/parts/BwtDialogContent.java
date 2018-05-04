package com.talmadge.bwt.core.client.ui.widget.container.dialog.parts;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.DialogStyle;
import com.talmadge.bwt.core.client.ui.util.BwtElementUtils;
import com.talmadge.bwt.core.client.ui.widget.container.simple.SimpleWidgetContainer;

/**
 * 
 *
 */
public class BwtDialogContent extends SimpleWidgetContainer
{
	/**
	 * 
	 */
	public BwtDialogContent ()
	{
		super();
		
		this.ensureCssName("modal-content");
		
		this.ensureCssName("panel");
		
		this.ensureCssName("panel-default");
	}
	
	
	/**
	 * 
	 * @param style DialogStyle
	 */
	public void setDialogStyle (DialogStyle style)
	{
		BwtElementUtils.removeCssNames(this.getElement(), DialogStyle.values());
		this.ensureCssName(style.getCssName());
	}
}
