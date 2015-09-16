package practical;

public class TagFilter implements TaskFilter {
	private String tagToMatch;
	public TagFilter(String tagToMatch){
		this.tagToMatch = tagToMatch;
	}
	@Override
	public boolean matches(Task task) {
		if (task.getTag() != null && task.getTag().contains(tagToMatch)){
			return true;
		} else {
			return false;
		}
	}

}
