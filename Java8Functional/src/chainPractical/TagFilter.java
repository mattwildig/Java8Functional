package chainPractical;

import java.util.ArrayList;
import java.util.List;

public class TagFilter extends TaskListFilterer {
	private String tagToMatch;
	public TagFilter(TaskListFilterer nextProcessor, String tagToMatch){
		super(nextProcessor);
		this.tagToMatch = tagToMatch;
	}
	@Override
	public List<Task> applyFilter(List<Task> tasks) {
		List<Task> filteredTasks = new ArrayList<>();
		for(Task task : tasks){
			if (task.getTag() != null && task.getTag().contains(tagToMatch)){
				filteredTasks.add(task);
			}
		}
		return filteredTasks;
	}
}
