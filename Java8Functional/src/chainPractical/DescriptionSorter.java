package chainPractical;

public class DescriptionSorter extends TaskComparator {

	public DescriptionSorter(TaskComparator nextProcessor) {
		super(nextProcessor);
	}

	@Override
	protected int compareTasks(Task first, Task second) {
		return first.getDescription().compareTo(second.getDescription());
	}
}
