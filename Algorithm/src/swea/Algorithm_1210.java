package swea;
import java.util.Scanner;

public class Algorithm_1210 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int[][] ladder = new int[100][100];
		int x=99, y=99;
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int T = sc.nextInt();
            
			for(int i=0; i<100; ++i) {
				for(int j=0; j<100; ++j) {
					ladder[i][j] = sc.nextInt();
					if(ladder[i][j] == 2) {
						x = j;
						y = i;
					}
				}
			}
			while(y>0) {
				if(x>=1 && ladder[y][x-1] == 1) {
					while(x>=1 && ladder[y][x-1] == 1)
						--x;
				} else if(x <= 98 && ladder[y][x+1] == 1) {
					while(x <= 98 && ladder[y][x+1] == 1)
						++x;
				}
				--y;
				
			}
			System.out.println("#"+T+" "+x);
		}
		sc.close();
	}

}
