package com.talmadge.bwt.core.client.ui.dom.style;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.HasCssName;


/**
 * 
 * @author Noah
 *
 */
public interface BwtStyle
{
	/**
	 * 
	 */
	enum AlertStyle implements HasCssName
	{
		/**
	     */
	    SUCCESS("alert-success"),
	    
		/**
	     */
	    INFO("alert-info"),
	    
	    /**
	     */
	    WARNING("alert-warning"),
	
	    /**
	     */
	    DANGER("alert-danger");
	    
	    
	    /**
	     */
	    private String cssName;
	    
	    
	    /**
	     * Constructor 
	     *
	     * @param cssName String
	     */
	    AlertStyle (String cssName)
	    {
	    	this.cssName = cssName;
	    }
	    
	    
	    /**
	     * 
	     * @return String
	     */
	    public String getCssName ()
	    {
	    	return this.cssName;
	    }
	}
	
	
	/**
	 * 
	 */
	enum ButtonSize implements HasCssName
	{
		/**
	     */
	    LARGE("btn-lg"),
	    
		/**
	     */
	    NORMAL("btn-nm"),
	    
	    /**
	     */
	    SMALL("btn-sm"),
	
	    /**
	     */
	    XSMALL("btn-xs");
	    
	    
	    /**
	     */
	    private String cssName;
	    
	    
	    /**
	     * Constructor 
	     *
	     * @param cssName String
	     */
	    ButtonSize (String cssName)
	    {
	    	this.cssName = cssName;
	    }
	    
	    
	    /**
	     * 
	     * @return String
	     */
	    public String getCssName ()
	    {
	    	return this.cssName;
	    }
	}

	
	/**
	 * 
	 * @author Noah
	 *
	 */
	enum ButtonStyle implements HasCssName
	{
		/**
		 */
		DEFAULT("btn-default"),
		
		/**
		 */
		PRIMARY("btn-primary"),

		/**
		 */
		SUCCESS("btn-success"),

		/**
		 */
		INFO("btn-info"),

		/**
		 */
		WARNING("btn-warning"),

		/**
		 */
		DANGER("btn-danger"),

		/**
		 */
		LINK("btn-link");
		
		
		/**
	     */
	    private String cssName;
	    
	    
	    /**
	     * Constructor 
	     *
	     * @param cssName String
	     */
		ButtonStyle (String cssName)
	    {
	    	this.cssName = cssName;
	    }
	    
	    
	    /**
	     * 
	     * @return String
	     */
	    public String getCssName ()
	    {
	    	return this.cssName;
	    }
		
	}
	
	
	/**
     * 
     *
     */
    enum ContentAlign implements HasCssName
    {   
        /**
         */
        CENTER("text-center"),
        
        
        /**
         */
        JUSTIFY("text-justify"),
        
        /**
         */
        LEFT("text-left"),
        
        /**
         */
        NONE(),
      
        /**
         */
        RIGHT("text-right");
        
        //---------------------------------
        
        /**
         */
        private String cssName;
        
        
        
        /**
         * Constructor 
         *
         */
        ContentAlign () 
        {
            
        }
        
        /**
         * Constructor 
         *
         * @param cssName String
         */
        ContentAlign (String cssName) 
        {
            this.cssName = cssName;
        }
        
        
        /**
         * 
         * @return String
         */
        public String getCssName ()
        {
            return this.cssName;
        }
    }
    
    
    /**
	 * 
	 * @author Noah
	 *
	 */
	enum ContentPanelStyle implements HasCssName
	{
		/**
		 */
		DEFAULT("panel-default"),
		
		/**
		 */
		PRIMARY("panel-primary"),

		/**
		 */
		SUCCESS("panel-success"),

		/**
		 */
		INFO("panel-info"),

		/**
		 */
		WARNING("panel-warning"),

		/**
		 */
		DANGER("panel-danger");
		
		
		
