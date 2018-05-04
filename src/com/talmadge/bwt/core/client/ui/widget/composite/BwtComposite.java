package com.talmadge.bwt.core.client.ui.widget.composite;

import com.google.gwt.user.client.ui.Composite;
import com.talmadge.bwt.core.client.ui.util.BwtElementUtils;

/**
 * 
 * @author Noah
 *
 */
public class BwtComposite extends Composite 
{
	/**
	 */
	private boolean hasBeenAttached = false;
	
	
	
	/**
	 * Constructor
	 * 
	 */
	public BwtComposite ()
	{
		
	}
	
	
	/**
	 * 
	 * @param cssName String
	 * @return BwtComposite
	 */
	public BwtComposite ensureCssName (String cssName)
	{
		BwtElementUtils.ensureCssName(this.getElement(), cssName);
		
		return this;
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean hasBeenAttached ()
	{
		return this.hasBeenAttached;
	}

	/**
	 * 
	 */
	protected void onAttach ()
	{
		super.onAttach();
		
		if (!this.hasBeenAttached())
		{
			this.onInitialAttach();
			this.hasBeenAttached = true;
		}
	}
	
	
	/**
	 * 
	 */
	protected void onInitialAttach ()
	{
		
	}
}
