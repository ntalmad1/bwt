package com.talmadge.bwt.core.client.ui.widget.event.attach;

import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;

/**
 * 
 */
public abstract class AttachHandler implements Handler
{
    /**
     *
     * @param event AttachEvent
     */
    public abstract void onAttach (AttachEvent event);


    /**
     *
     * @param event AttachEvent
     */
    public void onAttachOrDetach (AttachEvent event)
    {
        if (event.isAttached())
        {
            this.onAttach(event);
        }
        else
        {
            this.onDetach(event);
        }
    }


    /**
     *
     * @param event AttachEvent
     */
    public void onDetach (AttachEvent event)
    {

    }
}