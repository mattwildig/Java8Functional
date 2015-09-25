package strategy;

import java.util.stream.Stream;
import java.util.function.Function;

public class StrategyPattern {
	private Function<Stream<String>, String> formattingStrategy;
	public StrategyPattern(Function<Stream<String>, String> strategy){
		this.formattingStrategy = strategy;
	}
	public void doStuff(){
		Stream<String> strings = Stream.of("apple","zebra","tree");
		System.out.println(formattingStrategy.apply(strings));
	}

}
