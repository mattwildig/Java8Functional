package taskList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Debbie
 * Class to sort a list of Task given a TaskComparator chain
 */
public class TaskListSorter {
	private TaskComparator comparatorChain;
	
	/**
	 * @param comparatorChain - chain of comparisons to be applied by sort
	 */
	public TaskListSorter(TaskComparator comparatorChain){
		this.comparatorChain = comparatorChain;
	}
	
	/**
	 * @param tasks list to be sorted
	 * @return		sorted list of Task
	 */
	public List<Task> sort(List<Task> tasks) {
		List<Task> sortedTasks = new ArrayList<>(tasks);
		Collections.sort(sortedTasks, comparatorChain);
		return sortedTasks;
	}
}
