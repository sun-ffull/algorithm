import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int rope[] = new int[N];
		int max = 0;
		
		for (int i=0; i<N; i++) {
			rope[i] = scan.nextInt();
		}
		
		Arrays.sort(rope);
		
		for (int i=N-1; i>=0; i--) {
			int tmp = (int)rope[i]*(N-i);
			if (tmp >= max) {
				max = tmp;
			}
		}
		
		System.out.println(max);
	}

}