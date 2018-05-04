package com.talmadge.bwt.core.client.ui;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Timer;
import com.talmadge.bwt.core.client.app.endpoint.presenter.BwtPresenter;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectEvent;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectHandler;
import com.talmadge.bwt.core.client.ui.widget.form.event.submit.HasSubmitHandlers;
import com.talmadge.bwt.core.client.ui.widget.form.event.submit.SubmitEvent;
import com.talmadge.bwt.core.client.ui.widget.form.event.submit.SubmitHandler;
import com.talmadge.bwt.core.client.ui.widget.form.valuefield.ValueField;

/**
 * The presenter
 *
 */
public class Form extends BwtPresenter implements HasSubmitHandlers
{	
	/**
	 */
	public enum SubmitMethod 
	{
		/**
		 */
		EVENT_ONLY,
		
		/**
		 */
		GET,
		
		/**
		 */
		POST;		
	}


	/**
	 */
	private static Integer DEFAULT_RESUBMIT_ALLOW_TIME = new Integer(256);

	
	
	/**
	 */
	private Integer resubmitAllowTime;

	
	
	/**
	 * Constructor
	 * 
	 */
	public Form ()
	{
		super();
		this.setView(new FormView(this));
		
		this.bindForm();
	}

	
	/**
	 * 
	 * @param button Button
	 */
	public void addSubmitButton (Button button)
	{
		this.add(button);
		this.bindSubmitButton(button);		
	}
	
	
	/**
	 * 
	 * @param handler SubmitHandler
	 */
	@Override
	public HandlerRegistration addSubmitHandler (SubmitHandler handler)
	{
		return this.addHandler(SubmitEvent.getType(), handler); 
	}

	
	/**
	 * 
	 * @return Integer
	 */
	public Integer getResubmitAllowTime ()
	{
		if (this.resubmitAllowTime == null)
		{
			this.setResubmitAllowTime(DEFAULT_RESUBMIT_ALLOW_TIME);
		}
		
		return this.resubmitAllowTime;
	}
	
	
	/**
	 * 
	 * @return FormView
	 */
	public FormView getView ()
	{
		return (FormView) super.getView();
	}
	
	
	/**
	 * 
	 * @param field ValueField<?>
	 */
	public <T> void add (ValueField<T> field)
	{
		this.getView().getFormContainer().add(field);
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isValid ()
	{
		return this.validate();
	}
	
	
	/**
	 * In milliseconds 
	 * 
	 * @param integer
	 */
	public void setResubmitAllowTime (Integer millis)
	{
		this.resubmitAllowTime = millis;
	}
	
	
	/**
	 * 
	 */
	public void submit ()
	{
		this.getView().getFormContainer().submit();
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean validate ()
	{
		return this.validate(true);
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean validate (boolean markFields)
	{
		return this.getView().getFormContainer().validate(markFields);
	}
	
	
	/**
	 * 
	 * @param button Button
	 */
	protected void bindSubmitButton (final Button button)
	{
		button.addSelectHandler(new SelectHandler<Button>()
		{
			public void onSelect (SelectEvent<Button> event)
			{
				Form.this.submit();
				button.disable();
				
				Timer timer = new Timer() {
					public void run () {
						button.enable();
					}
				};
				timer.schedule(Form.this.getResubmitAllowTime());
			}
		});
	}
	

	/**
	 * 
	 */
	protected void bindForm ()
	{
		this.getView().getFormContainer().addSubmitHandler(new SubmitHandler(){
			public void onSubmit (SubmitEvent event)
			{
				Form.this.fireEvent(event);				
			}
		});		
	}
}
