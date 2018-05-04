package com.talmadge.bwt.core.client.ui.widget.form.valuefield;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.form.constant.AddonPos;
import com.talmadge.bwt.core.client.ui.widget.form.element.AbstractFormElement;
import com.talmadge.bwt.core.client.ui.widget.form.event.keypress.HasKeyPressHandlers;
import com.talmadge.bwt.core.client.ui.widget.form.event.keypress.KeyPressEvent;
import com.talmadge.bwt.core.client.ui.widget.form.event.keypress.KeyPressHandler;
import com.talmadge.bwt.core.client.ui.widget.form.event.keyup.HasKeyUpHandlers;
import com.talmadge.bwt.core.client.ui.widget.form.event.keyup.KeyUpEvent;
import com.talmadge.bwt.core.client.ui.widget.form.event.keyup.KeyUpHandler;
import com.talmadge.bwt.core.client.ui.widget.form.event.valueinput.HasValueInputHandlers;
import com.talmadge.bwt.core.client.ui.widget.form.event.valueinput.ValueInputEvent;
import com.talmadge.bwt.core.client.ui.widget.form.event.valueinput.ValueInputHandler;
import com.talmadge.bwt.core.client.ui.widget.form.valuefield.constrainer.ValueFieldConstrainer;
import com.talmadge.bwt.core.client.ui.widget.form.valuefield.validator.ValueValidator;

/**
 * 
 *
 */
abstract public class ValueField<T> extends AbstractFormElement<T> implements HasKeyPressHandlers<ValueField<T>>, HasKeyUpHandlers<ValueField<T>>, HasValueInputHandlers<ValueField<T>, T>
{
	/**
	 */
	private T previousValue;
	
	/**
	 */
	private String placeholder;
	
	/**
	 */
	private ValueFieldConstrainer valueConstrainer;
	
	/**
	 * 
	 */
	private List<ValueValidator> validators;

	
	
	/**
	 * Constructor
	 * 
	 * @param appearance ValueFieldAppearance
	 */
	protected ValueField (ValueFieldAppearance appearance)
	{
		super(appearance);
		
		this.validators = new ArrayList<ValueValidator>();
		
		this.bindValueField();
	}
	
	
	/**
	 * 
	 * @param handler KeyPressHandler<ValueField<T>>
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addKeyPressHandler (KeyPressHandler<ValueField<T>> handler)
	{
		return this.addHandler(handler, KeyPressEvent.getType());		
	}


	/**
	 * 
	 * @param handler KeyUpHandler<ValueField<T>>
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addKeyUpHandler (KeyUpHandler<ValueField<T>> handler)
	{
		return this.addHandler(handler, KeyUpEvent.getType());
	}
	
	
	/**
	 * 
	 * @param handler ValueChangeHandler<ValueField<T>, String>
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addValueChangeHandler (ValueInputHandler<ValueField<T>, T> handler)
	{
		return this.addHandler(handler, ValueInputEvent.getType());
	}
	
	
	/**
	 * 
	 * @param validator ValueValidator
	 */
	public void addValidator (ValueValidator validator)
	{
		this.validators.add(validator);
	}

	
	/**
	 * 
	 */
	public void clear ()
	{
		this.clearState();
		this.getAppearance().clear();
	}

	
	/**
	 * 
	 */
	public void focus ()
	{
		this.getAppearance().focus();
	}
	
	
	/**
	 * 
	 * @return ValueFieldAppearance
	 */
	public ValueFieldAppearance getAppearance ()
	{
		return (ValueFieldAppearance) super.getAppearance();
	}
	
	
	/**
	 * 
	 * @return T
	 */
	abstract public T getValue ();
	
	
	/**
	 * 
	 * @param label String
	 */
	public void setLabel (String label)
	{
		if (this.placeholder == null)
		{
			this.setPlaceholder(label);
		}
		
		super.setLabel(label);
	}
	
	/**
	 * 
	 * @param placeholder String
	 */
	public void setPlaceholder (String placeholder)
	{
		this.placeholder = placeholder;
		this.getAppearance().setPlaceholder(placeholder);
	}
	
	/**
	 * 
	 * @param icon Glyphicon
	 * @param pos AddonPos 
	 * @return TextField
	 */
	public ValueField<T> setAddon (Glyphicon icon, AddonPos pos)
	{
		this.getAppearance().setAddon(icon, pos);
		
		return this;
	}	
	
