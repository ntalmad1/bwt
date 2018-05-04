package com.talmadge.bwt.java2html.client.util.text;

import java.io.PrintStream;

/**
 * 
 *
 */
public final class AsciiProgressBar
{

	/**
	 * Construct an AsciiProgressBar that prints to System.out
	 * 
	 * @param maxValue the maximum value that will be passed to the progress
	 *            method
	 */
	public AsciiProgressBar (float maxValue)
	{
		this.out = System.out;
		this.maxValue = maxValue;
	}


	/**
	 * Construct an AsciiProgressBar that prints to the PrintStream given in out
	 * 
	 * @param out the PrintStream to print the progress bar to
	 * @param maxValue the maximum value that will be passed to the progress
	 *            method
	 */
	public AsciiProgressBar (PrintStream out, float maxValue)
	{
		this.out = out;
		this.maxValue = maxValue;
	}


	/**
	 * Construct an AsciiProgressBar that prints to System.out. This is a
	 * convenience constructor that may be used for loops that count integers
	 * and terminate if the integer reaches the maximum
	 * 
	 * @param lessThanValue the value which is one greater than the maximum
	 *            value that will be passed to the progress method
	 */
	public AsciiProgressBar (int lessThanValue)
	{
		this.out = System.out;
		this.maxValue = lessThanValue - 1;
	}


	/**
	 * Construct an AsciiProgressBar that prints to the PrintStream given in
	 * out. This is a convenience constructor that may be used for loops that
	 * count integers and terminate if the integer reaches the maximum
	 * 
	 * @param out the PrintStream to print the progress bar to
	 * @param lessThanValue the value which is one greater than the maximum
	 *            value that will be passed to the progress method
	 */
	public AsciiProgressBar (PrintStream out, int lessThanValue)
	{
		this.out = out;
		this.maxValue = lessThanValue - 1;
	}
	
	/**
	 */
	private PrintStream out;

	/**
	 */
	private int currentProgress = 0;

	/**
	 */
	private boolean headerDone = false;

	/**
	 */
	private float maxValue;


	/**
	 * Draw the progress bar up to the current value. A header with a percentage
	 * scale will be printed at the first call of this method.
	 * <p>
	 * 
	 * @param value the current progress.
	 */
	public void progress (float value)
	{
		if (!headerDone)
		{
			out.println(PERCENTAGES);
			out.println(SCALE);
			headerDone = true;
		}

		int nextProgress = (int) (value / maxValue * SCALE_LENGTH);
		while (nextProgress > currentProgress && nextProgress <= SCALE_LENGTH)
		{
			out.print('.');
			currentProgress++;
		}
		if (value >= maxValue)
		{
			out.println();
		}

	}


	/**
	 * Draw the progress bar up to the current value. A header with a percentage
	 * scale will be printed at the first call of this method.
	 * 
	 * @param value the current progress.
	 */
	public void progressInteger (int value)
	{
		progress((float) value);
	}

	/**
	 */
	private static final String PERCENTAGES = "0%    10%    20%    30%    40%    50%    60%    70%    80%    90%    100%";

	/**
	 */
	private static final String SCALE = "|------|------|------|------|------|------|------|------|------|------|";

	/**
	 */
	private static final int SCALE_LENGTH = SCALE.length();

}
