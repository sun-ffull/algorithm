import java.util.*;

class Node implements Comparable<Node>{
	int n;
	int visited=0;
	PriorityQueue<Node> nei = new PriorityQueue<Node>();
	
	Node (int n){
		this.n = n;
	}
	
	public int compareTo(Node target) {
		if (this.n < target.n) {
			return -1;
		}
		else {
			return 1;
		}
	}
}


public class Main {
	
	public static Node Dnodes[] = new Node[1001];
	public static Node Bnodes[] = new Node[1001];
	
	public static ArrayList<Integer> Dresult = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int V = scan.nextInt();
		
		for (int i=0; i<M; i++) {
			int s = scan.nextInt();
			int e = scan.nextInt();
			
			if (Dnodes[s] == null) {
				Dnodes[s] = new Node(s);
				Bnodes[s] = new Node(s);
			}
			if (Dnodes[e] == null) {
				Dnodes[e] = new Node(e);
				Bnodes[e] = new Node(e);
			}
			
			Dnodes[s].nei.add(Dnodes[e]);
			Dnodes[e].nei.add(Dnodes[s]);
			
			Bnodes[s].nei.add(Bnodes[e]);
			Bnodes[e].nei.add(Bnodes[s]);
		}
		if (Dnodes[V] == null) {
			System.out.printf("%d ", V);
			System.out.printf("%d ", V);
			return;
		}
		
		DFS(V);
		
		for (int i=0; i<Dresult.size(); i++) {
			System.out.printf("%d ", Dresult.get(i));
		}
		System.out.println();
		
		ArrayList<Integer> Bresult = BFS(V);
		
		for (int i=0; i<Bresult.size(); i++) {
			System.out.printf("%d ", Bresult.get(i));
		}
	}
	
	static void DFS(int V){
		if (Dnodes[V].visited == 1) {
			return;
		}
		
		Dresult.add(V);
		Dnodes[V].visited = 1;
		
		while (Dnodes[V].nei.size() > 0) {
			DFS(Dnodes[V].nei.poll().n);
		}
	}
	
	static ArrayList<Integer> BFS(int V) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Queue<Node> q = new LinkedList<Node>();
		
		Bnodes[V].visited = 1;
		result.add(V);
		while (Bnodes[V].nei.size() > 0) {
			q.add(Bnodes[V].nei.poll());
		}
		
		while (q.peek() != null) {
			Node tmp = q.poll();
			if (tmp.visited == 1) {
				continue;
			}
			tmp.visited = 1;
			result.add(tmp.n);
			while (tmp.nei.size() > 0) {
				Node tmp2 = tmp.nei.poll();
				if (tmp2.visited != 1) {
					q.add(tmp2);
				}
			}
		}
		
		return result;
	}

}
