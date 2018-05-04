package com.talmadge.bwt.core.client.ui.widget.container;

import com.talmadge.bwt.core.client.ui.dom.style.color.Color;
import com.talmadge.bwt.core.client.ui.dom.style.color.RGBColor;

/**
 * 
 *
 */
public class ShadowConfig
{
	/**
	 */
	public enum Preset 
	{
		/**
		 */
		NONE("none");
		
		//-------------------------------------------------------
		
		/**
		 */
		private String value;
		
		
		/**
		 * 
		 * @param value String
		 */
		private Preset (String value)
		{
			this.value = value;
		}
		
		
		/**
		 * 
		 * @return String
		 */
		public String toString ()
		{
			return this.value;
		}
	}
	
	/**
	 */
	public static final ShadowConfig DEFAULT = new ShadowConfig(0, 1, 2, 2, new RGBColor(0, 0, 0, 0.075));
	
	/**
	 */
	public static final ShadowConfig NONE = new ShadowConfig(Preset.NONE);

	/**
	 */
	private int hShadow;
	
	/**
	 */
	private int vShadow;
	
	/**
	 */
	private int blur;
	
	/**
	 */
	private int spread;
	
	/**
	 */
	private boolean inset;
	
	/**
	 */
	private Color color;
	
	/**
	 */
	private Preset preset;
	
	
	/**
	 * Constructor
	 * 
	 */
	public ShadowConfig ()
	{
		
	}
	
	

	/**
	 * Constructor
	 * 
	 * @param preset Preset
	 */
	public ShadowConfig (Preset preset)
	{
		this.preset = preset;
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param hShadow int
	 * @param vShadow int
	 * @param blur int 
	 * @param spread int
	 * @param color Color
	 */
	public ShadowConfig (int hShadow, int vShadow, int blur, int spread, Color color)
	{
		this.setHShadow(hShadow);
		this.setVShadow(vShadow);
		this.setBlur(blur);
		this.setSpread(spread);
		this.setColor(color);
	}


	/**
	 * 
	 * @return int
	 */
	public int getHShadow ()
	{
		return this.hShadow;
	}


	/**
	 * 
	 * @return int
	 */
	public int getVShadow ()
	{
		return this.vShadow;
	}


	/**
	 * 
	 * @return int
	 */
	public int getBlur ()
	{
		return this.blur;
	}


	/**
	 * 
	 * @return int
	 */
	public int getSpread ()
	{
		return this.spread;
	}



	/**
	 * 
	 * @return boolean
	 */
	public boolean isInset ()
	{
		return this.inset;
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isPreset ()
	{
		 return this.preset != null;
	}


	/**
	 * 
	 * @return Color
	 */
	public Color getColor ()
	{
		return this.color;
	}


	/**
	 * Negative values ar allowed
	 * 
	 * @param hShadow int in pixels 
	 */
	public void setHShadow (int hShadow)
	{
		this.hShadow = hShadow;
	}


	/**
	 * Negative values ar allowed
	 * 
	 * @param vShadow int in pixels
	 */
	public void setVShadow (int vShadow)
	{
		this.vShadow = vShadow;
	}


	/**
	 * 
	 * @param blur int in pixels
	 */
	public void setBlur (int blur)
	{
		this.blur = blur;
	}


	/**
	 * 
	 * @param spread int in pixels
	 */
	public void setSpread (int spread)
	{
		this.spread = spread;
	}

	
	/**
	 * 
	 * @param inset boolean
	 */
	public void setInset (boolean inset)
	{
		this.inset = inset;
	}


	/**
	 *  
	 * @param color Color
	 */
	public void setColor (Color color)
	{
		this.color = color;
	}
	
	
	/**
	 * 
	 * @return String
	 */
	public String toString ()
	{
		if (this.isPreset())
		{
			return this.preset.toString();
		}
		
		String value = this.getHShadow() + "px";
		value += " ";
		value += this.getVShadow() + "px";
		value += " ";
		value += this.getBlur() + "px";
		value += " ";
		value += this.getSpread() + "px";
		value += " ";
		value += this.getColor().toString();
		
		if (this.isInset())
		{
			value += " ";
			value += "inset";
		}
		
		return value;
	}
	
	
}
