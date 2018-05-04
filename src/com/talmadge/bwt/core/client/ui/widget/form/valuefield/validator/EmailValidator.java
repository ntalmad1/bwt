package com.talmadge.bwt.core.client.ui.widget.form.valuefield.validator;

/**
 * 
 *
 */
public class EmailValidator implements ValueValidator
{
	/**
	 * 
	 */
	@Override
	public String validate (String label, String value)
	{
		if (value != null && !value.isEmpty() && !value.matches("^[A-Za-z0-9._%+-]{1,64}@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,63}$"))
        {
            return "Field '" + label + "' is not a valid email format.";
        }

        return null;
	}

}
