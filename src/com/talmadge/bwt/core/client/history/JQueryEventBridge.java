package com.talmadge.bwt.core.client.history;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * 
 *
 */
public class JQueryEventBridge
{
    /**
     */
  private BwtHistory history;

  /**
   */
  private JavaScriptObject jqStateHandler;
  
  
  /**
   * Constructor 
   *
   * @param history BwtHistory
   */
  public JQueryEventBridge (BwtHistory history)
  {
      this.history = history;
      
      this.jqStateHandler = this.exportJQueryCallback(history);
  }
  
  
  /**
   * 
   */
  public void attach ()
  {
      this.exportStateHandlers(this.jqStateHandler);
  }

  
  
  /**
   * 
   * @param history BwtHistory
   * @return JavaScriptObject jQueryClickHandler
   */
  private native JavaScriptObject exportJQueryCallback (BwtHistory history) /*-{
      return function(prevUrl, url) {
          history.@com.talmadge.bwt.core.client.history.BwtHistory::onStateChange(*)(prevUrl, url);
      };
  }-*/;
  
  
  /**
   * 
   * @param jqStateHandler JavaScriptObject
   */
  private native void exportStateHandlers (JavaScriptObject jqStateHandler) /*-{
      
      var bwtHistory = {};
      bwtHistory.lastUrl = $wnd.location.href;
  
      // handle pushState
      (function(history){
            var pushState = history.pushState;
            history.pushState = function(state, title, url) {
                
                var currentUrl = $wnd.location.href;
                
                if (currentUrl != url)
                {                
                    if (typeof history.onpushstate == "function") 
                    {
                        history.onpushstate({"state": state});
                    }
                    
                    // custom handling
                    if (state.fireEvent)
                    {
                        jqStateHandler(currentUrl, url);
                    }
                    
                    bwtHistory.lastUrl = url;
                    
                    return pushState.apply(history, arguments);
                }
                else
                {
                    return false;
                }
            }
      })($wnd.history);
      
      // handle popState
      $wnd.onpopstate = function(event){
          
          var currentUrl = $wnd.location.href;
          
          if (currentUrl != bwtHistory.lastUrl)
          {
              jqStateHandler(bwtHistory.lastUrl, currentUrl);
              bwtHistory.lastUrl = currentUrl;
          }
      };

  }-*/;
  
}
