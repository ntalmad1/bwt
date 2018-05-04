package com.talmadge.bwt.mobile.client.ui.widget.mainpanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.BwtPanel;
import com.talmadge.bwt.mobile.client.ui.widget.event.HammerEventBridge;
import com.talmadge.bwt.mobile.client.ui.widget.event.MobileEventBridge;
import com.talmadge.bwt.mobile.client.ui.widget.event.swiperight.HasSwipeRightHandlers;
import com.talmadge.bwt.mobile.client.ui.widget.event.swiperight.SwipeRightEvent;
import com.talmadge.bwt.mobile.client.ui.widget.event.swiperight.SwipeRightHandler;

/**
 * 
 *
 */
public class MobileMainPanel extends BwtPanel implements HasSwipeRightHandlers
{
	/**
	 */
	private MobileEventBridge mobileEventBridge;


	
	/**
	 * Constructor
	 * 
	 */
	public MobileMainPanel ()
	{
		this((MobileMainPanelAppearance) GWT.create(DefaultMobileMainPanelAppearance.class));
	}

	
	/**
	 * Hidden Constructor
	 * 
	 * @param appearance MobileMainPanelAppearance
	 */
	protected MobileMainPanel (MobileMainPanelAppearance appearance)
	{
		super(appearance);
		
		this.mobileEventBridge = new HammerEventBridge(this.getElement());
	}

	
	/**
	 *  
	 * @param handler SwipeRightHandler
	 */
	@Override
	public HandlerRegistration addSwipeRightHandler (SwipeRightHandler handler)
	{
		return this.addHandler(handler, SwipeRightEvent.getType());
	}
	
	
	/**
	 * 
	 * @return MobileEventBridge
	 */
	protected MobileEventBridge getMobileEventBridge ()
	{
		return this.mobileEventBridge;
	}
}
