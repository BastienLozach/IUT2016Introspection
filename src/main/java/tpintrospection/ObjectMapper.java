package tpintrospection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;

public class ObjectMapper {
	
	private static String[] primitivesArray = {"int", "java.lang.String"} ;
	
	
	public static String objectToJson(Object object){
		return "{\n" + objectToJson(object, 1) + "\n}" ;
	}

	private static String objectToJson(Object object, int tabNumbers){
		//tabulation
		String tab = "";
		for (int i = 0 ; i < tabNumbers ; i++){
			tab += "\t";
		}
		
		//introspection
		
		Class<?> classObject = object.getClass() ;
		Field[] fieldTab = classObject.getDeclaredFields();
		
		//Exclude primitives types and Strings
		if (classObject.isPrimitive() || classObject.equals("".getClass())){
			String json = "" ;
			json += tab + "\t" ;
			
			if(classObject.isPrimitive() || object == null){
				json += ""+ object ;
			} else {
				json += ""+'"' + object + '"' ;
			}
			
			return json ;
		}
		
		//opening		
		String json = tab + '"' + classObject.getSimpleName() + '"' + ": { \n";
				
		//body
		for(Field f : fieldTab){
			try {
				f.setAccessible(true);
				if (f.getType().isPrimitive() || f.getType().equals("".getClass())){
					json += tab + "\t" + '"' + f.getName() + '"' + ":" ;
					
					if(f.getType().isPrimitive() || f.get(object) == null){
						json += ""+ f.get(object) + "\n" ;
					} else {
						json += ""+'"' + f.get(object) + '"' + "\n" ;
					}
				} else if (f.get(object) instanceof Collection<?>){
					json += tab + "\t" + '"' + f.getName() + '"' + ": [\n" ;
					for (Object o : (Collection)f.get(object)){
						json += "\n" + objectToJson(o, tabNumbers+2) +",";
					}
					json = json.substring(0, json.length()-1);
					json += "\n"+ tab + "\t" + "] \n";
				
				} else {
					json += objectToJson(f.get(object), tabNumbers+1) + "\n";
				}
				
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//closure and return
		return json + tab + "}" ;
	}
	
	
}
