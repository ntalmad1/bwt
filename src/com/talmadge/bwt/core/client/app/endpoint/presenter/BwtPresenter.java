package com.talmadge.bwt.core.client.app.endpoint.presenter;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.app.endpoint.AbstractEndpoint;
import com.talmadge.bwt.core.client.app.endpoint.presenter.view.BwtViewInterface;

/**
 *
 */
public class BwtPresenter extends AbstractEndpoint implements BwtPresenterInterface
{
	/**
	 */
	private HandlerManager handlerManager;
	
	
    /**
     */
    private BwtViewInterface view;


    /**
     *
     * Constructor
     */
    public BwtPresenter ()
    {
        this.handlerManager = new HandlerManager(this);
    }
    
    
	/**
	 *
	 * Constructor
	 * 
	 * @param view BwtView
	 */
	public BwtPresenter (BwtViewInterface view)
	{
		this();
		this.setView(view);
	}
	

	/**
	 * 
	 * @param widget Widget
	 */
	public void add (Widget widget)
	{
	    this.getView().add(widget);
	}
	
	
	/**
	 * 
	 * @param type Type<H>
	 * @param handler H
	 * @return HandlerRegistration
	 */
	public <H extends EventHandler> HandlerRegistration addHandler (Type<H> type, H handler)
	{
		return this.handlerManager.addHandler(type, handler);
	}


    /**
     *
     * @return BWTView
     */
    public BwtViewInterface getView ()
    {
        return this.view;
    }
    
    
    /**
     * 
     */
    @Override
	public void go () throws Exception
	{
		if (this.getView() != null)
		{
			this.getView().setTarget(this.getTarget());
			this.getView().go();
		}
	}


	/**
     * 
     * @param event GwtEvent<H>
     */
    public <H extends EventHandler> void fireEvent (GwtEvent<H> event)
    {
    	this.handlerManager.fireEvent(event);
    }
    
    
//    /**
//	 * 
//	 * @return boolean
//	 */
//	public boolean isAttached ()
//	{
//	    return this.getView().isAttached();
//	}


	/**
     * 
     */
	public void mask ()
	{
		this.getView().mask();
	}
    
    
    /**
     * @param view BWTView
     */
    public void setView (BwtViewInterface view)
    {
        this.view = view;
    }
    
    
    /**
     * 
     */
    protected void unmask ()
	{
    	this.getView().unmask();		
	}
}
