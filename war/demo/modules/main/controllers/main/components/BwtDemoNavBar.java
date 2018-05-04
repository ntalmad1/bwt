package com.talmadge.bwt.demo.client.modules.main.controllers.main.components;

import com.talmadge.bwt.core.client.ui.widget.nav.navbar.NavBar;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.history.HistoryNavItem;

/**
 * 
 *
 */
public class BwtDemoNavBar extends NavBar
{
	/**
	 * Hidden Constructor
	 * 
	 */
	public BwtDemoNavBar ()
	{
		super();
		
		this.setFluid(false);
		this.setMarginBottom(0);
				
		
		NavItem componentsNavItem = new HistoryNavItem("/components/", "Components"); 
        this.add(componentsNavItem);
        
        NavItem layoutsNavItem = new HistoryNavItem("/layouts/", "Layouts");
        this.add(layoutsNavItem);
        
        NavItem tablesNavItem = new HistoryNavItem("/tables/", "Tables");
        this.add(tablesNavItem);
        
        NavItem formsNavItem = new HistoryNavItem("/forms/", "Forms");
        this.add(formsNavItem);
        
        NavItem templatesNavItem = new HistoryNavItem("/templates/", "Templates");
        this.add(templatesNavItem);
        
        NavItem tooltipsNavItem = new HistoryNavItem("/tooltips/", "Tooltips");
        this.add(tooltipsNavItem);
        
        NavItem interactionsNavItem = new HistoryNavItem("/interactions/", "Interactions");
        this.add(interactionsNavItem);
        
        NavItem effectsNavItem = new HistoryNavItem("/effects/", "Effects");
        this.add(effectsNavItem);
	}
}
