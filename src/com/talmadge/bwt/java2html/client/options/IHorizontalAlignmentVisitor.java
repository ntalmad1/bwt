package com.talmadge.bwt.java2html.client.options;

/**
 * @author Markus Gebhard
 */
public interface IHorizontalAlignmentVisitor
{	
	/**
	 * 
	 * @param horizontalAlignment HorizontalAlignment
	 */
	void visitLeftAlignment (HorizontalAlignment horizontalAlignment);


	/**
	 * 
	 * @param horizontalAlignment HorizontalAlignment
	 */
	void visitRightAlignment (HorizontalAlignment horizontalAlignment);


	/**
	 * 
	 * @param horizontalAlignment HorizontalAlignment
	 */
	void visitCenterAlignment (HorizontalAlignment horizontalAlignment);
}
