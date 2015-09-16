package designPatterns.strategy;

import java.util.Collections;
import java.util.List;

class SortedLineFormatter implements Formatter{

	@Override
	public String format(List<String> unformattedString) {
		Collections.sort(unformattedString);
		StringBuilder formattedString = new StringBuilder();
		for( String element : unformattedString){
			formattedString.append(element).append('\n');
		}
		return formattedString.toString();
	}
	
}