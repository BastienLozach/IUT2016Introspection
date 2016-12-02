package tpintrospection;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		String[] typeArray = {"int", "String"} ;
		
		//System.out.println(getClass().getName());
		//System.out.println(Arrays.asList(typeArray).contains("String"));
		
		
		Book book = new Book("mon Titre", new Author("prenom", "nom"), 55);
		
		String json = ObjectMapper.objectToJson(book) ;
		
		System.out.println(json);

	}

}