		/**
	     */
	    private String cssName;
	    
	    
	    /**
	     * Constructor 
	     *
	     * @param cssName String
	     */
	    ContentPanelStyle (String cssName)
	    {
	    	this.cssName = cssName;
	    }
	    
	    
	    /**
	     * 
	     * @return String
	     */
	    public String getCssName ()
	    {
	    	return this.cssName;
	    }
		
	}

    
	/**
	 * 
	 * @author Noah
	 *
	 */
	enum Context 
	{	
		/**
		 */
		DANGER("text-danger", "bg-danger"), 
		
		/**
		 */
		INFO("text-info", "bg-info"), 
		
		/**
		 */
		MUTED("text-muted", ""),
		
		/**
		 */
		NORMAL("", ""),
		
		/**
		 */
		PRIMARY("text-primary", "bg-primary"),
		
		/**
		 */
		SUCCESS("text-success", "bg-success"),
		
		/**
		 */
		WARNING("text-warning", "bg-warning");
		
		
		/**
		 * 
		 * @return  HasCssName[]
		 */
		public static HasCssName[] getBgContextValues ()
		{
			Context[] values = Context.values(); 
			
			HasCssName[] cssNames = new HasCssName[values.length];
			
			for (int i = 0; i < values.length; ++i)
			{
				cssNames[i] = values[i].getBgContext();
			}
			
			return cssNames;
		}
		
		
		/**
		 * 
		 * @return  HasCssName[]
		 */
		public static HasCssName[] getTextContextValues ()
		{
			Context[] values = Context.values(); 
			
			HasCssName[] cssNames = new HasCssName[values.length];
			
			for (int i = 0; i < values.length; ++i)
			{
				cssNames[i] = values[i].getTextContext();
			}
			
			return cssNames;
		}



		/**
		 * 
		 */
		private CssName bgContext;
		
		
		/**
		 * 
		 */
		private CssName textContext;
		
		
		/**
		 * Constructor
		 * 
		 * @param textContext String
		 * @param bgContext String
		 */
		Context (String textContext, String bgContext)
		{
			this.textContext = new CssName(textContext);
			this.bgContext = new CssName(bgContext);
		}
		
		
		
		/**
		 * 
		 * @return CssName
		 */
		public CssName getBgContext ()
		{
			return this.bgContext;
		}
		
		
		
		/**
		 * 
		 * @return CssName
		 */
		public CssName getTextContext ()
		{
			return this.textContext;
		}
	}
	
	
	/**
	 * 
	 * @author Noah
	 *
	 */
	enum FormElementSize implements HasCssName
	{
		/**
	     */
	    LARGE("input-lg"),
	    
		/**
	     */
	    NORMAL(),
	    
	    /**
	     */
	    SMALL("input-sm");
		
	    
		/**
	     */
	    private String cssName;
		
	    /**
	     * Constructor 
	     *
	     */
		FormElementSize ()
	    {
			
	    }
		
		/**
	     * Constructor 
	     *
	     * @param cssName String
	     */
		FormElementSize (String cssName)
	    {
	    	this.cssName = cssName;
	    }
	    
	    
	    /**
	     * 
	     * @return String
	     */
	    public String getCssName ()
	    {
	    	return this.cssName;
	    }
		
		
	}
	
	
	/**
	 * 
	 */
	enum IconAlign implements HasCssName
	{
		/**
	     */
	    ABOVE("bwt-icon-align-above"),
	    
		/**
	     */
	    BELOW("bwt-icon-align-below"),
	    
	    /**
	     */
	    LEFT("bwt-icon-align-left"),
	
	    /**
	     */
	    RIGHT("bwt-icon-align-right");
	    
	    
	    /**
	     */
	    private String cssName;
	    
	    
	    /**
	     * Constructor 
	     *
	     * @param cssName String
	     */
	    IconAlign (String cssName)
	    {
	    	this.cssName = cssName;
	    }
	    
	    
	    /**
	     * 
	     * @return String
	     */
	    public String getCssName ()
	    {
	    	return this.cssName;
	    }
	}
	
	
	/**
	 * 
	 * @author Noah
	 *
	 */
	enum InputSize implements HasCssName
	{
		/**
	     */
	    LARGE("input-lg"),
	    
