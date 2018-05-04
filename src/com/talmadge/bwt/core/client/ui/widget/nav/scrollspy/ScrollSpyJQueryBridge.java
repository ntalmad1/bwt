package com.talmadge.bwt.core.client.ui.widget.nav.scrollspy; 


/**
 * 
 * @author Noah
 *
 */
class ScrollSpyJQueryBridge
{
	/**
	 */
	private ScrollSpy scrollSpy;
		
	
	
	/**
	 * Constructor 
	 * 
	 * @param scrollSpy ScrollSpy
	 */
	ScrollSpyJQueryBridge (ScrollSpy scrollSpy)
	{
		this.scrollSpy = scrollSpy;
	}
	
	
	/**
	 * 
	 */
	protected void attach ()
	{
		this.exportJQuery(this.scrollSpy.getTarget().getId(), this.scrollSpy.getNav().getId());
	}

	
	/**
	 * 
	 */
	protected void detach ()
	{
		
	}
	
	
	/**
	 *
	 */
	protected void bindNavItems ()
	{
	   this._bindNavItems(this.scrollSpy.getTarget().getId()); 
	}
	
	
	/**
	 * 
	 */
	protected void refresh ()
	{
	    this._refresh();
	}
	
	
	/**
	 * 
	 * @param targetId String
	 * @param navId String
	 */
	private native void exportJQuery (String targetId, String navId) /*-{
		$wnd.$('#' + targetId).scrollspy({ target: '#' + navId });
	}-*/;

	
	/**
	 * 
	 * @param targetId String
	 */
    private native void _bindNavItems (String targetId)
    /*-{
        
        $wnd.$('.scrollclass').click(function(){
            $wnd.$('#' + targetId).scrollTo($wnd.$(this).data('target'),{duration: 0,offset: 0});
        });
        
    }-*/;


    /**
     * 
     */
    private native void _refresh () /*-{
        
        $wnd.$('[data-spy="scroll"]').each(function () {
              $wnd.$(this).scrollspy('refresh')
        });
  
        
    }-*/;
    
    
	
	
}
