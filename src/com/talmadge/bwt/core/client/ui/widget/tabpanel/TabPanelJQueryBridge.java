package com.talmadge.bwt.core.client.ui.widget.tabpanel;

import com.google.gwt.core.client.JavaScriptObject;


/**
 * 
 * jQuery
 * 
 * BeforeShow
 * show.bs.tab	 This event fires on tab show, but before the new tab has been shown. Use event.target and event.relatedTarget to target the active tab and the previous active tab (if available) respectively.
 * 
 * Show
 * shown.bs.tab	 This event fires on tab show after a tab has been shown. Use event.target and event.relatedTarget to target the active tab and the previous active tab (if available) respectively.
 * 
 * BeforeHide
 * hide.bs.tab	 This event fires when a new tab is to be shown (and thus the previous active tab is to be hidden). Use event.target and event.relatedTarget to target the current active tab and the new soon-to-be-active tab, respectively.
 * 
 * Hide
 * hidden.bs.tab This event fires after a new tab is shown (and thus the previous active tab is hidden). Use event.target and event.relatedTarget to target the previous active tab and the new active tab, respectively.
 * 
 * e.target // newly activated tab
 * e.relatedTarget // previous active tab
 * 
 * @author Noah
 *
 */
class TabPanelJQueryBridge
{
	/**
	 */
	private TabPanel tabPanel;

	/**
	 */
	private JavaScriptObject jqShowHandler;
	
