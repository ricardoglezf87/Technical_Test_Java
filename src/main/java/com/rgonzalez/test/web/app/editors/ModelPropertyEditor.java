package com.rgonzalez.test.web.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rgonzalez.test.web.app.models.services.ModelService;

@Component
public class ModelPropertyEditor extends PropertyEditorSupport{

	@Autowired
	private ModelService modelService;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(text != null && text.length()>0) {
			Integer id= Integer.parseInt(text);
			this.setValue(modelService.getbyId(id));
		}
		else {
			this.setValue(null);
		}
	}

	
	
}
