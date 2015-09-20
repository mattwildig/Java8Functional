package strategy;

public class Main {
	public static void main(String args[]){
		StrategyPattern test1 = new StrategyPattern(new CSVFormatter());
		StrategyPattern test2 = new StrategyPattern(new SortedLineFormatter());
		
		test1.doStuff();
		System.out.println("---");
		test2.doStuff();
	}
}