		/**
	     */
	    NORMAL(""),
	    
	    /**
	     */
	    SMALL("input-sm");
		
		
		/**
		 * 
		 * @param formElementSize
		 * @return InputGroupSize
		 */
		public static InputSize map (FormElementSize formElementSize)
		{
			switch (formElementSize)
			{
				case LARGE:
					return InputSize.LARGE;
				case NORMAL:
					return InputSize.NORMAL;
				case SMALL:
					return InputSize.SMALL;
				default:
					return null;
			}
		}
		
	    
		/**
	     */
	    private String cssName;
	    
	    
	    /**
	     * Constructor 
	     *
	     * @param cssName String
	     */
	    InputSize (String cssName)
	    {
	    	this.cssName = cssName;
	    }
	    
	    
	    /**
	     * 
	     * @return String
	     */
	    public String getCssName ()
	    {
	    	return this.cssName;
	    }
	}
	
	
	
	/**
	 * 
	 * @author Noah
	 *
	 */
	enum InputGroupSize implements HasCssName
	{
		/**
	     */
	    LARGE("input-group-lg"),
	    
		/**
	     */
	    NORMAL(""),
	    
	    /**
	     */
	    SMALL("input-group-sm");
		
	    
		/**
		 * 
		 * @param formElementSize
		 * @return InputGroupSize
		 */
		public static InputGroupSize map (FormElementSize formElementSize)
		{
			switch (formElementSize)
			{
				case LARGE:
					return InputGroupSize.LARGE;
				case NORMAL:
					return InputGroupSize.NORMAL;
				case SMALL:
					return InputGroupSize.SMALL;
				default:
					return null;
			}
		}


		/**
	      */
	    private String cssName;
	    
	    
	    /**
	     * Constructor 
	     *
	     * @param cssName String
	     */
	    InputGroupSize (String cssName)
	    {
	    	this.cssName = cssName;
	    }
	    
	    
	    /**
	     * 
	     * @return String
	     */
	    public String getCssName ()
	    {
	    	return this.cssName;
	    }
	}
	
	
	/**
	 * 
	 * @author Noah
	 *
	 */
	enum DialogStyle implements HasCssName
	{
		/**
		 */
		DEFAULT("panel-default"),
		
		/**
		 */
		PRIMARY("panel-primary"),

		/**
		 */
		SUCCESS("panel-success"),

		/**
		 */
		INFO("panel-info"),

		/**
		 */
		WARNING("panel-warning"),

		/**
		 */
		DANGER("panel-danger");
		
		
		
		/**
	     */
	    private String cssName;
	    
	    
	    /**
	     * Constructor 
	     *
	     * @param cssName String
	     */
	    DialogStyle (String cssName)
	    {
	    	this.cssName = cssName;
	    }
	    
	    
	    /**
	     * 
	     * @return String
	     */
	    public String getCssName ()
	    {
	    	return this.cssName;
	    }
		
	}
	
	
	/**
	 * 
	 */
	enum NavBarFixedStyle implements HasCssName  
	{	
		/**
		 */
		FIXED_BOTTOM("navbar-fixed-bottom"),
		
		/**
		 */
		FIXED_TOP("navbar-fixed-top"), 
		
		/**
		 */
		NONE(),
		
