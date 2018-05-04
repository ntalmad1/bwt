package com.talmadge.bwt.core.client.ui.widget.form.datetimepicker;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.form.constant.AddonPos;
import com.talmadge.bwt.core.client.ui.widget.form.valuefield.text.TextField;

/**
 * 
 * @author Noah
 *
 */
public class DateTimePicker extends TextField
{
	/**
	 * Constructor
	 * 
	 * @param appearance DateTimePickerAppearance
	 */
	protected DateTimePicker (DateTimePickerAppearance appearance)
	{
		super(appearance);
		
		this.setAddon(Glyphicon.CALENDAR, AddonPos.RIGHT);
		this.getAppearance().setInputGroupId(this.getId() + "-picker");
	}
	
	
	/**
	 * Constructor
	 * 
	 */
	public DateTimePicker ()
	{
		this((DateTimePickerAppearance) GWT.create(DefaultDateTimePickerAppearance.class));
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param label String
	 */
	public DateTimePicker (String label)
	{
		this();
		
		this.setLabel(label);
	}
	
	
	/**
	 * 
	 */
	protected void onInitialAttach ()
	{
		JSONObject options = new JSONObject();
		
		options.put("format", new JSONString("MM/DD/YYYY"));
		// options.put("pickTime", JSONBoolean.getInstance(false));
		
		this._initPicker(this.getAppearance().getInputGroupId(), options.getJavaScriptObject());
	}


	/**
	 * 
	 * @param id String
	 * @param options JavaScriptObject
	 */
	protected native void _initPicker (String id, JavaScriptObject options) /*-{
	
		$wnd.$("#" + id).datetimepicker(options);
		
	}-*/;
}
