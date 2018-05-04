package com.talmadge.bwt.core.client.ui.widget.layout.row;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;


/**
 * 
 * @author Noah
 *
 */
public class DefaultLayoutRowAppearance extends DefaultBwtWidgetContainerAppearance implements LayoutRowAppearance
{
	/**
	 * 
	 * @param element
	 */
	protected DefaultLayoutRowAppearance ()
	{
		super();
	}
	

	/**
	 * 
	 */
	protected void build ()
	{
		this.getElement().addClassName("row");		
	}

	
	/**
	 * 
	 * @param clearFix BwtClearFix
	 */
	public void add (ClearFix clearFix)
	{
		this.getElement().appendChild(clearFix.getElement());
	}

	
	/**
	 * 
	 * @param clearFix BwtClearFix
	 */
	public void remove (ClearFix clearFix)
	{
		this.getElement().removeChild(clearFix.getElement());
	}


	/**
	 * 
	 * @param height int
	 */
	public void setMinHeight (int height)
	{
		this.getElement().getStyle().setProperty("minHeight", height, Unit.PX);
	}
	
	
	/**
	 * 
	 * @param align VerticalAlign
	 */
	public void setVerticalAlign (VerticalAlign align)
	{
		this.getElement().getStyle().setVerticalAlign(align);
	}
}