		/**
		 */
		STATIC_TOP("navbar-static-top");
		
		
		/**
	     */
	    private String cssName;
		
	    
		/**
	     * Constructor 
	     *
	     */
	    NavBarFixedStyle ()
	    {
	    	this.cssName = "";
	    }
	    
	    
	    /**
	     * Constructor 
	     *
	     * @param cssName String
	     */
	    NavBarFixedStyle (String cssName)
	    {
	    	this.cssName = cssName;
	    }
	    
	    
	    /**
	     * 
	     * @return String
	     */
	    public String getCssName ()
	    {
	    	return this.cssName;
	    }
	}
	
	
	/**
	 * 
	 *
	 */
	enum NavGroupOrientation implements HasCssName 
	{
		/**
		 */
		HORIZONTAL(),
		
		/**
		 */
		VERTICAL("nav-stacked");
		
		/**
	     */
	    private String cssName;
		
	    
		/**
	     * Constructor 
	     *
	     */
		NavGroupOrientation ()
	    {
	    	this.cssName = "";
	    }
	    
	    
	    /**
	     * Constructor 
	     *
	     * @param cssName String
	     */
		NavGroupOrientation (String cssName)
	    {
	    	this.cssName = cssName;
	    }
	    
	    
	    /**
	     * 
	     * @return String
	     */
	    public String getCssName ()
	    {
	    	return this.cssName;
	    }
	}
	
	
	/**
	 * 
	 * @author Noah
	 *
	 */
	enum NavGroupStyle implements HasCssName
	{	
		/**
		 */
		NONE(),
		
		/**
		 */
		PILLS("nav-pills"),
		
		/**
		 */
		TABS("nav-tabs");
		
		/**
	     */
	    private String cssName;
	    
	    
	    /**
	     * Constructor 
	     *
	     */
	    NavGroupStyle ()
	    {
	    	this.cssName = "";
	    }
	    
	    
	    /**
	     * Constructor 
	     *
	     * @param cssName String
	     */
	    NavGroupStyle (String cssName)
	    {
	    	this.cssName = cssName;
	    }
	    
	    
	    /**
	     * 
	     * @return String
	     */
	    public String getCssName ()
	    {
	    	return this.cssName;
	    }
	}

	
	/**
	 */
	enum SubtextAlign implements HasCssName
	{
	    /**
	     */
	    BELOW("bwt-subtext-align-below"),

	    /**
	     */
	    RIGHT("bwt-subtext-align-right");
	    
	    
	    /**
	     */
	    private String cssName;
	    
	    
	    /**
	     * Constructor 
	     *
	     * @param cssName String
	     */
	    SubtextAlign (String cssName)
	    {
	    	this.cssName = cssName;
	    }
	    
	    
	    /**
	     * 
	     * @return String
	     */
	    public String getCssName ()
	    {
	    	return this.cssName;
	    }
	}
	
	
	/**
	 */
	enum BwtTextAlign implements HasCssName
	{
		/**
	     */
	    CENTER("text-center", Style.TextAlign.CENTER),
		
		
	    /**
	     */
	    JUSTIFY("text-justify", Style.TextAlign.JUSTIFY),
	    
	    /**
	     */
	    LEFT("text-left", Style.TextAlign.LEFT),
		
	    
	    /**
	     */
	    RIGHT("text-right", Style.TextAlign.RIGHT);
	    
	    
	    /**
	     * 
	     * @param textAlign Style.TextAlign
	     * @return BwtTextAlign
	     */
	    public static BwtTextAlign getByTextAlign (Style.TextAlign textAlign)
	    {
	    	BwtTextAlign[] values = BwtTextAlign.values();
	    	
	    	for (int i = 0; i < values.length; ++i)
	    	{
	    		if (values[i].getTextAlign().equals(textAlign))
	    		{
	    			return values[i];
	    		}
	    	}
	    	
	    	return null;
	    }
	    
	    
	    /**
	     */
	    private String cssName;
	    
