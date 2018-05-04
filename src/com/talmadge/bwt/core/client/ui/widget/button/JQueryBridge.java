package com.talmadge.bwt.core.client.ui.widget.button;



/**
 * 
 * @author Noah
 *
 */
class JQueryBridge
{
	/**
	 */
//	private Button button;
//
//	/**
//	 */
//	private JavaScriptObject jqClickHandler;
//	
//	
//	/**
//	 * Constructor 
//	 *
//	 * @param button
//	 */
//	public JQueryEventBridge (Button button)
//	{
//		this.button = button;
//		
//		this.jqClickHandler = this.exportJQueryClickHandler(button);
//	}
//	
//	
//	/**
//	 * 
//	 */
//	public void attach ()
//	{
//		this.attachJQueryClickHandler(this.button.getId(), this.jqClickHandler);
//	}
//
//	
//	/**
//	 * 
//	 */
//	public void detach ()
//	{
//		this.detachJQueryClickHandler(this.button.getId(), this.jqClickHandler);
//	}
//
//	
//	/**
//	 * 
//	 * @param button Button
//	 * @return JavaScriptObject jQueryClickHandler
//	 */
//	private native JavaScriptObject exportJQueryClickHandler (Button button) /*-{
//		return function() {
//			button.@com.talmadge.bwt.core.client.ui.widget.button.Button::_click()();
//		};
//	}-*/;
//	
//	
//	/**
//	 * 
//	 * @param id String
//	 * @param jQueryClickHandler
//	 */
//	private native void attachJQueryClickHandler (String id, JavaScriptObject jQueryClickHandler) /*-{
//
//		$wnd.$("#" + id).bind("click", jQueryClickHandler);
//
//	}-*/;
//
//	
//	/**
//	 * 
//	 * @param id String
//	 * @param jQueryClickHandler
//	 */
//	private native void detachJQueryClickHandler (String id, JavaScriptObject jQueryClickHandler) /*-{
//
//		$wnd.$("#" + id).unbind("click", jQueryClickHandler);
//
//	}-*/;
}
