package com.talmadge.bwt.core.client.ui.widget.html;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.TextTransform;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.dom.layout.padding.Padding;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ContentAlign;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.Context;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.TextWrap;
import com.talmadge.bwt.core.client.ui.widget.BwtHasText;
import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;
import com.talmadge.bwt.core.client.ui.widget.html.a.A;
import com.talmadge.bwt.core.client.ui.widget.html.abbr.Abbr;
import com.talmadge.bwt.core.client.ui.widget.html.cell.HtmlCell;
import com.talmadge.bwt.core.client.ui.widget.html.list.li.Li;
import com.talmadge.bwt.core.client.ui.widget.html.p.P;
import com.talmadge.bwt.core.client.ui.widget.html.pre.Pre;
import com.talmadge.bwt.core.client.ui.widget.image.BwtImage;

/**
 * 
 * @author Noah
 *
 */
public class Html extends BwtComposite implements BwtHasText
{
	/**
	 * 
	 * @param html String
	 * @return A
	 */
	public static A a (String html)
	{
		return new A(html);
	}


	/**
	 * 
	 * @param abbr String
	 * @return Abbr
	 */
	public static Abbr abbr (String abbr)
	{
		return new Abbr(abbr);
	}

	
	/**
	 * 
	 * @param abbr String
	 * @param fullForm String
	 * @return Abbr
	 */
	public static Abbr abbr (String abbr, String fullForm)
	{
		Abbr abbrWidget = new Abbr(abbr, fullForm); 
		
		return abbrWidget;
	}

	
	/**
	 * 
	 * @return Html
	 */
	public static Html button () 
	{
		Html html = new Html(HtmlTag.BUTTON); 
		return html;
	}
	
	
	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html cite (String html)
	{
		return new Html(HtmlTag.CITE, html);
	}

	
	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html code (String html) 
	{
		return new Html(HtmlTag.CODE, html);
	}


	/**
	 * 
	 * @return  Html
	 */
	public static Html dd ()
	{
		return new Html(HtmlTag.DD);
	}


	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html del (String html)
	{
		return new Html(HtmlTag.DEL, html);
	}

	
	/**
	 * 
	 * @return Html
	 */
	public static Html div ()
	{
		return new Html(HtmlTag.DIV);
	}


	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html div (String html)
	{
		return new Html(HtmlTag.DIV, html);
	}
	
	
	/**
	 * 
	 * @return  Html
	 */
	public static Html dt ()
	{
		return new Html(HtmlTag.DT);
	}
	
	
	/**
	 * 
	 * @param html String 
	 * @return  Html
	 */
	public static Html dt (String html)
	{
		return new Html(HtmlTag.DT, html);
	}


	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html em (String html)
	{
		return new Html(HtmlTag.EM, html);
	}

	
	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html footer (String html)
	{
		return new Html(HtmlTag.FOOTER, html);
	}


	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html h1 (String html)
	{
		return new Html(HtmlTag.H1, html);
	}
	
	
	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html h2 (String html)
	{
		return new Html(HtmlTag.H2, html);
	}
	
	
	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html h3 (String html)
	{
		return new Html(HtmlTag.H3, html);
	}
	
	
	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html h4 (String html)
	{
		return new Html(HtmlTag.H4, html);
	}
	
	
	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html h5 (String html)
	{
		return new Html(HtmlTag.H5, html);
	}
	
	
	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html h6 (String html)
	{
		return new Html(HtmlTag.H6, html);
	}

	
	/**
	 * 
	 * @param image ImageResource
	 * @return
	 */
	public static BwtImage image (ImageResource image)
	{
		return new BwtImage(image);
	}


	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html ins (String html)
	{
		return new Html(HtmlTag.INS, html);
	}

	/**
	 *  
	 * @param html String
	 * @return Html
	 */
	public static Html kbd (String html)
	{
		return new Html(HtmlTag.KBD, html);
	}


	/**
	 * 
	 * @param html String
	 * @return Li
	 */
	public static Html li (String html)
	{
		return new Li(html);
	}


	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html mark (String html)
	{
		return new Html(HtmlTag.MARK, html);
	}

	
	/**
	 * 
	 * @return P
	 */
	public static P p ()
	{
		return new P();
	}
	

	/**
	 * 
	 * @param html String
	 * @return P
	 */
	public static P p (String html)
	{
		return new P(html);
	}

