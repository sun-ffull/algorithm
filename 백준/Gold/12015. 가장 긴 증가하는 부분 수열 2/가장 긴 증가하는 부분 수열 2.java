import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
	
	public static ArrayList<Integer> ary = new ArrayList<Integer>(1000000);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		ary.add(Integer.parseInt(st.nextToken()));		//최초값
		for (int i=0; i<N-1; i++) {
			binary_sol(0, ary.size()-1, Integer.parseInt(st.nextToken()));
		}
		
		bw.write(Integer.toString(ary.size()));
		bw.flush();
		bw.close();
		br.close();
	}

	static void binary_sol(int start, int end, int n) {
		int mid=0;
		int fixed_end = end;
		
		while (end >= start) {
			mid = (start+end)/2;
			if (ary.get(mid) > n) {
				end = mid-1;
			}
			else if (ary.get(mid) < n) {
				start = mid+1;
			}
			else {
				return;
			}
		}
		
		if (ary.get(mid) > n) {
			ary.set(mid, n);
		}
		else {
			if (mid != ary.size()-1) {
				ary.set(mid+1, n);
			}
			else {
				ary.add(n);
			}
		}
	}
}