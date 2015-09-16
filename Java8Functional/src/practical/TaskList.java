package practical;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
	public static void main(String args[]){
		List<Task> tasks = getTasks(); 
		TaskProcessor dateSortedAdminTagProcessor = new TaskProcessor(new TagFilter("admin"), 
																		 new DateSorter());
		List<Task> dateSortedAdminTasks = dateSortedAdminTagProcessor.filterAndSortTasks(tasks);
		for( Task task : dateSortedAdminTasks){
			System.out.println(task);
		}
	}
	
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
		tasks.add(new Task("admin", LocalDate.of(2015,Month.SEPTEMBER, 21), 1, "pay bill"));
		tasks.add(new Task("java", LocalDate.of(2015,Month.SEPTEMBER, 29), 2, "pay bill"));
		tasks.add(new Task("admin", LocalDate.of(2015,Month.SEPTEMBER, 17), 3, "pay bill"));
		tasks.add(new Task("admin", LocalDate.of(2015,Month.SEPTEMBER, 28), 1, "pay bill"));
		return tasks;
	}
}
