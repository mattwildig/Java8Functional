package taskList;

import java.util.Comparator;

/**
 * @author Debbie
 * Class implementing Chain of Responsibility for comparing Task objects
 * may be used for sorting a list.
 */
public abstract class TaskComparator implements Comparator<Task>{
	private TaskComparator nextComparator;
	
	/**
	 * @param nextComparator
	 */
	public TaskComparator(TaskComparator nextComparator){
		this.nextComparator = nextComparator;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * Implementation of compare using chain of comparisons
	 */
	@Override
	public int compare(Task first, Task second) {
		int firstComparison = compareTasks(first, second);
		if (nextComparator != null && firstComparison == 0){
			return nextComparator.compare(first, second);
		} else {
			return firstComparison;
		}
	}
	
	/**
	 * @param first
	 * @param second
	 * @return
	 */
	protected abstract int compareTasks(Task first, Task second);
}