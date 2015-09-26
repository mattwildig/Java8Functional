package taskList;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
import java.util.Comparator;

import static java.util.Comparator.comparing;

public class TaskList {
	
	/* (non-Javadoc)
	 * tests for TaskListProcessor
	 */
	public static void main(String args[]){
		List<Task> tasks = getTasks();

		System.out.println("Tasks by tag 'admin' sorted by dueDate");

		tasks.stream()
			.filter(t -> t.getTag() != null && t.getTag().contains("admin"))
			.sorted(comparing(Task::getDueDate))
			.forEach(System.out::println);

		System.out.println("----");
		
		System.out.println("Tasks by tag 'admin' and priority <= 2 sorted by dueDate");

		tasks.stream()
			.filter(t -> t.getTag() != null && t.getTag().contains("admin"))
			.filter(t -> t.getPriority() != null && t.getPriority() <= 2)
			.sorted(comparing(Task::getDueDate))
			.forEach(System.out::println);

		System.out.println("----");

		System.out.println("Tasks by tag 'admin' and priority < 2 sorted by dueDate then description");

		tasks.stream()
			.filter(t -> t.getTag() != null && t.getTag().contains("admin"))
			.filter(t -> t.getPriority() != null && t.getPriority() <= 2)
			.sorted(
				comparing(Task::getDueDate)
				.thenComparing(comparing(Task::getDescription))
			)
			.forEach(System.out::println);

	}
	
	//Generate test data
	private static List<Task> getTasks(){
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task("java", LocalDate.of(2015,Month.SEPTEMBER, 23), 1, "java8 talk"));
		tasks.add(new Task("admin", LocalDate.of(2015,Month.SEPTEMBER, 16), 1, "pay bill"));
		tasks.add(new Task("admin", LocalDate.of(2015,Month.NOVEMBER, 1), 2, "write letter"));
		tasks.add(new Task("misc", LocalDate.of(2015,Month.OCTOBER, 20), 1, "buy fish"));
		tasks.add(new Task("admin", LocalDate.of(2015,Month.SEPTEMBER, 10), 3, "book holiday"));
		tasks.add(new Task("java", LocalDate.of(2015,Month.SEPTEMBER, 20), 2, "refactoring"));
		tasks.add(new Task("misc", LocalDate.of(2015,Month.SEPTEMBER, 30), 4, "return library books"));
		tasks.add(new Task("admin", LocalDate.of(2015,Month.SEPTEMBER, 16), 1, "make list"));
		tasks.add(new Task("admin", LocalDate.of(2015,Month.SEPTEMBER, 14), 1, "anything"));
		tasks.add(new Task("misc", LocalDate.of(2015,Month.SEPTEMBER, 20), 4, "pay bill"));
		tasks.add(new Task("admin", LocalDate.of(2015,Month.SEPTEMBER, 21), 1, "add entry"));
		tasks.add(new Task("java", LocalDate.of(2015,Month.SEPTEMBER, 29), 2, "pay bill"));
		tasks.add(new Task("admin", LocalDate.of(2015,Month.SEPTEMBER, 17), 3, "pay bill"));
		tasks.add(new Task("admin", LocalDate.of(2015,Month.SEPTEMBER, 28), 1, "pay bill"));
		return tasks;
	}
}
