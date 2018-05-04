package com.talmadge.bwt.demo.client.modules.main.controllers.main.components;

import com.talmadge.bwt.core.client.ui.widget.container.ShadowConfig;
import com.talmadge.bwt.core.client.ui.widget.layout.container.LayoutContainer;

/**
 * 
 *
 */
public class BwtDemoBody extends LayoutContainer
{
	/**
	 * Constructor
	 * 
	 */
	public BwtDemoBody ()
	{
		super();
		
		this.setId("mainContentContainer");
		
		this.ensureCssName("bwt-demo-maincontainer");
		
		this.setCornerRadiusBottomLeft(5);
		this.setCornerRadiusBottomRight(5);
		
		this.setShadow(ShadowConfig.DEFAULT);
		
		
		
		//this.setPaddingBottom(600);
        
        
//        LayoutRow mainRow = new LayoutRow();
//        this.add(mainRow);
//
//        this.mainColumn = new LayoutColumn();
//        this.sideColumn = new LayoutColumn();
//        this.sideColumn.setPaddingTop(20);
//        
//        this.sidebar = new Sidebar();
//        this.sidebar.setAffix(true);
//        
//        ScrollSpy scrollSpy = new ScrollSpy(Document.get().getBody());
//        scrollSpy.setOffsetTop(400);
//        scrollSpy.setOffsetBottom(300);
//        
//        this.sidebar.setScrollSpy(scrollSpy);
//
//        mainRow.add(this.mainColumn, Size.MD, 9);
//        mainRow.add(this.sideColumn, Size.MD, 3);
//
//        this.sideColumn.add(this.sidebar);
//        
//        this.add(this);
    }
}
