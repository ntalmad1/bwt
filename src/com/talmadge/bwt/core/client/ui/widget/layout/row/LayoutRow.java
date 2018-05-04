package com.talmadge.bwt.core.client.ui.widget.layout.row;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.Size;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutUtils;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.layout.column.LayoutColumn;
import com.talmadge.bwt.core.client.ui.widget.layout.column.layoutdata.AbstractColumnData;
import com.talmadge.bwt.core.client.ui.widget.layout.column.layoutdata.ColumnSize;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.BwtPanelInterface;

/**
 * 
 * @author Noah
 *
 */
public class LayoutRow extends BwtWidgetContainer implements BwtPanelInterface
{
	/**
	 * Constructor
	 * 
	 */
	public LayoutRow ()
	{           
		this((LayoutRowAppearance) GWT.create(DefaultLayoutRowAppearance.class));
	}
	
	
	/**
	 * 
	 * @param bwtColumn BwtColumn
	 */
	public LayoutRow (LayoutColumn bwtColumn)
	{
		this();
		
		this.add(bwtColumn);
	}


	/**
	 * Constructor 
	 * 
	 * @param appearance BwtRowAppearance
	 */
	protected LayoutRow (LayoutRowAppearance appearance)
	{
		super(appearance);
	}
	
	
	/**
	 * 
	 * @param clearFix BwtClearFix
	 */
	public void add (ClearFix clearFix)
	{
		this.getAppearance().add(clearFix);
	}
	
	
	/**
	 * 
	 * @param col BwtColumn
	 * @param layoutData BwtColumnLayoutData
	 */
	public void add (LayoutColumn col, AbstractColumnData layoutData)
	{
		this.add(col, layoutData, new Margins());
	}
	
	
	/**
	 * 
	 * @param col BwtColumn
	 * @param layoutData BwtColumnLayoutData
	 * @param margins Margins
	 */
	public void add (LayoutColumn col, AbstractColumnData layoutData, Margins margins)
	{
		col.addLayoutData(layoutData);
		
		LayoutUtils.applyMargins(col, margins);
		
		super.add(col);
	}
	
	
	/**
	 * 
	 * @param col BwtColumn
	 * @param size Size
	 * @param columns int
	 */
	public void add (LayoutColumn col, Size size, int columns)
	{
		this.add(col, size, columns, new Margins()); 		
	}
	
	
	/**
	 * 
	 * @param col BwtColumn
	 * @param size Size
	 * @param columns int
	 * @param margins Margins
	 */
	public void add (LayoutColumn col, Size size, int columns, Margins margins)
	{
		this.add(col, new ColumnSize(size, columns), margins);		
	}
	
	
	/**
	 * 
	 * @param widget Widget
	 * @param layoutData BwtColumnLayoutData
	 */
	public void add (Widget widget, AbstractColumnData layoutData)
	{
		LayoutColumn col = new LayoutColumn();
		col.add(widget);
		
		this.add(col, layoutData);
	}


	/**
	 * 
	 * @param widget widget
	 * @param size Size
	 * @param cols int
	 */
	public void add (Widget widget, Size size, int cols)
	{
		this.add(new LayoutColumn(widget), size, cols);
		
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
	 * @param clearFix BwtClearFix
	 */
	public void remove (ClearFix clearFix)
	{
		this.getAppearance().remove(clearFix);
	}		
	


	/**
	 * 
	 * @param height int 
	 */
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
	protected LayoutRowAppearance getAppearance ()
	{
		return (LayoutRowAppearance) super.getAppearance();
	}
}
