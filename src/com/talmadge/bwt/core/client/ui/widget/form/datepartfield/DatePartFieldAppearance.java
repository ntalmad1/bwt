package com.talmadge.bwt.core.client.ui.widget.form.datepartfield;

import com.talmadge.bwt.core.client.ui.widget.form.element.FormElementAppearance;
import com.talmadge.bwt.core.client.ui.widget.form.option.Item;
import com.talmadge.bwt.core.client.ui.widget.form.simpleselect.SimpleSelect;

/**
 * 
 * @author Noah
 *
 */
public interface DatePartFieldAppearance extends FormElementAppearance
{
	/**
	 * 
	 * @param daySelect SimpleSelect<String> 
	 * @param monthSelect SimpleSelect<Option<String>> 
	 * @param yearSelect SimpleSelect<String> 
	 */
	void init (SimpleSelect<String> daySelect, SimpleSelect<Item<String>> monthSelect, SimpleSelect<String> yearSelect);

}
