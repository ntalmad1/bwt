package com.talmadge.bwt.core.client.ui.widget.form;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.FormElement;
import com.talmadge.bwt.core.client.ui.Form.SubmitMethod;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 *
 */
public class DefaultFormContainerAppearance extends DefaultBwtWidgetContainerAppearance implements FormContainerAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultFormContainerAppearance ()
	{
		super(Document.get().createFormElement());
	}
	
	
	/**
	 * 
	 * @return FormElement
	 */
	public FormElement getElement ()
	{
		return (FormElement) super.getElement();
	}
	
	
	/**
	 * 
	 * @param method SubmitMethod
	 */
	@Override
	public void setSubmitMethod (SubmitMethod method)
	{
		switch (method)
		{
			case GET:
				this.getElement().setAttribute("method", "get");
				break;
			case POST:
				this.getElement().setAttribute("method", "post");
				break;
			case EVENT_ONLY:
			default:
				this.getElement().setAttribute("method", "javascript:");
				break;
		}
	}


	/**
	 * 
	 */
	@Override
	protected void build ()
	{
		this.setSubmitMethod(SubmitMethod.EVENT_ONLY);
	}
}
