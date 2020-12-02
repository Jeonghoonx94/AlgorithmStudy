package swea;
import java.util.ArrayList;
import java.util.Scanner;

public class Algorithm_1211 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int[][] ladder = new int[100][100];
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			ArrayList<Integer> xlist = new ArrayList<>();
			ArrayList<Integer> countlist = new ArrayList<>();
			int T = sc.nextInt();
            int min = Integer.MAX_VALUE;
            int ans = 0;
			for(int i=0; i<100; ++i) {
				for(int j=0; j<100; ++j) {
					ladder[i][j] = sc.nextInt();
					if(ladder[0][j] == 1) {
						xlist.add(j);	// x의 값이 오름차순으로 저장됨.
					}
				}
			}
			for(int x : xlist ) {
				int y = 0;
				int count = 0;
				while(y<99) {
					if(x>=1 && ladder[y][x-1] == 1) {
						while(x>=1 && ladder[y][x-1] == 1) {
							--x;
							++count;
						}
					} else if(x <= 98 && ladder[y][x+1] == 1) {
						while(x <= 98 && ladder[y][x+1] == 1) {
							++x;
							++count;
						}
					}
					++y;
					++count;
				}
				countlist.add(count);	// xlist에 저장된 x값의 순서에 맞춰서 각 거리 저장.
			}
			for(int i : countlist) {
				if(min >= i)	min = i;	// 거리 중 가장 작은 값. 중복값 있으면 그 중 x가 가장 큰 값 
			}
			ans = xlist.get(countlist.lastIndexOf(min));	// 가장 작은 값도 중복이 있으면 그 중 x가 가장 큰 값
			System.out.println("#"+T+" "+ans);
		}
		sc.close();
	}

}
