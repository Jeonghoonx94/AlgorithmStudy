package swea;
import java.util.Scanner;

public class Algorithm_1231 {
	static char[] tree;	// 트리
	static int n;	// 트리의 노드 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;
		for(int test_case = 1; test_case<=T; ++test_case) {

			n = sc.nextInt();	// 트리의 노드 수
			tree = new char[n+1];	// 노드 번호의 시작은 1부터
			for(int i=0; i<n; ++i)
				tree[sc.nextInt()] = sc.nextLine().charAt(1);	// 공백부터 읽어지므로 1
			
			System.out.print("#"+test_case+" ");
			inorder_traverse(1);
			System.out.println();
		}
		sc.close();
	}
	static void inorder_traverse(int i) {
		if(i<=n) {	// 마지막 번호 노드까지
			inorder_traverse(2*i);
			System.out.print(tree[i]);
			inorder_traverse(2*i + 1);
		}
	}
}