	/**
	 * 
	 * @param html String
	 * @return Pre
	 */
	public static Pre pre (String html)
	{
		return new Pre(html);
	}


	/**
	 * Strikethrough
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html s (String html)
	{
		return new Html(HtmlTag.S, html);
	}

	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html samp (String html)
	{
		return new Html(HtmlTag.SAMP, html);
	}


	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html small (String html)
	{
		return new Html(HtmlTag.SMALL, html);
	}
	
	
	/**
     * 
     * @return Html
     */
    public static Html span ()
    {
        return new Html(HtmlTag.SPAN);
    }

	
	/**
     * 
     * @param html String
     * @return Html
     */
	public static Html span (String html)
    {
	    return new Html(HtmlTag.SPAN, html);
    }


    /**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html strong (String html)
	{
		return new Html(HtmlTag.STRONG, html);
	}


	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html u (String html)
	{
		return new Html(HtmlTag.U, html);
	}
	
	
	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public static Html var (String html)
	{
		return new Html(HtmlTag.VAR, html);
	}


	/**
	 */
	private HtmlCell cell;
	
	
	
	/**
	 * Constructor 
	 *
	 * @param html String
	 */
	public Html (String html)
	{
		this(HtmlTag.DIV, html);
	}


	/**
	 * Constructor 
	 *
	 * @param tag HtmlTag
	 */
	public Html (HtmlTag tag)
	{
		this.setCell(new HtmlCell(tag));		
		this.initWidget(this.getCell());
	}


	/**
	 * Constructor 
	 *
	 * @param tag HtmlTag
	 * @param html String
	 */
	public Html (HtmlTag tag, String html)
	{
		this.setCell(new HtmlCell(tag, html));		
		this.initWidget(this.getCell());
	}

	
	/**
	 * Constructor 
	 *
	 */
	protected Html ()
	{
		
	}
	
	
	/**
	 * 
	 * @param html Html
	 * @return Html
	 */
	public Html add (Html html)
	{
		this.getCell().add(html);	
		
		return this;
	}
	
	
	/**
	 * 
	 * @param html HTML
	 * @return Html
	 */
	public Html add (HTML html)
	{
		this.getCell().add(html);	
		
		return this;
	}
	
	
	
	/**
	 * 
	 * @param html Html
	 * @param margins Margins
	 */
	public void add (Html html, Margins margins)
	{
		this.getCell().add(html, margins);		
	}
	
	
	/**
	 * 
	 * @param html Html
	 * @param padding Padding
	 */
	public void add (Html html, Padding padding)
	{
		this.getCell().add(html, padding);
	}
	

	/**
	 * 
	 * @param widget Widget
	 * @return Html
	 */
	public Html add (Widget widget)
	{
	    this.getCell().add(widget);
	    return this;
	}


	/**
	 * 
	 * @param html String
	 * @return Html
	 */
	public Html append (String html)
	{
		this.getCell().append(html);
		return this;
	}
	
	
	/**
	 * 
	 * @param html Html
	 * @return Html
	 */
	public Html append (Html html)
	{
		this.add(html);
		return this;
	}

	
	/**
	 * 
	 * @return Html
	 */
	public Html br ()
	{
		this.getCell().br();
		
		return this;
	}
	
	
	/**
	 * 
	 */
    public void clear ()
    {
        this.getCell().clear();
    }


	/**
     * 
     * @return int
     */
    public int getHeight ()
    {
        return this.getElement().getClientHeight();
    }


    /**
	 * 
	 * @return String
	 */
	public String getId ()
	{
		return this.getCell().getId();
	}

	
	/**
	 * 
	 * @return String
	 */
	public String getInnerHtml ()
	{
		return this.getCell().getInnerHtml();
	}

	
	/**
	 *  
	 * @return String
	 */
	public String getText ()
	{
		return this.getInnerHtml();
	}

	
	/**
	 * 
	 */
	public void hide ()
    {
        this.getCell().hide();
    }
	

	/**
	 * 
	 * @return Html
	 */
	public Html italic () 
	{
		this.setItalic(true);
		return this;
	}


	/**
	 *  
	 * @return Html
	 */
	public Html nbsp ()
	{
		this.append("&nbsp;");
		
		return this;
	}

	
	/**
	 * 
	 * @param key String
	 * @param value String
	 */
	public void setAttribute (String key, String value)
	{
		this.getCell().setAttribute(key, value);	
	}


