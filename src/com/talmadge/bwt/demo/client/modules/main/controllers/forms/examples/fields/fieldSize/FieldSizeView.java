/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.forms.examples.fields.fieldSize;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.FormElementSize;
import com.talmadge.bwt.core.client.ui.widget.form.constant.AddonPos;
import com.talmadge.bwt.core.client.ui.widget.form.valuefield.text.TextField;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 *
 * @author Noah
 *
 */
public class FieldSizeView extends BwtExampleView
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
    public FieldSizeView (FieldSizePresenter presenter)
    {
        super(presenter, "Field Size");
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
        TextField field1 = new TextField();
        field1.setSize(FormElementSize.LARGE);
        field1.setAddon("@", AddonPos.LEFT);
        field1.setPlaceholder("Username");
        tab.add(field1);
        
        TextField field2 = new TextField();
        field2.setSize(FormElementSize.NORMAL);
        field2.setAddon("@", AddonPos.LEFT);
        field2.setPlaceholder("Username");
        tab.add(field2);
        
        TextField field3 = new TextField();
        field3.setSize(FormElementSize.SMALL);
        field3.setAddon("@", AddonPos.LEFT);
        field3.setPlaceholder("Username");
        tab.add(field3);
        //<=

    }
}