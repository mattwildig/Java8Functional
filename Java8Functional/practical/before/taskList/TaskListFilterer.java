package taskList;

import java.util.List;

/**
 * @author Debbie
 * Filter for list of Task, uses Chain of Responsibility pattern to 
 * implement and chain together different filter types
 */
public abstract class TaskListFilterer {
	protected TaskListFilterer nextProcessor;
	
	/**
	 * @param nextProcessor Next element in chain of responsibility, 
	 * 						or null if this is the final one
	 */
	public TaskListFilterer(TaskListFilterer nextProcessor){
		this.nextProcessor = nextProcessor;
	}
	
	/**
	 * Apply all the filters in the chain in order
	 * @param tasks -	list to be filtered
	 * @return			filtered list
	 */
	public final List<Task> filter(List<Task> tasks){
		List<Task> filteredTasks = applyFilter(tasks);
		if ( nextProcessor != null){
			return nextProcessor.filter(filteredTasks);
		} else {
			return filteredTasks;
		}
	}
	
	/**
	 * To be implemented by specialisations- apply the actual filter
	 * @param tasks	-	list to be filtered
	 * @return 			filtered list
	 */
	protected abstract List<Task> applyFilter(List<Task> tasks);
}
