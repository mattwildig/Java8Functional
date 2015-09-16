package designPatterns.strategy;

import java.util.Arrays;
import java.util.List;

public class StrategyPattern {
	private Formatter formattingStrategy;
	public StrategyPattern(Formatter strategy){
		this.formattingStrategy = strategy;
	}
	public void doStuff(){
		List<String> strings = Arrays.asList("apple","zebra","tree");
		System.out.println(formattingStrategy.format(strings));
	}

}
