package chainPractical;

import java.util.List;

public abstract class TaskListFilterer {
	protected TaskListFilterer nextProcessor;
	
	public TaskListFilterer(TaskListFilterer nextProcessor){
		this.nextProcessor = nextProcessor;
	}
	
	public final List<Task> filter(List<Task> tasks){
		List<Task> filteredTasks = applyFilter(tasks);
		if ( nextProcessor != null){
			return nextProcessor.filter(filteredTasks);
		} else {
			return filteredTasks;
		}
	}
	
	protected abstract List<Task> applyFilter(List<Task> tasks);
}
