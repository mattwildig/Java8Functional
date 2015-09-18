package chainPractical;

import java.util.Comparator;

public abstract class TaskComparator implements Comparator<Task>{
	private TaskComparator nextComparator;
	
	public TaskComparator(TaskComparator nextComparator){
		this.nextComparator = nextComparator;
	}
	
	@Override
	public int compare(Task first, Task second) {
		int firstComparison = compareTasks(first, second);
		if (nextComparator != null && firstComparison == 0){
			return nextComparator.compare(first, second);
		} else {
			return firstComparison;
		}
	}
	
	protected abstract int compareTasks(Task first, Task second);
}