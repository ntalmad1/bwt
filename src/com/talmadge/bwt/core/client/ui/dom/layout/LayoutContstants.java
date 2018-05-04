package com.talmadge.bwt.core.client.ui.dom.layout;

import com.google.gwt.dom.client.Style.HasCssName;
import com.talmadge.bwt.core.client.ui.dom.style.CssName;

/**
 * 
 * @author Noah
 *
 */
public interface LayoutContstants
{
	/**
	 * 
	 * @author Noah
	 *
	 */
	enum Size 
	{ 
		/**
		 */
		XS("xs"), 
		
		/**
		 */
		SM("sm"), 
		
		/**
		 */
		MD("md"), 
		
		/**
		 */
		LG("lg");
		
		
		/**
		 */
		private String string;
	
		
		
		/**
		 * Constructor 
		 *
		 * @param string String
		 */
		Size (String string)
		{
			this.string = string;
		}
		
		
		/**
		 * 
		 * @return String
		 */
		public String toString ()
		{
			return this.string;
		}
	}
	
	
	/**
	 * 
	 * @author Noah
	 *
	 */
	enum ResponsiveDisplay
	{
		/**
		 */
		HIDDEN("hidden-*"),
		
		/**
		 */
		VISIBLE_BLOCK("visible-*-block"),
		
		/**
		 */
		VISIBLE_INLINE("visible-*-block"),
		
		/**
		 */
		VISIBLE_INLINE_BLOCK("visible-*-inline-block");
	
		
		/**
		 */
		private String string;
		
		
		/**
		 * 
		 * @param size Size
		 * @return HasCssName[]
		 */
		public static HasCssName[] values (Size size)
		{
			ResponsiveDisplay[] values =  ResponsiveDisplay.values();
			
			HasCssName[] cssValues = new HasCssName[4];
			
			for (int i = 0; i < values.length; ++i)
			{
				cssValues[i] = values[i].getCssName(size);
			}
			
			return cssValues;
		}
	

		
		/**
		 * Constructor 
		 *
		 * @param string String
		 */
		ResponsiveDisplay (String string)
		{
			this.string = string;
		}
	    
	    
	    /**
	     * 
	     * @param size Size
	     * @return HasCssName
	     */
		public HasCssName getCssName (Size size)
		{
			return new CssName(this.toString().replaceAll("\\*", size.toString()));
		}



		/**
		 * 
		 * @return String
		 */
		public String toString ()
		{
			return this.string;
		}
	}
	
	
	
}
