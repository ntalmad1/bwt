package com.talmadge.bwt.core.client.ui.widget.form;

import java.util.List;

import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;
import com.talmadge.bwt.core.client.ui.widget.form.element.FormElement;

/**
 * 
 */
public interface BwtFormAppearance extends BwtWidgetContainerAppearance
{
	/**
	 * 
	 */
	void clearFields ();


	/**
	 * @return List<FormElement<?>>
	 */
	List<FormElement<?>> getFormElements ();
	
	/**
	 * @return List<BwtFormPart>
	 */
	List<BwtFormPart> getFormParts ();


	/**
	 * 
	 */
	void focus ();

	
	/**
	 * 
	 * @param formPart FormParts
	 */
	void registerFormPart (BwtFormPart formPart);

	/**
	 * 
	 * @param widget
	 */
	void registerFormParts (BwtWidgetContainer container);
}
