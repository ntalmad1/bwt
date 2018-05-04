package com.talmadge.bwt.java2html.client.options;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Markus Gebhard
 */
public abstract class HorizontalAlignment
{
	/**
	 */
	private static final Map<String, HorizontalAlignment> BY_NAME = new HashMap<String, HorizontalAlignment>();

	/**
	 */
	private static final List<HorizontalAlignment> ALL = new ArrayList<HorizontalAlignment>();

	
	/**
	 * 
	 */
	public static final HorizontalAlignment LEFT = new HorizontalAlignment("left")
	{
		public void accept (IHorizontalAlignmentVisitor visitor)
		{
			visitor.visitLeftAlignment(this);
		}
	};

	
	/**
	 * 
	 */
	public static final HorizontalAlignment CENTER = new HorizontalAlignment("center")
	{
		public void accept (IHorizontalAlignmentVisitor visitor)
		{
			visitor.visitCenterAlignment(this);
		}
	};

	
	/**
	 * 
	 */
	public static final HorizontalAlignment RIGHT = new HorizontalAlignment("right")
	{
		public void accept (IHorizontalAlignmentVisitor visitor)
		{
			visitor.visitRightAlignment(this);
		}
	};

	
	/**
	 * 
	 * @param name String
	 * @return HorizontalAlignment
	 */
	public static HorizontalAlignment getByName (String name)
	{
		return (HorizontalAlignment) BY_NAME.get(name);
	}

	
	/**
	 * 
	 * @return HorizontalAlignment[]
	 */
	public static HorizontalAlignment[] getAll ()
	{
		return (HorizontalAlignment[]) ALL.toArray(new HorizontalAlignment[ALL.size()]);
	}
	
	
	/**
	 */
	private String name;


	/**
	 * Constructor 
	 *
	 * @param name String
	 */
	public HorizontalAlignment (String name)
	{
		this.name = name;
		BY_NAME.put(name, this);
		ALL.add(this);
	}

	
	/**
	 * 
	 * @param visitor IHorizontalAlignmentVisitor
	 */
	public abstract void accept (IHorizontalAlignmentVisitor visitor);

	
	/**
	 * 
	 * @return String
	 */
	public String getName ()
	{
		return name;
	}

	
	/**
	 * 
	 * @return String
	 */
	public String toString ()
	{
		return "HorizontalAlignment{" + getName() + "}";
	}

}