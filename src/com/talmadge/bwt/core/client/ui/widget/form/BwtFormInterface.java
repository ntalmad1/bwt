package com.talmadge.bwt.core.client.ui.widget.form;

import java.util.List;

import com.google.gwt.json.client.JSONObject;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerInterface;

/**
 *
 */
public interface BwtFormInterface extends BwtWidgetContainerInterface
{
	/**
	 */
	public void clearFields ();
	
	/**
	 */
	void focus ();

	/**
	 * @return List<String>
	 */
	List<String> getErrorMessages ();
	
	/**
	 * @return JSONObject
	 */
	JSONObject asJson ();
	
	/**
	 * @return boolean
	 */
	boolean isValid ();
	
	/**
	 * @param b boolean
	 */ 
	void setValidateOnBlur (boolean b);

	/**
	 * @param mark boolean
	 * @return boolean
	 */
	boolean validate (boolean mark);
}
