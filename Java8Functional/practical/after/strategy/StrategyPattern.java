package strategy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StrategyPattern {
	private Function<List<String>,String> formattingStrategy;
	public StrategyPattern(Function<List<String>,String> strategy){
		this.formattingStrategy = strategy;
	}
	public void doStuff(){
		List<String> strings = Arrays.asList("apple","zebra","tree");
		System.out.println(formattingStrategy.apply(strings));
	}

}
