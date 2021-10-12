package com.rgonzalez.test.web.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rgonzalez.test.web.app.models.services.BrandService;

@Component
public class BrandPropertyEditor extends PropertyEditorSupport{

	@Autowired
	private BrandService brandService;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(text != null && text.length()>0) {
			Integer id= Integer.parseInt(text);
			this.setValue(brandService.getbyId(id));
		}
		else {
			this.setValue(null);
		}
	}

	
	
}
