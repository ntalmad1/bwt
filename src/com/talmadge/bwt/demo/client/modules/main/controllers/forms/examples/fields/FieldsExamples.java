package com.talmadge.bwt.demo.client.modules.main.controllers.forms.examples.fields;

import com.talmadge.bwt.demo.client.lib.example.BwtExampleGroup;
import com.talmadge.bwt.demo.client.modules.main.controllers.forms.examples.fields.datepartfield.DatePartFieldPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.forms.examples.fields.datetimepicker.DateTimePickerPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.forms.examples.fields.fieldSize.FieldSizePresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.forms.examples.fields.textfield.TextFieldPresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 *
 * @author Noah
 *
 */
public class FieldsExamples extends BwtExampleGroup
{


    /**
     * Constructor
     *
     */
	public FieldsExamples (BwtDemoSidebar sidebar)
    {
        super();
        this.setView(new FieldsView(this));
        
        this.addExample(new TextFieldPresenter());
        this.addExample(new FieldSizePresenter());
        this.addExample(new DatePartFieldPresenter());
        this.addExample(new DateTimePickerPresenter());

        this.populateSideNav(sidebar);
	}
}
