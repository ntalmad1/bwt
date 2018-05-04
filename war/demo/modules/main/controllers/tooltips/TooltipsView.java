package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.talmadge.bwt.core.client.app.endpoint.presenter.view.BwtView;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.Size;
import com.talmadge.bwt.core.client.ui.widget.layout.column.LayoutColumn;
import com.talmadge.bwt.core.client.ui.widget.layout.row.LayoutRow;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;
import com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.customtriggers.CustomTriggersExample;
import com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.defaultsettings.DefaultSettingsExample;
import com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.events.EventsExample;
import com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.html.HtmlExample;
import com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.interactions.InteractionsExample;
import com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.mouse.MouseExample;
import com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.multiple.MultipleExample;
import com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.smart.SmartExample;
import com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.theme.ThemeExample;
import com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.widgets.WidgetsExample;

/**
 * 
 *
 */
public class TooltipsView extends BwtView
{
	private LayoutRow mainRow;
	private BwtDemoSidebar sidebar;
	
	
	/**
	 * Constructor
	 * 
	 * @param controller ToolTipsController
	 */
	public TooltipsView (TooltipsController controller)
	{
		super(controller);
	}
	
	
	/**
	 * 
	 */
	@Override
	protected void init ()
	{
		this.mainRow = new LayoutRow();
        
		LayoutColumn mainColumn = new LayoutColumn();
		
		this.sidebar = new BwtDemoSidebar(); 
		
		LayoutColumn sideColumn = new LayoutColumn();
        sideColumn.setPaddingTop(20);
        sideColumn.add(sidebar);
        
        this.mainRow.add(mainColumn, Size.MD, 9); 
        this.mainRow.add(sideColumn, Size.MD, 3);
        
        mainColumn.add(new DefaultSettingsExample(this.sidebar));
        mainColumn.add(new HtmlExample(this.sidebar));
        mainColumn.add(new MultipleExample(this.sidebar));
        mainColumn.add(new EventsExample(this.sidebar));
        mainColumn.add(new WidgetsExample(this.sidebar));
        mainColumn.add(new CustomTriggersExample(this.sidebar));
        mainColumn.add(new SmartExample(this.sidebar));
        mainColumn.add(new InteractionsExample(this.sidebar));
        mainColumn.add(new MouseExample(this.sidebar));
        mainColumn.add(new ThemeExample(this.sidebar));
	}

	
	@Override
	public void go ()
	{
		if (this.mainRow.isAttached())
		{
			return;
		}

		
		this.clear();
		
		this.add(mainRow);
		
		sidebar.getScrollSpy().bindNavItems();
        
        if (sidebar.getFirstItem() != null)
        {
			sidebar.getFirstItem().setActive(true);
        } 
        
        Scheduler.get().scheduleDeferred(new ScheduledCommand()
        {
            public void execute ()
            {
            	if (sidebar.getFirstItem() != null)
                {
            		sidebar.getFirstItem().setActive(true);
                }   
            }
        });
	}
	
	
}
