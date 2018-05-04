package com.talmadge.bwt.core.client.ui.widget.container.dialog;

/**
 * 
 *
 */
class JQueryBridge
{
	/**
	 */
	private BwtDialog dialog;
	
	
	/**
	 * Constructor
	 * 
	 * @param dialog BwtDialog
	 */
	public JQueryBridge (BwtDialog dialog)
	{
		this.dialog = dialog;
	}

	
	
	/**
	 * 
	 */
	public void attach ()
	{
		this._attachHideHandler(this.dialog.getId(), this.dialog);
		this._attachAfterHideHandler(this.dialog.getId(), this.dialog);
		
		this._attachShowHandler(this.dialog.getId(), this.dialog);
		this._attachAfterShowHandler(this.dialog.getId(), this.dialog);
	}


	/**
	 * 
	 */
	public void hide ()
	{
		this._hide(this.dialog.getId());		
	}
	
	
	/**
	 * 
	 */
	public void show ()
	{
		this._show(this.dialog.getId());		
	}
	
	
	private native void _attachHideHandler (String id, BwtDialog dialog) /*-{
		
		$wnd.$('#' + id).on('hide.bs.modal', function(e){
			dialog.@com.talmadge.bwt.core.client.ui.widget.container.dialog.BwtDialog::_hide()();
		});
		
	}-*/;
	
	
	private native void _attachAfterHideHandler (String id, BwtDialog dialog) /*-{
	
	$wnd.$('#' + id).on('hidden.bs.modal', function(e){
		dialog.@com.talmadge.bwt.core.client.ui.widget.container.dialog.BwtDialog::_afterHide()();
	});
	
}-*/;
	
	
	private native void _attachShowHandler (String id, BwtDialog dialog) /*-{
	
		$wnd.$('#' + id).on('show.bs.modal', function(e){
			dialog.@com.talmadge.bwt.core.client.ui.widget.container.dialog.BwtDialog::_show()();
		});
	
	}-*/;
	
	
	private native void _attachAfterShowHandler (String id, BwtDialog dialog) /*-{
	
		$wnd.$('#' + id).on('shown.bs.modal', function(e){
			dialog.@com.talmadge.bwt.core.client.ui.widget.container.dialog.BwtDialog::_afterShow()();
		});

	}-*/;



	/**
	 * 
	 * @param id String
	 */
	private native void _hide (String id) /*-{
		
		$wnd.$('#' + id).modal('hide');
		
	}-*/;
	
	
	/**
	 * 
	 * @param id String
	 */
	private native void _show (String id) /*-{
		
		$wnd.$('#' + id).modal('show');
		
	}-*/;
}
