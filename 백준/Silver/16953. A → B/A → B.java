import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		
		int cnt = 1;
		
		while (A != B) {
			if (B%2 != 0 && B%10 !=1 && B!= A) {
				cnt = -1;
				break;
			}
			if (B < A) {
				cnt = -1;
				break;
			}
			
			if (B%2 == 0) {
				B = B/2;
				cnt++;
			}
			else if (B%10 == 1) {
				B = B/10;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
