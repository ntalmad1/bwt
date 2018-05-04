package com.talmadge.bwt.demo.client.modules.main.controllers.forms.examples.fields.textfield;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 *
 * @author Noah
 *
 */
public class TextFieldPresenter extends BwtExamplePresenter
{
    /**
     * Constructor
     *
     */
    public TextFieldPresenter ()
    {
        super();

        this.setView(new TextFieldView(this));
    }


    /**
     *
     * @return DatePartFieldView
     */
    public TextFieldView getView ()
    {
        return (TextFieldView) super.getView();
    }
}
