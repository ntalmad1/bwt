package com.talmadge.bwt.core.client.ui.widget.table.footer.column;

///**
// * 
// *
// */
//public class FooterColumnOLD<T extends JavaScriptObject> extends Html
//{
//	/** 
//	 */
//	private FooterColumnCell<T> cell;
//	
//	
//	
//	/**
//	 * Constructor
//	 * 
//	 */
//	public FooterColumnOLD ()
//	{
//		super();
//		this.cell = this.createCell();
//		this.initWidget(this.cell);
//	}
//	
//	
//	/**
//	 * Constructor 
//	 * 
//	 * @param html String
//	 */
//	public FooterColumnOLD (String html)
//	{
//		this();
//		this.setInnerHtml(html);
//	}
//
//	/**
//	 * 
//	 * @param event FooterCallbackEvent
//	 */
//	public void onFooterCallback (FooterCallbackEvent event)
//	{
//		this.getCell().onFooterCallback(event);		
//	}
//	
//	
//	/**
//	 * 
//	 * @return FooterColumnCell<T>
//	 */
//	protected FooterColumnCell<T> createCell ()
//	{
//		return new FooterColumnCell<T>();
//	}
//
//	
//	/**
//	 * 
//	 * @return FooterColumnCell<T>
//	 */
//	protected FooterColumnCell<T> getCell ()
//	{
//		return this.cell;
//	}
//}
