package com.talmadge.bwt.core.client.ui.widget.form;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.Form.SubmitMethod;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.form.element.FormElement;
import com.talmadge.bwt.core.client.ui.widget.form.event.keypress.KeyPressEvent;
import com.talmadge.bwt.core.client.ui.widget.form.event.keypress.KeyPressHandler;
import com.talmadge.bwt.core.client.ui.widget.form.event.submit.HasSubmitHandlers;
import com.talmadge.bwt.core.client.ui.widget.form.event.submit.SubmitEvent;
import com.talmadge.bwt.core.client.ui.widget.form.event.submit.SubmitHandler;
import com.talmadge.bwt.core.client.ui.widget.form.valuefield.ValueField;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.BwtPanelInterface;

/**
 * 
 *
 */
public class FormContainer extends BwtWidgetContainer implements HasSubmitHandlers, BwtPanelInterface
{
	/**
	 */
	private List<FormElement<?>> fields = new ArrayList<FormElement<?>>();
	
	
	/**
	 */
	private SubmitMethod submitMethod = SubmitMethod.EVENT_ONLY;
	
	
	/**
	 * 
	 */
	public FormContainer ()
	{
		this((FormContainerAppearance) GWT.create(DefaultFormContainerAppearance.class));
	}
	
	
	/**
	 * 
	 * @param appearance FormAppearance
	 */
	protected FormContainer (FormContainerAppearance appearance)
	{
		super(appearance);
	}


	/**
	 * 
	 * @param handler SubmitHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addSubmitHandler (SubmitHandler handler)
	{
		return this.addHandler(handler, SubmitEvent.getType());
	}

	
	/**
	 * 
	 * @param field ValueField<?>
	 */
	public <T> void add (ValueField<T> field)
	{
		super.add(field);
		
		this.fields.add(field);
		
		field.addKeyPressHandler(new KeyPressHandler<ValueField<T>>() { 
			public void onKeyPress (KeyPressEvent<ValueField<T>> event) { 
				
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					FormContainer.this.onSubmit();
				}
			}
		});
	}
	
	
	/**
	 * 
	 */
	public void clear ()
	{
		for (FormElement<?> field : this.fields)
		{
			field.clear();
		}
	}

	
	/**
	 * 
	 * @return SubmitMethod
	 */
	public SubmitMethod getSubmitMethod ()
	{
		return this.submitMethod;
	}
	

	/**
	 * 
	 * @param method SubmitMethod
	 */
	public void setSubmitMethod (SubmitMethod method)
	{
		this.submitMethod = method;
		
		this.getAppearance().setSubmitMethod(method);
	}
	
	
	/**
	 * 
	 * @param markFields boolean
	 * @return boolean
	 */
	public boolean validate (boolean markFields)
	{
		boolean isValid = true;
		
		for (FormElement<?> element : this.fields)
		{
			if (!element.validate(markFields))
			{
				isValid = false;
			}
		}
		
		return isValid;
	}

	
	/**
	 */
	public void submit ()
	{
		switch (this.submitMethod)
		{
			case EVENT_ONLY:
				this.onSubmit();
				break;
			case GET:
			case POST:				
			default:
				this.getAppearance().getElement().submit();
				break;
		}
	}


	/**
	 * 
	 * @return FormContainerAppearance
	 */
	protected FormContainerAppearance getAppearance ()
	{	
		return (FormContainerAppearance) super.getAppearance();
	}
	
	
	/**
	 * 
	 */
	protected void onSubmit ()
	{
		this.fireEvent(new SubmitEvent());	 	
	}
} 
