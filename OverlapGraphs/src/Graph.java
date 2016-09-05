import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Graph {
	private HashMap<String, Set<Node>> startingSymbols;
	private HashMap<String, Set<Node>> endingSymbols;
	private ArrayList<String> lines;
	
	public Graph() {
		startingSymbols = new HashMap<>();
		endingSymbols = new  HashMap<>();
		lines = new ArrayList<>();
		
	}
	
	public void addNew(Node aNode) {
		if (startingSymbols.containsKey(aNode.getFinish())) 
			for (Iterator<Node> it = startingSymbols.get(aNode.getFinish()).iterator(); it.hasNext();) 
				lines.add(aNode.getName() + " " + it.next().getName());
		if (endingSymbols.containsKey(aNode.getStart())) 
			for (Iterator<Node> it = endingSymbols.get(aNode.getStart()).iterator(); it.hasNext();) 
				lines.add(it.next().getName() + " " + aNode.getName());
		if (startingSymbols.containsKey(aNode.getStart()))
			startingSymbols.get(aNode.getStart()).add(aNode);
		else {
			HashSet<Node> nodeList = new HashSet<>();
			nodeList.add(aNode);
			startingSymbols.put(aNode.getStart(), nodeList);
		}
		
		if (endingSymbols.containsKey(aNode.getFinish()))
			endingSymbols.get(aNode.getFinish()).add(aNode);
		else {
			HashSet<Node> nodeList = new HashSet<>();
			nodeList.add(aNode);
			endingSymbols.put(aNode.getFinish(), nodeList);
		}
	}
	
	public ArrayList<String> getInfo() {
		return lines;
	}
}
