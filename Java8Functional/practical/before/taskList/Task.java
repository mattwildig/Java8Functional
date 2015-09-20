package taskList;

import java.time.LocalDate;

/**
 * @author Debbie
 * Represents a task in a to do list
 */
public class Task {
	
	private String tag;
	private LocalDate dueDate;
	private Integer priority;
	private String description;
	
	/**
	 * Create a task:
	 * @param tag			searchable label for task
	 * @param localDate		date task is due to be done
	 * @param priority		priority (lower number, higher priority)
	 * @param description	description of task
	 */
	public Task(String tag, LocalDate dueDate, Integer priority, String description){
		this.tag = tag;
		this.dueDate = dueDate;
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