	    /**
	     */
	    private Style.TextAlign textAlign;
	    
	    
	    /**
	     * Constructor 
	     *
	     * @param cssName String
	     * @param textAlign Style.TextAlign 
	     */
	    BwtTextAlign (String cssName, Style.TextAlign  textAlign) 
	    {
	    	this.cssName = cssName;
	    	this.textAlign = textAlign;
	    }
	    
	    
	    /**
	     * 
	     * @return String
	     */
	    public String getCssName ()
	    {
	    	return this.cssName;
	    }
	    
	    
	    /**
	     * 
	     * @return Style.TextAlign
	     */
	    public Style.TextAlign getTextAlign ()
	    {
	    	return this.textAlign;
	    }
	}
	
	
//	/**
//	 */
//	public enum BwtTextTransform implements HasCssName
//	{
//		/**
//	     */
//		LOWERCASE("text-lowercase", Style.TextTransform.LOWERCASE),
//		
//		
//	    /**
//	     */
//	    UPPERCASE("text-uppercase", Style.TextTransform.UPPERCASE),
//	    
//	    /**
//	     */
//	    CAPITALIZE("text-capitalize", Style.TextTransform.CAPITALIZE),
//		
//	    
//	    /**
//	     */
//	    NONE(null, Style.TextTransform.NONE);
//	    
//	    
//	    /**
//	     * 
//	     * @param textTransform Style.TextTransform
//	     * @return BwtTextTransform
//	     */
//	    public static BwtTextTransform getByTextTransform (Style.TextTransform textTransform)
//	    {
//	    	BwtTextTransform[] values = BwtTextTransform.values();
//	    	
//	    	for (int i = 0; i < values.length; ++i)
//	    	{
//	    		if (values[i].getTextTransform().equals(textTransform))
//	    		{
//	    			return values[i];
//	    		}
//	    	}
//	    	
//	    	return null;
//	    }
//	    
//	    
//	    /**
//	     */
//	    private String cssName;
//	    
//	    /**
//	     */
//	    private Style.TextTransform textTransform;
//	    
//	    
//	    /**
//	     * Constructor 
//	     *
//	     * @param cssName String
//	     * @param textTransform Style.TextTransform 
//	     */
//	    BwtTextTransform (String cssName, Style.TextTransform  textTransform) 
//	    {
//	    	this.cssName = cssName;
//	    	this.textTransform = textTransform;
//	    }
//	    
//	    
//	    /**
//	     * 
//	     * @return String
//	     */
//	    public String getCssName ()
//	    {
//	    	return this.cssName;
//	    }
//	    
//	    
//	    /**
//	     * 
//	     * @return Style.TextTransorm
//	     */
//	    public Style.TextTransform getTextTransform ()
//	    {
//	    	return this.textTransform;
//	    }
//	}
	
	
	
	/**
	 */
	enum TextWrap implements HasCssName
	{
		/**
	     */
	    NO_WRAP("text-nowrap"),
	    
	    
	    /**
	     */
	    WRAP("text-wrap");
	    	    
	    
	    /**
	     */
	    private String cssName;
	    
	    
	    
	    /**
	     * Constructor 
	     *
	     * @param cssName String
	     */
	    TextWrap (String cssName) 
	    {
	    	this.cssName = cssName;
	    }
	    
	    
	    /**
	     * 
	     * @return String
	     */
	    public String getCssName ()
	    {
	    	return this.cssName;
	    }
	}
	
	
	/**
	 */
	enum WellSize implements HasCssName
	{
	    /**
	     */
	    LARGE("well-lg"),
	    
	    /**
	     */
	    NORMAL(),

	    /**
	     */
	    SMALL("well-sm");
	    
	    
	    /**
	     */
	    private String cssName;
	    
	    
	    /**
	     * Constructor 
	     *
	     */
	    WellSize ()
	    {
	    	
	    }
	    
	    
	    /**
	     * Constructor 
	     *
	     * @param cssName String
	     */
	    WellSize (String cssName)
	    {
	    	this.cssName = cssName;
	    }
	    
	    
	    /**
	     * 
	     * @return String
	     */
	    public String getCssName ()
	    {
	    	return this.cssName;
	    }
	}
}
