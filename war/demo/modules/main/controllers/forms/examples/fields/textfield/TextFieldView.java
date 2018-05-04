/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.forms.examples.fields.textfield;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.form.constant.AddonPos;
import com.talmadge.bwt.core.client.ui.widget.form.valuefield.text.TextField;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 *
 * @author Noah
 *
 */
public class TextFieldView extends BwtExampleView
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
    public TextFieldView (TextFieldPresenter presenter)
    {
        super(presenter, "Text Field");
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
        TextField fieldOne = new TextField();
        fieldOne.setLabel("Example 1");
        tab.add(fieldOne);
        
        TextField fieldTwo = new TextField();
        fieldTwo.setLabel("Example 2");
        fieldTwo.setAddon(Glyphicon.USD, AddonPos.LEFT);
        fieldTwo.setAddon(".00", AddonPos.RIGHT);
        tab.add(fieldTwo);
        //<=

    }
}