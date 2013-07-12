package binders;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import play.data.binding.TypeBinder;

public class CommaSeperatedValueBinder implements TypeBinder<String> {
	 
	@Override
	public String[] bind(String name,
			java.lang.annotation.Annotation[] annotations, String value,
			Class actualClass, Type genericType) throws Exception {
		
		String[] split = value.split("\\s*,\\s");
		return split;
	}
}