package com.talmadge.bwt.java2html.client.util;

/**
 * A color representation similar to {@link java.awt.Color}, but more
 * lightweight, since it does not rquire GUI libraries.
 * 
 * @author Markus Gebhard
 */
public class RGB
{
	/**
	 */
	public static final RGB MAGENTA = new RGB(255, 0, 255);

	/**
	 */
	public static final RGB GREEN = new RGB(0, 255, 0);
	
	/**
	 */
	public static final RGB BLACK = new RGB(0, 0, 0);

	/**
	 */
	public static final RGB RED = new RGB(255, 0, 0);

	/**
	 */
	public static final RGB WHITE = new RGB(255, 255, 255);

	/**
	 */
	public static final RGB ORANGE = new RGB(255, 200, 0);

	/**
	 */
	public static final RGB CYAN = new RGB(0, 255, 255);

	/**
	 */
	public static final RGB BLUE = new RGB(0, 0, 255);

	/**
	 */
	public static final RGB LIGHT_GRAY = new RGB(192, 192, 192);

	/**
	 */
	public static final RGB GRAY = new RGB(128, 128, 128);

	/**
	 */
	public static final RGB DARK_GRAY = new RGB(64, 64, 64);

	/**
	 */
	public static final RGB YELLOW = new RGB(255, 255, 0);

	/**
	 */
	public static final RGB PINK = new RGB(255, 175, 175);

	/**
	 * 
	 * @param red int
	 * @param green int
	 * @param blue int
	 */
	private static void assertColorValueRange (int red, int green, int blue)
	{
		boolean rangeError = false;
		String badComponentString = ""; //$NON-NLS-1$
		if (red < 0 || red > 255)
		{
			rangeError = true;
			badComponentString = badComponentString + " Red"; //$NON-NLS-1$
		}
		if (green < 0 || green > 255)
		{
			rangeError = true;
			badComponentString = badComponentString + " Green"; //$NON-NLS-1$
		}
		if (blue < 0 || blue > 255)
		{
			rangeError = true;
			badComponentString = badComponentString + " Blue"; //$NON-NLS-1$
		}
		
		if (rangeError)
		{
			throw new IllegalArgumentException(
					"Color parameter outside of expected range:" //$NON-NLS-1$
							+ badComponentString);
		}
	}


	/**
	 */
	private int red;

	/**
	 */
	private int green;

	/**
	 */
	private int blue;

	
	/**
	 * Constructor 
	 *
	 * @param red int
	 * @param green int
	 * @param blue int
	 */
	public RGB (int red, int green, int blue)
	{
		assertColorValueRange(red, green, blue);
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	
	/**
	 * 
	 * @return int
	 */
	public int getRed ()
	{
		return red;
	}

	
	/**
	 * 
	 * @return int
	 */
	public int getGreen ()
	{
		return green;
	}

	
	/**
	 * 
	 * @return int
	 */
	public int getBlue ()
	{
		return blue;
	}

	
	/**
	 * 
	 * @param obj Object
	 * @return boolean
	 */
	public boolean equals (Object obj)
	{
		if (!(obj instanceof RGB))
		{
			return false;
		}
		RGB other = (RGB) obj;
		return other.getRed() == getRed() && other.getGreen() == getGreen()
				&& other.getBlue() == getBlue();
	}

	
	/**
	 * 
	 * @return int
	 */
	public int hashCode ()
	{
		return (red & 0xFF) << 16 | (green & 0xFF) << 8 | blue & 0xFF;
	}


	/**
	 * Returns a string containing a concise, human-readable description of the
	 * receiver.
	 *
	 * @return a string representation of the <code>RGB</code>
	 */
	public String toString ()
	{
		return "RGB {" + red + ", " + green + ", " + blue + "}"; //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}
}