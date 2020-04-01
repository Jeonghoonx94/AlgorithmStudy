import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Algorithm_1225 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		LinkedList<Integer> q = new LinkedList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int test_case = 1; test_case<=10; ++test_case) {
			int T = sc.nextInt();
			for(int i=0; i<8; ++i)
				q.add(sc.nextInt());
			while(true) {
				for(int i=1; i<=5; ++i) {
					int n = q.poll() - i;
					if( n <= 0 ) {
						q.add( 0 );
						break;
					}
					else
						q.add( n );
				}
//				if(q.getLast() == 0)
				if(q.contains(0))
					break;
			}
			System.out.println("#"+T+" "+q);
			q.clear();
		}
		sc.close();
	}
}
