package com.talmadge.bwt.core.client.ui.widget.layout.column;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.Size;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.layout.column.layoutdata.AbstractColumnData;
import com.talmadge.bwt.core.client.ui.widget.layout.column.layoutdata.ColumnSize;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.BwtPanelInterface;

/**
 * 
 * @author Noah
 *
 */
public class LayoutColumn extends BwtWidgetContainer implements BwtPanelInterface
{
	/**
	 * Constructor
	 * 
	 */
	public LayoutColumn ()
	{           
		this((LayoutColumnAppearance) GWT.create(DefaultBwtLayoutColumnAppearance.class));
	}
	
	
	/**
	 * Constructor 
	 * 
	 * @param layoutData BwtColumnLayoutData ...
	 */
	public LayoutColumn (AbstractColumnData ... layoutData)
	{
		this();
		
		for (int i = 0; i < layoutData.length; ++i)
		{
			this.addLayoutData(layoutData[i]);
		}
	}
	
	
	/**
	 * 
	 * @param widget Widget
	 */
	public LayoutColumn (Widget widget)
	{
		this();
		
		this.add(widget);
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param widget Widget
	 * @param size Size
	 * @param columns int 
	 */
	public LayoutColumn (Widget widget, Size size, int columns)
	{
		this();
		
		this.setColumnSize(size, columns);
		
		this.add(widget);
	}

	
	/**
	 * Constructor 
	 * 
	 * @param appearance BwtColumnAppearance
	 */
	protected LayoutColumn (LayoutColumnAppearance appearance)
	{
		super(appearance);
	}
	
	
	


	/**
	 * 
	 * @param layoutData BwtColumnLayoutData
	 */
	public void addLayoutData (AbstractColumnData layoutData)
	{
		this.getAppearance().addLayoutData(layoutData);		
	}

	
	/**
	 * 
	 * @param widget IsWidget
	 * @param margins Margins...
	 */
	@Override
	public void add (IsWidget widget, Margins... margins)
	{
		super.add(widget.asWidget(), margins);		
	}


	/**
	 * 
	 * @param size Size
	 * @param columns int
	 */
	public void setColumnSize (Size size, int columns)
	{
		this.addLayoutData(new ColumnSize(size, columns));
	}
	
	
	/**
	 * 
	 * @param height int
	 */
	@Override
	public void setMinHeight (int height)
	{
		this.getAppearance().setMinHeight(height);		
	}

	
	/**
	 * 
	 * @param align VerticalAlign
	 */
	public void setVerticalAlign (VerticalAlign align)
	{
		this.getAppearance().setVerticalAlign(align);
	}
	

	/**
	 * 
	 * @return BwtRowAppearance
	 */
	protected LayoutColumnAppearance getAppearance ()
	{
		return (LayoutColumnAppearance) super.getAppearance();
	}
}
