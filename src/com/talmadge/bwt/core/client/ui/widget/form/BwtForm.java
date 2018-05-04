package com.talmadge.bwt.core.client.ui.widget.form;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.json.JsonUtils;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.form.element.FormElement;
import com.talmadge.bwt.core.client.ui.widget.form.fieldset.FieldSet;

/**
 * 
 *
 */
public class BwtForm extends BwtWidgetContainer implements BwtFormInterface
{
	/**
	 */
	public enum JsonOption {
		FLATTEN;
	}
	
	
	/**
	 */
	private List<String> errorMessages;
	
	/**
	 */
	private boolean validateOnBlur;
	
	/**
	 */
	private boolean collapseJson = false;

	

	/**
	 * Constuctor
	 * 
	 */
	public BwtForm ()
	{
		this(new DefaultBwtFormAppearance());
	}
	
	
	/**
	 * Hidden Constructor
	 * 
	 * @param appearance BwtFormAppearance
	 */
	protected BwtForm (BwtFormAppearance appearance)
	{
		super(appearance);
		
		this.bind();
	}
	
	
	/**
	 * 
	 * @param widget Widget
	 */
	public void add (Widget widget)
	{
		super.add(widget.asWidget());
		
		if (widget instanceof BwtFormPart)
		{
			this.getAppearance().registerFormPart((BwtFormPart) widget);
		}
		else if (widget instanceof BwtWidgetContainer)
		{
			this.getAppearance().registerFormParts((BwtWidgetContainer) widget);
		}
	}
	

	/**
	 * 
	 */
	public void clearFields ()
	{
		this.getAppearance().clearFields();		
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
	 * @return List<String>
	 */
	public List<String> getErrorMessages ()
	{
		return this.errorMessages;
	}
	
	
	/**
	 * 
	 * @return List<FormElement<?>>
	 */
	public List<FormElement<?>> getFormElements ()
	{
		return this.getAppearance().getFormElements();
	}
	
	
	/**
	 * 
	 * @return List<FormFormPart>
	 */
	public List<BwtFormPart> getFormParts ()
	{
		return this.getAppearance().getFormParts();
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean getValidateOnBlur ()
	{
		return this.validateOnBlur;
	}

	
	/**
	 * 
	 * @return JSONObject
	 */
	public JSONObject asJson ()
	{
		return this.asJson(new JsonOption[]{});
	}
	
	
	/**
	 * 
	 * @return JSONObject
	 */
	@SuppressWarnings("rawtypes")
	public JSONObject asJson (JsonOption... optionsArray)
	{
		ArrayList<JsonOption> options = new ArrayList<JsonOption>(Arrays.asList(optionsArray));
		
		List<BwtFormPart> formParts = this.getFormParts();
		
		JSONObject json = new JSONObject();
		
		for (BwtFormPart formPart : formParts)
		{
			if (formPart instanceof FormElement)
			{
				json.put(formPart.getName(), ((FormElement) formPart).asJsonValue());
			}
			else if (formPart instanceof FieldSet)
			{
				if (options.contains(JsonOption.FLATTEN))
				{
					JSONObject formPartJson = ((FieldSet) formPart).asJson(optionsArray);
					
					JsonUtils.combine(json, formPartJson);
				}
				else if (this.collapseJson)
				{
					JSONObject formPartJson = ((FieldSet) formPart).asJson();
					
					for (String key : formPartJson.keySet())
					{
						json.put(key, formPartJson.get(key));
					}
				}
				else
				{
					json.put(formPart.getName(), ((FieldSet) formPart).asJson(optionsArray));
				}
			}
		}
		
		return json;
	}
	
	
	/**
	 * 
	 * @return JSONObject
	 */
	public JSONObject toJson ()
	{
		return this.asJson();
	}

	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isValid ()
	{
		return this.validate(true);
	}
	
	
	/**
	 * 
	 * @param collapseJson boolean 
	 */
	public void setCollapseJson (boolean collapseJson)
	{
		this.collapseJson = collapseJson;
	}
	
	
	/**
	 * 
	 * @param validateOnBlur boolean
	 */ 
	public void setValidateOnBlur (boolean validateOnBlur)
	{
		this.validateOnBlur = validateOnBlur;
		
	}


	/**
	 * 
	 * @param mark boolean
	 * @return boolean
	 */
	public boolean validate (boolean mark)
	{
		List<FormElement<?>> formElements = this.getFormElements();
		
		boolean isValid = true;
		
		List<String> errorMessages = new ArrayList<String>();
		
		for (FormElement<?> formElement : formElements)
		{
			if (!formElement.validate(mark))
			{
				isValid = false;
				errorMessages.add(formElement.getErrorMessage());
			}
		}
		
		this.errorMessages = errorMessages;
		
		return isValid;
	}
	
	
	/**
	 * 
	 */
	protected void bind ()
	{
						
	}


	/**
	 * 
	 */
	protected BwtFormAppearance getAppearance ()
	{
		return (BwtFormAppearance) super.getAppearance();
	}
}
