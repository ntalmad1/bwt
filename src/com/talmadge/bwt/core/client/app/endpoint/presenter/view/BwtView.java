/**
 *
 */
package com.talmadge.bwt.core.client.app.endpoint.presenter.view;

import java.util.Iterator;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;
import com.talmadge.bwt.core.client.app.endpoint.presenter.BwtPresenterInterface;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ContentAlign;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 *
 */
public abstract class BwtView implements BwtViewInterface
{
    /**
     */
    private BwtWidgetContainer target;

    /**
     */
    private BwtPresenterInterface presenter;
    
    
	/**
	 * Constructor
	 * 
	 * @param presenter BwtPresenter
	 */
	public BwtView (BwtPresenterInterface presenter)
	{
		this.presenter = presenter;
        
        this.init();
	}

    //	/**
	//     * Sets the underlying container of the view. Care must be taken when calling,
	//     * could corrupt the state of the view if widgets are added to view already when
	//     * called.
	//     * 
	//     * @param panel BwtPanel
	//     */
	//    protected void setPanel (BwtPanel panel)
	//    {
	//    	this.getContainer() = panel;
	//    }
	
		
		/**
		 * 
		 */
		protected abstract void init ();

	/**
     * 
     * @param child IsWidget
     */
	public void add (IsWidget child)
	{
		this.add(child.asWidget());		
	}


	/**
	 * 
	 * @param html String
	 */
	public void add (String html)
	{
	    this.add(new Html(html));
	}


	/**
	 *
	 * @param child Widget
	 */
	public void add (Widget child)
	{
	    this.getTarget().add(child);
	
	}


	/**
	 * 
	 * @param child IsWidget
	 * @param margins Margins...
	 */
	public void add (IsWidget child, Margins... margins)
	{
		this.add(child.asWidget(), margins);		
	}


	/**
	 * 
	 * @param child Widget
	 * @param margins Margins...
	 */
	public void add (Widget child, Margins... margins)
	{
		this.getTarget().add(child, margins);
	
	}


	/**
     *
     * @return Widget
     */
    public Widget asWidget ()
    {
        return this.getTarget().asWidget();
    }


    /**
     *
     */
    public void clear ()
    {
        this.getTarget().clear();
    }


	/**
	 * 
	 * @return WidgetCollection
	 */
	public WidgetCollection getChildren ()
	{
		return this.getTarget().getChildren();
	}
	
	
	/**
	 * 
	 * @return BwtPanelInterface
	 */
	public BwtWidgetContainer getTarget ()
	{
		return this.target;
	}


	/**
	 * 
	 * @return Element
	 */
	public Element getElement ()
	{
		return this.getTarget().getElement();
	}

	
	/**
	 * 
	 * @return String
	 */
	public String getId ()
	{
	    return this.getTarget().getId();
	}
	

	/**
     *
     * @return BWTPresenter
     */
    public BwtPresenterInterface getPresenter ()
    {
        return this.presenter;
    }
    
    
    /**
     * 
     */
    public abstract void go ();
    
    
    /**
	 * 
	 * @param cssName
	 */
	public void ensureCssName (String cssName)
	{
		this.getTarget().ensureCssName(cssName);		
	}
    
    
    /**
     * 
     * @return boolean
     */
    public boolean hasId ()
    {
        return (this.getId() != null && !this.getId().isEmpty());
    }


    /**
     *
     * @return Iterator<Widget>
     */
    public Iterator<Widget> iterator ()
    {
        return this.getTarget().iterator();
    }

    
    /**
     * 
     */
    @Override
	public void mask ()
	{
		this.getTarget().mask();		
	}


	/**
	 * 
	 * @param message
	 */
	public void mask (String message)
	{
		this.getTarget().mask(message);		
	}
	
	
	/**
	 * 
	 * @param e Exception
	 */
	public void onException (Exception e)
	{
		this.getPresenter().getApp().onException(e);
	}


	/**
     * 
     * @param child IsWidget
     * @return boolean true if the widget exists
     */
	public boolean remove (IsWidget child)
	{
		return this.remove(child.asWidget());
	}


	/**
     *
     * @param child Widget
     * @return boolean
     */
    public boolean remove (Widget child)
    {
        return this.getTarget().remove(child);
    }

    
    /**
     * 
     * @param align ContentAlign
     */ 
    public void setContentAlign (ContentAlign align)
    {
        this.getTarget().setContentAlign(align);        
    }


    /**
     *
     * @param isCentered boolean
     */
    public void setCentered (boolean isCentered)
    {
        this.getTarget().setCentered(isCentered);
    }

    
    /**
     * 
     * @param display Display
     */
   public void setDisplay (Display display)
	{
		this.getTarget().setDisplay(display);		
	}


	/**
	 * 
	 * @param height String
	 */
	public void setHeight (String height)
	{
		this.getTarget().setHeight(height);		
	}
	
	
	/**
     * 
     * @param id
     */
    @Override
    public void setId (String id)
    {
        this.getTarget().setId(id);
    }
    
    
    /**
     * 
     * @param height String
     */
    public void setMinHeight (int height)
    {
        this.getTarget().setMinHeight(height);     
    }
    
    
    /**
     * 
     * @param target BwtWidgetContainer
     */
    public void setTarget (BwtWidgetContainer target)
    {
    	this.target = target;
    }
    
    
    /**
     * 
     * @param align VerticalAlign
     */
 	public void setVerticalAlign (VerticalAlign align)
	{
		this.getTarget().setVerticalAlign(align);		
	}

    
    /**
     * 
     */
	@Override
	public void unmask ()
	{
		this.getTarget().unmask();
	}


//	/**
//     * Sets the underlying container of the view. Care must be taken when calling,
//     * could corrupt the state of the view if widgets are added to view already when
//     * called.
//     * 
//     * @param panel BwtPanel
//     */
//    protected void setPanel (BwtPanel panel)
//    {
//    	this.getContainer() = panel;
//    }

}
