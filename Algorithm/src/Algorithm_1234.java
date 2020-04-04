import java.util.LinkedList;
import java.util.Scanner;

public class Algorithm_1234 {
	
	static int n;	// 트리의 노드 수
	static LinkedList<String[]> tree2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int test_case = 1; test_case<=T; ++test_case) {
			n = sc.nextInt();	// 트리의 노드 수
			sc.nextLine();
			tree2 = new LinkedList<>();
			
			for(int i=0; i<n; ++i) 
				tree2.add(sc.nextLine().split(" "));

			System.out.println("#"+test_case+" "+calculate(n));
			tree2.clear();
		}
		sc.close();
	}
	static int calculate(int n) {
		for(int i=n-1; i>=0; --i) {
			if(!Character.isDigit(tree2.get(i)[1].charAt(0))) {
				int a = Integer.parseInt(tree2.get(Integer.parseInt(tree2.get(i)[2])-1)[1]);
				int b = Integer.parseInt(tree2.get(Integer.parseInt(tree2.get(i)[3])-1)[1]);
				switch(tree2.get(i)[1].charAt(0)) {
				case '+':
					a+=b;
					break;
				case '-':
					a-=b;
					break;
				case '*':
					a*=b;
					break;
				case '/':
					a/=b;
					break;
				}
				tree2.set(i, (tree2.get(i)[0] +" " + Integer.toString(a)).split(" "));
				
			}
		}
		return Integer.parseInt(tree2.peek()[1]);
	}

}
