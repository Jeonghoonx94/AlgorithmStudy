package swea;
import java.util.Scanner;

public class Algorithm_1208 {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int try_num = sc.nextInt();
            int max = 0, min = 0;
            int max_index = 0, min_index = 0, ans = 0;
            int[] box_height = new int[100];
            for(int i=0; i<100; ++i) {
                box_height[i] = sc.nextInt();
                if(max<box_height[i]) {
                    max = box_height[i];	// 가장 높은 값
                    max_index = i;	// 그 위치
                }
                if(min>box_height[i]) {
                    min = box_height[i];	// 가장 낮은 값
                    min_index = i;	// 그 위치
                }
            }
            
            for(int i=0; i<try_num; ++i) {	// 덤프 수행
                --box_height[max_index];	// 가장 높은 값을 가진 박스의 높이 -1
                ++box_height[min_index];	// 가장 낮은 값을 가진 박스의 높이 +1
                for(int j=0; j<100; ++j) {
                	if( box_height[max_index] < box_height[j])	// 가장 높은 값이 아니게 되면
                		max_index = j;	// 가장 높은 값 위치로 바꾸기
                	if( box_height[min_index] > box_height[j])
                		min_index = j;
                }
            }
            ans = box_height[max_index] - box_height[min_index];
            System.out.println("#"+test_case+" "+ans);

		}
		sc.close();
	}
}
