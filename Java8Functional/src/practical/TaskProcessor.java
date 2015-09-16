package practical;

import java.util.ArrayList;
import java.util.List;

public class TaskProcessor {
	private TaskFilter filter;
	private TaskSorter sorter;
	
	public TaskProcessor(TaskFilter filter, TaskSorter sorter){
		this.filter = filter;
		this.sorter = sorter;
	}
	
	public List<Task> filterAndSortTasks(List<Task> tasks){
		List<Task> filteredTasks = new ArrayList<>();
		for(Task task : tasks){
			if (filter.matches(task)){
				filteredTasks.add(task);
			}
		}
		return sorter.sort(filteredTasks);
	}
}