	/**
	 */
	private JavaScriptObject jqShownHandler;
	
//	/**
//	 */
//	private JavaScriptObject jqHideHandler;
//	
//	/**
//	 */
//	private JavaScriptObject jqHiddenHandler;
	
	
	/**
	 * Constructor 
	 *
	 * @param tabPanel TabPanel
	 */
	TabPanelJQueryBridge (TabPanel tabPanel)
	{
		this.tabPanel = tabPanel;
		
		
		this.jqShowHandler   = this.exportJQueryShowHandler(tabPanel);
		this.jqShownHandler  = this.exportJQueryShownHandler(tabPanel);
//		this.jqHideHandler   = this.exportJQueryHideHandler(tabPanel);
//		this.jqHiddenHandler = this.exportJQueryHiddenHandler(tabPanel);
	}
	
	
	/**
	 * 
	 */
	public void attach ()
	{
		this.attachJQueryShowHandler(this.tabPanel.getId(), this.jqShowHandler);
		this.attachJQueryShownHandler(this.tabPanel.getId(), this.jqShownHandler);
//		this.attachJQueryHideHandler(this.tabPanel.getId(), this.jqHideHandler);
//		this.attachJQueryHiddenHandler(this.tabPanel.getId(), this.jqHiddenHandler);
	}

	
	/**
	 * 
	 */
	public void detach ()
	{
		this.detachJQueryShowHandler(this.tabPanel.getId(), this.jqShowHandler);
		this.detachJQueryShownHandler(this.tabPanel.getId(), this.jqShownHandler);
//		this.detachJQueryHideHandler(this.tabPanel.getId(), this.jqHideHandler);
//		this.detachJQueryHiddenHandler(this.tabPanel.getId(), this.jqHiddenHandler);
	}

	
	/**
	 * 
	 * @param tabPanel TabPanel
	 * @return JavaScriptObject jqShowHandler
	 */
	private native JavaScriptObject exportJQueryShowHandler (TabPanel tabPanel) /*-{
		return function (e) {
			
			if (e.relatedTarget)
			{
				var relatedTargetId = e.relatedTarget.hash;
				relatedTargetId = relatedTargetId.replace('#', '');
				
				tabPanel.@com.talmadge.bwt.core.client.ui.widget.tabpanel.TabPanel::_beforeHide(Ljava/lang/String;)(relatedTargetId);
			}
			
			var targetId = e.target.hash;
			targetId = targetId.replace('#', '');
			
			tabPanel.@com.talmadge.bwt.core.client.ui.widget.tabpanel.TabPanel::_beforeShow(Ljava/lang/String;)(targetId); 
		};
	}-*/;
	
	
	/**
	 * 
	 * @param tabPanel TabPanel
	 * @return JavaScriptObject jqShowHandler
	 */
	private native JavaScriptObject exportJQueryShownHandler (TabPanel tabPanel) /*-{
		return function (e) {
			
			if (e.relatedTarget)
			{
				var relatedTargetId = e.relatedTarget.hash;
				relatedTargetId = relatedTargetId.replace('#', '');
				
				tabPanel.@com.talmadge.bwt.core.client.ui.widget.tabpanel.TabPanel::_hide(Ljava/lang/String;)(relatedTargetId);
			}
			
			var targetId = e.target.hash;
			targetId = targetId.replace('#', '');
			
			tabPanel.@com.talmadge.bwt.core.client.ui.widget.tabpanel.TabPanel::_show(Ljava/lang/String;)(targetId);
		};
	}-*/;
	
//	/**
//	 * 
//	 * @param tabPanel TabPanel
//	 * @return JavaScriptObject jqShowHandler
//	 */
//	private native JavaScriptObject exportJQueryHideHandler (TabPanel tabPanel) /*-{
//		return function (e) {
//			
//			var targetId = e.target.hash;
//			targetId = targetId.replace('#', '');
//			
//			tabPanel.@com.talmadge.bwt.core.client.ui.widget.tabpanel.TabPanel::_beforeHide(Ljava/lang/String;)(targetId);
//		};
//	}-*/;
//	
//	
//	/**
//	 * 
//	 * @param tabPanel TabPanel
//	 * @return JavaScriptObject jqShowHandler
//	 */
//	private native JavaScriptObject exportJQueryHiddenHandler (TabPanel tabPanel) /*-{
//		return function (e) {
//			
//			var targetId = e.target.hash;
//			targetId = targetId.replace('#', '');
//			
//			tabPanel.@com.talmadge.bwt.core.client.ui.widget.tabpanel.TabPanel::_hide(Ljava/lang/String;)(targetId);
//		};
//	}-*/;
	
	
	
	
	/**
	 * 
	 * @param id String
	 * @param jqShowHandler JavaScriptObject
	 */
	private native void attachJQueryShowHandler (String id, JavaScriptObject jqShowHandler) /*-{

		$wnd.$("#" + id).on("show.bs.tab", jqShowHandler);

	}-*/;
	
	
	/**
	 * 
	 * @param id String
	 * @param jqShownHandler JavaScriptObject
	 */
	private native void attachJQueryShownHandler (String id, JavaScriptObject jqShownHandler) /*-{

		$wnd.$("#" + id).on("shown.bs.tab", jqShownHandler);

	}-*/;
	
	
//	/**
//	 * 
//	 * @param id String
//	 * @param jqHideHandler JavaScriptObject
//	 */
//	private native void attachJQueryHideHandler (String id, JavaScriptObject jqHideHandler) /*-{
//
//		$wnd.$("#" + id).on("hide.bs.tab", jqHideHandler);
//
//	}-*/;
//	
//	
//	/**
//	 * 
//	 * @param id String
//	 * @param jqSHiddenHandler JavaScriptObject
//	 */
//	private native void attachJQueryHiddenHandler (String id, JavaScriptObject jqHiddenHandler) /*-{
//
//		$wnd.$("#" + id).on("hidden.bs.tab", jqHiddenHandler);
//
//	}-*/;

	
	
	/**
	 * 
	 * @param id String
	 * @param jqShowHandler JavaScriptObject
	 */
	private native void detachJQueryShowHandler (String id, JavaScriptObject jqShowHandler) /*-{

		$wnd.$("#" + id).off("show.bs.tab", jqShowHandler);

	}-*/;
	
	
	/**
	 * 
	 * @param id String
	 * @param jqShownHandler JavaScriptObject
	 */
	private native void detachJQueryShownHandler (String id, JavaScriptObject jqShownHandler) /*-{

		$wnd.$("#" + id).off("shown.bs.tab", jqShownHandler);

	}-*/;
	
	
//	/**
//	 * 
//	 * @param id String
//	 * @param jqHideHandler JavaScriptObject
//	 */
//	private native void detachJQueryHideHandler (String id, JavaScriptObject jqHideHandler) /*-{
//
//		$wnd.$("#" + id).off("hide.bs.tab", jqHideHandler);
//
//	}-*/;
//	
//	
//	/**
//	 * 
//	 * @param id String
//	 * @param jqHiddenHandler JavaScriptObject
//	 */
//	private native void detachJQueryHiddenHandler (String id, JavaScriptObject jqHiddenHandler) /*-{
//
//		$wnd.$("#" + id).off("hidden.bs.tab", jqHiddenHandler);
//
//	}-*/;
	
	
	
}
