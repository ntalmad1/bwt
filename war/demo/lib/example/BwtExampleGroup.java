package com.talmadge.bwt.demo.client.lib.example;

import java.util.ArrayList;
import java.util.List;

import com.talmadge.bwt.core.client.ui.util.BwtWidgetUtils;
import com.talmadge.bwt.core.client.ui.widget.component.BwtComponent;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;
import com.talmadge.bwt.core.client.ui.widget.nav.sidebar.Sidebar;

/**
 * 
 * @author Noah
 *
 */
public abstract class BwtExampleGroup extends BwtComponent
{
	/**
	 */
	private List<BwtExamplePresenter> examples;
	
	
	/**
	 */
	private NavItem item;
	
	
	/**
	 * Constructor 
	 *
	 */
	public BwtExampleGroup ()
	{
		super();
		
		this.examples = new ArrayList<BwtExamplePresenter>(); 
	}
	
	
	/**
	 * 
	 * @return List<BwtExamplePresenter>
	 */
	public List<BwtExamplePresenter> getExamples ()
	{
		return this.examples;
	}
	
	
	/**
	 * 
	 * @return BwtDemoView
	 */
	public BwtExampleGroupView getView ()
	{
		return (BwtExampleGroupView) super.getView();
	}
	
	
	
	
	/**
	 * 
	 * @param sidebar Sidebar
	 */
	public void populateSideNav (Sidebar sidebar)
	{
		if (this.getView().getId() == null || this.getView().getId().isEmpty())
		{
			this.getView().setId(BwtWidgetUtils.uniqueId());
		}
	    
		if (this.item == null)
		{
			this.item = new NavItem(
					  this.getView().getId() 
					, this.getView().getHeader().getText());
			
			
			for (BwtExamplePresenter example : this.getExamples())
			{
				item.add(example.getNavItem());
			}
		}
		
		sidebar.add(item);
	}


	/**
	 * 
	 * @param example BwtExamplePresenter
	 */
	protected void addExample (BwtExamplePresenter example)
	{
		this.getExamples().add(example);
		this.getView().add(example.asWidget());
	}
}