	/**
	 * 
	 * @param context Context
	 */
	public void setBgContext (Context context)
	{
		this.getCell().setBgContext(context);		
	}

	/**
	 * 
	 * @param isBold boolean
	 * @return Html
	 */
	public Html setBold (boolean isBold)
	{	
		this.getCell().setBold(isBold);
		return this;
	}


	/**
	 * 
	 * @param isCentered boolean
	 * @return Html
	 */
	public Html setCentered (boolean isCentered)
	{
		this.getCell().setCentered(isCentered);
		return this;
	}


	/**
	 * 
	 * @param align ContentAlign
	 * @return Html
	 */
	public Html setContentAlign (ContentAlign align)
	{
		this.getCell().setContentAlign(align);
		return this;
	}


	/**
	 * 
	 * @param context Context
	 */
	public void setContext (Context context)
	{
		this.getCell().setContext(context);
	}

	
	/**
	 * 
	 * @param display  Display
	 * @return this;
	 */ 
	public Html setDisplay (Display display)
	{
		this.getCell().setDisplay(display);
		return this;
	}


	/**
	 * 
	 * @param size int
	 * @return Html
	 */
	public Html setFontSize (int size)
	{
		this.getCell().setFontSize(size);
		return this;
	}


	/**
	 * 
	 * @param fontStyle FontStyle
	 * @return Html
	 */
	public Html setFontStyle (FontStyle fontStyle) 
	{
		this.getCell().setFontStyle(fontStyle);
		return this;
	}


	/**
	 * 
	 * @param fontWeight FontWeight
	 * @return Html
	 */
	public Html setFontWeight (FontWeight fontWeight)
	{
		this.getCell().setFontWeight(fontWeight);
		return this;
	}


	/**
	 * 
	 * @param height int
	 */
	public void setHeight (int height)
	{
		this.getCell().setHeight(height);		
	}

	
	/**
	 * 
	 * @param id String
	 */
	public void setId (String id)
	{
		this.getCell().setId(id);
	}
	
	
	/**
	 * 
	 * @param innerHtml String
	 */
	public void setInnerHtml (String innerHtml)
	{
		this.getCell().setInnerHtml(innerHtml);
	}

	
	/**
	 * 
	 * @param isItalic boolean
	 * @return Html
	 */
	public Html setItalic (boolean isItalic) 
	{
		if (isItalic) {
			this.setFontStyle(FontStyle.ITALIC);
		}
		else {
			this.setFontStyle(FontStyle.NORMAL);
		}
		return this;
	}

	
	/**
	 * 
	 * @param width int
	 * @return Html
	 */
	public Html setMaxWidth (int width)
	{
		this.getCell().setMaxWidth(width);
		return this;
	}


	/**
	 * 
	 * @param text String
	 */
	public void setText (String text)
	{
		this.setInnerHtml(text);		
	}


	/**
	 * 
	 * @param align TextAlign
	 * @return Html
	 */
	public Html setTextAlign (TextAlign align)
	{
		this.getCell().setTextAlign(align);
		
		return this;
	}
	
	
	/**
	 * 
	 * @param context Context
	 */
	public void setTextContext (Context context)
	{
		this.getCell().setTextContext(context);
	}


	/**
	 *  
	 * @param textTransform TextTransform
	 * @return Html
	 */
	public Html setTextTransform (TextTransform textTransform)
	{
		this.getCell().setTextTransform(textTransform);
		
		return this;
	}


	/**
	 * 
	 * @param textWrap TextWrap
	 * @return Html
	 */
	public Html setTextWrap (TextWrap textWrap)
	{
		this.getCell().setTextWrap(textWrap);
		
		return this;
	}

	
	/**
	 * 
	 * @param align VerticalAlign
	 */ 
	public void setVerticalAlign (VerticalAlign align)
	{
		this.getCell().setVerticalAlign(align);		
	}


	/**
	 * 
	 * @return HtmlWidget
	 */
	protected HtmlCell getCell ()
	{
		return this.cell;
	}
	
	
	/**
	 * 
	 * @param cell HtmlCell
	 */
	protected void setCell (HtmlCell cell)
	{
		this.cell = cell;
	}
}
