package tpintrospection;

import java.util.ArrayList;
import java.util.List;

public class Book {
	
	private String title;
	private Author author;
	private String resume;
	private int pageNumber ;
	
	private List<String> liste = new ArrayList<String>();
	
	

	public Book(String title, Author author) {
		super();
		this.title = title;
		this.author = author;
	}
	
	
	
	public Book(String title, Author author, int pageNumber) {
		super();
		this.title = title;
		this.author = author;
		this.pageNumber = pageNumber;
		
		liste.add("test");
		liste.add("test2");
	}

	public Book(String title, Author author, String resume) {
		super();
		this.title = title;
		this.author = author;
		this.resume = resume;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	

}
