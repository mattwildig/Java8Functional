package chainPractical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskListSorter {
	private TaskComparator comparatorChain;
	public TaskListSorter(TaskComparator comparatorChain){
		this.comparatorChain = comparatorChain;
	}
	
	public List<Task> sort(List<Task> tasks) {
		List<Task> sortedTasks = new ArrayList<>(tasks);
		Collections.sort(sortedTasks, comparatorChain);
		return sortedTasks;
	}
}
