/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.forms.examples.fields.datetimepicker;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.widget.form.datetimepicker.DateTimePicker;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 *
 * @author Noah
 *
 */
public class DateTimePickerView extends BwtExampleView
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
     * @param presenter DatePickerPresenter
     */
    public DateTimePickerView (DateTimePickerPresenter presenter)
    {
        super(presenter, "Date picker");
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
        DateTimePicker datePicker = new DateTimePicker();

        tab.add(datePicker);
        //<=

    }
}