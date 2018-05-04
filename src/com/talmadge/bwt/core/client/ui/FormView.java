package com.talmadge.bwt.core.client.ui;

import com.talmadge.bwt.core.client.app.endpoint.presenter.view.BwtView;
import com.talmadge.bwt.core.client.ui.widget.form.FormContainer;

/**
 * 
 *
 */
public class FormView extends BwtView
{
	/**
	 * 
	 * @param presenter FormPresenter
	 */
	public FormView (Form presenter)
	{
		super(presenter);
	}

	
	/**
	 * 
	 * @return FormContainer 
	 */
	public FormContainer getFormContainer ()
	{
		return (FormContainer) this.getTarget();
	}


	@Override
	protected void init ()
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void go ()
	{
		// TODO Auto-generated method stub
		
	}


}
