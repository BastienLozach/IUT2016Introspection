package tpintrospection;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class ObjectMapperTest {

	@Test
	public void objectToJsonTest() {
		//Given
		Book book = new Book("mon Titre", new Author("prenom", "nom"));
		
		//When
		String json = ObjectMapper.objectToJson(book) ;
		System.out.println(json);

		//Then
		String expected = "" ;		
		Assert.assertEquals(expected, json);
		
	}

}
