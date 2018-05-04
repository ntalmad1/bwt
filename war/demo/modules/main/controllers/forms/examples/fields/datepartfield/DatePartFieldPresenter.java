package com.talmadge.bwt.demo.client.modules.main.controllers.forms.examples.fields.datepartfield;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 *
 * @author Noah
 *
 */
public class DatePartFieldPresenter extends BwtExamplePresenter
{
    /**
     * Constructor
     *
     */
    public DatePartFieldPresenter ()
    {
        super();

        this.setView(new DatePartFieldView(this));
    }


    /**
     *
     * @return DatePartFieldView
     */
    public DatePartFieldView getView ()
    {
        return (DatePartFieldView) super.getView();
    }
}
