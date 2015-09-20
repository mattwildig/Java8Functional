package taskList;

/**
 * @author Debbie
 * Compare tasks by description - part of Chain of Responsibility
 */
public class DescriptionSorter extends TaskComparator {

	public DescriptionSorter(TaskComparator nextProcessor) {
		super(nextProcessor);
	}

	@Override
	protected int compareTasks(Task first, Task second) {
		return first.getDescription().compareTo(second.getDescription());
	}
}
