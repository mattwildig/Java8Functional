package designPatterns.java8strategy;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
	public static void main(String args[]){
		Function<List<String>,String> csvFormatter = 
				(List<String> stringsToFormat)-> stringsToFormat.stream()
													.collect(Collectors.joining(","));
		StrategyPattern test1 = new StrategyPattern(csvFormatter);
				
		StrategyPattern test2 = new StrategyPattern((List<String> strings)-> 
			{return strings.stream()
					.sorted()
					.collect(
							Collectors.joining(System.getProperty("line.separator")));});
		
		test1.doStuff();
		System.out.println("---");
		test2.doStuff();
	}
}
