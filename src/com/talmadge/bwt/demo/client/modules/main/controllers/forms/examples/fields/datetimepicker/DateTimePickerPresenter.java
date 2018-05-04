package com.talmadge.bwt.demo.client.modules.main.controllers.forms.examples.fields.datetimepicker;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 *
 * @author Noah
 *
 */
public class DateTimePickerPresenter extends BwtExamplePresenter
{
    /**
     * Constructor
     *
     */
    public DateTimePickerPresenter ()
    {
        super();

        this.setView(new DateTimePickerView(this));
    }


    /**
     *
     * @return DatePartFieldView
     */
    public DateTimePickerView getView ()
    {
        return (DateTimePickerView) super.getView();
    }
}
