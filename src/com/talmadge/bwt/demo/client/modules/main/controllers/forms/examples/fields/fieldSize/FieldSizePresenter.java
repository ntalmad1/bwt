package com.talmadge.bwt.demo.client.modules.main.controllers.forms.examples.fields.fieldSize;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 *
 * @author Noah
 *
 */
public class FieldSizePresenter extends BwtExamplePresenter
{
    /**
     * Constructor
     *
     */
    public FieldSizePresenter ()
    {
        super();

        this.setView(new FieldSizeView(this));
    }


    /**
     *
     * @return DatePartFieldView
     */
    public FieldSizeView getView ()
    {
        return (FieldSizeView) super.getView();
    }
}
