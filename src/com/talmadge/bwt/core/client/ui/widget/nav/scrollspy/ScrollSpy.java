package com.talmadge.bwt.core.client.ui.widget.nav.scrollspy;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.talmadge.bwt.core.client.ui.util.BwtWidgetUtils;
import com.talmadge.bwt.core.client.ui.widget.event.attach.AttachHandler;
import com.talmadge.bwt.core.client.ui.widget.nav.AbstractNav;
import com.talmadge.bwt.core.client.ui.widget.nav.event.ItemAddEvent;
import com.talmadge.bwt.core.client.ui.widget.nav.event.ItemAddHandler;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;

/**
 * 
 * @author Noah
 *
 */
public class ScrollSpy
{ 
	/**
	 */
	private ScrollSpyJQueryBridge jQueryBridge;
	
	/**
	 */
	private AbstractNav nav;
	
	/**
	 */
	private int offsetBottom;
	
	/**
	 */
	private int offsetTop;
	
	/**
	 */
	private Element spyedOnElement;
	
	/**
	 */
	private boolean hasNavBeenAttached = false;
	
	
	/**
	 * Constructor
	 *  
	 * 
	 * @param spyedOnElement Element
	 */
	public ScrollSpy (Element spyedOnElement)
	{
		super();
		
		this.spyedOnElement = spyedOnElement;
        
		// make sure the spyedOnElement has an id
		if (this.spyedOnElement.getId() == null || this.spyedOnElement.getId().isEmpty())
		{
			this.spyedOnElement.setId(BwtWidgetUtils.uniqueId());
		}
		
		this.jQueryBridge = new ScrollSpyJQueryBridge(this);
	}
	
	
//	/**
//	 * 
//	 * @param item NavItem
//	 */
//	public void add (NavItem item)
//	{
//		item.setScrollTo(true);
//		
//		this.getNav().add(item);		
//	}


    /**
     * 
     */
    public void bindNavItems ()
    {
        this.getJQueryBridge().bindNavItems();
    }


    /**
	 * 
	 * @return AbstractNav
	 */
	public AbstractNav getNav ()
	{
		return this.nav;
	}

	
	/**
	 * 
	 * @return int
	 */
	public int getOffsetBottom ()
	{
		return this.offsetBottom;
	}
	
	
	/**
	 * 
	 * @return int
	 */
	public int getOffsetTop ()
	{
		return this.offsetTop;
	}


	/**
	 * 
	 * @return Element
	 */
	public Element getTarget ()
	{
		return this.spyedOnElement;
	}

	
	/**
	 * 
	 */
	public void refresh ()
	{
	    this.getJQueryBridge().refresh();
	}
	
	
	/**
	 * 
	 * @param nav AbstractNav
	 */
	public void setNav (AbstractNav nav)
	{
	    this.nav = nav;
	    
	    if (this.offsetTop > 0)
	    {
	        this.nav.setOffsetTop(this.offsetTop);
	    }
	    
	    if (this.offsetBottom > 0)
	    {
	        this.nav.setOffsetBottom(this.offsetBottom);
	    }
	    
	    this.bindNav();
	}
	

	/**
	 * 
	 * @param offset int
	 */
	public void setOffsetBottom (int offset)
	{
		this.offsetBottom = offset;
		
		if (this.nav != null)
        {
            this.nav.setOffsetBottom(offset);
        }
	}


	/**
	 * 
	 * @param offset int
	 */
	public void setOffsetTop (int offset)
	{
		this.offsetTop = offset;
		
		if (this.nav != null)
		{
		    this.nav.setOffsetTop(offset);
		}
	}

	
	/**
	 * 
	 */
	protected void bindNav ()
    {   
	    this.nav.addAttachHandler(new AttachHandler()
        {
            public void onAttach (AttachEvent event)
            {
                if (event.isAttached())
                {
                    ScrollSpy.this.onNavAttach();
                }
                else
                {
                    ScrollSpy.this.onNavDetach();
                }
                
            }
        }); 
	    
	    
	    
	    this.nav.addItemAddHandler(new ItemAddHandler()
        {
	        public void onItemAdd (ItemAddEvent event)
	        {
	           ScrollSpy.this.onNavItemAdd(event.getItem());
	        }
        });
    }

	
	/**
	 * 
	 * @return ScrollSpyJQueryBridge
	 */
	protected ScrollSpyJQueryBridge getJQueryBridge ()
	{
		return this.jQueryBridge;
	}
	

	/**
     */
    protected void onNavDetach ()
    {
    
        
    }


    /**
     */
    protected void onNavAttach ()
    {
        if (!this.hasNavBeenAttached)
        {
            this.hasNavBeenAttached = true;
            
            this.onNavInitialAttach();
        }
        
    }


    /**
	 * 
	 */
    protected void onNavInitialAttach ()
    {
        this.getTarget().setAttribute("data-spy", "scroll");
        
        this.getTarget().setAttribute("data-target", "#" + this.getNav().getId());
        this.getTarget().setAttribute("data-offset-top", "" + this.offsetTop);
        this.getTarget().setAttribute("data-offset-bottom", "" + this.offsetBottom);

        this.getTarget().getStyle().setPosition(Position.RELATIVE);

        this.getNav().setActive(this.getNav().getFirstItem());

        Scheduler.get().scheduleDeferred(new ScheduledCommand()
        {
            public void execute ()
            {
                ScrollSpy.this.jQueryBridge.attach();
            }
        });        
    }


    /**
     * 
     * @param item NavItem
     */
    protected void onNavItemAdd (NavItem item)
    {
      
    }
}
