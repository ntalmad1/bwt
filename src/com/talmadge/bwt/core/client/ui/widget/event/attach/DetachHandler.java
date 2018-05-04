package com.talmadge.bwt.core.client.ui.widget.event.attach;

import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;

/**
 * 
 */
public abstract class DetachHandler implements Handler
{
    /**
     *
     * @param event AttachEvent
     */
    public void onAttach (AttachEvent event)
    {

    }


    /**
	 *
	 * @param event AttachEvent
	 */
	public void onAttachOrDetach (AttachEvent event)
	{
	    if (!event.isAttached())
	    {
	        this.onDetach(event);
	    }
	    else
	    {
	        this.onAttach(event);
	    }
	}


	/**
     *
     * @param event AttachEvent
     */
    public abstract void onDetach (AttachEvent event);
}