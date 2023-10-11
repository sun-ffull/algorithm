import java.io.*;
import java.util.*;

class Node {
	LinkedList<Edge> nei = new LinkedList<Edge>();
}

class Edge{
	int destination;
	int value;
	
	Edge(int d, int v){
		destination = d;
		value = v;
	}
}

class route implements Comparable<route>{
	int routeValue;
	int nodeIndex;
	
	route(int r, int n){
		routeValue = r;
		nodeIndex = n;
	}
	
	public int compareTo(route target) {
		if (this.routeValue < target.routeValue) {
			return -1;
		}
		else if (this.routeValue > target.routeValue) {
			return 1;
		}
		return 0;
	}
}

public class Main {
	
	public static Node nodes[] = new Node[20001];
	public static int V;
	public static int E;
	public static int routeV[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		
		int index=0;
		int destination;
		int value;
		for (int i=1; i<V+1; i++) {
			nodes[i] = new Node();
		}
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			index = Integer.parseInt(st.nextToken());
			destination = Integer.parseInt(st.nextToken());
			value = Integer.parseInt(st.nextToken());
			nodes[index].nei.add(new Edge(destination, value));
		}
		
		dijkstra(start);
		
		for (int i=1; i<V+1; i++) {
			if (routeV[i] == 1000000000) {
				System.out.printf("%s\n", "INF");
			}
			else {
				System.out.printf("%d\n", routeV[i]);
			}
		}
	}

	static void dijkstra(int start) {
		PriorityQueue<route> pq = new PriorityQueue<route>();
		int visited[] = new int[V+1];
		routeV = new int[V+1];
		route tmp;
		
		for (int i=1; i<V+1; i++) {
			routeV[i] = 1000000000;
		}
		routeV[start] = 0;
		pq.add(new route(routeV[start], start));
		while (pq.peek() != null) {
			tmp = pq.poll();
			if (visited[tmp.nodeIndex] == 1) {
				continue;
			}
			visited[tmp.nodeIndex] = 1;
			Iterator<Edge> iter = nodes[tmp.nodeIndex].nei.iterator();
			while (iter.hasNext()) {
				Edge etmp = iter.next();
				if (routeV[etmp.destination] > routeV[tmp.nodeIndex] + etmp.value) {		//이 조건을 통과하는 것 자체가 해당 노드로의 경로가 고정이 안되었다는 의미
					routeV[etmp.destination] = routeV[tmp.nodeIndex] + etmp.value;
					pq.add(new route(routeV[etmp.destination], etmp.destination));
				}
			}
		}
	}
}
