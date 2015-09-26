package filesearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.function.Predicate.isEqual;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.summarizingInt;

public class FileSearch {
	//Regular expression to match word boundaries (space & punctuation)
	private static final String WORD_REGEXP = "[- .:,;!?]+";
	private static final Pattern wordMatcher = Pattern.compile(WORD_REGEXP);

	/**
	 * Count the number of words that match supplied word in supplied file
	 * @param file			file to process
	 * @param wordToMatch	word to look for
	 * @return				number of matches
	 */
	public int countInstances(String file, String wordToMatch){
		return processText(file, f -> (int)f.filter(isEqual(wordToMatch)).count());
	}
	
	/**
	 * Count the number of words in supplied file
	 * @param file	file to process
	 * @return		total number of words
	 */
	public int countWords(String file){
		return processText(file, f -> (int)f.count());
	}

	/**
	 * Count the number of different words in supplied file
	 * uses case-insensitive match.
	 * @param file	file to process
	 * @return		total number of different words
	 */
	public int countDistinctWords(String file){
		return processText(file, f -> (int)f.map(String::toLowerCase)
				.distinct()
				.count());
	}

	/**
	 * Count the number of letters in the longest word in supplied file
	 * uses case-insensitive match.
	 * @param file	file to process
	 * @return		length of longest word
	 */
	public int longestWordLength(String file){
		return processText(file, f -> f.collect(summarizingInt(String::length)).getMax());
	}

	private int processText(String file, Function<Stream<String>, Integer> f) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
			getClass().getResourceAsStream(file), StandardCharsets.UTF_8))) {

			return f.apply(reader.lines()
				.filter(((Predicate<String>)String::isEmpty).negate())
				.flatMap(wordMatcher::splitAsStream));

		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static void main(String args[]){
		FileSearch fs = new FileSearch();
		System.out.println("number of words: " + fs.countWords("Ode.txt"));
		System.out.println("number of 'thy': " + fs.countInstances("Ode.txt", "thy"));
		System.out.println("number of distinct words: " + fs.countDistinctWords("Ode.txt"));
		System.out.println("length of longest word: " + fs.longestWordLength("Ode.txt"));
	}
}
