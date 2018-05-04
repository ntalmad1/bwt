/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.forms.examples.fields.datepartfield;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.widget.form.datepartfield.DatePartField;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 *
 * @author Noah
 *
 */
public class DatePartFieldView extends BwtExampleView
{
    /**
     */
    protected interface Resources extends ClientBundle, BwtExampleView.Resources
    {
        /**
         */
        Resources INSTANCE = GWT.create(Resources.class);

        /**
         *
         * @return TextResource
         */
        TextResource code ();
    }


    /**
     * Constructor
     *
     * @param presenter DatePartFieldPresenter
     */
    public DatePartFieldView (DatePartFieldPresenter presenter)
    {
        super(presenter, "Date part field");
    }



    /**
     *
     * @return String
     */
    protected String getCodeRawText ()
    {
        return Resources.INSTANCE.code().getText();
    }



    /**
     *
     * @param tab Tab
     */
    protected void populateExamplesTab (Tab tab)
    {
        //=>
        DatePartField field = new DatePartField();
        field.setRequired(true);

        tab.add(field);

        //<=

    }
}