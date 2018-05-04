package com.talmadge.bwt.core.client.ui.widget.form.element;

import com.google.gwt.dom.client.Style.HasCssName;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.widget.form.BwtFormPart;

/**
 * 
 * @author Noah
 *
 * @param <T>
 */
public interface FormElement<T> extends BwtFormPart
{
	/**
	 */
	enum State implements HasCssName
	{
		/**
		 */
		INVALID("has-error"),
		
		/**
		 */
		NORMAL(""),
		
		/**
		 */
		SUCCESS("has-success"),
		
		/**
		 */
		WARNING("has-warning");
		
		
		/**
		 */
		private String css;
		
		
		/**
		 * Hidden Constructor
		 *  
		 * @param css String
		 */
		State (String css)
		{
			this.css = css;
		}

		/**
		 * 
		 * @return String
		 */
		public String getCssName ()
		{
			return this.css;
		}
	}
	
	
	/**
	 * @return JSONValue
	 */
	JSONValue asJsonValue ();

	
	/**
	 * 
	 * @return Widget
	 */
	Widget asWidget ();


	/**
	 */
	void clear ();

	/**
	 * @return String
	 */
	String getErrorMessage ();


	/**
	 * @return String
	 */
	String getName ();

	/**
	 */
	void focus ();


	/**
	 * 
	 * @return boolean 
	 */
	boolean hasError ();
	
	
	/**
	 * 
	 * @return boolean
	 */
	boolean hasValue ();
	
	
	/**
	 * @param isRequired boolean
	 */
	void setRequired (boolean isRequired);
	
	
	/**
	 * @param mark boolean
	 * @return boolean
	 */
	boolean validate (boolean mark);
}
