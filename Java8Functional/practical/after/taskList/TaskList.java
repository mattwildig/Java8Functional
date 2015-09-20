package taskList;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskList {
	private static Predicate<Task> tagFilter(String tagToMatch){
		return (task)-> task.getTag() != null && task.getTag().contains(tagToMatch);
	}
	
	private static Predicate<Task> priorityFilter(int priority){
		return (task) -> task.getPriority() != null && task.getPriority() <= priority;
	}
	public static void main(String args[]){
		List<Task> tasks = getTasks(); 
		
		System.out.println("Tasks by tag 'admin' sorted by dueDate");
		tasks.stream()
			.filter(tagFilter("admin"))
			.sorted(Comparator.comparing(Task::getDueDate))
			.forEach(System.out::println);
		
		System.out.println("----");
		System.out.println("Tasks by tag 'admin' and priority < 2 sorted by dueDate");
		
		tasks.stream()
			.filter(tagFilter("admin").and(priorityFilter(2)))
			.sorted(Comparator.comparing(Task::getDueDate))
			.forEach(System.out::println);
		
		System.out.println("----");
		System.out.println("Tasks by tag 'admin' and priority < 2 sorted by dueDate then description");
		
		tasks.stream()
			.filter(tagFilter("admin").and(priorityFilter(2)))
			.sorted(Comparator.comparing(Task::getDueDate).thenComparing(Task::getDescription))
			.forEach(System.out::println);
	}
	
	private static List<Task> getTasks(){
		List<Task> tasks = Stream.of(
				new Task("java", LocalDate.of(2015,Month.SEPTEMBER, 23), 1, "java8 talk"),
				new Task("admin", LocalDate.of(2015,Month.SEPTEMBER, 16), 1, "pay bill"),
				new Task("admin", LocalDate.of(2015,Month.NOVEMBER, 1), 2, "write letter"),
				new Task("misc", LocalDate.of(2015,Month.OCTOBER, 20), 1, "buy fish"),
				new Task("admin", LocalDate.of(2015,Month.SEPTEMBER, 10), 3, "book holiday"),
				new Task("java", LocalDate.of(2015,Month.SEPTEMBER, 20), 2, "refactoring"),
				new Task("misc", LocalDate.of(2015,Month.SEPTEMBER, 30), 4, "return library books"),
				new Task("admin", LocalDate.of(2015,Month.SEPTEMBER, 16), 1, "make list"),
				new Task("admin", LocalDate.of(2015,Month.SEPTEMBER, 14), 1, "anything"),
				new Task("misc", LocalDate.of(2015,Month.SEPTEMBER, 20), 4, "pay bill"),
				new Task("admin", LocalDate.of(2015,Month.SEPTEMBER, 21), 1, "add entry"),
				new Task("java", LocalDate.of(2015,Month.SEPTEMBER, 29), 2, "pay bill"),
				new Task("admin", LocalDate.of(2015,Month.SEPTEMBER, 17), 3, "pay bill"),
				new Task("admin", LocalDate.of(2015,Month.SEPTEMBER, 28), 1, "pay bill"))
				.collect(Collectors.toList());
		return tasks;
	}
}
