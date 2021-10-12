package com.rgonzalez.test.web.app.models.entity.serializers;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.rgonzalez.test.web.app.models.entity.Brand;

public class BrandSerializer implements JsonSerializer<Brand>{

	@Override
	public JsonElement serialize(Brand src,Type typeOfSrc,JsonSerializationContext context) {
		JsonObject result = new JsonObject();
        result.add("id", new JsonPrimitive(src.getId()));
        result.add("descrip", new JsonPrimitive(src.getDescrip()));
        return result;
	}

	
	

}
