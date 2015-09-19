package chainPractical;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Debbie
 *	Filter tasks by priority - part of Chain of Responsibility
 */
public class PriorityFilter extends TaskListFilterer {
	private int priority;
	public PriorityFilter(TaskListFilterer nextProcessor, int priority) {
		super(nextProcessor);
		this.priority = priority;
	}

	@Override
	protected List<Task> applyFilter(List<Task> tasks) {
		List<Task> filteredTasks = new ArrayList<>();
		for( Task task : tasks){
			if ( task.getPriority() != null && task.getPriority() <= priority){
				filteredTasks.add(task);
			}
		}
		return filteredTasks;
	}

}
