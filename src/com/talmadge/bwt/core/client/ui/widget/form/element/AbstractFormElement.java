package com.talmadge.bwt.core.client.ui.widget.form.element;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.HasBlurHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONValue;
import com.talmadge.bwt.core.client.json.JsonUtils;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.FormElementSize;
import com.talmadge.bwt.core.client.ui.util.Position;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;

/**
 * 
 * @author Noah
 *
 * @param <T>
 */
public abstract class AbstractFormElement<T> extends BwtWidget implements FormElement<T>, HasBlurHandlers
{
	/**
	 */
	private String errorMessage;

	/**
	 */
	private String name;
	
	/**
	 */
	private boolean hasError;

	/**
	 */
	private boolean hasFocus;
	
	/**
	 */
	private boolean isRequired;
	
	/**
	 */
	private boolean isValidateOnBlur = true;
	
	
	
	/**
	 * Hidden Constructor 
	 * @param appearance FormElementAppearance
	 */
	protected AbstractFormElement (FormElementAppearance appearance)
	{
		super(appearance);
		
		this.bindAbstractFormElement();
	}
	
	
	/**
	 * 
	 * @param handler BlurHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addBlurHandler (BlurHandler handler)
	{
		return this.addHandler(handler, BlurEvent.getType());
	}
	
	
	/**
	 * 
	 * @return JSONValue
	 */
	public JSONValue asJsonValue ()
	{
		return JsonUtils.asJSONValue(this.getValue());
	}
	
	
	/**
	 * 
	 */
	public void clearState ()
	{
		this.errorMessage = null;
		this.hasError = false;
		
		this.setState(FormElement.State.NORMAL, null);
	}
	
	
	/**
	 * 
	 * @return FormElementAppearance
	 */
	public FormElementAppearance getAppearance ()
	{
		return (FormElementAppearance) super.getAppearance();
	}

	
	/**
	 * 
	 * @return String
	 */
	public String getErrorMessage ()
	{
		return this.errorMessage;
	}
	
	
	/**
	 * 
	 * @return List<FormElement<?>>
	 */
	public List<FormElement<?>> getFormElements ()
	{
		List<FormElement<?>> list = new ArrayList<FormElement<?>>();
		
		list.add(this);
		
		return list;
	}
	
	
	/**
	 * 
	 * @return String
	 */
	public String getLabel ()
	{
		return this.getAppearance().getLabel();
	}


	/**
	 * 
	 * @return String 
	 */
	public String getName ()
	{
		if (this.name == null)
		{
			return this.getId();
		}
		
		return this.name;
	}
	
	
	/**
	 * 
	 * @return T
	 */
	public abstract T getValue ();

	
	/**
	 * 
	 * @return boolean
	 */
	public boolean hasError ()
	{
		return this.hasError;
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean hasFocus ()
	{
		return this.hasFocus;
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean hasValue ()
	{
		return this.getValue() != null;
	}
	
	
	/**
	 * 
	 * @return boolean 
	 */
	public boolean isRequired ()
	{
		return this.isRequired;
	}
	
	
	/**
	 * 
	 * @return boolean 
	 */
	public boolean isValidateOnBlur ()
	{
		return this.isValidateOnBlur;
	}
	
	
	/**
	 * 
	 */
	public void removeLabel ()
	{
		this.getAppearance().removeLabel();		
	}
	

	/**
	 * 
	 * @param label String
	 */
	public void setLabel (String label)
	{
		this.getAppearance().setLabel(label);		
	}
	
	/**
	 * 
	 * @param size FormElementSize
	 */
	public void setSize (FormElementSize size)
	{
		this.getAppearance().setSize(size);		
	}
	
	/**
	 */
	public void markInvalid ()
	{
		this.setState(FormElement.State.INVALID);
	}
	
	
	/**
	 * 
	 * @param message String
	 */
	public void markInvalid (String message)
	{
		this.hasError = true;
		this.setState(FormElement.State.INVALID, message);
	}
	
	
	/**
	 */
	public void markSuccess ()
	{
		this.setState(FormElement.State.SUCCESS);
	}
	
	
	/**
	 * 
	 * @param message String
	 */
	public void markSuccess (String message)
	{
		this.setState(FormElement.State.SUCCESS, message);
	}
	
	
	/**
	 */
	public void markWarning ()
	{
		this.setState(FormElement.State.WARNING);
	}
	
	
	/**
	 * 
	 * @param message String
	 */
	public void markWarning (String message)
	{
		this.setState(FormElement.State.WARNING, message);
	}
	
	
	/**
	 *  
	 * @param message String
	 */
	public void setErrorMessage (String message)
	{
		this.errorMessage = message;		
	}
	
	
	/**
	 * 
	 * @param position Position
	 */
	public void setMessagePosition (Position position)
	{
		this.getAppearance().setMessagePosition(position);
	}


	/**
	 * 
	 * @param name String
	 */
	public void setName (String name)
	{
		this.name = name;
	}
	
	
	/**
	 * 
	 * @param isRequired boolean
	 */
	public void setRequired (boolean isRequired)
	{
		this.isRequired = isRequired;
		
		this.getAppearance().setRequired(isRequired);
	}
	
	
	/**
	 * 
	 * @param state FormElement.State
	 */
	public void setState (FormElement.State state)
	{
		this.getAppearance().setState(state);
	}
	
	
	/**
	 * 
	 * @param state FormElement.State
	 * @param message String
	 */
	public void setState (FormElement.State state, String message)
	{
		this.getAppearance().setState(state, message);
	}
	
	
	/**
	 * 
	 * @param b boolean
	 */
	public void setValidateOnBlur (boolean b)
	{
		this.isValidateOnBlur = b;
		
	}
	
	
	
	/**
	 * 
	 * @param mark boolean
	 * @return boolean
	 */
	public boolean validate (boolean mark)
	{
		boolean isValid = this.validate();
		
		if (!isValid && mark)
		{
			this.markInvalid(this.getErrorMessage());
		}
		
		if (isValid)
		{
			this.clearState();
		}
		
		return isValid;
	}
	
	
	/**
	 * 
	 * @param nativeEvent NativeEvent
	 */
	protected void _onBlur (NativeEvent nativeEvent)
	{
		this.hasFocus = false;
		
		DomEvent.fireNativeEvent(nativeEvent, this);
		
		this.onBlur();
	}
	
	
	/**
	 * 
	 * @param nativeEvent NativeEvent
	 */
	protected void _onFocus (NativeEvent nativeEvent)
	{
		this.hasFocus = true;
	}
		


	/**
	 * 
	 */
	protected void bindAbstractFormElement ()
	{
		this.addBlurHandler(new BlurHandler()
		{
			public void onBlur (BlurEvent event)
			{
				if (AbstractFormElement.this.isValidateOnBlur())
				{
					AbstractFormElement.this.validate(true);
				}
			}
		});
		
	}
	
	
	/**
	 * 
	 */
	protected void onBlur ()
	{
		
	}


	/**
	 * 
	 * @return boolean
	 */
	protected boolean validate ()
	{
		boolean isValid = true;
		
		T value = this.getValue();
		
		if (this.isRequired() 
		&& ((value == null) || (value instanceof String && ((String) value).isEmpty())))
		{
			isValid = false;
			
			if (this.getLabel() == null)
			{
				this.setErrorMessage("This field is required.");
			}
			else
			{
				this.setErrorMessage("Field '" + this.getLabel() + "' is required."); 
			}
		}
		
		return isValid;
	}
	
}
