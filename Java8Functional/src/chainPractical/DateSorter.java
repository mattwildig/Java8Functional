package chainPractical;

public class DateSorter extends TaskComparator {

	public DateSorter(TaskComparator nextProcessor) {
		super(nextProcessor);
	}

	@Override
	protected int compareTasks(Task first, Task second) {
		return first.getDueDate().compareTo(second.getDueDate());
	}
}
