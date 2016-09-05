
public class Node{

	private final String start;
	private final String finish;
	private final String name;
	public Node(String aName, String aStart, String aFinish) {
		start = aStart;
		name = aName;
		finish = aFinish;
	}
	public boolean isFirst(Node other) {
		if (finish.equals(other.start))
			return true;
		else 
			return false;
	}
	
	public boolean isSecond(Node other) {
		if (start.equals(other.finish))
			return true;
		else 
			return false;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStart() {
		return start;
	}
	public String getFinish() {
		return finish;
	}


}
