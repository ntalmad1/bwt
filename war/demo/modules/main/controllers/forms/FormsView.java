package com.talmadge.bwt.demo.client.modules.main.controllers.forms;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.talmadge.bwt.core.client.app.endpoint.presenter.view.BwtView;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.Size;
import com.talmadge.bwt.core.client.ui.widget.layout.column.LayoutColumn;
import com.talmadge.bwt.core.client.ui.widget.layout.row.LayoutRow;
import com.talmadge.bwt.demo.client.modules.main.controllers.forms.examples.fields.FieldsExamples;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 *
 */
public class FormsView extends BwtView
{
	/**
	 */
	private LayoutRow mainRow;
	private BwtDemoSidebar sidebar;
	
	
	/**
	 * Constructor
	 * 
	 */
	public FormsView (FormsController controller)
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
        
        mainColumn.add(new FieldsExamples(this.sidebar));
    }
	


	/**
	 * 
	 */
	@Override
	public void go ()
	{
		if (this.mainRow.isAttached())
		{
			return;
		}
		
		this.clear();
		this.add(mainRow);
		
		//sidebar.getScrollSpy().refresh();
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
