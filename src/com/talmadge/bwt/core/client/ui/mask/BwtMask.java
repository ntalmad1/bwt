package com.talmadge.bwt.core.client.ui.mask;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.talmadge.bwt.core.client.ui.resources.BwtResources;
import com.talmadge.bwt.core.client.ui.widget.image.BwtImage;

/**
 * 
 */
public class BwtMask
{
	/**
	 */
	private String message;


	/**
	 */
	private Element target;
	
	
	/**
	 * Constructor
	 * 
	 * @param target Element
	 */
	public BwtMask (Element target)
	{
		this.target = target;
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param target Element
	 * @param message String
	 */
	public BwtMask (Element target, String message)
	{
		this(target);
		this.message = message;
	}
	
	
	public Element getElement ()
	{
		return this.target;
	}
	
	
	/**
	 * 
	 */
	public void mask ()
	{
		this.mask(this.message);
	}


	/**
	 * 
	 */
	public void mask (String message)
	{
		this.message = message;
		
		BwtImage ajaxLoader = new BwtImage(BwtResources.INSTANCE.ajaxLoader());
		
		String content = "<div style=\"margin-bottom: 10px;\">" + ajaxLoader.toString() + "</div>" 
				+ (this.message != null ? this.message : "");
		
		DivElement overlay = null;
		overlay = this._mask(this.getElement().getId(), content);
		
		
		overlay.getStyle().setProperty("borderTopLeftRadius",     this._getCornerRadiusTopLeft(this.getElement().getId()));
		overlay.getStyle().setProperty("borderTopRightRadius",    this._getCornerRadiusTopRight(this.getElement().getId()));
		overlay.getStyle().setProperty("borderBottomRightRadius", this._getCornerRadiusBottomRight(this.getElement().getId()));
		overlay.getStyle().setProperty("borderBottomLeftRadius",  this._getCornerRadiusBottomLeft(this.getElement().getId()));
	}
	
	
	/**
	 * 
	 */
	public void unmask ()
	{
		this._unmask(this.getElement().getId());		
	}


	/**
	 * 
	 * @param id String
	 * @return String
	 */
	private native String _getCornerRadiusTopLeft (String id) /*-{
		
		return $wnd.$("#" + id).css("border-top-left-radius");
		
	}-*/;


	/**
	 * 
	 * @param id String
	 * @return String
	 */
	private native String _getCornerRadiusTopRight (String id) /*-{
		
		return $wnd.$("#" + id).css("border-top-right-radius");
		
	}-*/;


	/**
	 * 
	 * @param id String
	 * @return String
	 */
	private native String _getCornerRadiusBottomRight (String id) /*-{
		
		return $wnd.$("#" + id).css("border-bottom-right-radius");
		
	}-*/;


	/**
	 * 
	 * @param id String
	 * @return String
	 */
	private native String _getCornerRadiusBottomLeft (String id) /*-{
		
		return $wnd.$("#" + id).css("border-bottom-left-radius");
		
	}-*/;


	/**
	 * 
	 * @param targetId String
	 * @return DivElement
	 */
	private native DivElement _mask (String targetId) /*-{
		
		$wnd.$("#" + targetId).loading();
		return $doc.getElementById(targetId + "_loading-overlay");
	
	}-*/;


	/**
	 * 
	 * @param targetId String
	 * @return DivElement
	 */
	private native DivElement _mask (String targetId, String message) /*-{
		
		$wnd.$("#" + targetId).loading({"message": message});
		return $doc.getElementById(targetId + "_loading-overlay");
	
	}-*/;


	/**
	 * 
	 * @param targetId String
	 */
	private native DivElement _unmask (String targetId) /*-{
		
		$wnd.$("#" + targetId).loading('destroy');
	}-*/;
}
