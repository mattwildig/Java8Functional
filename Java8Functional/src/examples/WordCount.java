package examples;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Debbie
 * Example code used in presentation 
 *
 */
public class WordCount {
	
	/**
	 * Used in slides to illustrate internal iteration and mutating state
	 * @param words 	list of strings to be searched for matches
	 * @param pattern 	string to search for
	 * @return			count of strings in words containing pattern
	 */
	public int imperativeCount(List<String> words, String pattern){
		int count =0;
		for( String word : words){
			if (word.equals(pattern)){
				++count;
			}
		}
		return count;
	}
	
	/**
	 * Used in slides to illustrate functional equivalent to imperativeCount
	 * @param words 	list of strings to be searched for matches  
	 * @param pattern 	string to search for                        
	 * @return			count of strings in words containing pattern
	 */
	public long functionalCount(List<String> words, String pattern){
		long count = words.stream()
				.filter((word)-> {return word.equals(pattern);})
				.count();
		return count;
	}
	
	/**
	 * Used in slides to illustrate function composition
	 * @param books
	 */
	public void functionComposition(List<Book> books){
		//Comparator.comparing could be statically included to clean up syntax
		//but left here to show where it comes from
		List<Book> sortedBooks = books.stream()
			.sorted(Comparator.comparing(Book::getAuthor).thenComparing(Book::getTitle))
			.collect(Collectors.toList());
	}
	
	/**
	 * Class used purely for illustration in function composition above
	 * @author Debbie
	 *
	 */
	private class Book {
		private String title;
		private String author;
		private LocalDate publicationDate;

		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public LocalDate getPublicationDate() {
			return publicationDate;
		}
		public void setPublicationDate(LocalDate publicationDate) {
			this.publicationDate = publicationDate;
		}
	}
}
