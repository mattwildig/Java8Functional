

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaSamples {
	
	//Lambda passed into a method
	public boolean checkAllEven(List<Integer> numbers){
		boolean allEven = numbers.stream().allMatch(num->{ return num % 2 == 0;});
		return allEven;
	}
	
	//Lambda returned from a method
	public Predicate<Integer> getTest(){
		return ((Integer input)-> { return input % 2 == 0; });
	}
	
	//Lambda saved like a variable
	public boolean checkAllEven2(List<Integer> numbers){
		Predicate<Integer> predicate = ((Integer input)-> { return input % 2 == 0; });
		boolean allEven = numbers.stream().allMatch(predicate);
		return allEven;
	}
	//Method reference syntax
}