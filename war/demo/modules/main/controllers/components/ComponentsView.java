package com.talmadge.bwt.demo.client.modules.main.controllers.components;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.talmadge.bwt.core.client.app.endpoint.presenter.view.BwtView;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.Size;
import com.talmadge.bwt.core.client.ui.widget.layout.column.LayoutColumn;
import com.talmadge.bwt.core.client.ui.widget.layout.row.LayoutRow;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttondropdowns.ButtonDropdownsPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups.ButtonGroupsPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttons.ButtonsExamples;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.code.CodeExamples;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.dropdowns.DropdownsExample;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.glyphicons.GlyphiconsExamples;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.images.ImagesExamples;
import com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.TypographyExamples;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 *
 */
public class ComponentsView extends BwtView
{
	/**
	 */
	private LayoutRow mainRow;
	
	/**
	 */
	private BwtDemoSidebar sidebar;


	/**
	 * Constructor
	 * 
	 * @param controller MainController
	 */
	public ComponentsView (ComponentsController controller)
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
        
        mainColumn.add(new GlyphiconsExamples(this.sidebar));
        mainColumn.add(new ButtonsExamples(this.sidebar));
        mainColumn.add(new TypographyExamples(this.sidebar));
        mainColumn.add(new CodeExamples(this.sidebar));
        mainColumn.add(new ImagesExamples(this.sidebar));
        mainColumn.add(new DropdownsExample(this.sidebar));
        mainColumn.add(new ButtonDropdownsPresenter(this.sidebar));
        mainColumn.add(new ButtonGroupsPresenter(this.sidebar));
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
