package taskListRefactored;

import java.time.LocalDate;
//filter by tag, by due date, by description
//sort by date and/or priority
public class Task {
	
	private String tag;
	private LocalDate dueDate;
	private Integer priority;
	private String description;
	
	public Task(String tag, LocalDate localDate, Integer priority, String description){
		this.tag = tag;
		this.dueDate = localDate;
		this.priority = priority;
		this.description = description;
	}
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Task [tag=" + tag + ", dueDate=" + dueDate + ", priority=" + priority + ", description=" + description
				+ "]";
	}
}
