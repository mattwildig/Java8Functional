import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz{
	public static void main(String args[]){
		//imperative style loop 
		List<String> result = new ArrayList<>();
		for( int i=0; i< 10; ++i){
			if (i % 3 == 0 ) result.add("Fizz");
			else if (i % 5 == 0 ) result.add("Buzz");
			else result.add(Integer.toString(i));
		}
		for (String s : result){
			System.out.println(s);
		}
		
		System.out.println("----");
		
		//functional style
		IntFunction<String> fizzBuzz = (i)-> {
			if (i % 3 == 0 ) return "Fizz";
			else if (i % 5 == 0 ) return "Buzz";
			else return Integer.toString(i); 
		};
		List<String> result2 = IntStream.range(0, 10)
									.mapToObj(fizzBuzz)
									.collect(Collectors.toList());
		result2.stream().forEach(System.out::println);
	}
}