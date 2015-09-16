package practical;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DateSorter implements TaskSorter {

	@Override
	public List<Task> sort(List<Task> tasks) {
		List<Task> sortedTasks = new ArrayList<>(tasks);
		Collections.sort(sortedTasks, new DateComparator());
		return sortedTasks;
	}

	private class DateComparator implements Comparator<Task>{

		@Override
		public int compare(Task first, Task second) {
			return first.getDueDate().compareTo(second.getDueDate());
		}
		
	}
}
