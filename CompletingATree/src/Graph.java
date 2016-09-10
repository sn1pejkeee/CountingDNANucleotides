import java.util.ArrayList;
import java.util.List;

public class Graph {
	private boolean[] mark;
	private ArrayList<ArrayList<Integer>> edges;
	
	public Graph(List<String> lines) {
		int n = Integer.parseInt(lines.get(0));
		edges = new ArrayList<>(n);
		
		mark = new boolean[n];
		for (int i = 0; i <= n - 1; i++) {
			mark[i] = false;
			ArrayList<Integer> q = new ArrayList<>();
			edges.add(q);
		}
		lines.remove(0);
		int index1;
		int index2;
		for (String token : lines) {
			index1 = Integer.parseInt(token.substring(0, token.indexOf(' '))) - 1;
			index2 = Integer.parseInt(token.substring(token.indexOf(' ') + 1)) - 1;
			//if (edges.)
			//	System.out.println("LUL");
			edges.get(index1).add(index2);
			edges.get(index2).add(index1);
		}
	}
	
	public void dfs(int v) {
		if (mark[v])
			return;
		mark[v] = true;
		for (int i = 0; i < edges.get(v).size(); i++)
			dfs(edges.get(v).get(i));
	}
	
	public int notVisited() {
		for (int i = 0; i <= mark.length - 1; i++)
			if (!mark[i])
				return i;
		return -1;
	}
	
	public int counter() {
		int count = -1;
		while (notVisited() >= 0) {
			dfs(notVisited());
			//System.out.println(notVisited());
			count++;
		}
		return count;
	}
}
