package swea;
//길찾기
// 0: start vertex
// 99: destination vertex
import java.util.Arrays;
import java.util.Scanner;

public class Algorithm_1219 {

	static int[] arr = new int[100];
	static int[] arr2 = new int[100];
	static int result = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++) {
			result = 0;
			Arrays.fill(arr, -1);
			Arrays.fill(arr2, -1);
			
			int T = sc.nextInt();
			int length = sc.nextInt();
			
			for(int i=0; i<length; ++i) {
				int s = sc.nextInt();
				int d = sc.nextInt();
				if(arr[s] == -1) arr[s] = d;
				else arr2[s] = d;
			}
			
			DFS(0);	//0부터 시작, 0번째 배열부터
			
			System.out.println("#"+T+" "+result);
		}
		sc.close();
	}
	
	static void DFS(int v) {	// n번째 배열 0~1, v번째 정점 0~99
		if(arr[v] == 99 || arr2[v] == 99)
			result = 1;
		else {
			if(arr[v] != -1) DFS(arr[v]);
			if(arr2[v] != -1) DFS(arr2[v]);
		}
	}
}
