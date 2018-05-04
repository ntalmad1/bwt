package com.talmadge.bwt.core.client.ui.widget.button.dropdown;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * show.bs.dropdown 	This event fires immediately when the show instance method is called.
 * 
 * shown.bs.dropdown 	This event is fired when the dropdown has been made visible to the user (will wait for CSS transitions, to complete).
 * 
 * hide.bs.dropdown 	This event is fired immediately when the hide instance method has been called.
 * 
 * hidden.bs.dropdown 	This event is fired when the dropdown has finished being hidden from the user (will wait for CSS transitions, to complete).
 * 
 * @author Noah
 *
 */
public class DropdownJQueryBridge
{
	/**
	 */
	private DropdownButtonCell dropdownButton;

	/**
	 */
	private JavaScriptObject jqShowHandler;

	/**
	 */
	private JavaScriptObject jqShownHandler;

	/**
	 */
	private JavaScriptObject jqHideHandler;
	
	/**
	 */
	private JavaScriptObject jqHiddenHandler;

	
	
	/**
	 * Constructor
	 *
	 * @param dropdownButton DropdownButtonCell
	 */
	public DropdownJQueryBridge (DropdownButtonCell dropdownButton)
	{
		this.dropdownButton = dropdownButton;

		this.jqShowHandler = this.exportJQueryShowHandler(dropdownButton);
		this.jqShownHandler = this.exportJQueryShownHandler(dropdownButton);
		this.jqHideHandler = this.exportJQueryHideHandler(dropdownButton);
		this.jqHiddenHandler = this.exportJQueryHiddenHandler(dropdownButton);
	}


	/**
		 * 
		 */
	public void attach ()
	{
		this.attachJQueryShowHandler(this.dropdownButton.getId(), this.jqShowHandler);
		this.attachJQueryShownHandler(this.dropdownButton.getId(), this.jqShownHandler);
		this.attachJQueryHideHandler(this.dropdownButton.getId(), this.jqHideHandler);
		this.attachJQueryHiddenHandler(this.dropdownButton.getId(), this.jqHiddenHandler);
	}


	/**
	 * 
	 */
	public void detach ()
	{
		this.detachJQueryShowHandler(this.dropdownButton.getId(), this.jqShowHandler);
		this.detachJQueryShownHandler(this.dropdownButton.getId(), this.jqShownHandler);
		this.detachJQueryHideHandler(this.dropdownButton.getId(),	this.jqHideHandler);
		this.detachJQueryHiddenHandler(this.dropdownButton.getId(), this.jqHiddenHandler);
	}


	/**
	 *
	 * @param id String
	 * @param jqHideHandler JavaScriptObject
	 */
	private native void attachJQueryHideHandler (String id, JavaScriptObject  jqHideHandler) /*-{
	 	$wnd.$("#" + id).on("hide.bs.dropdown", jqHideHandler);
	}-*/;


	/**
	 *
	 * @param id String
	 * @param jqHiddenHandler JavaScriptObject
	 */
	private native void attachJQueryHiddenHandler (String id, JavaScriptObject jqHiddenHandler) /*-{
	 	$wnd.$("#" + id).on("hidden.bs.dropdown", jqHiddenHandler);
	}-*/;


	/**
	 * 
	 * @param id String
	 * @param jqShowHandler JavaScriptObject
	 */
	private native void attachJQueryShowHandler (String id, JavaScriptObject jqShowHandler) /*-{
		$wnd.$("#" + id).on("show.bs.dropdown", jqShowHandler);
	}-*/;


	/**
	 * 
	 * @param id String
	 * @param jqShownHandler JavaScriptObject
	 */
	private native void attachJQueryShownHandler (String id, JavaScriptObject jqShownHandler) /*-{
		$wnd.$("#" + id).on("shown.bs.dropdown", jqShownHandler);
	}-*/;


	/**
	 *
	 * @param dropdownButton DropdownButtonCell
	 * @return JavaScriptObject jqShowHandler
	 */
	private native JavaScriptObject exportJQueryHideHandler (DropdownButtonCell dropdownButton) /*-{
		return function (e) 
		{
		 	var targetId = e.target.id;
	 	
	 		dropdownButton.@com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButtonCell::_beforeMenuHide(Ljava/lang/String;)(targetId);
	 	};
	}-*/;


	/**
	 *
	 * @param dropdownButton DropdownButtonCell
	 * @return JavaScriptObject jqShowHandler
	 */
	private native JavaScriptObject exportJQueryHiddenHandler (DropdownButtonCell dropdownButton) /*-{
		return function (e) 
	 	{
	 		var targetId = e.target.id;
	 	
	 		dropdownButton.@com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButtonCell::_menuHide(Ljava/lang/String;)(targetId);
	 	};
	}-*/;


	/**
	 * 
	 * @param dropdownButton DropdownButtonCell
	 * @return JavaScriptObject jqShowHandler
	 */
	private native JavaScriptObject exportJQueryShowHandler (DropdownButtonCell dropdownButton) /*-{
		return function(e) 
		{
			var relatedTargetId = e.relatedTarget.id;
			var targetId = e.target.id;
			
			dropdownButton.@com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButtonCell::_beforeMenuShow(Ljava/lang/String;)(targetId);
		};
	}-*/;


	/**
	 * 
	 * @param dropdownButton DropdownButtonCell
	 * @return JavaScriptObject jqShowHandler
	 */
	private native JavaScriptObject exportJQueryShownHandler (DropdownButtonCell dropdownButton) /*-{
		return function(e) 
		{
			var targetId = e.target.id;
	
			dropdownButton.@com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButtonCell::_menuShow(Ljava/lang/String;)(targetId);
		};
	}-*/;


	/**
	 * 
	 * @param id String
	 * @param jqHideHandler JavaScriptObject
	 */
	private native void detachJQueryHideHandler (String id, JavaScriptObject jqHideHandler) /*-{
		$wnd.$("#" + id).off("show.bs.dropdown", jqHideHandler);
	}-*/;


	/**
	 * 
	 * @param id String
	 * @param jqHiddenHandler JavaScriptObject
	 */
	private native void detachJQueryHiddenHandler (String id, JavaScriptObject jqHiddenHandler) /*-{
		$wnd.$("#" + id).off("shown.bs.dropdown", jqHiddenHandler);
	}-*/;


	/**
	 * 
	 * @param id String
	 * @param jqShowHandler JavaScriptObject
	 */
	private native void detachJQueryShowHandler (String id, JavaScriptObject jqShowHandler) /*-{
		$wnd.$("#" + id).off("show.bs.dropdown", jqShowHandler);
	}-*/;


	/**
	 * 
	 * @param id String
	 * @param jqShownHandler JavaScriptObject
	 */
	private native void detachJQueryShownHandler (String id, JavaScriptObject jqShownHandler) /*-{
		$wnd.$("#" + id).off("shown.bs.dropdown", jqShownHandler);
	}-*/;
}
