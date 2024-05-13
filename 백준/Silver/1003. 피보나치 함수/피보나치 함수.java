import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int result[][] = new int[T][2];
		for (int i=0; i<T; i++) {
			int zero=0, one=0;
			int N = scan.nextInt();
			
			int[][] dp = new int[N+1][2];
			dp[0][0] = 1;
			dp[0][1] = 0;
			
			if (N > 0) {
				dp[1][0] = 0;
				dp[1][1] = 1;
			}
			
			if (N == 0) {
				result[i][0] = dp[0][0];
				result[i][1] = dp[0][1];
				continue;
			}
			if (N == 1) {
				result[i][0] = dp[1][0];
				result[i][1] = dp[1][1];
				continue;
			}
			
			int index= 1;
			while (index != N) {
				index++;
				dp[index][0] = dp[index-1][0] + dp[index-2][0];
				dp[index][1] = dp[index-1][1] + dp[index-2][1];
			}
			
			result[i][0] = dp[N][0];
			result[i][1] = dp[N][1];
		}
		
		for (int i=0; i<T; i++) {
			System.out.printf("%d %d\n", result[i][0], result[i][1]);
		}
	}

}
