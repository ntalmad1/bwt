package com.talmadge.bwt.core.client.ui.widget.layout.container;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.Size;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutUtils;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.layout.column.LayoutColumn;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.BwtPanelInterface;
import com.talmadge.bwt.core.client.ui.widget.layout.row.LayoutRow;

/**
 * 
 * @author Noah
 *
 */
public class LayoutContainer extends BwtWidgetContainer implements BwtPanelInterface
{
	/**
	 * Constructor
	 * 
	 */
	public LayoutContainer ()
	{
		this((LayoutContainerAppearance) GWT.create(DefaultLayoutContainerAppearance.class));
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param widget Widget
	 */
	public LayoutContainer (Widget widget)
	{
		this();
		
		this.add(widget);
	}
	
	
	/**
	 * Constructor 
	 * 
	 * @param appearance BwtContainerAppearance
	 */
	protected LayoutContainer (LayoutContainerAppearance appearance)
	{
		super(appearance);
	}
	
	
	/**
	 * 
	 * @param row LayoutRow
	 */
	public void add (LayoutRow row)
	{
		this.addRow(row);
	}
	
	
	
	/**
	 * 
	 * @param widget Widget
	 * @param size Size
	 * @param cols int
	 */
	public void add (Widget widget)
	{
		this.add(widget, Size.XS, 12, null);
	}
	
	
	
	/**
	 * 
	 * @param widget Widget
	 * @param size Size
	 * @param cols int
	 */
	public void add (Widget widget, Size size, int cols)
	{
		this.add(widget, size, cols, null);
	}
	
	
	
	/**
	 * 
	 * @param widget Widget
	 * @param size Size
	 * @param cols int
	 */
	public void add (Widget widget, Size size, int cols, Margins margins)
	{
		LayoutRow row = new LayoutRow();
		LayoutColumn col = new LayoutColumn();
		col.add(widget);
		
		if (margins != null)
		{
			LayoutUtils.applyMargins(col, margins);
		}
		
		row.add(col, size, cols); 
		
		this.add(row);
	}
	
	
	/**
	 *
	 * @param widget IsWidget
	 * @param margins Margins...
	 */
	public void add (IsWidget widget, Margins... margins)
	{
		this.add(widget.asWidget(), margins); 
	}


	/**
	 * 
	 * @param row LayoutRow
	 */
	public void addRow (LayoutRow row)
	{
		super.add(row);
	}


	/**
	 * 
	 * @param widget Widget
	 * @param size Size
	 * @param cols int
	 * @return LayoutRow
	 */
	public LayoutRow addRow (Widget widget, Size size, int cols)
	{
		LayoutRow row = new LayoutRow();
		row.add(widget, size, cols);
		
		super.add(row);
		
		return row;
	}


	/**
	 * 
	 * @return boolean
	 */
	public boolean isFluid ()
	{
		return this.getAppearance().isFluid();  
	}
	
	
	/**
	 * 
	 * @param color String
	 */
	public void setBackgroundColor (String color)
	{
		this.getAppearance().setBackgroundColor(color);
		
	}


	/**
	 * 
	 * @param fluid boolean
	 */
	public void setFluid (boolean fluid)
	{
		this.getAppearance().setFluid(fluid);		
	}

	
	/**
	 * 
	 * @param margin int
	 */
	public void setMarginBottom (int margin)
	{
		this.getAppearance().setMarginBottom(margin);		
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
	 * @param padding int
	 */
	public void setPaddingBottom (int padding)
	{
		this.getAppearance().setPaddingBottom(padding);		
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
	 * @return BwtContainerAppearance
	 */
	protected LayoutContainerAppearance getAppearance ()
	{
		return (LayoutContainerAppearance) super.getAppearance();
	}
}
