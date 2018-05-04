package com.talmadge.bwt.core.client.ui.widget.layout.column;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;
import com.talmadge.bwt.core.client.ui.widget.layout.column.layoutdata.AbstractColumnData;
import com.talmadge.bwt.core.client.ui.widget.layout.column.layoutdata.ColumnOffset;
import com.talmadge.bwt.core.client.ui.widget.layout.column.layoutdata.ColumnPull;
import com.talmadge.bwt.core.client.ui.widget.layout.column.layoutdata.ColumnPush;


/**
 * 
 * @author Noah
 *
 */
public class DefaultBwtLayoutColumnAppearance extends DefaultBwtWidgetContainerAppearance implements LayoutColumnAppearance
{
	/**
	 * 
	 * @param element
	 */
	public DefaultBwtLayoutColumnAppearance () 
	{
		super();
	}
	

	/**
	 * 
	 * @param layoutData BwtColumnLayoutData
	 */
	public void addLayoutData (AbstractColumnData layoutData)
	{
		String colSize = "";
		
		switch (layoutData.getSize())
		{
			case XS:
				colSize = "xs";
				break;
				
			case SM:
				colSize = "sm";
				break;
				
			case MD:
				colSize = "md";
				break;
				
			case LG:
				colSize = "lg";
				break;
			
			default:
				break;			
		}
		
		String modifier = "";
		
		if (layoutData instanceof ColumnPull)
		{
			modifier = "-pull";
		}
		else if (layoutData instanceof ColumnPush)
		{
			modifier = "-push";
		}
		else if (layoutData instanceof ColumnOffset)
		{
			modifier = "-offset";
		}
		
		for (int i = 1; i <= 12; ++i)
		{
			String colClass = "col-" + colSize + modifier + "-" + i;
			
			this.removeCssName(colClass);
		}
				
		this.ensureCssName("col-" + colSize + modifier + "-" + layoutData.getColumns());
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
	 * @param align VerticalAlign
	 */
	public void setVerticalAlign (VerticalAlign align)
	{
		this.getElement().getStyle().setVerticalAlign(align);
	}


	/**
	 * 
	 */
	protected void build ()
	{
			
	}
}
