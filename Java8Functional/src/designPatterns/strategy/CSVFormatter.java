package designPatterns.strategy;

import java.util.List;

class CSVFormatter implements Formatter{

	@Override
	public String format(List<String> unformattedString) {
		StringBuilder formattedString = new StringBuilder();
		for(String element : unformattedString ){
			formattedString.append(element).append(",");		
		}
		return formattedString.substring(0, formattedString.length()-1);
	}
}