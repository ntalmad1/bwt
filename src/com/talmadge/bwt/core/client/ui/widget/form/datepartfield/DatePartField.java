package com.talmadge.bwt.core.client.ui.widget.form.datepartfield;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.user.client.Timer;
import com.talmadge.bwt.core.client.date.BwtDate;
import com.talmadge.bwt.core.client.date.BwtDateException;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.FormElementSize;
import com.talmadge.bwt.core.client.ui.util.BwtWidgetUtils;
import com.talmadge.bwt.core.client.ui.widget.event.BwtBlurEvent;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectEvent;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectHandler;
import com.talmadge.bwt.core.client.ui.widget.form.element.AbstractFormElement;
import com.talmadge.bwt.core.client.ui.widget.form.option.Item;
import com.talmadge.bwt.core.client.ui.widget.form.simpleselect.SimpleSelect;

/**
 *
 * @author Noah
 *
 */
public class DatePartField extends AbstractFormElement<BwtDate>
{
    /**
     */
    private SimpleSelect<String> daySelect;

    /**
     */
    private boolean isValidateOnSelect = true;

    /**
      */
    private int maxYear;

    /**
     */
    private int minYear;

    /**
     */
    private SimpleSelect<Item<String>> monthSelect;

    /**
     */
    private SimpleSelect<String> yearSelect;



    /**
     * Hidden Constructor
     *
     * @param appearance DatePartFieldAppearance
     */
    protected DatePartField (DatePartFieldAppearance appearance)
    {
        super(appearance);

        this.daySelect   = new SimpleSelect<String>();
        this.daySelect.setPlaceholder("Day");
        this.daySelect.removeLabel();

        this.populateDayField();


        this.monthSelect = new SimpleSelect<Item<String>>();
        this.monthSelect.setPlaceholder("Month");
        this.monthSelect.removeLabel();

        this.populateMonthField();

        this.yearSelect  = new SimpleSelect<String>();
        this.yearSelect.setPlaceholder("Year");
        this.yearSelect.removeLabel();

        this.minYear = 1977;
        this.maxYear = new BwtDate().getYear();

        appearance.init(this.daySelect, this.monthSelect, this.yearSelect);

        this.bindDatePartField();
    }


    /**
     * Constructor
     *
     */
    public DatePartField ()
    {
        this((DatePartFieldAppearance) GWT.create(DefaultDatePartFieldAppearance.class));
    }


    /**
     *
     * @param label String
     */
    public DatePartField (String label)
    {
        this();
        this.setLabel(label);
    }

    
    /**
     * 
     * @param name String
     * @param label String 
     */
    public DatePartField (String name, String label)
	{
    	this(label);
		this.setName(name);
	}


	/**
     *
     */
    public void clear ()
    {
        this.clearState();

        this.yearSelect.clear();
        this.monthSelect.clear();
        this.daySelect.clear();
    }


    /**
     *
     * @return BwtDate
     */
    public BwtDate getValue ()
    {
        String year = this.yearSelect.getValue();

        String month = null;
        Item<String> monthItem = this.monthSelect.getSelectedItem();
        if (monthItem != null)
        {
            month = monthItem.getValue();
        }

        String day  = this.daySelect.getValue();

        BwtDate date;

        try
        {
            date = new BwtDate(year + "-" + month + "-" + day);
        }
        catch (BwtDateException e)
        {
            return null;
        }

        return date;
    }


    /**
     *
     * @return boolean
     */
    public boolean isValidateOnSelect ()
    {
        return this.isValidateOnSelect;
    }


    /**
     *
     * @param year int
     */
    public void setMaxYear (int year)
    {
        this.maxYear = year;

    }


    /**
     *
     * @param year int
     */
    public void setMinYear (int year)
    {
        this.minYear = year;
    }


    /**
     *
     * @param size FormElementSize
     */
    public void setSize (FormElementSize size)
    {
        super.setSize(size);
    }


    /**
     *
     */
    @SuppressWarnings("unchecked")
    protected void bindDatePartField ()
    {
        BlurHandler focusGroupHandler = new BlurHandler()
        {
            public void onBlur (final BlurEvent event)
            {
                Timer timer = new Timer()
                {
                    public void run ()
                    {
                        if (!DatePartField.this.daySelect.hasFocus()
                                &&  !DatePartField.this.monthSelect.hasFocus()
                                &&  !DatePartField.this.yearSelect.hasFocus())
                        {
                            DatePartField.this.fireEvent(new BwtBlurEvent());
                        }

                    }

                };

                timer.schedule(300);

            }
        };


        this.daySelect.addBlurHandler(focusGroupHandler);
        this.monthSelect.addBlurHandler(focusGroupHandler);
        this.yearSelect.addBlurHandler(focusGroupHandler);


        @SuppressWarnings("rawtypes")
        SelectHandler selectGroupHandler = new SelectHandler()
        {
            public void onSelect (SelectEvent event)
            {
                if (DatePartField.this.isValidateOnSelect())
                {
                    if (DatePartField.this.hasError()) 
                    	//|| (DatePartField.this.daySelect.hasValue()
                        //    &&  DatePartField.this.monthSelect.hasValue()
                        //    &&  !DatePartField.this.yearSelect.hasValue()))
                    {
                        DatePartField.this.validate(true);
                    }

                }
            }
        };


        this.daySelect.addSelectHandler(selectGroupHandler);
        this.monthSelect.addSelectHandler(selectGroupHandler);
        this.yearSelect.addSelectHandler(selectGroupHandler);
    }


    /**
     *
     */
    protected void onInitialAttach ()
    {
        super.onInitialAttach();

        this.populateYearField();
    }

    /**
     *
     */
    protected void onAttach ()
    {
        super.onAttach();

        BwtWidgetUtils.attachWidget(this.daySelect);
        BwtWidgetUtils.attachWidget(this.monthSelect);
        BwtWidgetUtils.attachWidget(this.yearSelect);
    }

    /**
     *
     */
    protected void onDetach ()
    {
        super.onDetach();

        BwtWidgetUtils.detachWidget(this.daySelect);
        BwtWidgetUtils.detachWidget(this.monthSelect);
        BwtWidgetUtils.detachWidget(this.yearSelect);
    }


    /**
     *
     */
    protected void populateDayField ()
    {
        for (int i = 1; i <= 31; ++i)
        {
            String value = i + "";

            if (i < 10)
            {
                value = "0" + value;
            }

            this.daySelect.add(value);
        }

    }


    /**
     *
     */
    protected void populateMonthField ()
    {
        this.monthSelect.add(new Item<String>("Jan", "01"));
        this.monthSelect.add(new Item<String>("Feb", "02"));
        this.monthSelect.add(new Item<String>("Mar", "03"));
        this.monthSelect.add(new Item<String>("Apr", "04"));
        this.monthSelect.add(new Item<String>("May", "05"));
        this.monthSelect.add(new Item<String>("Jun", "06"));
        this.monthSelect.add(new Item<String>("Jul", "07"));
        this.monthSelect.add(new Item<String>("Aug", "08"));
        this.monthSelect.add(new Item<String>("Sep", "09"));
        this.monthSelect.add(new Item<String>("Oct", "10"));
        this.monthSelect.add(new Item<String>("Nov", "11"));
        this.monthSelect.add(new Item<String>("Dec", "12"));
    }


    /**
     *
     */
    protected void populateYearField ()
    {
        for (int i = this.maxYear; i >= this.minYear; --i)
        {
            this.yearSelect.add(i + "");
        }
    }
}
