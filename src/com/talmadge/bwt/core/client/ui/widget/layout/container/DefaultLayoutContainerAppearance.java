package com.talmadge.bwt.core.client.ui.widget.layout.container;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.talmadge.bwt.core.client.ui.util.BwtElementUtils;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;


/**
 * 
 * @author Noah
 *
 */
public class DefaultLayoutContainerAppearance extends DefaultBwtWidgetContainerAppearance implements LayoutContainerAppearance
{
	/**
	 * 
	 * @param element
	 */
	public DefaultLayoutContainerAppearance ()
	{
		super();
	}
	

	/**
	 * 
	 */
	protected void build ()
	{
		this.getElement().addClassName("container");		
	}

	
	/**
	 * 
	 * @return boolean 
	 */
	public boolean isFluid ()
	{
		return this.getElement().hasClassName("container-fluid");
	}


	/**
	 * 
	 * @param color String
	 */
	public void setBackgroundColor (String color)
	{
		this.getElement().getStyle().setBackgroundColor(color);
	}


	/**
	 * 
	 * @param fluid boolean
	 */
	public void setFluid (boolean fluid)
	{
		if ((this.isFluid() && fluid) || (!this.isFluid() && !fluid))
		{
			return;
		}
		
		if (fluid)
		{
			BwtElementUtils.removeCssName(this.getElement(), "container");
			BwtElementUtils.ensureCssName(this.getElement(), "container-fluid");
		}
		else
		{
			BwtElementUtils.removeCssName(this.getElement(), "container-fluid");
			BwtElementUtils.ensureCssName(this.getElement(), "container");
		}
	}

	
	/**
	 * 
	 * @param height int
	 */
	@Override
	public void setMinHeight (int height)
	{
		this.getElement().getStyle().setProperty("minHeight", height, Unit.PX);		
	}


	/**
	 * 
	 * @param padding int
	 */
	public void setPaddingBottom (int padding)
	{
		this.getElement().getStyle().setPaddingBottom(padding, Unit.PX);
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
