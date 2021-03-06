package strategy;

import java.util.Collections;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Main {
	public static void main(String args[]){
		StrategyPattern test1 = new StrategyPattern(
			list -> list.collect(joining(","))
		);

		StrategyPattern test2 = new StrategyPattern(
			list -> list.sorted().collect(joining("\n", "", "\n"))
		);
		
		test1.doStuff();
		System.out.println("---");
		test2.doStuff();
	}
}
