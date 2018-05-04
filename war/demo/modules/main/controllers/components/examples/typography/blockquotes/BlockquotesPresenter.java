package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.blockquotes;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class BlockquotesPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public BlockquotesPresenter ()
	{
		super();
		
		this.setView(new BlockquotesView(this));
	}

	
	/**
	 * 
	 * @return BlockquotesView
	 */
	public BlockquotesView getView ()
	{
		return (BlockquotesView) super.getView();
	}
}
