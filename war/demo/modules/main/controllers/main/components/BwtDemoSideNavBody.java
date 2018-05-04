package com.talmadge.bwt.demo.client.modules.main.controllers.main.components;

import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.Size;
import com.talmadge.bwt.core.client.ui.widget.container.ShadowConfig;
import com.talmadge.bwt.core.client.ui.widget.layout.column.LayoutColumn;
import com.talmadge.bwt.core.client.ui.widget.layout.container.LayoutContainer;
import com.talmadge.bwt.core.client.ui.widget.layout.row.LayoutRow;
import com.talmadge.bwt.core.client.ui.widget.nav.sidebar.Sidebar;

/**
 * 
 *
 */
public class BwtDemoSideNavBody extends LayoutContainer
{
	/**
	 */
	private static BwtDemoSideNavBody instance;
    
	/**
	 * 
	 * @return BwtDemoBody
	 */
	public static BwtDemoSideNavBody getInstance ()
	{
		if (instance == null)
		{
			instance = new BwtDemoSideNavBody();
		}
		
		return instance;
	}

	
	/**
	 */
	private LayoutColumn mainColumn;	
	
	/**
	 */
	private LayoutColumn sideColumn;

	private Sidebar sidebar;
	
	
	public BwtDemoSideNavBody ()
	{
		super();
		
		this.ensureCssName("bwt-demo-maincontainer");
		
		this.setCornerRadiusBottomLeft(5);
		this.setCornerRadiusBottomRight(5);
		
		this.setShadow(ShadowConfig.DEFAULT);
		
		
		
		//this.setPaddingBottom(600);
        
        
        LayoutRow mainRow = new LayoutRow();
        this.add(mainRow);

        this.mainColumn = new LayoutColumn();
        this.sideColumn = new LayoutColumn();
        this.sideColumn.setPaddingTop(20);
        
      
        
        mainRow.add(this.mainColumn, Size.MD, 9); 
        mainRow.add(this.sideColumn, Size.MD, 3);

        this.sideColumn.add(this.sidebar);
    }
	
	
	/**
	 * 
	 * @return LayoutColumn
	 */
	public LayoutColumn getMainColumn ()
	{
		return this.mainColumn;
	}
	
	
//	/**
//	 * 
//	 * @return LayoutColumn
//	 */
//	public LayoutColumn getSideColumn ()
//	{
//		return this.sideColumn;
//	}


	/**
	 * 
	 * @return Sidebar
	 */
	public Sidebar getSidebar ()
	{
		return this.sidebar;
	}
}
