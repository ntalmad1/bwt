package com.talmadge.bwt.core.client.ui.widget.form;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;
import com.talmadge.bwt.core.client.ui.widget.form.element.FormElement;

/**
 * 
 * @author Noah
 * 	
 */
public class DefaultBwtFormAppearance extends DefaultBwtWidgetContainerAppearance implements BwtFormAppearance
{
	/**
	 */
	private List<BwtFormPart> formParts = new ArrayList<BwtFormPart>();
	
	/**
	 */
	private FormElement<?> focusFormElement;
	
	
	
	/**
	 * Constructor
	 *  
	 */
	public DefaultBwtFormAppearance ()
	{
		this(DOM.createDiv());

	}
	
	
	/**
	 * Hidden Constructor
	 * 
	 * @param element Element
	 */
	protected DefaultBwtFormAppearance (Element element)
	{
		super(element);
	}


	/**
	 * 
	 */
	public void clearFields ()
	{
		for (FormElement<?> element : this.getFormElements())
		{
			element.clear();
		}
	}

	
	/**
	 * 
	 */
	public FormElement<?> getFocusFormElement ()
	{
		if (this.focusFormElement != null)
		{
			return this.focusFormElement;
		}
		
		
		List<FormElement<?>> formElements = this.getFormElements();
		
		if (!formElements.isEmpty())
		{
			return formElements.get(0);
		}
		
		return null;
	}


	/**
	 * 
	 * @return List<FormElement<?>> 
	 */
	public List<FormElement<?>> getFormElements ()
	{
		List<FormElement<?>> formElements = new ArrayList<FormElement<?>>();
		
		for (BwtFormPart formPart : this.formParts)
		{	
			formElements.addAll(formPart.getFormElements());
		}
		
		return formElements;
	}
	
	
	/**
	 * 
	 * @return List<BwtFormPart>
	 */
	@Override
	public List<BwtFormPart> getFormParts ()
	{
		return this.formParts;
	}


	/**
	 * 
	 */
	public void focus ()
	{
		FormElement<?> focusFromElement = this.getFocusFormElement();
		if (focusFromElement != null)
		{
			this.getFocusFormElement().focus();
		}
	}


	/**
	 * 
	 * @param part BwtFormPart
	 */
	public void registerFormPart (BwtFormPart part)
	{
		this.formParts.add(part);
	}

	
	/**
	 * 
	 * @return container BwtWidgetContainer
	 */
	@Override
	public void registerFormParts (BwtWidgetContainer container)
	{
		WidgetCollection children = container.getChildren();
		
		for (int i = 0; i < children.size(); ++i)
		{
			Widget child = children.get(i);
			
			if (child instanceof BwtFormPart)
			{
				this.registerFormPart((BwtFormPart) child);
			}
			else if (child instanceof BwtWidgetContainer)
			{
				this.registerFormParts((BwtWidgetContainer) child);
			}
			
		}
		
	}


	/**
	 * 
	 * @param focusFormElement FormElement<?> 
	 */
	public void setFocusFormElement (FormElement<?> focusFormElement)
	{
		this.focusFormElement = focusFormElement;
	}
	
	
	/**
	 * 
	 */
	@Override
	protected void build ()
	{
		
		
	}
}