	/**
	 * 
	 * @param string String
	 * @param pos AddonPos 
	 * @return TextField
	 */
	public ValueField<T> setAddon (String string, AddonPos pos)
	{
		this.getAppearance().setAddon(string, pos);
		
		return this;
		
	}

	/**
	 * 
	 * @param widget Widget
	 * @param pos AddonPos 
	 */
	public void setAddon (Widget widget, AddonPos pos)
	{
		this.getAppearance().setAddon(widget, pos);
		
	}
	
	
	/**
	 * 
	 * @param maxLength int
	 */
	public void setMaxLength (int maxLength)
	{
		this.getAppearance().setMaxLength(maxLength);
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	protected boolean validate ()
	{
		boolean isValid = super.validate();
		
		if (!this.validators.isEmpty() && isValid)
		{
			for (ValueValidator validator : this.validators)
			{
				String message = validator.validate(this.getLabel(), this.getValue().toString());
				
				if (message != null)
				{
					this.setErrorMessage(message);
					isValid = false;
					break;
				}
			}
		}
			
		return isValid;
	}
	
	
	/**
	 * 
	 */
	protected void bindValueField ()
	{
		Element input = this.getAppearance().getInputElement();
		
		Event.sinkEvents(input, Event.ONBLUR | Event.ONFOCUS | Event.ONKEYUP | Event.ONKEYPRESS | Event.ONPASTE);
		Event.setEventListener(input, new EventListener() {

	        @Override
	        public void onBrowserEvent (Event event) 
	        {
	        	if (Event.ONBLUR == event.getTypeInt()) 
	            {
	        		ValueField.this._onBlur(event);
	            }
	        	else if (Event.ONFOCUS == event.getTypeInt()) 
	            {
	        		ValueField.this._onFocus(event);
	            }
	        	else if (Event.ONKEYUP == event.getTypeInt()) 
	            {
	        		ValueField.this._onKeyUp(event);
	            }
	        	else if (Event.ONKEYPRESS == event.getTypeInt()) 
	            {
	        		ValueField.this._onKeyPress(event);
	            }
	        	else if (Event.ONPASTE == event.getTypeInt()) 
	            {
	        		ValueField.this._onPaste(event);
	            }
	        }
	    });
		
		
	
	}
	
	
	/**
	 * 
	 */
	abstract protected void checkForValueChange ();
	
	
	/**
	 * 
	 * @return T
	 */
	protected T getPreviousValue ()
	{
		return this.previousValue;
	}

	
	/**
	 * 
	 * @return ValueFieldConstrainer
	 */
	protected ValueFieldConstrainer getValueConstrainer ()
	{
		if (this.valueConstrainer == null)
		{
			this.setValueConstrainer(new ValueFieldConstrainer());
		}
		
		return this.valueConstrainer;
	}


	/**
	 * 
	 * @param value T
	 */
	protected void setPreviousValue (T value)
	{
		this.previousValue = value;
	}
	
	
	/**
	 * 
	 * @param valueConstrainer ValueFieldConstrainer
	 */
	protected void setValueConstrainer (ValueFieldConstrainer valueConstrainer)
	{
		this.valueConstrainer = valueConstrainer;
		this.valueConstrainer.setTarget(this.getAppearance().getInputElement());
	}
	
	
	/**
	 * 
	 * @param event Event
	 */
	protected void _onKeyDown (Event event)
	{
		this.getValueConstrainer().onKeyDown(event);
	}
	

	/**
	 * 
	 * @param event Event
	 */
	protected void _onKeyPress (Event event)
	{
		if (this.getValueConstrainer().onKeyPress(event))
		{
			KeyPressEvent<ValueField<T>> keyPressEvent = new KeyPressEvent<ValueField<T>>(this, event);
			this.fireEvent(keyPressEvent);
		}	
	}


	/**
	 * 
	 * @param event Event
	 */
	protected void _onKeyUp (Event event)
	{
		KeyUpEvent<ValueField<T>> keyUpEvent = new KeyUpEvent<ValueField<T>>(this, event);
		this.fireEvent(keyUpEvent);
		
		this.checkForValueChange();
	}
	
	
	/**
	 * 
	 * @param event Event
	 */
	protected void _onPaste (Event event)
	{
		this.getValueConstrainer().onPaste(event);
	}
}