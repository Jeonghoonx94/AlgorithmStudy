import java.util.Scanner;

public class Algorithm_1206 {
	public static void main(String[] args) throws Exception	{
		
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int width = sc.nextInt();
            int sum_height=0, highest = 0;
            int[] height = new int[width];
            
            for(int i=0;i<width;++i){
                height[i] = sc.nextInt();
            }
            for(int i=2;i<width-2; ++i) {
                highest = Math.max( Math.max( height[i-2], height[i-1] ) , Math.max( height[i+1], height[i+2] ) );
                if(height[i]>highest)
                    sum_height += (height[i]-highest);
            }
                
            System.out.println("#"+test_case+" "+ sum_height);
		}
		sc.close();
	}
}