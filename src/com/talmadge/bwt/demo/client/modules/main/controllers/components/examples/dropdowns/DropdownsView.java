/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.dropdowns;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.Window;
import com.talmadge.bwt.core.client.ui.widget.BwtHasText;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectEvent;
import com.talmadge.bwt.core.client.ui.widget.menu.Menu;
import com.talmadge.bwt.core.client.ui.widget.menu.item.MenuItem;
import com.talmadge.bwt.core.client.ui.widget.pageheader.PageHeader;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah
 *
 */
public class DropdownsView extends BwtExampleView
{
	/**
	 */
	protected interface Resources extends ClientBundle, BwtExampleView.Resources
	{
		/**
		 */
		Resources INSTANCE = GWT.create(Resources.class); 
		
		/**
		 * 
		 * @return TextResource
		 */
		TextResource code ();
	}
	
	
	
	/**
	 * Constructor 
	 *
	 * @param presenter DropdownsPresenter
	 */
	public DropdownsView (DropdownsExample presenter)
	{
		super(presenter, "Dropdowns");
	}

	
	/**
	 * 
	 * @param header String
	 * @return Html
	 */
	protected BwtHasText createHeader (String header)
	{
		return new PageHeader(header);
		
	}
	
	
	/**
	 * 
	 * @return String
	 */
	protected String getCodeRawText ()
	{
		return Resources.INSTANCE.code().getText();
	}


	/**
	 * 
	 * @param tab Tab
	 */
	protected void populateExamplesTab (Tab tab)
	{
		//=>
		final DropdownButton dropdownButtonOne = new DropdownButton("Dropdown");
		//dropdownButtonOne.setMode(Mode.HOVER);
		
//		dropdownButtonOne.addBeforeMenuShowHandler(new BeforeMenuShowHandler()
//		{
//			public void onBeforeMenuShow (BeforeMenuShowEvent event)
//			{
//				Window.alert("Before show");
//			}
//		});
//		
//		dropdownButtonOne.addMenuShowHandler(new MenuShowHandler()
//		{
//			public void onMenuShow (MenuShowEvent event)
//			{
//				Window.alert("Show");
//			}
//		});
//		
//		dropdownButtonOne.addBeforeMenuHideHandler(new BeforeMenuHideHandler()
//		{
//			public void onBeforeMenuHide (BeforeMenuHideEvent event)
//			{
//				Window.alert("Before hide");
//			}
//		});
//		
//		dropdownButtonOne.addMenuHideHandler(new MenuHideHandler()
//		{
//			public void onMenuHide (MenuHideEvent event)
//			{
//				Window.alert("Hide");
//			}
//		});
		
		dropdownButtonOne.addHeader("Dropdown header");
		
		MenuItem actionMenuItem = new MenuItem("Action")
		{
			public void onSelect (SelectEvent<MenuItem> event)
			{
				Window.alert("Action selected");
			}
		};
		
		dropdownButtonOne.addItem(actionMenuItem);
		dropdownButtonOne.addSeparator();
		
		
		Menu subMenu = new Menu();
		subMenu.add(new MenuItem("Sub action")
		{
			public void onSelect (SelectEvent<MenuItem> event)
			{
				Window.alert("Sub action selected");
			}
		});
		
		actionMenuItem.setMenu(subMenu);
	
		tab.add(dropdownButtonOne);
		
		
		
		//<=
	}
}