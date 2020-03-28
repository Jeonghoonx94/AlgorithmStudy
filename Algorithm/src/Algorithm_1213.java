import java.util.Scanner;

public class Algorithm_1213 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 1; test_case++)
		{
			int T = sc.nextInt();
			String find = sc.next();
			String str = sc.next();
			
			int count=0;
			for(int i=0; i<=str.length()-find.length(); ++i) {
				if(str.substring(i, i+find.length()).equals(find))
					++count;
			}
			System.out.println("#"+T+" "+count);
		}
		sc.close();
	}

}
